package hu.sed.prf.javaeedemo.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.sed.prf.javaeedemo.controller.core.AbstractDataModel;
import hu.sed.prf.javaeedemo.controller.person.SelectedPatientContainer;
import hu.sed.prf.javaeedemo.dao.core.GenericDAO;
import hu.sed.prf.javaeedemo.dao.measurement.WeightDataDAO;
import hu.sed.prf.javaeedemo.entity.measurement.WeightData;

@Named
@ViewScoped
public class Chart2DataModel extends AbstractDataModel<WeightData, Long> {
	
	private static final long serialVersionUID = -3446654405173782044L;
	
	@Inject
	private WeightDataDAO weightDataDAO;
	
	@Inject
	private SelectedPatientContainer selectedPatientContainer;
	
	@Override
	public void load() {
		setList(weightDataDAO.findByPatient(selectedPatientContainer.getSelectedPatient()));
	}

	@Override
	protected GenericDAO<WeightData, Long> getEntityDao() {
		return weightDataDAO;
	}

}
