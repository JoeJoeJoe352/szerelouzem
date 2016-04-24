package hu.sed.prf.javaeedemo.controller;

import hu.sed.prf.javaeedemo.controller.AbstractEntityAction;
import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.dao.ProductDao;
import hu.sed.prf.javaeedemo.dao.ProductCategoryDao;
import hu.sed.prf.javaeedemo.entity.ProductCategory;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ProductCategoryAction extends AbstractEntityAction<ProductCategory, Long> {
	
	private static final long serialVersionUID = -7066061243283683127L;
	
	private static final String NAVIGATION_TARGET_AFTER_PERSIST = "";//"/content/patient/list?faces-redirect=true";
	
	@Inject
	private ProductCategoryDao productCategoryDao;
	
	@Inject
	private ProductDao productDao;

	public ProductCategoryAction() {
		super(ProductCategory.class);
	}
	
	@Override
	protected void afterCreation() {
		//getEntity().setAddress(new Address());
	}
	
	@Override
	protected void beforeRemoving(ProductCategory entityToRemove) {
		productDao.removeByProductCategory(entityToRemove);
	}

	@Override
	protected GenericDao<ProductCategory, Long> getEntityDao() {
		return productCategoryDao;
	}

	@Override
	protected String getNavigationTargetAfterPersist() {
		return NAVIGATION_TARGET_AFTER_PERSIST;
	}

}
