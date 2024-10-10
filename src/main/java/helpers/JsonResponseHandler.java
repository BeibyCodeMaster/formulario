package helpers;

import java.io.PrintWriter;

import org.json.JSONObject;
import models.Mesa;

public class JsonResponseHandler {
	
    public static void enviarRespuesta(PrintWriter out, boolean isSuccess, String message) {
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("success", isSuccess);
        jsonResponse.put("message", message);
        out.print(jsonResponse);
        out.flush();
        out.close();
    }

    public static void enviarRespuestaConDatos(PrintWriter out, boolean isSuccess, String message, JSONObject data) {
    	JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", isSuccess);
		jsonResponse.put("message", message); 
		jsonResponse.put("data", data); 	  
		out.print(jsonResponse);
		out.flush();
		out.close();        
    }
    
    
    public static JSONObject getMesaToJson( Mesa mesa) {
    	JSONObject jsonResponse = new JSONObject();    	
		jsonResponse.put("id", mesa.getId());
		jsonResponse.put("codigo", mesa.getCodigo());		 
		jsonResponse.put("estado", mesa.getEstado());
		jsonResponse.put("decorada", mesa.getDecorada());		   
		jsonResponse.put("capacidad", mesa.getCapacidad());	
		jsonResponse.put("ubicacion", mesa.getUbicacion()); 
		jsonResponse.put("imagen", mesa.getImagen());
		jsonResponse.put("ruta_imagen", mesa.getImagenRuta());		
		return jsonResponse;    	
    }
    	
}
