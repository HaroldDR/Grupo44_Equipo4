package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;
import modelo.proveedorDAO;
import modelo.proveedorDTO;

@WebServlet("/proveedor")
@MultipartConfig
public class proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public proveedor() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proveedorDAO prodao= new proveedorDAO();
		
		if(request.getParameter("insertar")!=null) {
			String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;
			int nitproveedor;
			nitproveedor=Integer.parseInt(request.getParameter("nitproveedor"));
			ciudad_proveedor=request.getParameter("ciudad_proveedor");
			direccion_proveedor=request.getParameter("direecion_proveedor");
			nombre_proveedor=request.getParameter("nombre_proveedor");
			telefono_proveedor=request.getParameter(telefono_proveedor);
			proveedorDTO pro=new proveedorDTO(nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor);
			if(prodao.Insertar_proveedor(pro)) {
				response.sendRedirect("proveedor.jsp?men=Se Registro el proveedor exitosamente!!");
			}else {
				response.sendRedirect("proveedor.jsp?men=No se Registro el proveedor.....");
			}
		}
		
		if(request.getParameter("consultar")!=null) {
			int nitproveedor=Integer.parseInt(request.getParameter("nitproveedor"));
			proveedorDTO pro=prodao.Buscar_proveedor(nitproveedor);
			if(pro!=null) {
				String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;
				int nitproveedor;
				nitproveedor=pro.getNitproveedor();
				ciudad_proveedor=pro.getCiudad_proveedor();
				direccion_proveedor=pro.getDireccion_proveedor();
				nombre_proveedor=pro.getNombre_proveedor();
				telefono_proveedor=pro.getTelefono_proveedor();
				response.sendRedirect("proveedor.jsp?nitproveedor="+nitproveedor+"&&ciudad_proveedor="+ciudad_proveedor+"&&direccion_proveedor="
						+direccion_proveedor+"&&nombre_proveedor="+nombre_proveedor+"&&telefono_proveedor="+telefono_proveedor);
			}else {
				JOptionPane.showMessageDialog(null, "El proveedor no Existe");
				response.sendRedirect("proveedor.jsp");
			}
		}
		
		if(request.getParameter("actualizar")!=null) {
			String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;
			int nitproveedor;
			nitproveedor=Integer.parseInt(request.getParameter("nitproveedor"));
			ciudad_proveedor=request.getParameter("ciudad_poveedor");
			direccion_proveedor=request.getParameter("direccion_proveedor");
			nombre_proveedor=request.getParameter("nombre_proveedor");
			telefono_proveedor=request.getParameter("telefono_proveedor");
			proveedorDTO pro=new proveedorDTO(nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor);
			if(prodao.Actualizar_proveedor(pro)) {
				response.sendRedirect("proveedor.jsp?men=Se Actualizo el proveedor exitosamente!!");
			}else {
				response.sendRedirect("proveedor.jsp?men=No se Actualizo el proveedor.....");
			}
		}
		
		if(request.getParameter("eliminar")!=null) {
			int nitproveedor;
			nitproveedor=Integer.parseInt(request.getParameter("nit"));
			int op=JOptionPane.showConfirmDialog(null, "Desea Eliminar el proveedor NIT: "+nitproveedor);
			if(op==0){
			if(prodao.Eliminar_proveedor(nitproveedor)) {
				response.sendRedirect("proveedor.jsp?men=proveedor Eliminado");
			}else {
				response.sendRedirect("proveedor.jsp?men=El proveedor no se elimino");
			}
			}else {
				response.sendRedirect("proveedor.jsp");
			}
		}
	}
}
