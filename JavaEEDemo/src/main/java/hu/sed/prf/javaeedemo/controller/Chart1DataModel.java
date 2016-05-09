package hu.sed.prf.javaeedemo.controller;

import hu.sed.prf.javaeedemo.controller.AbstractDataModel;
import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.dao.ProductDao;
import hu.sed.prf.javaeedemo.entity.Product;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class Chart1DataModel extends AbstractDataModel<Product, Long> {
	
	private static final long serialVersionUID = -7210487593216166015L;
	
	@Inject
	private ProductDao productDao;
	@Override
	protected GenericDao<Product, Long> getEntityDao() {
		return productDao;
	}

    @Override
    public void loader() {
	setList(productDao.findAllProduct());
    }
	
	
	
}