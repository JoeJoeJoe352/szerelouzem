package hu.sed.prf.javaeedemo.controller;

	import javax.faces.view.ViewScoped;
	import javax.inject.Inject;
	import javax.inject.Named;

	import hu.sed.prf.javaeedemo.controller.AbstractDataModel;
	import hu.sed.prf.javaeedemo.controller.SelectedProductContainer;
	import hu.sed.prf.javaeedemo.dao.GenericDao;
	import hu.sed.prf.javaeedemo.dao.PartDao;
	import hu.sed.prf.javaeedemo.entity.Part;

	@Named
	@ViewScoped
	public class PartDataModel extends AbstractDataModel<Part, Long> {
		
		private static final long serialVersionUID = -3446654405373782044L;
		
		@Inject
		private PartDao partDao;
		
		@Inject
		private SelectedProductContainer selectedProductContainer;
		
		@Override
		public void load() {
			setList(partDao.findByProduct(selectedProductContainer.getSelectedProduct()));
		}

		@Override
		protected GenericDao<Part, Long> getEntityDao() {
			return partDao;
		}

	}
