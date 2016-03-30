package hu.sed.prf.javaeedemo.controller.person;

import hu.sed.prf.javaeedemo.controller.core.AbstractEntityAction;
import hu.sed.prf.javaeedemo.dao.core.GenericDAO;
import hu.sed.prf.javaeedemo.dao.measurement.MeasurementDataDAO;
import hu.sed.prf.javaeedemo.dao.person.PatientDAO;
import hu.sed.prf.javaeedemo.entity.person.Patient;
import hu.sed.prf.javaeedemo.entity.place.Address;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PatientAction extends AbstractEntityAction<Patient, Long> {
	
	private static final long serialVersionUID = -7067061243883686127L;
	
	private static final String NAVIGATION_TARGET_AFTER_PERSIST = "/content/patient/list?faces-redirect=true";
	
	@Inject
	private PatientDAO patientDAO;
	
	@Inject
	private MeasurementDataDAO measurementDataDAO;

	public PatientAction() {
		super(Patient.class);
	}
	
	@Override
	protected void afterCreation() {
		getEntity().setAddress(new Address());
	}
	
	@Override
	protected void beforeRemoving(Patient entityToRemove) {
		measurementDataDAO.removeByPatient(entityToRemove);
	}

	@Override
	protected GenericDAO<Patient, Long> getEntityDao() {
		return patientDAO;
	}

	@Override
	protected String getNavigationTargetAfterPersist() {
		return NAVIGATION_TARGET_AFTER_PERSIST;
	}

}
