package hu.sed.prf.javaeedemo.controller;

import hu.sed.prf.javaeedemo.controller.AbstractEntityAction;
import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.dao.PartDao;
import hu.sed.prf.javaeedemo.dao.ProductCategoryDao;
import hu.sed.prf.javaeedemo.dao.ProductDao;
//import hu.sed.prf.javaeedemo.dao.PartDao;
import hu.sed.prf.javaeedemo.entity.Product;
import hu.sed.prf.javaeedemo.entity.ProductCategory;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@ViewScoped
public class ProductAction extends AbstractEntityAction<Product, Long> {
	
	private static final long serialVersionUID = -7066061243883686127L;
	
	private static final String NAVIGATION_TARGET_AFTER_PERSIST = "/content/product/list?faces-redirect=true";
	/*
	@Inject
	private ProductCategoryDao productCategoryDao;
	*/
	@Inject
	private ProductDao productDao;
	
	@Inject
	private PartDao partDao;

	public ProductAction() {
		super(Product.class);
	}
	
	@Override
	protected void afterCreation() {
		//setCategoryById();
	}
	
	@Override
	protected void beforeRemoving(Product entityToRemove) {
		partDao.removeByProduct(entityToRemove);
	}

	@Override
	protected GenericDao<Product, Long> getEntityDao() {
		return productDao;
	}

	@Override
	protected String getNavigationTargetAfterPersist() {
		return NAVIGATION_TARGET_AFTER_PERSIST;
	}
	/*
	protected void setCategoryById(String cid) {
		getEntity().setProductCategory(productCategoryDao.findEntity(Long.parseLong(cid)));
	}*/
	/*
	@Transactional
	public String persist(String pc) {
		Product prod = getEntity();
		prod.setProductCategory(productCategoryDao.findEntity(Long.parseLong(pc)));
		if (null == getId()) {
			getEntityDao().persist(prod);
		} else {
			// Entity instance is detached here in case of editing, so merge() should be used instead of persist().
			getEntityDao().merge(prod);
		}
		afterPersisting();
		return getNavigationTargetAfterPersist();
	}
	*/

}