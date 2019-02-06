package com.biblioteca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="libro")

public class Libro implements Serializable{

	
	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
		private long id;
	
	@Column(name="isbn")
		private String isbn;
	
	@Column(name="Titolo")
		private String titolo;
	
	@Column(name="prezzo")
		private float prezzo;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_autore")
	private Autore autore; 
		
	@Column(name="version")
		private int version;
		
	
		public Libro(){
			this.autore = new Autore(); 
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getTitolo() {
			return titolo;
		}
		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}
		public float getPrezzo() {
			return prezzo;
		}
		public void setPrezzo(float prezzo) {
			this.prezzo = prezzo;
		}
		public Autore getAutore() {
			return autore;
		}
		public void setAutore(Autore autore) {
			this.autore = autore;
		}
		public int getVersion() {
			return version;
		}
		public void setVersion(int version) {
			this.version = version;
		}
		@Override
		public String toString() {
			return  isbn + "," + titolo + "," + prezzo + "," + autore;
		}
	
		
	

}
