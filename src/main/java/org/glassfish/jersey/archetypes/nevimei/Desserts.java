package org.glassfish.jersey.archetypes.nevimei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("desserts")
public class Desserts{
	
    final Logger logger = Logger.getLogger(Meal.class.getName());  
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "json" media type.
     *
     * @return String that will be returned as a json response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Recipe> getDesserts() {
    	
    	 FileHandler fh;  
         try {  

             // This block configure the logger with handler and formatter  
             fh = new FileHandler("C:\\Users\\Dell\\Desktop\\eclipse\\eclipse-workspace666\\nevimei\\log\\logger.log");  
             logger.addHandler(fh);
             SimpleFormatter formatter = new SimpleFormatter();  
             fh.setFormatter(formatter);  
             

         } catch (SecurityException e) {  
             e.printStackTrace();  
         } catch (IOException e) {  
             e.printStackTrace();  
         }
         
     	logger.info("Call on rest api desserts");
         
    	Database connect = new Database();
    	//4 = desserts
    	return connect.getRecipe(4);
    }
}
