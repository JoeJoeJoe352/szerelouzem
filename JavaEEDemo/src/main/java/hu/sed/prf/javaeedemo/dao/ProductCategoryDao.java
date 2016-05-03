package hu.sed.prf.javaeedemo.dao;


	import javax.persistence.Query;

	import hu.sed.prf.javaeedemo.dao.GenericDao;
	import hu.sed.prf.javaeedemo.entity.ProductCategory;

	public class ProductCategoryDao extends GenericDao<ProductCategory, Long> {

		private static final long serialVersionUID = -7092750617222161406L;

		public ProductCategoryDao() {
			super(ProductCategory.class);
		}
		
		//TODO: lekerdezes
		/*
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