package controllers;

import beans.UserControllerBean;
import data.LoginData;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;

import data.UserData;
import entities.*;

@Path("/user")
@LocalBean
@Stateless
public class UserController {
    @EJB
    private UserControllerBean userController;

    @Path("/addUser")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public UsersEntity addUser(UserData userData) {
//        try {
            //userController.addUser(userData.login, userData.password, userData.email);
        UsersEntity user = new UsersEntity(userData.login, userData.password.hashCode(), userData.email);
        userController.addUser(user);
            //return "Success";
        //UserData newUser = new UserData(user.getLogin(), user.getPassword().toString(), user.getEmail());
        return user;
//        } catch (Exception e) {
            //return "Not success";
//            return new UserData("lol", "lol", "lol");
//        }
    }


    //@Produces("text/plain")//@Produces("text/html")//@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/auth")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public UsersEntity authentication(LoginData loginData){//(@FormParam("login") String login, @FormParam("password") String password, @Context HttpServletResponse resp, @Context HttpServletRequest req) throws IOException {
        UsersEntity user = userController.authentication(loginData.login, loginData.password);
        return user;
    }
}
