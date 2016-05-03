package hu.sed.prf.javaeedemo.entity;

	import java.io.Serializable;
	import java.util.List;
		
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;


	@Entity
	@Table(name = "storage")
	public class Storage implements Serializable {
		
		private static final long serialVersionUID = -1783655608420130917L;;

		@Id
		@GeneratedValue(strategy = GenerationType.TABLE)
		private Long id;
		
		private String name;

		public Storage() {
		}

		public Storage(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Storage other = (Storage) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (id !=other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Storage [id=" + id + ", name=" + name + "]";
		}

}