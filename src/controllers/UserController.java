package controllers;

import beans.UserControllerBean;
import entities.UsersEntity;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
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

    @Path("login")
    @GET
    @Produces("text/html")
    public String getLoginPage() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "    <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script>\n" +
                "    <style>\n" +
                "        .center {\n" +
                "            width: 80%; /* Ширина элемента в пикселах */\n" +
                "            margin: auto; /* Выравниваем по центру */\n" +
                "        }\n" +
                "\n" +
                "        .head {\n" +
                "        / / clear: center;\n" +
                "            text-align: center;\n" +
                "        / / background-image: url(\"resources/images/logo.png\");\n" +
                "            min-height: 20%;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        .input {\n" +
                "            text-align: center;\n" +
                "            background-color: #C0C0C0;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "    </style>\n" +
                "\n" +
                "    <script>\n" +
                "        //        $(function() {\n" +
                "        //            $('form').submit(function(e) {\n" +
                "        //             //  $.session.set(\"login\", \"321\");\n" +
                "        //            });\n" +
                "        //        });\n" +
                "//        $(function () {\n" +
                "//            $('form').submit(function (e) {\n" +
                "//             //   alert(\"123\");\n" +
                "//                var $form = $(this);\n" +
                "//                $.ajax({\n" +
                "//                    type: $form.attr('method'),\n" +
                "//                    url: $form.attr('action'),\n" +
                "//                    data: $form.serialize()\n" +
                "//                }).done(function () {\n" +
                "//                    console.log('success');\n" +
                "//                }).fail(function () {\n" +
                "//                    console.log('fail');\n" +
                "//                });\n" +
                "//                //отмена действия по умолчанию для кнопки submit\n" +
                "//                e.preventDefault();\n" +
                "//            });\n" +
                "//        });\n" +
                "    </script>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"center\">\n" +
                "    <div class=\"head\">\n" +
                "\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"input\">\n" +
                "        <p><b>Лабораторная работа № 3</b></p>\n" +
                "        <p><b>Выполнили: Егоров A.Д. / Лысенко С.В. / Божик A.И. </b></p>\n" +
                "        <p><b>Группа P3219</b></p>\n" +
                "        <p><b>Вариант 923</b></p>\n" +
                "        <p id=\"messegeResult\"></p>\n" +
                "        <form id=\"formMain\" method=\"post\" action=\"/kursach2/rest/user/auth\">\n" +
                "            <label for=\"log\">Логин </label> <input type=\"text\" name=\"login\" id=\"log\"> <br/>\n" +
                "            <label for=\"passw\">Пароль</label> <input type=\"password\" name=\"password\" id=\"passw\"> <br/>\n" +
                "            <input type=\"submit\" value=\"Вход\"/> <br/>\n" +
                "        </form>\n" +
                "        <a href=\"/kursach2/rest/user/register\">Регистрация</a>\n" +
                "    </div>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

    @Path("/addUser")
    @POST
    @Produces("text/html")
    public String addUser(@FormParam("login") String login, @FormParam("password") String password) {
        userController.addUser(login, password);
        return "123";
    }

    //HttpServletRequest request;
    //HttpServletResponse response;

    @Path("/auth")
    @POST
    @Produces("application/json")
//@Produces("text/plain")//@Produces("text/html")//@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void authentication(@FormParam("login") String login, @FormParam("password") String password, @Context HttpServletResponse resp, @Context HttpServletRequest req) throws IOException {
        UsersEntity user = userController.authentication(login, password);
        req.getSession().setAttribute("user", user.getId());
       resp.sendRedirect("http://localhost:8080/kursach2/rest/forum/adding");
         //req.getSession().getServletContext().getRequestDispatcher("/rest/forum/adding").forward(req, resp);
        //return "Success";
        //request.getSession().in
        //return user;
    }
}
