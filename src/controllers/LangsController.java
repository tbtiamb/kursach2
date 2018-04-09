package controllers;

import beans.LangsBean;
import data.AllLangData;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.List;

import data.AllProgLangData;
import data.NationData;
import entities.*;

@Path("langs")
@Stateless
public class LangsController {
    @EJB
    private LangsBean lang;

    @Path("all")
    @Produces("application/json")
    @GET
    public List<AllLangData> getAllLangs(){
        return lang.getAllLangs();
    }

    @Path("allProg")
    @Produces("application/json")
    @GET
    public List<AllProgLangData> getAllProgLangs(){
        return lang.getAllProgLangs();
    }

    @Path("{name}")
    @GET
    @Produces("application/json")
    public AllLangData getLang(@PathParam("name") String name){

      //  return lang.getLang(language, em);
        return lang.getLang(name);
    }

    @Path("/prog/{name}")
    @GET
    @Produces("application/json")
    public AllProgLangData getProgLang(@PathParam("name") String name){
        return lang.getProgLangs(name);
    }


}
