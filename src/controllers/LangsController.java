package controllers;

import beans.LangsBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("langs")
@Stateless
public class LangsController {
    @EJB
    private LangsBean lang;

    //public EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
    //public EntityManager em = emf.createEntityManager();
    @Path("all")
    @GET
    public String getAllLangs(){
       return lang.getAllLangs();
    }


    @GET
    public String getLang(@QueryParam("lang") String language){

      //  return lang.getLang(language, em);
        return lang.getLang(language);
    }


}
