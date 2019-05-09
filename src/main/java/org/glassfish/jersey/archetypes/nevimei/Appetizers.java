package org.glassfish.jersey.archetypes.nevimei;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("appetizers")
public class Appetizers{
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "json" media type.
     *
     * @return String that will be returned as a json response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Recipe> getAppetizers() {
    	Database connect = new Database();
    	//1 = appetizers
    	return connect.getRecipe(1);
    }
}
