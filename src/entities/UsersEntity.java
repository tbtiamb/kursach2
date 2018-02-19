package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users", schema = "s223552", catalog = "studs")
public class UsersEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    private long id;
    private String login;
    private int password;
    private String email;

    public UsersEntity() {
    }

    public UsersEntity(String login, int password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public static void addUser(String login, String password){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        UsersEntity user = new UsersEntity(login, password.hashCode(), "lol@mail.com");
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (password != that.password) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + password;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
