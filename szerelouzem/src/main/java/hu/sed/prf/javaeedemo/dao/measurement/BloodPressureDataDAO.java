package hu.sed.prf.javaeedemo.dao.measurement;

import java.util.List;

import javax.persistence.TypedQuery;

import hu.sed.prf.javaeedemo.dao.core.GenericDAO;
import hu.sed.prf.javaeedemo.entity.measurement.BloodPressureData;
import hu.sed.prf.javaeedemo.entity.person.Patient;

public class BloodPressureDataDAO extends GenericDAO<BloodPressureData, Long> {

	private static final long serialVersionUID = 8748068210157776424L;

	public BloodPressureDataDAO() {
		super(BloodPressureData.class);
	}
	
	public List<BloodPressureData> findByPatient(Patient patient) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("	select ");
		queryBuilder.append("		bloodPressureData ");
		queryBuilder.append("	from ");
		queryBuilder.append("		BloodPressureData bloodPressureData ");
		queryBuilder.append("	where ");
		queryBuilder.append("		bloodPressureData.patient = :patient ");
		
		TypedQuery<BloodPressureData> query = getEntityManager().createQuery(queryBuilder.toString(), getEntityClass());
		query.setParameter("patient", patient);
		return query.getResultList();
	}

}
