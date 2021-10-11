package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controlador.conexion;

public class proveedorDAO {
	conexion cnn=new conexion();
	Connection conec=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Insertar_proveedor(proveedorDTO pro) {
		boolean resul=false;
		proveedorDTO proex=null;
		try {
			proex=Buscar_proveedor(pro.getNitproveedor());
			if(proex==null) {
				String sql="insert into proveedores value(?,?,?,?,?)";
				ps=conec.prepareStatement(sql);
				ps.setInt(1, pro.getNitproveedor());
				ps.setString(2, pro.getCiudad_proveedor());
				ps.setString(3, pro.getDireccion_proveedor());
				ps.setString(4, pro.getNombre_proveedor());
				ps.setString(5, pro.getTelefono_proveedor());
				resul=ps.executeUpdate()>0;
			}else {
				JOptionPane.showMessageDialog(null, "El el proveedor ya Existe");
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar el proveedor"+ex);
		}
		return resul;
	}
	
	public proveedorDTO Buscar_proveedor(int nitproveedor) {
		proveedorDTO pro=null;
		try {
			String sql="select * from proveedores where nitproveedor=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, nitproveedor);
			res=ps.executeQuery();
			while(res.next()) {
				pro=new proveedorDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al consultar"+ex);
		}
		return pro;
	}
	
	public boolean Actualizar_proveedor(proveedorDTO pro) {
		boolean resul=false;
		try {
			String sql="update proveedor set nitproveedor=?, cuidad_proveedor=?, direccion_proveedor, nombre_proveedor=?, telefono_proveedor=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, pro.getNitproveedor());
			ps.setString(2, pro.getCiudad_proveedor());
			ps.setString(3, pro.getDireccion_proveedor());
			ps.setString(4, pro.getNombre_proveedor());
			ps.setString(5, pro.getTelefono_proveedor());
			resul=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error l actualizar el proveedor"+ex);
		}
		return resul;
	}
	
	public boolean Eliminar_proveedor(int nitproveedor) {
		boolean resul=false;
		try {
			String sql="delete from proveedores where nitproveedor=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, nitproveedor);
			resul=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar proveedor"+ex);
		}
		return resul;
	}
}
