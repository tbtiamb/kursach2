package beans;


import entities.UsersEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@LocalBean
@Stateful//(name = "UserControllerEJB")
public class UserControllerBean {
    public UserControllerBean() {
    }

    public void addUser(String login, String password){
        UsersEntity.addUser(login, password);
    }

    public boolean authentication(String login, String password){
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("Select user FROM UsersEntity user WHERE user.login = :login AND user.password = :password");
            query.setParameter("login", login);
            query.setParameter("password", password.hashCode());
            UsersEntity result = (UsersEntity) query.getSingleResult();
            //return "123";
            return true;
        }
        catch (Exception e){
           //return "321";
            return false;
        }
    }
}
