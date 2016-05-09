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
	public class NumberCategory implements Serializable {
		
		private static final long serialVersionUID = -1783655608420130917L;;

		@Id
		@GeneratedValue(strategy = GenerationType.TABLE)
		private int counter;
		
		private String name;

		public NumberCategory() {
		}

		public NumberCategory(Integer counter, String name) {
			super();
			this.counter = counter;
			this.name = name;
		}

		public int getCounter() {
			return counter;
		}

		public void setCounter(int counter) {
			this.counter = counter;
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
		public String toString() {
			return "Storage [name=" + name + "]";
		}

}