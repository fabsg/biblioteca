package com.biblioteca.utils;

import javax.persistence.EntityManager;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBaseUtils {

	/*
	 * private static ConfigPropertyLoader cfg = null; private boolean isMSqlOpen =
	 * false;
	 * 
	 * // pattern SingolTom private static DataBaseUtils _instance = null; static {
	 * // Leggo il file di configurazione try { cfg = new ConfigPropertyLoader();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); System.exit(0); } }
	 * 
	 * private DataBaseUtils() {
	 * 
	 * }
	 * 
	 * private void initMySqlDriver() { // Istanzia il driver if (isMSqlOpen ==
	 * false) {
	 * 
	 * try { Class.forName(cfg.readProperty("database.driver")); isMSqlOpen = true;
	 * 
	 * } catch (Exception e) { e.printStackTrace(); System.exit(0); } }
	 * 
	 * }
	 * 
	 * public static DataBaseUtils getInstance() { if (_instance == null) {
	 * 
	 * _instance = new DataBaseUtils(); }
	 * 
	 * return _instance; }
	 * 
	 * public static Connection openMySqlConnection() throws SQLException {
	 * 
	 * // 2 avvio la connessione return
	 * DriverManager.getConnection(cfg.readProperty("database.url"),
	 * cfg.readProperty("database.username"),
	 * cfg.readProperty("database.password"));
	 * 
	 * }
	 */

	private static DataBaseUtils _instance = null;

	private EntityManagerFactory emfactory = null;

	private DataBaseUtils() {

		emfactory = Persistence.createEntityManagerFactory("Biblioteca");
	}

	public static synchronized DataBaseUtils getInstance() {

		if (_instance == null) {
			_instance = new DataBaseUtils();
		}
		return _instance;
	}

	public EntityManager getEntityManager() {
		return emfactory.createEntityManager();
	}

}
