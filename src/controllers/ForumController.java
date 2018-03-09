package controllers;

import entities.ElementEntity;
import entities.QuestionsEntity;
import entities.UsersEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.Calendar;

@Stateless
@Path("forum")
public class ForumController {

    @Path("adding")
    @Produces("text/html")
    @GET
    public String adding(@Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException {
        if (req.getSession().getAttribute("user") != null) {
            return "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <meta http-equiv=\"Content-Type\" content=\"text/php; charset=utf-8\"/>\n" +
                    "    <title>Языки</title>\n" +
                    "    <link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/kursach2/style.css\">\n" +
                    "\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"header\">\n" +
                    "    <a href=\"./index.html\"><img src=\"http://localhost:8080/kursach2/logo.png\" alt=\"На главную\" width=\"200px\"></a>\n" +
                    "\n" +
                    "</div>\n" +
                    "\n" +
                    "<div class=\"adding\">\n" +
                    "    <form method=\"post\" action=\"/kursach2/rest/forum/add\">\n" +
                    "        <input type=\"text\" name=\"title\">\n" +
                    "        <textarea name=\"question\"> </textarea>\n" +
                    "        <input type=\"submit\" value=\"Add\">\n" +
                    "    </form>\n" +
                    "</div>\n" +
                    "<div class=\"footer\">\n" +
                    "    &copy; Все права защищены<br>\n" +
                    "    Мамиконян Н.Н. и Божик А.И. группа P3219, вариант 502\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";
        } else {
            // resp.sendRedirect("http://localhost:8080/kursach2/login.html");
            return "123321";
        }
    }

    @Path("questions/{id}")
    @Produces("text/html")
    @GET
    public String getQuestionPage(@PathParam("id") String id, @Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            QuestionsEntity elem = em.find(QuestionsEntity.class, Long.parseLong(id));
            em.getTransaction().commit();
            return elem.getDescription();
    }

    @Path("add")
    @Produces("text/html")
    @POST
    public void add(@FormParam("title") String title, @FormParam("question") String question, @Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException {
        if (req.getSession().getAttribute("user") != null) {
            //UsersEntity user = (UsersEntity) req.getSession().getAttribute("user");
            String stringID = req.getSession().getAttribute("user").toString();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            UsersEntity user = em.find(UsersEntity.class, Long.parseLong(stringID));
            Calendar currenttime = Calendar.getInstance();
            QuestionsEntity elem = new QuestionsEntity(title, question, new java.sql.Date((currenttime.getTime()).getTime()), user);
            QuestionsEntity.addElem(elem);
            em.getTransaction().commit();
            resp.sendRedirect("http://localhost:8080/kursach2/rest/forum/questions/" + elem.getId());
        } else {
            resp.sendRedirect("http://localhost:8080/kursach2/login.html");
        }
    }
}
