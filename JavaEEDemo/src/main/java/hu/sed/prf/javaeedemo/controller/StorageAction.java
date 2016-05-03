package hu.sed.prf.javaeedemo.controller;

import hu.sed.prf.javaeedemo.controller.AbstractEntityAction;
import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.dao.StorageDao;
import hu.sed.prf.javaeedemo.dao.PartDao;
import hu.sed.prf.javaeedemo.entity.Storage;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class StorageAction extends AbstractEntityAction<Storage, Long> {
	
	private static final long serialVersionUID = -7066061376883686127L;
	
	private static final String NAVIGATION_TARGET_AFTER_PERSIST = "/content/storage/list?faces-redirect=true";
	
	@Inject
	private StorageDao storageDao;
	
	@Inject
	private PartDao partDao;

	public StorageAction() {
		super(Storage.class);
	}
	
	@Override
	protected void afterCreation() {
		//getEntity().setAddress(new Address());
	}
	
	@Override
	protected void beforeRemoving(Storage entityToRemove) {
		partDao.removeByStorage(entityToRemove);
	}

	@Override
	protected GenericDao<Storage, Long> getEntityDao() {
		return storageDao;
	}

	@Override
	protected String getNavigationTargetAfterPersist() {
		return NAVIGATION_TARGET_AFTER_PERSIST;
	}

}
