package hu.sed.prf.javaeedemo.entity;

	import java.io.Serializable;

	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.JoinTable;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;


	@Entity
	@Table(name = "part")
	public class Part implements Serializable {
		
		private static final long serialVersionUID = -1483355608420130917L;;

		@Id
		@GeneratedValue(strategy = GenerationType.TABLE)
		private Long id;
		
		private String name;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinTable(name = "parts_storage", joinColumns = @JoinColumn(name = "part_id"), 
				inverseJoinColumns = @JoinColumn(name = "storage_id"))
		private Storage storage;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinTable(name = "parts_product", joinColumns = @JoinColumn(name = "part_id"), 
				inverseJoinColumns = @JoinColumn(name = "product_id"))
		private Product product;
		
		private int quantity;
		
		public Part() {
		}

		public Part(Long id, String name, Storage storage, Product product, int quantity) {
			super();
			this.id = id;
			this.name = name;
			this.storage = storage;
			this.product = product;
			this.quantity = quantity;
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

		public Storage getStorage() {
			return storage;
		}

		public void setStorage(Storage storage) {
			this.storage = storage;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
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
			Part other = (Part) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (id !=other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Part [id=" + id + ", name=" + name + ", storage=" + storage
					+ ", product=" + product + ", quantity=" + quantity + "]";
		}

}

