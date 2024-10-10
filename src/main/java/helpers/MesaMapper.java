package helpers;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import models.Mesa;

public class MesaMapper {

	public static String fileName;
	public static String imagenRuta;

    // Método que mapea un ResultSet a un objeto Mesa
    public static Mesa mapResultSetToMesa(ResultSet resultSet) throws SQLException {
        Mesa mesa = new Mesa();
        mesa.setId(resultSet.getInt("id_mesa"));
        mesa.setCodigo(resultSet.getString("codigo"));
        mesa.setCapacidad(resultSet.getInt("capacidad"));
        mesa.setEstado(resultSet.getString("estado"));
        mesa.setUbicacion(resultSet.getString("ubicacion"));
        mesa.setDecorada(resultSet.getBoolean("decorada"));
        // Extraer imagen como byte[]
        byte[] imagenBytes = resultSet.getBytes("imagen");
        mesa.setImagen(imagenBytes); // Usar el setter que maneja byte[]
        // Obtener la ruta de la imagen
        String rutaImagen = resultSet.getString("ruta_imagen");
        mesa.setImagenRuta(rutaImagen);
        
        showMesa(mesa);
        return mesa;
    }

    // Método que mapea los parámetros de la solicitud a un objeto Mesa
    public static Mesa mapRequestParamsToMesa(HttpServletRequest req) throws IOException, ServletException { 
    	
        Mesa mesa = new Mesa();         

        // Extraer y validar los parámetros
        String codigo = req.getParameter("codigo");
        String capacidadStr = req.getParameter("capacidad");
        String estado = req.getParameter("estado");
        String ubicacion = req.getParameter("ubicacion");
        String decoradaStr = req.getParameter("decorada");        
        Part filePart = req.getPart("imagen");
        fileName = (filePart != null) ? filePart.getSubmittedFileName() : null;
        Integer id =  req.getParameter("id") != null ? Integer.parseInt( req.getParameter("id") ) : null;
        byte[] imagenBytes = null;
        

        if (fileName != null) {
			// Se recibe un archivo
			imagenBytes = filePart.getInputStream().readAllBytes();  	          
			imagenRuta = "uploads/"  + fileName;		
			System.out.println("Imagen recibida con tamaño: " + imagenBytes.length + " bytes");
	        mesa.setImagen(imagenBytes); // Puede ser null si no se recibe imagen
	        mesa.setImagenRuta(imagenRuta); // Puede ser null si no se recibe imagen     
			
        } else {
            System.out.println("No se recibió archivo.");
        }

        // Setear los valores en el objeto Mesa
        mesa.setCodigo(codigo);
        mesa.setCapacidad(Integer.parseInt(capacidadStr));
        mesa.setEstado(estado);
        mesa.setUbicacion(ubicacion);
        mesa.setDecorada(Boolean.parseBoolean(decoradaStr));
 
        mesa.setId(id);          

        return mesa;
    }

    // Método para mapear el ID de la solicitud a un objeto Mesa
    public static Mesa mapRequestIdToMesa(HttpServletRequest req) {    
        Mesa mesa = new Mesa();
        String id = req.getParameter("id");

        if (id != null && !id.isEmpty()) {
            mesa.setId(Integer.parseInt(id));
        } else {
            throw new IllegalArgumentException("ID inválido en la solicitud");
        }

        return mesa;
    }
    
    public static void showMesa(Mesa mesa) {	
    	System.out.println("Mostrando  mesa actual");
		System.out.println("Codigo:  "  +  mesa.getCodigo());
		System.out.println("Capacidad:  "  +  mesa.getCapacidad());		
		System.out.println("Estado:  "  +  mesa.getEstado());
		System.out.println("Ubicacion:  "  +  mesa.getUbicacion());
		System.out.println("Decorada:  "  +  mesa.getDecorada());
		System.out.println("Imagen:  "  +  mesa.getImagen());
		System.out.println("ImagenRuta:  "  +  mesa.getImagenRuta());
		System.out.println("Id:  "  +  mesa.getId());	
	}
    
    
}
