package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controlador.conexion;

public class productoDAO {
	
	conexion cnn=new conexion();
	Connection conec=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean cargar_productos(String ruta) {
		boolean resul=false;
		
		try {
			String sql="load data infile '"+ruta+"' into table productos fields terminated by ',' lines terminated by '\r\n';";
			ps=conec.prepareStatement(sql);
			resul=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al cargar los productos"+ex);
		}
		return resul;
	}
}
