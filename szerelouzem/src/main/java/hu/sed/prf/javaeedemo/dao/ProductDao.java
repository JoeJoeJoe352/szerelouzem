package hu.sed.prf.javaeedemo.dao;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.entity.Part;
import hu.sed.prf.javaeedemo.entity.Product;
import hu.sed.prf.javaeedemo.entity.ProductCategory;
import hu.sed.prf.javaeedemo.entity.Storage;

	public class ProductDao extends GenericDao<Product, Long> {

		private static final long serialVersionUID = -7092250617222161406L;

		public ProductDao() {
			super(Product.class);
		}
		
		public void removeByProductCategory(ProductCategory productCategory) {
			StringBuilder sb = new StringBuilder();
			sb.append("delete from Product product");
			sb.append("	where product.productCategory = :prodCat");
			
			Query query = getEntityManager().createQuery(sb.toString());
			query.setParameter("prodCat", productCategory);
			query.executeUpdate();
		}
		
		public List<Product> findByProductCategory(ProductCategory productCategory) {
			StringBuilder sb = new StringBuilder();
			sb.append("select product from Product product");
			sb.append(" where product.productCategory = :prodCat");
					
			TypedQuery<Product> query = getEntityManager().createQuery(sb.toString(), getEntityClass());
			query.setParameter("prodCat", productCategory);
			return query.getResultList();
		}

	}