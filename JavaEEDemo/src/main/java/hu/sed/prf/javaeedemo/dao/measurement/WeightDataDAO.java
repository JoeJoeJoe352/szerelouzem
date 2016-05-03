package hu.sed.prf.javaeedemo.dao.measurement;

import java.util.List;

import javax.persistence.TypedQuery;

import hu.sed.prf.javaeedemo.dao.core.GenericDAO;
import hu.sed.prf.javaeedemo.entity.measurement.WeightData;
import hu.sed.prf.javaeedemo.entity.person.Patient;

public class WeightDataDAO extends GenericDAO<WeightData, Long> {

	private static final long serialVersionUID = 1286322127054098460L;

	public WeightDataDAO() {
		super(WeightData.class);
	}
	
	public List<WeightData> findByPatient(Patient patient) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("	select ");
		queryBuilder.append("		weightData ");
		queryBuilder.append("	from ");
		queryBuilder.append("		WeightData weightData ");
		queryBuilder.append("	where ");
		queryBuilder.append("		weightData.patient = :patient ");
		
		TypedQuery<WeightData> query = getEntityManager().createQuery(queryBuilder.toString(), getEntityClass());
		query.setParameter("patient", patient);
		return query.getResultList();
	}

}
