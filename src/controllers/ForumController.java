package controllers;

import data.AnswerData;
import data.QuestionData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import entities.*;

@Stateless
@Path("forum")
public class ForumController {

    @Path("adding")
    @Consumes("application/json")
    @POST
    public void adding(QuestionData questionData, @Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException {

    }

    @Path("questions/{id}/answers")
    @Produces("application/json")//@Produces("text/html")
    @GET
    public List<AnswersEntity> getAnswers(@PathParam("id") String id, @Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        //QuestionsEntity elem = em.find(QuestionsEntity.class, Long.parseLong(id));
//        QuestionsEntity elem = QuestionsEntity.readElem(Long.parseLong(id));
        //em.getTransaction().commit();
        req.getSession().setAttribute("questionID", id);
        //return elem.getDescription();
        QuestionsEntity question = QuestionsEntity.readElem(Long.parseLong(id));
        Query query = em.createQuery("select answ from AnswersEntity answ where answ.questionsByQuestionid = :question");
        query.setParameter("question", question);
        List<AnswersEntity> answers = query.getResultList();//.subList(0, query.getResultList().size());
        return query.getResultList();
    }

    @Path("questions/all")
    @Produces("application/json")
    @GET
    public List<QuestionsEntity> getQuestion(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select question from QuestionsEntity question");
        return query.getResultList();
    }

    @Path("questions/{id}")
    @Produces("application/json")//@Produces("text/html")
    @GET
    public QuestionsEntity getQuestion(@PathParam("id") String id, @Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        QuestionsEntity question = QuestionsEntity.readElem(Long.parseLong(id));
        return question;
    }

    @Path("add")
    @Consumes("application/json")
    @Produces("application/json")
    @POST
    public QuestionsEntity addQuestion(QuestionData questionData) {
        try{
        UsersEntity user = UsersEntity.readElem(Long.parseLong(questionData.userId));
        Calendar currenttime = Calendar.getInstance();
        QuestionsEntity elem = new QuestionsEntity(questionData.title, questionData.question, new java.sql.Date((currenttime.getTime()).getTime()), user);
        QuestionsEntity.addElem(elem);
        return elem;
        }
        catch (Exception e){
            return null;
        }
    }

    @Path("addAnswer")
    //@Produces("text/html")
    @Consumes("application/json")
    @POST
    public void addAnswer(AnswerData answer) {//(@FormParam("answer") String answer, @Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException {
        //if (req.getSession().getAttribute("user") != null) {
        //String stringQID = req.getSession().getAttribute("questionID").toString();
        UsersEntity user = UsersEntity.readElem(Long.parseLong(answer.id));//(Long.parseLong(req.getSession().getAttribute("user").toString()));
        QuestionsEntity question = QuestionsEntity.readElem(Long.parseLong(answer.questionId));//(Long.parseLong(req.getSession().getAttribute("questionID").toString()));
        Calendar currenttime = Calendar.getInstance();
        AnswersEntity elem = new AnswersEntity(answer.answer, new java.sql.Date((currenttime.getTime()).getTime()), question, user);
        AnswersEntity.addElem(elem);
        //return elem.getAnswer();
        //    resp.sendRedirect("http://localhost:8080/kursach2/rest/forum/questions/" + req.getSession().getAttribute("questionID"));
//        }
//        else {
//            resp.sendRedirect("http://localhost:8080/kursach2/rest/user/login");
        //return null;
        //}
    }

}
