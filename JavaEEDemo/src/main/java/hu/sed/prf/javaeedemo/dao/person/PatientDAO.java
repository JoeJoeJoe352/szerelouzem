package hu.sed.prf.javaeedemo.dao.person;

import hu.sed.prf.javaeedemo.dao.core.GenericDAO;
import hu.sed.prf.javaeedemo.entity.person.Patient;

public class PatientDAO extends GenericDAO<Patient, Long> {

	private static final long serialVersionUID = -5859058016736013679L;

	public PatientDAO() {
		super(Patient.class);
	}

}
