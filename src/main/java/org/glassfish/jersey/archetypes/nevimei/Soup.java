//package org.glassfish.jersey.archetypes.nevimei;
//
//public class Soup {
//
//}
package org.glassfish.jersey.archetypes.nevimei;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("soups")
public class Soup{
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "json" media type.
     *
     * @return String that will be returned as a json response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Recipe> getSoups() {
    	Database connect = new Database();
    	//2 soups
    	return connect.getRecipe(2);
    }
}
