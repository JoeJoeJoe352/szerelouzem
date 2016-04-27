package hu.sed.prf.javaeedemo.controller;

import hu.sed.prf.javaeedemo.controller.AbstractDataModel;
import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.dao.ProductCategoryDao;
import hu.sed.prf.javaeedemo.entity.ProductCategory;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ProductCategoryDataModel extends AbstractDataModel<ProductCategory, Long> {
	
	private static final long serialVersionUID = -7210487333216166015L;
	
	@Inject
	private ProductCategoryDao productCategoryDao;

	@Override
	protected GenericDao<ProductCategory, Long> getEntityDao() {
		return productCategoryDao;
	}
	
	@Override
	public void load() {
		//todo
		//Minta: setList(weightDataDAO.findByPatient(selectedPatientContainer.getSelectedPatient()));
	}
	
}