package hu.sed.prf.javaeedemo.controller.measurement;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.sed.prf.javaeedemo.controller.core.AbstractDataModel;
import hu.sed.prf.javaeedemo.controller.person.SelectedPatientContainer;
import hu.sed.prf.javaeedemo.dao.core.GenericDAO;
import hu.sed.prf.javaeedemo.dao.measurement.BloodPressureDataDAO;
import hu.sed.prf.javaeedemo.entity.measurement.BloodPressureData;

@Named
@ViewScoped
public class BloodPressureDataModel extends AbstractDataModel<BloodPressureData, Long> {
	
	private static final long serialVersionUID = -7776424479888565750L;
	
	@Inject
	private BloodPressureDataDAO bloodPressureDataDAO;
	
	@Inject
	private SelectedPatientContainer selectedPatientContainer;
	
	@Override
	public void load() {
		setList(bloodPressureDataDAO.findByPatient(selectedPatientContainer.getSelectedPatient()));
	}

	@Override
	protected GenericDAO<BloodPressureData, Long> getEntityDao() {
		return bloodPressureDataDAO;
	}
	
}
