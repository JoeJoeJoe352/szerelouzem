package hu.sed.prf.javaeedemo.controller.measurement;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.sed.prf.javaeedemo.controller.core.AbstractDataModel;
import hu.sed.prf.javaeedemo.controller.person.PatientDataModel;
import hu.sed.prf.javaeedemo.dao.core.GenericDAO;
import hu.sed.prf.javaeedemo.dao.measurement.WeightDataDAO;
import hu.sed.prf.javaeedemo.entity.measurement.WeightData;
import hu.sed.prf.javaeedemo.entity.person.Patient;

@Named
@ViewScoped
public class AjaxWeightDataModel extends AbstractDataModel<WeightData, Long> {
	
	private static final long serialVersionUID = -3446654405173782044L;
	
	@Inject
	private WeightDataDAO weightDataDAO;
	
	@Inject
	private PatientDataModel patientDataModel;
	
	private Patient patient;
	
	@Override
	public void load() {
		List<Patient> patients = patientDataModel.getList();
		if (null == patient && null != patients && !patients.isEmpty()) {
			patient = patients.get(0);
		}
		setList(weightDataDAO.findByPatient(patient));
	}

	@Override
	protected GenericDAO<WeightData, Long> getEntityDao() {
		return weightDataDAO;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
