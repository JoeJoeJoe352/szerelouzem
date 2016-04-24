package hu.sed.prf.javaeedemo.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.entity.Part;
import hu.sed.prf.javaeedemo.entity.Product;
import hu.sed.prf.javaeedemo.entity.Storage;


	public class PartDao extends GenericDao<Part, Long> {

		private static final long serialVersionUID = -7092750617222161406L;

		public PartDao() {
			super(Part.class);
		}
		
		public List<Part> findByProduct(Product product) {
			//TODO: impl.
			/* segitseg:
			StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append("	select ");
			queryBuilder.append("		weightData ");
			queryBuilder.append("	from ");
			queryBuilder.append("		WeightData weightData ");
			queryBuilder.append("	where ");
			queryBuilder.append("		weightData.patient = :patient ");
			
			TypedQuery<WeightData> query = getEntityManager().createQuery(queryBuilder.toString(), getEntityClass());
			query.setParameter("patient", patient);
			return query.getResultList();*/
			List<Part> list = new LinkedList();
			return list;
		}
		
		public void removeByStorage(Storage storage) {
			//TODO: minden adott storage-ba levo part eltavolitasa
		}
		
		//TODO: egyeb lekerdezes
		/* segitseg:
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
		}*/

	}
