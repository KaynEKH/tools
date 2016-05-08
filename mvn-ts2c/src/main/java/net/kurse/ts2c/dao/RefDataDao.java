package net.kurse.ts2c.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.kurse.ts2c.utils.DBConnexion;
import net.kurse.ts2c.utils.IConstantes;

public class RefDataDao {

	public static void test () {
 		DBConnexion db = new DBConnexion(IConstantes.DB_PATH); 
		db.connect();
		ResultSet rs = db.query("SELECT * FROM ECHELLE");
        try {
            while (rs.next()) {
            	StringBuilder sb = new StringBuilder();
            	sb.append(rs.getString("Value"));
            	sb.append(" : ");
            	sb.append(rs.getString("Description"));
                System.out.println(sb.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
