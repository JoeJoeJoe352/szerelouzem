package org.primefaces.examples.view;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean
public class ChartView implements Serializable {
 
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries storages = new ChartSeries();
        storages.setLabel("Raktárak");
		
		List<Object> storageDataList = storageDataDao.partNumberByStorage();
		for (Object o : storageDataList) {
			storages.set(dateFormat.format(o[0]), o[1]);
		}
		model.addSeries(storages);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Raktárak alkatrész száma");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Raktárak");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Alkatrész darab");
        yAxis.setMin(0);
        yAxis.setMax(50);
    }
     
 
}