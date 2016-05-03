package hu.sed.prf.javaeedemo.controller;


	import hu.sed.prf.javaeedemo.dao.GenericDao;

	import java.io.Serializable;
	import java.util.List;

	public abstract class AbstractDataModel<EntityType, IdentifierType extends Serializable> implements Serializable {
		
		private static final long serialVersionUID = -1162381107575635107L;
		
		private List<EntityType> list;
		
		public void load() {
			list = getEntityDao().list();
		}
		
		protected abstract GenericDao<EntityType, IdentifierType> getEntityDao();
		
		public List<EntityType> getList() {
			return list;
		}
		
		public void setList(List<EntityType> list) {
			this.list = list;
		}

	}
