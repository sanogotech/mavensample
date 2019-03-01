package com.openclassrooms.game;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

public class MainGame{
	
	private final static Logger log = Logger.getLogger(MainGame.class);
	
	public static void main(String[] args) {

		
		createLogs();

		String paramprop =null;

		if(args.length>0){
				paramprop = args[0];
		}
		
		System.out.println(paramprop);
		displayPropValues(paramprop);
		
	}



	public static void createLogs(){
		if(log.isDebugEnabled()){
			log.debug("This is debug : ");
		}
		
		if(log.isInfoEnabled()){
			log.info("This is info : ");
		}
		
		log.warn("This is warn : ");
		log.error("This is error : ");
		log.fatal("This is fatal : ");


	}


	public static  void displayPropValues(String paramprop)  {

		InputStream inputStream=null;
		  //FileInputStream inputStream =null;
 
		try {
			Properties prop = new Properties();

			String propFileName = null;

			if("--ext".equals(paramprop)){

					propFileName = "./config/configexternal.properties";
					inputStream = new FileInputStream(propFileName);

			}else{

			   propFileName = "config.properties";
			   inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propFileName);

			}
			
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				log.error("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the property value and print it out
			String rechercheNombrechiffre = prop.getProperty("rechercheNombrechiffre");
			String rechercheNombreessai = prop.getProperty("rechercheNombreessai");
			String masterNombrecouleur = prop.getProperty("masterNombrecouleur");

			String confvalues = "rechercheNombrechiffre = "+rechercheNombrechiffre + " rechercheNombreessai =" +rechercheNombreessai + " masterNombrecouleur ="+masterNombrecouleur;

			log.debug(confvalues);

			inputStream.close();

		}catch ( FileNotFoundException e) {
			log.error("FileNotFoundException: " + e);

		}catch (IOException e) {
			log.error("IOException: " + e);
		}catch (Exception e) {
			log.error("Exception: " + e);
		} 

	}
	
}