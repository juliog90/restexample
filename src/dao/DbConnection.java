package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection() throws Exception
	{
		// Aqui preparamos tanto los datos del servidor como del usuario de
        // Mysql
        String url = "jdbc:mariadb://localhost:3306/test";
        String usuario = "root";
        String clave = "";
        // Intentamos conectarnos y regresar la conexion
        try
        {
        	Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(
                     url, usuario, clave);
        }
        catch(SQLException e){
            // Imprimimos excepcion en consola
            System.out.println(e.getMessage());
            throw e;
        }
        catch(Exception e)
        {
        	throw e;
        }
	}
}
