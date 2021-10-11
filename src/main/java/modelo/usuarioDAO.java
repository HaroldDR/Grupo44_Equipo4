package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import controlador.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class usuarioDAO {
	conexion cnn=new conexion();
	Connection conec=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Ingresar_usuario(usuarioDTO usu) {
		boolean resul=false;
		usuarioDTO usuex=null;
		try {
			usuex=Buscar_usuario(usu.getCedula_usuario());
			if(usuex==null) {
				String sql="insert into usuarios value(?,?,?,?,?)";
				ps=conec.prepareStatement(sql);
				ps.setInt(1, usu.getCedula_usuario());
				ps.setString(2, usu.getEmail_usuario());
				ps.setString(3, usu.getNombre_usuario());
				ps.setString(4, usu.getUsuario());
				ps.setString(5, usu.getPassword());
				resul=ps.executeLargeUpdate()>0;
			}else {
				JOptionPane.showMessageDialog(null, "ya existe el usuario");
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al ingresar usuario"+ex);
		}
		return resul;
	}
	
	public usuarioDTO Buscar_usuario(int cedula_usuario) {
		usuarioDTO usu=null;
		try {
			String sql="select * from usuarios where cedula_usuario=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, cedula_usuario);
			res=ps.executeQuery();
			while(res.next()) {
				usu=new usuarioDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Eror al Consultar"+ex);
		}
		return usu;
	}
	
	public boolean Actualizar_usuario(usuarioDTO usu) {
		boolean resul=false;
		try {
			String sql="update usuarios set email_usuario=?, nombre_usuario=?, password=?, usuario=? where cedula_usuario=?";
			ps=conec.prepareStatement(sql);
			ps.setString(1, usu.getEmail_usuario());
			ps.setString(2, usu.getNombre_usuario());
			ps.setString(3, usu.getPassword());
			ps.setString(4, usu.getUsuario());
			ps.setInt(5, usu.getCedula_usuario());
			resul=ps.executeLargeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar usuario"+ex);
		}
		return resul;
	}
	
	public boolean Eliminar_usuario(int cedula_usuario) {
		boolean resul=false;
		try {
			String sql="delete from usuarios where cedula_usuario=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, cedula_usuario);
			resul=ps.executeLargeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar"+ex);
		}
		return resul;
	}
}
