package hu.sed.prf.javaeedemo.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.sed.prf.javaeedemo.controller.AbstractEntityAction;
//import hu.sed.prf.javaeedemo.controller.SelectedProductContainer;
import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.dao.PartDao;
import hu.sed.prf.javaeedemo.entity.Part;

@Named
@ViewScoped
public class PartAction extends AbstractEntityAction<Part, Long> {
	
	private static final long serialVersionUID = 222976612070357967L;
	
	private static final String NAVIGATION_TARGET_AFTER_PERSIST = "/content/part/list?faces-redirect=true";

	@Inject
	private PartDao partDao;
	
	public PartAction() {
		super(Part.class);
	}
	
	@Override
	protected void afterCreation() {

	}

	@Override
	protected GenericDao<Part, Long> getEntityDao() {
		return partDao;
	}

	@Override
	protected String getNavigationTargetAfterPersist() {
		return NAVIGATION_TARGET_AFTER_PERSIST;
	}

}