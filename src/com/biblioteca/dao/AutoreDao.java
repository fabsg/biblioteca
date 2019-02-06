package com.biblioteca.dao;

import javax.persistence.EntityManager;

import com.biblioteca.model.Autore;
import com.biblioteca.utils.DataBaseUtils;

/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import com.biblioteca.model.Autore;
import com.biblioteca.model.Libro;
import com.biblioteca.utils.DataBaseUtils; */

public class AutoreDao {

	/*
	 * public List<Autore> findAll() throws Exception { // carica tutti gli autori
	 * in tabella
	 * 
	 * List<Autore> retList = null; Connection connection = null;
	 * 
	 * try{
	 * 
	 * // richiesta connessione connection = DataBaseUtils.openMySqlConnection();
	 * 
	 * // 3 ottengo lo statement Statement stmt = connection.createStatement();
	 * 
	 * // 4 eseguo la query e leggo il risultato ResultSet rs =
	 * stmt.executeQuery("Select id,nome,cognome,version From biblioteca.autori");
	 * 
	 * retList = new ArrayList<Autore>();
	 * 
	 * while(rs.next()){ // popolo autore con i dati del DB
	 * 
	 * Autore au = new Autore(); au.setId(rs.getLong("id"));
	 * au.setNome(rs.getString("nome")); au.setCognome(rs.getString("cognome"));
	 * au.setVersion(rs.getInt("version"));
	 * 
	 * // lo inserisco nella lista retList.add(au); } } catch(Exception e) {
	 * 
	 * throw new Exception("ERROR001", e);
	 * 
	 * } finally { if(connection != null) connection.close(); }
	 * 
	 * return retList; }
	 * 
	 * public Long inserimentoAutore(Autore au) throws Exception{
	 * 
	 * Connection connection = null;
	 * 
	 * 
	 * try{ connection = DataBaseUtils.openMySqlConnection(); String query =
	 * "Insert into autori (nome,cognome)" + " values (?,?)";
	 * 
	 * PreparedStatement stmt =
	 * connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	 * 
	 * 
	 * 
	 * stmt.setString(1,au.getNome()); stmt.setString(2,au.getCognome());
	 * 
	 * stmt.executeUpdate();
	 * 
	 * ResultSet rs = stmt.getGeneratedKeys();
	 * 
	 * if (rs.next());
	 * 
	 * Long chiave = rs.getLong("id"); return chiave; } catch(Exception e){
	 * 
	 * throw new Exception("ERR",e); }
	 * 
	 * finally { if(connection != null); connection.close(); } }
	 * 
	 * public Autore findAutoreByid(Long id) throws Exception {
	 * 
	 * Autore a = null; Connection connection = null;
	 * 
	 * try { connection = DataBaseUtils.openMySqlConnection(); String query =
	 * "SELECT id, nome,cognome FROM biblioteca.autori where id=?";
	 * 
	 * PreparedStatement stmt = connection.prepareStatement(query); stmt.setLong(1,
	 * id); ResultSet rs = stmt.executeQuery();
	 * 
	 * 
	 * 
	 * if (rs.next()) { a = new Autore(); a.setId(rs.getLong("id"));
	 * a.setNome(rs.getString("nome")); a.setCognome(rs.getString("cognome"));
	 * 
	 * 
	 * } } catch (Exception e) {
	 * 
	 * throw new Exception("ERROR002", e); } finally { if (connection != null)
	 * connection.close();
	 * 
	 * }
	 * 
	 * return a;
	 * 
	 * }
	 */

	public Autore findById(Long id, boolean eager) {

		EntityManager em = null;
		Autore cust = null;

		try {
			em = DataBaseUtils.getInstance().getEntityManager();
			cust = em.find(Autore.class, id);

			if (eager)
				cust.getLibri().size();
		} finally {
			if (em != null)
				em.close();

		}

		return cust;
	}

}
