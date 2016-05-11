package hu.sed.prf.javaeedemo.controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;

import hu.sed.prf.javaeedemo.controller.AbstractDataModel;
import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.dao.StorageDao;
import hu.sed.prf.javaeedemo.entity.Storage;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class Chart2DataModel extends AbstractDataModel<Storage, Long> {

	private static final long serialVersionUID = -7210487593216166015L;

	private List<Object[]> list;
	@Inject
	private StorageDao storageDao;

	@Override
	protected GenericDao<Storage, Long> getEntityDao() {
		return storageDao;
	}

	public List<Object[]> getListObject() {
		return list;
	}

	public void setListObject(List<Object[]> list) {
		this.list = list;
	}

	@Override
	public void loader() {
		setListObject(storageDao.partNumberByStorage());
	}
	
	/*private LineChartModel chartModel;
	 
	public void initialize() {
	  chartModel = new LineChartModel();
	  
	  DateAxis dateAxis = new DateAxis();
	  dateAxis.setTickAngle(-90);
	  dateAxis.setTickFormat("%Y. %m. %d. %H:%M:%S");
	  chartModel.getAxes().put(AxisType.X, dateAxis);
	  
	  LineChartSeries lineChartSeries = new LineChartSeries();
	  List<Object[]> storages = storageDao.partNumberByStorage();
	  for (Object[] o : storages) {
	   lineChartSeries.set(o[1], (Number) o[0]);
	  }
	  chartModel.addSeries(lineChartSeries);
	}
	 
	public LineChartModel getChartModel() {
	  return chartModel;
	}*/

}