package com.biblioteca.ui;

import com.biblioteca.dao.AutoreDao;
import com.biblioteca.dao.LibroDao;
import com.biblioteca.model.Autore;
import com.biblioteca.model.Libro;

/*import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import com.biblioteca.dao.AutoreDao;
import com.biblioteca.dao.LibroDao;
import com.biblioteca.model.Autore;
import com.biblioteca.model.Libro;
*/


public class Application {

	public static void main(String[] args) throws Exception {

		try {
			
		Libro l = new Libro();
		Autore a = new Autore();
		
		LibroDao lDao = new LibroDao();
        AutoreDao aDao = new AutoreDao();
        
        
       l= lDao.findById(3L, false);
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println(e);
		}
	}

	/* private static Long scegliAutore() throws Exception {

		Long selectedId = null;

		System.out.println("Selezionare l'autore:");
        Autore aut= null;
		AutoreDao au = new AutoreDao();
		List<Autore> authList = au.findAll();

		for (Autore a : authList) {
			System.out.println(a);
		}

		Long l = null;
		Scanner s = new Scanner(System.in);
		do {
			try {
				

				String id = s.nextLine();
				// ci vuole il costrutto try catch per essere sicuro che l'utente non inserisca
				// dei caratteri
				l = Long.parseLong(id);

				// ci serve il metodo findById dell'autore
                  aut =  au.findAutoreByid(l);
                    		
				if (aut == null)
					throw new Exception();
			}

			catch (Exception ex) {
				System.err.println("Id non valido per autore");
			}
		} while (l == null);

		System.out.println(aut);
		return l;
	}

	/*
	 * Filter //String q0 = "select * from libro "
	 * 
	 * boolean where = false;
	 * 
	 * if(titolo != null) { q0 += "where titolo = ?"; where = true; } if (isbn !=
	 * null) { if(where){ q0+= " and isbn= ?"; } else {
	 * 
	 * 
	 * q0+= "where isbn = ?"; where = true; }
	 * 
	 * PreparedStatement ps = conn.prepareStatement(q0); }
	 */

}
