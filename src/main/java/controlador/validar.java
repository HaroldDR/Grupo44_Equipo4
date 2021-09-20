package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/validar")
public class validar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public validar() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("enviar")!=null ) {
			String usuario, password;
			usuario=request.getParameter("usuario");
			password=request.getParameter("password");
			if(usuario.equals("admininicial") && password.equals("admin123456")) {
				response.sendRedirect("menu.jsp");
			}else{
				JOptionPane.showMessageDialog(null, "Datos Incorrectos, inténtelo de nuevo");
				response.sendRedirect("login.jsp");
			}
		}
	}

}
