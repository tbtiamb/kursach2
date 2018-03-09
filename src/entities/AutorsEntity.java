package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "АВТОРЫ", schema = "s223552", catalog = "studs")
public class AutorsEntity implements Serializable{
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
    public static EntityManager em = emf.createEntityManager();
    private static final int serialVersionUID = 1;

    private int autor_id;
    private String firstName;
    private String secondName;
    private Integer nation_id;
    private Date dateOfBirth;
    private Date dateOfDeath;

    public AutorsEntity() {}

    public AutorsEntity(String firstName, String secondName, Integer nation_id, Date dateOfBirth, Date dateOfDeath) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.nation_id = nation_id;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }


    public static AutorsEntity readElem(int id){
        em.getTransaction().begin();
        AutorsEntity elem = em.find(AutorsEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(AutorsEntity elem) {
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(AutorsEntity elem) {
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }

    public static void updateFirstName(AutorsEntity elem, String firstName){
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE AutorsEntity autor SET  autor.firstName = :firstName WHERE  autor.autor_id = :elem_id");
        query.setParameter("firstName", firstName);
        query.setParameter("elem_id", elem.getAutor_id());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    public static void updateSecondName(AutorsEntity elem, String secondName){
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE AutorsEntity autor SET  autor.secondName = :secindName WHERE  autor.autor_id = :elem_id");
        query.setParameter("secindName", secondName);
        query.setParameter("elem_id", elem.getAutor_id());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    public static void updateDateOfDeath(AutorsEntity elem, Date dod){
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE AutorsEntity autor SET  autor.dateOfDeath = :dod WHERE  autor.autor_id = :elem_id");
        query.setParameter("dod", dod);
        query.setParameter("elem_id", elem.getAutor_id());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ИД_АВТОРА")
    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    @Basic
    @Column(name = "ИМЯ")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "ФАМИЛИЯ")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "ИД_НАЦИОНАЛЬНОСТИ")
    public Integer getNation_id() {
        return nation_id;
    }

    public void setNation_id(Integer nation_id) {
        this.nation_id = nation_id;
    }

    @Basic
    @Column(name = "ДАТА_РОЖДЕНИЯ")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "ДАТА_СМЕРТИ")
    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutorsEntity that = (AutorsEntity) o;

        if (autor_id != that.autor_id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (nation_id != null ? !nation_id.equals(that.nation_id) : that.nation_id != null)
            return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (dateOfDeath != null ? !dateOfDeath.equals(that.dateOfDeath) : that.dateOfDeath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autor_id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (nation_id != null ? nation_id.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (dateOfDeath != null ? dateOfDeath.hashCode() : 0);
        return result;
    }
}
