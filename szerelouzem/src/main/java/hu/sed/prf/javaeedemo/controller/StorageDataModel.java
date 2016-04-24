package hu.sed.prf.javaeedemo.controller;


import hu.sed.prf.javaeedemo.controller.AbstractDataModel;
import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.dao.StorageDao;
import hu.sed.prf.javaeedemo.entity.Storage;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class StorageDataModel extends AbstractDataModel<Storage, Long> {
	
	private static final long serialVersionUID = -7210627593216166015L;
	
	@Inject
	private StorageDao storageDao;

	@Override
	protected GenericDao<Storage, Long> getEntityDao() {
		return storageDao;
	}

}