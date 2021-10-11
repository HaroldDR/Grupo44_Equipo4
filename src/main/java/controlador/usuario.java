package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.usuarioDAO;
import modelo.usuarioDTO;

@WebServlet("/usuario")
@MultipartConfig
public class usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public usuario() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuarioDAO usudao=new usuarioDAO();
		if(request.getParameter("ingresar")!=null) {
			String email_usuario, nombre_usuario, password, usuario;
			int cedula_usuario;
			cedula_usuario=Integer.parseInt(request.getParameter("cedula_usuario"));
			email_usuario=request.getParameter("email_usuario");
			nombre_usuario=request.getParameter("nombre_usuario");
			password=request.getParameter("password");
			usuario=request.getParameter("usuario");
			usuarioDTO usu=new usuarioDTO(cedula_usuario,email_usuario,nombre_usuario,password,usuario);
			if(usudao.Ingresar_usuario(usu)) {
				JOptionPane.showMessageDialog(null, "se registro el usuario");
				response.sendRedirect("usuario.jsp?men=se registro el usuario");
			}else {
				JOptionPane.showMessageDialog(null, "No se regitro el usuario");
				response.sendRedirect("usuario.jsp?men=No se regitro el usuario");
			}
		}
		
		if(request.getParameter("consultar")!=null) {
			int cedula_usuario = Integer.parseInt(request.getParameter("cedula_usuario"));
			usuarioDTO usu=usudao.Buscar_usuario(cedula_usuario);
			if(usu!=null) {
				String email_usuario, nombre_usuario, password, usuario;
				//int cedula_usuario;
				cedula_usuario=usu.getCedula_usuario();
				email_usuario=usu.getEmail_usuario();
				nombre_usuario=usu.getNombre_usuario();
				password=usu.getPassword();
				usuario=usu.getUsuario();
				response.sendRedirect("usuario.jsp?cedula_usuario="+cedula_usuario+"&&email_usuario="+email_usuario+"&&nombre_usuario="+nombre_usuario+"&&password="+password+"&&usuario="+usuario);
			}else {
				JOptionPane.showMessageDialog(null, "El usuario no existe");
				response.sendRedirect("usuario.jsp");
			}
		}
		
		if(request.getParameter("actualizar")!=null) {
			String email_usuario, nombre_usuario, password, usuario;
			int cedula_usuario;
			cedula_usuario=Integer.parseInt(request.getParameter("ced"));
			email_usuario=request.getParameter("email_usuario");
			nombre_usuario=request.getParameter("nombre_usuario");
			password=request.getParameter("password");
			usuario=request.getParameter("usuario");
			usuarioDTO usu=new usuarioDTO(cedula_usuario,email_usuario,nombre_usuario,password,usuario);
			if(usudao.Actualizar_usuario(usu)) {
				JOptionPane.showMessageDialog(null, "se actualizo el usuario");
				response.sendRedirect("usuario.jsp?men=se actualizo el usuario");
			}else {
				JOptionPane.showMessageDialog(null, "no se actualizo el usuario");
				response.sendRedirect("usuario.jsp?men=no se actualizo el usuario");
			}
		}
		
		if(request.getParameter("eliminar")!=null) {
			int cedula_usuario;
			cedula_usuario=Integer.parseInt(request.getParameter("ced"));
			int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el usuario"+cedula_usuario);
			if(op==0) {
				if(usudao.Eliminar_usuario(cedula_usuario)) {
					response.sendRedirect("usuario.jsp?men=Usuario eliminado");
				}else {
					response.sendRedirect("usuario.jsp?men=Usuario no eliminado");
				}
			}else {
				response.sendRedirect("usuario.jsp");
			}
		}
	}
}
