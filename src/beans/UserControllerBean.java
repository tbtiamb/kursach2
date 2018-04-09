package beans;


import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.*;
import entities.*;

@LocalBean
@Stateful//(name = "UserControllerEJB")
public class UserControllerBean {
    public UserControllerBean() {
    }

   // @PersistenceContext
    //private EntityManager em;
   //@PersistenceContext(unitName = "Languages")
   //private EntityManager em;

    public void addUser(UsersEntity user){
        //UsersEntity.addUser(login, password, email);
        UsersEntity.addUser(user);
    }

    public UsersEntity authentication(String login, String password){
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("Select user FROM UsersEntity user WHERE user.login = :login AND user.password = :password");
            query.setParameter("login", login);
            query.setParameter("password", password.hashCode());
            UsersEntity result = (UsersEntity) query.getSingleResult();
            return result;
        }
        catch (Exception e){
           //return "321";
            return null;
        }
    }
}
