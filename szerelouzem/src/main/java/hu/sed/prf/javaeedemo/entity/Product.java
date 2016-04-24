package hu.sed.prf.javaeedemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


	@Entity
	@Table(name = "product")
	public class Product implements Serializable {
		
		private static final long serialVersionUID = -1583355608420130917L;;

		@Id
		@GeneratedValue(strategy = GenerationType.TABLE)
		private Long id;
		
		private String name;

		@OneToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "parts_product", joinColumns = @JoinColumn(name = "product_id"), 
				inverseJoinColumns = @JoinColumn(name = "part_id"))
		private List<Part> parts;

		private String part;
		
		public Product() {
		}

		
		public Product(Long id, String name, List<Part> parts) {
			super();
			this.id = id;
			this.name = name;
			this.parts = parts;
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


		public List<Part> getParts() {
			return parts;
		}


		public void setParts(List<Part> parts) {
			this.parts = parts;
		}

		
		public String getPart() {
			return part;
		}


		public void setPart(String part) {
			this.part = part;
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
			Product other = (Product) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (id !=other.id)
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", parts=" + parts
					+ "]";
		}

		
}

