package hu.sed.prf.javaeedemo.dao;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.entity.Part;
import hu.sed.prf.javaeedemo.entity.Product;
import hu.sed.prf.javaeedemo.entity.Storage;
import hu.sed.prf.javaeedemo.entity.measurement.WeightData;


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
		
		@Inject
		private EntityManager entityManager;
		
		private Class<Part> entityClass;
		
		@Override
		@Transactional
		public List<Part> list() {
			StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append("SELECT part.name, part.id");
			queryBuilder.append("FROM PART part");
			
			TypedQuery<Part> query = entityManager.createQuery(queryBuilder.toString(), entityClass);
			return query.getResultList();
		}
		
		/*
			queryBuilder.append("SELECT par");
			queryBuilder.append("FROM PART par, STORAGE sto, PRODUCT pro, PARTS_PRODUCT j, PARTS_STORAGE jj");
			queryBuilder.append("WHERE par.id = j.part_id AND pro.id = j.product_id ");
			queryBuilder.append("AND par.id = jj.part_id AND sto.id = jj.storage_id");
		 */

	}
