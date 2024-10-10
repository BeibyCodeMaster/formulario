package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Mesa;
import models.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helpers.FileUploadHelper;
import helpers.JsonResponseHandler;
import helpers.MesaMapper;

/**
 * Servlet implementation class MesaServlet
 */

@MultipartConfig
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String usuario = request.getParameter("usuario");	
		String password = request.getParameter("password");	
	
		Usuario user = new Usuario();
		user.set_usuario(usuario);
		user.set_password(password);
    	
	    request.setAttribute("user", user);
    	request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List mesas = new ArrayList<Mesa>();		 
    	
        try {
            Mesa mesa = MesaMapper.mapRequestParamsToMesa(request);
            mesas.add(mesa);
            MesaMapper.showMesa(mesa);
            crearDirectorio();
            guardarImagen(mesa);
            request.setAttribute("mesas", mesas);
            request.getRequestDispatcher("/home.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
            this.handleError(response, "Error en la petición POST: " + e.getMessage());
        }
    }

    private void handleError(HttpServletResponse res, String errorMessage) throws IOException {
        res.setContentType("application/json");
        System.out.println(errorMessage);
        try (PrintWriter out = res.getWriter()) {
            JsonResponseHandler.enviarRespuesta(out, false, errorMessage);
        }
    }

    private void guardarImagen(Mesa mesa) throws IOException {
        if (mesa.getImagen() != null) {
            FileUploadHelper.saveImageFromDatabase(mesa.getImagen(), FileUploadHelper.DIR_PATH + "/" + MesaMapper.fileName);
        }
    }

    private void crearDirectorio() throws IOException {
        FileUploadHelper.createDirectoryIfNotExists();
    }
        
}
