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
			StringBuilder sb = new StringBuilder();
			sb.append("select part from Part part");
			sb.append(" where part.product = :prod");
					
			TypedQuery<Part> query = getEntityManager().createQuery(sb.toString(), getEntityClass());
			query.setParameter("prod", product);
			return query.getResultList();
		}
		
		public List<Part> findByStorage(Storage storage) {
			StringBuilder sb = new StringBuilder();
			sb.append("select part from Part part");
			sb.append(" where part.storage = :stor");
					
			TypedQuery<Part> query = getEntityManager().createQuery(sb.toString(), getEntityClass());
			query.setParameter("stor", storage);
			return query.getResultList();
		}
		
		public void removeByStorage(Storage storage) {
			StringBuilder sb = new StringBuilder();
			sb.append("delete from Part part");
			sb.append("	where part.storage = :stor");
			
			Query query = getEntityManager().createQuery(sb.toString());
			query.setParameter("stor", storage);
			query.executeUpdate();
		}
		
		public void removeByProduct(Product product) {
			StringBuilder sb = new StringBuilder();
			sb.append("delete from Part part");
			sb.append("	where part.product = :prod");
			
			Query query = getEntityManager().createQuery(sb.toString());
			query.setParameter("prod", product);
			query.executeUpdate();
		}

	}
