/**
 * ConfigPropertyLoader.java
 *
 * robgion
 * www.2clever.it
 * 
 * 21 giu 2017
 * For further information please write to info@2clever.it
 */
package com.biblioteca.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author robgion
 *
 * Classe per il caricamento di risorse esterne tramite file *.properties.
 */
public class ConfigPropertyLoader {

	private Properties prop = new Properties();
	
	public ConfigPropertyLoader() throws Exception {
		
		loadConfigFile();
	}
	
	private void loadConfigFile() throws Exception {
	
		FileInputStream fis = null;
		try {
			
			fis = new FileInputStream("META-INF/database.properties");
			prop.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				fis.close();
			}
		}
	}
	
	public String readProperty(String key) {
		return prop.getProperty(key);
	}
	
	}
	

