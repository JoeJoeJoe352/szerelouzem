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
public class Part implements Serializable {
	
	private static final long serialVersionUID = -1583355608420130917L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	private String nev;
	
	private int ar;
	
	private int meret;
	
	public Part() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getAr() {
		return ar;
	}

	public void setAr(int ar) {
		this.ar = ar;
	}

	public int getMeret() {
		return meret;
	}

	public void setMeret(int meret) {
		this.meret = meret;
	}

	public Part(String nev, int ar, int meret) {
		super();
		this.nev = nev;
		this.ar = ar;
		this.meret = meret;
	}


	
}
