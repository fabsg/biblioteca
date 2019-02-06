package com.biblioteca.dao;

import javax.persistence.EntityManager;

//import com.biblioteca.model.Autore;
import com.biblioteca.model.Libro;
import com.biblioteca.utils.DataBaseUtils;

/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biblioteca.model.Autore;
import com.biblioteca.model.Libro;
import com.biblioteca.utils.DataBaseUtils; */

public class LibroDao {

	/*
	 * public List<Libro> loadAll() throws Exception {
	 * 
	 * List<Libro> libri = null; Connection connection = null;
	 * 
	 * try { connection = DataBaseUtils.openMySqlConnection();
	 * 
	 * Statement stmt = connection.createStatement(); ResultSet rs =
	 * stmt.executeQuery(
	 * "SELECT l.Titolo,l.isbn,l.prezzo,a.id as id_autore, a.nome,a.cognome FROM biblioteca.libro as l inner join biblioteca.autori as a on l.id_autore = a.id"
	 * );
	 * 
	 * libri = new ArrayList<Libro>();
	 * 
	 * while (rs.next()) {
	 * 
	 * Libro l = new Libro(); Autore a = new Autore();
	 * l.setTitolo(rs.getString("Titolo")); l.setIsbn(rs.getString("isbn"));
	 * l.setPrezzo(rs.getFloat("prezzo"));
	 * 
	 * a.setId(rs.getLong("id_autore")); a.setNome(rs.getString("nome"));
	 * a.setCognome(rs.getString("cognome")); l.setAutore(a);
	 * 
	 * libri.add(l); } } catch (Exception e) {
	 * 
	 * throw new Exception("ERROR002", e); } finally { if (connection != null)
	 * connection.close();
	 * 
	 * }
	 * 
	 * return libri;
	 * 
	 * }
	 * 
	 * public Libro findlibro(Long id) throws Exception {
	 * 
	 * Libro libri = null; Connection connection = null;
	 * 
	 * try { connection = DataBaseUtils.openMySqlConnection(); String query =
	 * "SELECT l.Titolo,l.isbn,l.prezzo," + "a.id as id_autore, a.nome,a.cognome" +
	 * " FROM biblioteca.libro as l inner join biblioteca.autori " +
	 * "as a on l.id_autore = a.id";
	 * 
	 * if (id != null) { query += " where l.id =?";
	 * 
	 * }
	 * 
	 * PreparedStatement stmt = connection.prepareStatement(query); stmt.setLong(1,
	 * id); ResultSet rs = stmt.executeQuery();
	 * 
	 * libri = new Libro(); Autore autori = new Autore();
	 * 
	 * if (rs.next()) {
	 * 
	 * libri.setTitolo(rs.getString("Titolo")); libri.setIsbn(rs.getString("isbn"));
	 * libri.setPrezzo(rs.getFloat("prezzo"));
	 * 
	 * autori.setId(rs.getLong("id_autore")); autori.setNome(rs.getString("nome"));
	 * autori.setCognome(rs.getString("cognome"));
	 * 
	 * libri.setAutore(autori);
	 * 
	 * } else libri = null; } catch (Exception e) {
	 * 
	 * throw new Exception("ERROR002", e); } finally { if (connection != null)
	 * connection.close();
	 * 
	 * }
	 * 
	 * return libri;
	 * 
	 * }
	 * 
	 * public void inserimento(Libro l) throws Exception {
	 * 
	 * Connection connection = null;
	 * 
	 * try { connection = DataBaseUtils.openMySqlConnection(); String query =
	 * "Insert into biblioteca.libro (isbn,Titolo,prezzo,id_autore) values (?,?,?,?); "
	 * ;
	 * 
	 * PreparedStatement stmt = connection.prepareStatement(query,
	 * Statement.RETURN_GENERATED_KEYS);
	 * 
	 * stmt.setString(1, l.getIsbn()); stmt.setString(2, l.getTitolo());
	 * stmt.setFloat(3, l.getPrezzo()); stmt.setLong(4, l.getAutore().getId());
	 * 
	 * 
	 * stmt.executeUpdate();
	 * 
	 * 
	 * } catch (Exception e) {
	 * 
	 * throw new Exception("ERR", e); }
	 * 
	 * finally { if (connection != null) ; connection.close(); }
	 * 
	 * }
	 * 
	 * public boolean deleteLibro(long id) throws Exception {
	 * 
	 * Connection connection = null; Libro l = new Libro(); boolean deleteComplete =
	 * false;
	 * 
	 * try { connection = DataBaseUtils.openMySqlConnection(); l = findlibro(id);
	 * 
	 * if (l != null) {
	 * 
	 * String query = "DELETE FROM biblioteca.libro WHERE id=? "; PreparedStatement
	 * stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 * stmt.setLong(1, id); stmt.executeUpdate();
	 * 
	 * deleteComplete = true; }
	 * 
	 * } catch (Exception e) {
	 * 
	 * throw new Exception(e); }
	 * 
	 * finally { if (connection != null) ; connection.close(); }
	 * 
	 * return deleteComplete;
	 * 
	 * }
	 * 
	 * public void modificaLibro(Long id,int campo_modifica) throws Exception {
	 * 
	 * Connection connection = null; String query = "UPDATE biblioteca.libro " ; try
	 * { connection = DataBaseUtils.openMySqlConnection();
	 * 
	 * 
	 * // Seleziona campo da modificare if(campo_modifica == 0) { query +=
	 * " set isbn = ? WHERE id = ? " ; System.out.println("Inserisci nuovo isbn: ");
	 * Scanner s = new Scanner(System.in); String isbn = s.nextLine();
	 * PreparedStatement stmt = connection.prepareStatement(query,
	 * Statement.RETURN_GENERATED_KEYS); stmt.setString(1, isbn); stmt.setLong(2,
	 * id); stmt.executeUpdate(); }
	 * 
	 * else if(campo_modifica == 1) { query+="set Titolo = ? where id = ?;" ;
	 * System.out.println("Inserisci nuovo Titolo"); Scanner s = new
	 * Scanner(System.in); String titolo = s.nextLine(); PreparedStatement stmt =
	 * connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 * stmt.setString(1, titolo); stmt.setLong(2, id); stmt.executeUpdate();
	 * 
	 * }
	 * 
	 * else if(campo_modifica == 2) { query+="set id_autore = ? where id = ? ;" ;
	 * System.out.println("Inserisci nuovo id_autore: "); Scanner s = new
	 * Scanner(System.in); Long l = Long.parseLong(s.nextLine()); PreparedStatement
	 * stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 * stmt.setLong(1, l); stmt.setLong(2, id); stmt.executeUpdate(); } else
	 * if(campo_modifica == 3) { query+="set prezzo = ? where id = ?;" ;
	 * System.out.println("Inserisci nuovo prezzo: "); Scanner s = new
	 * Scanner(System.in); Long l = Long.parseLong(s.nextLine()); PreparedStatement
	 * stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	 * stmt.setLong(1, l); stmt.setLong(2, id); stmt.executeUpdate(); } else
	 * if(campo_modifica > 3 | campo_modifica<0) {
	 * 
	 * System.out.println("Scelta non possibile");
	 * 
	 * }
	 * 
	 * } catch (Exception e) {
	 * 
	 * throw new Exception(e);
	 * 
	 * 
	 * } }
	 */

	public Libro findById(Long id, boolean eager) {

		EntityManager em = null;
		Libro cust = null;

		try {
			em = DataBaseUtils.getInstance().getEntityManager();
			cust = em.find(Libro.class, id);

			if (eager) {
				cust.getAutore().getNome();
			    cust.getAutore().getCognome();
			}
		} finally {
			if (em != null)
				em.close();

		}

		return cust;
	}

}
