package hu.sed.prf.javaeedemo.dao;


	import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;

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
			//TODO: minden adott kategoriaju product eltavolitasa
		}
		
		public List<Product> findByProductCategory(Product product) {
			//TODO: minden adott kategoriaban levo product kigyujtese listaba
			List<Product> list = new LinkedList();
			return list;
		}

	}