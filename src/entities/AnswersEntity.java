package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "answers", schema = "s223552", catalog = "studs")
public class AnswersEntity {
    private long id;
    private String answer;
    private Date dateofanswer;
    private Integer likes;
    private Integer dislikes;
    private QuestionsEntity questionsByQuestionid;
    private UsersEntity usersByUserid;

    public AnswersEntity() {
    }

    public AnswersEntity(String answer, Date dateofanswer, QuestionsEntity questionsByQuestionid, UsersEntity usersByUserid) {
        this.answer = answer;
        this.dateofanswer = dateofanswer;
        this.questionsByQuestionid = questionsByQuestionid;
        this.usersByUserid = usersByUserid;
    }

    public static AnswersEntity readElem(long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        AnswersEntity elem = em.find(AnswersEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(AnswersEntity elem) {
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
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Basic
    @Column(name = "dateofanswer")
    public Date getDateofanswer() {
        return dateofanswer;
    }

    public void setDateofanswer(Date dateofanswer) {
        this.dateofanswer = dateofanswer;
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

        AnswersEntity that = (AnswersEntity) o;

        if (id != that.id) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (dateofanswer != null ? !dateofanswer.equals(that.dateofanswer) : that.dateofanswer != null) return false;
        if (likes != null ? !likes.equals(that.likes) : that.likes != null) return false;
        if (dislikes != null ? !dislikes.equals(that.dislikes) : that.dislikes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (dateofanswer != null ? dateofanswer.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (dislikes != null ? dislikes.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "questionid", referencedColumnName = "id")
    public QuestionsEntity getQuestionsByQuestionid() {
        return questionsByQuestionid;
    }

    public void setQuestionsByQuestionid(QuestionsEntity questionsByQuestionid) {
        this.questionsByQuestionid = questionsByQuestionid;
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
