package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "questions", schema = "s223552", catalog = "studs")
public class QuestionsEntity {
    private long id;
    private String title;
    private String description;
    private Date askeddate;
    private Integer likes;
    private Integer dislikes;
    private UsersEntity usersByUserid;

    public QuestionsEntity() {}

    public QuestionsEntity(String title, String description, Date askeddate, UsersEntity usersByUserid) {
        this.title = title;
        this.description = description;
        this.askeddate = askeddate;
        this.usersByUserid = usersByUserid;
    }

    public static void addElem(QuestionsEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elem);
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "askeddate")
    public Date getAskeddate() {
        return askeddate;
    }

    public void setAskeddate(Date askeddate) {
        this.askeddate = askeddate;
    }

    @Basic
    @Column(name = "likes")
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Basic
    @Column(name = "dislikes")
    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionsEntity that = (QuestionsEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (askeddate != null ? !askeddate.equals(that.askeddate) : that.askeddate != null) return false;
        if (likes != null ? !likes.equals(that.likes) : that.likes != null) return false;
        if (dislikes != null ? !dislikes.equals(that.dislikes) : that.dislikes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (askeddate != null ? askeddate.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (dislikes != null ? dislikes.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    public UsersEntity getUsersByUserid() {
        return usersByUserid;
    }

    public void setUsersByUserid(UsersEntity usersByUserid) {
        this.usersByUserid = usersByUserid;
    }
}
