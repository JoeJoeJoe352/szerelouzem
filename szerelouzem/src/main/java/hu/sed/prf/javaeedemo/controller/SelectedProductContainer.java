package hu.sed.prf.javaeedemo.controller;


	import hu.sed.prf.javaeedemo.dao.ProductDao;
	import hu.sed.prf.javaeedemo.entity.Product;

	import java.io.Serializable;

	import javax.enterprise.context.SessionScoped;
	import javax.inject.Inject;
	import javax.inject.Named;

	@Named
	@SessionScoped
	public class SelectedProductContainer implements Serializable {

		private static final long serialVersionUID = -387708321738479164L;
		
		@Inject
		private ProductDao productDao;
		
		private Product selectedProduct;
		
		public void selectProduct(Long productIdentifier) {
			if (null != productIdentifier) {
				this.selectedProduct = productDao.findEntity(productIdentifier);
			}
		}
		
		public Product getSelectedProduct() {
			return selectedProduct;
		}

	}