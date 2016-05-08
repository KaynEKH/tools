/**
 * 
 */
package net.kurse.ts2c.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author KaynEKH
 *
 */
public class DBConnexion {

    private String DBPath = null;
    private Connection connection = null;
    private Statement statement = null;
 
    public DBConnexion(String dBPath) {
        DBPath = dBPath;
    }
 
    public String getDbPath() {
    	File dbFile = new File(IConstantes.DB_PATH);
    	String dbPath = dbFile.getAbsolutePath();
    	return dbPath;
    }
    
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + getDbPath());
            statement = connection.createStatement();
            System.out.println("Connexion : " + DBPath + " avec succès");
            DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
            System.out.println("Driver name: " + dm.getDriverName());
            System.out.println("Driver version: " + dm.getDriverVersion());
            System.out.println("Product name: " + dm.getDatabaseProductName());
            System.out.println("Product version: " + dm.getDatabaseProductVersion());
            ResultSet rs = dm.getCatalogs();
            while (rs.next()) {
            	
            }
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connexion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connexion");
        }
    }
 
    public void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public ResultSet query(String request) {
        ResultSet resultSet = null;
        try {
        	resultSet = statement.executeQuery(request);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans la requet : " + request);
        }
        return resultSet;
  
    }
    
}
