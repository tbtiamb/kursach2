package lab4;

import Test.Test;
import beans.UserControllerBean;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;

@Path("/user")
@LocalBean
@Stateless
public class UserController {
    @EJB
    private UserControllerBean userController;

    @Path("/addUser")
    @POST
    @Produces("text/html")
    public String addUser(@FormParam("login") String login, @FormParam("password") String password){
        //userController.addUser(login, password);
        return "123";
    }
    //HttpRequest request, HttpResponse response
    @Path("/auth")
    @POST
    //@Produces("application/json")//@Produces("text/plain")//@Produces("text/html")//@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String authentication(@FormParam("login") String login, @FormParam("password") String password, @Context HttpServletResponse resp, @Context HttpServletRequest req) throws IOException {
        if (userController.authentication(login, password)) {
            return "Success";
        }
        return "Wrong";

    }
}
