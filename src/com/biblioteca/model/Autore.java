package com.biblioteca.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Version;

@Entity
@Table (name="autori")
public class Autore implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	   private  long id;
	
	@Column(name="nome")
	   private String nome;
	
	@Column(name="cognome")
	   private String cognome;
	
	@Column(name="version")
	   private int version;
	
	@OneToMany(mappedBy="autore")
	   private List<Libro> libri;
	   
	public List<Libro> getLibri() {
		return libri;
	}
	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Override
	public String toString() {
		return  this.id + ","+ this.nome + "," +  this.cognome ;
	}

	
	
	
}
