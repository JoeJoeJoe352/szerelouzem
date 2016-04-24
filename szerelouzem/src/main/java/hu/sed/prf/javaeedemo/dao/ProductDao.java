package hu.sed.prf.javaeedemo.dao;


	import javax.persistence.Query;

	import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.entity.Product;
import hu.sed.prf.javaeedemo.entity.ProductCategory;

	public class ProductDao extends GenericDao<Product, Long> {

		private static final long serialVersionUID = -7092250617222161406L;

		public ProductDao() {
			super(Product.class);
		}
		
		public void removeByProductCategory(ProductCategory productCategory) {
			//TODO: minden adott kategoriaju product eltavolitasa
		}
		
		//TODO: lekerdezes
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