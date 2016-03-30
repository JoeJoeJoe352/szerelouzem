package hu.sed.prf.javaeedemo.controller.measurement;

import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.sed.prf.javaeedemo.controller.core.AbstractEntityAction;
import hu.sed.prf.javaeedemo.controller.person.SelectedPatientContainer;
import hu.sed.prf.javaeedemo.dao.core.GenericDAO;
import hu.sed.prf.javaeedemo.dao.measurement.BloodPressureDataDAO;
import hu.sed.prf.javaeedemo.entity.measurement.BloodPressureData;

@Named
@ViewScoped
public class BloodPressureDataAction extends AbstractEntityAction<BloodPressureData, Long> {
	
	private static final long serialVersionUID = 4335991674417481192L;
	
	private static final String NAVIGATION_TARGET_AFTER_PERSIST = "/content/bloodpressuredata/list?faces-redirect=true";
	
	@Inject
	private BloodPressureDataDAO bloodPressureDataDAO;
	
	@Inject
	private SelectedPatientContainer selectedPatientContainer;
	
	public BloodPressureDataAction() {
		super(BloodPressureData.class);
	}
	
	@Override
	protected void afterCreation() {
		getEntity().setPatient(selectedPatientContainer.getSelectedPatient());
		getEntity().setDate(new Date());
	}

	@Override
	protected GenericDAO<BloodPressureData, Long> getEntityDao() {
		return bloodPressureDataDAO;
	}

	@Override
	protected String getNavigationTargetAfterPersist() {
		return NAVIGATION_TARGET_AFTER_PERSIST;
	}

}
