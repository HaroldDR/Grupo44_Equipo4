package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import controlador.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class clienteDAO {
	conexion cnn=new conexion();
	Connection conec=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Ingresar_cliente(clienteDTO cli) {
		boolean resul=false;
		clienteDTO cliex=null;
		try {
			Buscar_cliente(cli.getCedula_cliente());
			if(cliex==null) {
				String sql="insert into clientes value(?,?,?,?,?)";
				ps=conec.prepareStatement(sql);
				ps.setInt(1, cli.getCedula_cliente());
				ps.setString(2, cli.getDireccion_cliente());
				ps.setString(3, cli.getEmail_cliente());
				ps.setString(4, cli.getNombre_cliente());
				ps.setString(5, cli.getTelefono_cliente());
				resul=ps.executeLargeUpdate()>0;
			}else {
				JOptionPane.showMessageDialog(null, "ya existe el cliente");
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al ingresar cliente"+ex);
		}
		return resul;
	}
	
	public clienteDTO Buscar_cliente(int cedula_liente) {
		clienteDTO cli=null;
		try {
			String sql="select * from clientes where cedula_cliente=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, cedula_liente);
			res=ps.executeQuery();
			while(res.next()) {
				cli=new clienteDTO(res.getInt(1),res.getString(2),res.getNString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Eror al Consultar"+ex);
		}
		return cli;
	}
	
	public boolean Actualizar_cliente(clienteDTO cli) {
		boolean resul=false;
		try {
			String sql="update clientes set direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=? where cedula_cliente=?";
			ps=conec.prepareStatement(sql);
			ps.setString(1, cli.getDireccion_cliente());
			ps.setString(2, cli.getEmail_cliente());
			ps.setString(3, cli.getNombre_cliente());
			ps.setString(4, cli.getTelefono_cliente());
			ps.setInt(5, cli.getCedula_cliente());
			resul=ps.executeLargeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar cliente"+ex);
		}
		return resul;
	}
	
	public boolean Eliminar_cliente(int cedula_cliente) {
		boolean resul=false;
		try {
			String sql="delete from clientes where cedula_cliente=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, cedula_cliente);
			resul=ps.executeLargeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar"+ex);
		}
		return resul;
	}
}
