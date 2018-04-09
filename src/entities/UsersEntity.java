package entities;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "s223552", catalog = "studs")
public class UsersEntity {
//    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
//    public static EntityManager em = emf.createEntityManager();
    private long id;
    private String login;
    private Integer password;
    private String email;

    public UsersEntity() {
    }

    public UsersEntity(String login, Integer password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public static UsersEntity readElem(long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        UsersEntity elem = em.find(UsersEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addUser(UsersEntity user){//(String login, String password, String email){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        //UsersEntity user = new UsersEntity(login, password.hashCode(), email);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = -1)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false)
    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = -1)
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
