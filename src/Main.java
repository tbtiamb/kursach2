import beans.UserControllerBean;
import controllers.UserController;
import entities.UsersEntity;

import javax.ejb.EJB;

public class Main {
    @EJB
    private UserControllerBean userController;

//    public void add(String login, String password, String email) {
//        userController.addUser(login, password, email);
//    }
//
    public static void main(String argc[]){
        System.out.println("test".hashCode());
    }
}
