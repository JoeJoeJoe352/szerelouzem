package hu.sed.prf.javaeedemo.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "patient",
		uniqueConstraints = @UniqueConstraint(name = "unique_name", columnNames = {"name"}))
public class PartQuantity implements Serializable {
	
	private static final long serialVersionUID = -1583355608420130917L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private Integer darab;

	public PartQuantity() {
	}

	public PartQuantity(Integer darab) {
		super();
		this.darab = darab;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDarab() {
		return darab;
	}

	public void setDarab(Integer darab) {
		this.darab = darab;
	}

	
}
