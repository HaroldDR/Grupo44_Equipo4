package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;
import modelo.productoDAO;
import javax.servlet.annotation.MultipartConfig;

@WebServlet("/producto")
@MultipartConfig
public class producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public producto() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		productoDAO prodao=new productoDAO();

		if(request.getParameter("cargar")!=null) {
			Part archivo=request.getPart("archivo");
			String Url="C:\\Users\\Shadow\\eclipse-workspace\\Grupo44_Equipo4\\src\\main\\webapp\\archivos\\";
			try {
				InputStream file=archivo.getInputStream();
				File copia=new File("productos.csv");
				FileOutputStream escribir=new FileOutputStream(copia);
				int num=file.read();
				while(num!=-1) {
					escribir.write(num);
					num=file.read();
				}
				escribir.close();
				file.close();
				JOptionPane.showMessageDialog(null, "El archivo se cargo correctamente");
				if(prodao.cargar_productos(Url+"producto.csv")) {
					response.sendRedirect("producto.jsp?men=Se insertaron los productos");
				}else {
					response.sendRedirect("producto.jsp?men=No se insertaron los productos");
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error de archivo...."+e);
			}
		}
	}
}
