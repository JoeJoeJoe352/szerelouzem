package hu.sed.prf.javaeedemo.dao.measurement;

import javax.persistence.Query;

import hu.sed.prf.javaeedemo.dao.core.GenericDAO;
import hu.sed.prf.javaeedemo.entity.measurement.MeasurementData;
import hu.sed.prf.javaeedemo.entity.person.Patient;

public class MeasurementDataDAO extends GenericDAO<MeasurementData, Long> {

	private static final long serialVersionUID = -7092750617722161406L;

	public MeasurementDataDAO() {
		super(MeasurementData.class);
	}
	
	public void removeByPatient(Patient patient) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("	delete ");
		queryBuilder.append("	from ");
		queryBuilder.append("		MeasurementData measurementData ");
		queryBuilder.append("	where ");
		queryBuilder.append("		measurementData.patient = :patient ");
		
		Query query = getEntityManager().createQuery(queryBuilder.toString());
		query.setParameter("patient", patient);
		query.executeUpdate();
	}

}
