package controlador;

import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class conexion{
	private String bd="tiendagenerica";
	private String url="jdbc:mysql://localhost:3306/"+bd;
	private String user="root";
	private String pass="";
	Connection conec=null;
	
	public Connection Conecta() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conec = DriverManager.getConnection(url,user,pass);
			JOptionPane.showMessageDialog(null, "conexion ok.....");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en conexion...."+e);
		}
		return conec;
	}
}
