package hu.sed.prf.javaeedemo.controller;

import hu.sed.prf.javaeedemo.controller.AbstractEntityAction;
import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.dao.ProductDao;
//import hu.sed.prf.javaeedemo.dao.PartDao;
import hu.sed.prf.javaeedemo.entity.Product;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ProductAction extends AbstractEntityAction<Product, Long> {
	
	private static final long serialVersionUID = -7066061243883686127L;
	
	private static final String NAVIGATION_TARGET_AFTER_PERSIST = "";//"/content/patient/list?faces-redirect=true";
	
	@Inject
	private ProductDao productDao;
	
	//@Inject
	//private PartDao partDao; //after,before metodusokban ha kell

	public ProductAction() {
		super(Product.class);
	}
	
	@Override
	protected void afterCreation() {
		//getEntity().setAddress(new Address());
	}
	
	@Override
	protected void beforeRemoving(Product entityToRemove) {
		//measurementDataDAO.removeByPatient(entityToRemove);
	}

	@Override
	protected GenericDao<Product, Long> getEntityDao() {
		return productDao;
	}

	@Override
	protected String getNavigationTargetAfterPersist() {
		return NAVIGATION_TARGET_AFTER_PERSIST;
	}

}