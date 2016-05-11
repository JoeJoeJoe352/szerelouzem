package hu.sed.prf.javaeedemo.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import hu.sed.prf.javaeedemo.dao.GenericDao;
import hu.sed.prf.javaeedemo.entity.Storage;

public class StorageDao extends GenericDao<Storage, Long> {

	private static final long serialVersionUID = -7092750617222161406L;

	public StorageDao() {
		super(Storage.class);
	}
	
	public List<Object[]> partNumberByStorage() {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(part.id), storage.name from Storage storage, Part part ");
		sb.append("group by storage.name");
		TypedQuery<Object[]> query = getEntityManager().createQuery(sb.toString(), Object[].class);
		return query.getResultList();
	}

}