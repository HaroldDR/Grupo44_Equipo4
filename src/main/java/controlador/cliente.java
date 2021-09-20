package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.clienteDAO;
import modelo.clienteDTO;

@WebServlet("/cliente")
public class cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public cliente() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clienteDAO clidao=new clienteDAO();
		if(request.getParameter("ingresar")!=null) {
			String direccion_cliente, email_cliente, nombre_cliente, telefono_cliente;
			int cedula_cliente;
			cedula_cliente=Integer.parseInt(request.getParameter("cedula_cliente"));
			direccion_cliente=request.getParameter("direccion_cliente");
			email_cliente=request.getParameter("email_cliente");
			nombre_cliente=request.getParameter("nombre_cliente");
			telefono_cliente=request.getParameter("telfono_cliente");
			clienteDTO cli=new clienteDTO(cedula_cliente,direccion_cliente,email_cliente,nombre_cliente,telefono_cliente);
			if(clidao.Ingresar_cliente(cli)) {
				JOptionPane.showMessageDialog(null, "se registro el cliente");
				response.sendRedirect("libros.jsp?men=se registro el cliente");
			}else {
				JOptionPane.showMessageDialog(null, "No se regitro el cliente");
				response.sendRedirect("libros.jsp?men=No se regitro el cliente");
			}
		}
		
		if(request.getParameter("consultar")!=null) {
			int cedula_cliente=Integer.parseInt(request.getParameter("cedula_cliente"));
			clienteDTO cli=clidao.Buscar_cliente(cedula_cliente);
			if(cli!=null) {
				String direccion_cliente, email_cliente, nombre_cliente, telefono_cliente;
				cedula_cliente=cli.getCedula_cliente();
				direccion_cliente=cli.getDireccion_cliente();
				email_cliente=cli.getEmail_cliente();
				nombre_cliente=cli.getNombre_cliente();
				telefono_cliente=cli.getTelefono_cliente();
				response.sendRedirect("libros.jsp?cdula_cliente="+cedula_cliente+"&&direccion_cliente="+direccion_cliente+"&&email_cliente="+email_cliente+"&&nombre_cliente="+nombre_cliente+"&&telefono_cliente="+telefono_cliente);
			}else {
				JOptionPane.showMessageDialog(null, "El cliente no existe");
				response.sendRedirect("cliente.jsp");
			}
		}
		
		if(request.getParameter("actualizar")!=null) {
			String direccion_cliente, email_cliente, nombre_cliente, telefono_cliente;
			int cedula_cliente;
			cedula_cliente=Integer.parseInt(request.getParameter("ced"));
			direccion_cliente=request.getParameter("direccion_cliente");
			email_cliente=request.getParameter("email_cliente");
			nombre_cliente=request.getParameter("_cliente");
			telefono_cliente=request.getParameter("telefono_cliente");
			clienteDTO cli=new clienteDTO(cedula_cliente,direccion_cliente,email_cliente,nombre_cliente,telefono_cliente);
			if(clidao.Actualizar_cliente(cli)) {
				JOptionPane.showMessageDialog(null, "se actualizo el cliente");
				response.sendRedirect("cliente.jsp?men=se actualizo el cliente");
			}else {
				JOptionPane.showMessageDialog(null, "no se actualizo el cliente");
				response.sendRedirect("libros.jsp?men=no se actualizo el cliente");
			}
		}
		
		if(request.getParameter("eliminar")!=null) {
			int cedula_cliente;
			cedula_cliente=Integer.parseInt(request.getParameter("ced"));
			int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el CLiente"+cedula_cliente);
			if(op==0) {
				if(clidao.Eliminar_cliente(cedula_cliente)) {
					response.sendRedirect("cliente.jsp?man=Cliente eliminado");
				}else {
					response.sendRedirect("cliente.jsp?man=Cliente no eliminado");
				}
			}else {
				response.sendRedirect("cliente.jsp");
			}
		}
	}
}
