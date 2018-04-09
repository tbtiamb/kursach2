package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "autors", schema = "s223552", catalog = "studs")
public class AutorsEntity {
    private int autorId;
    private String firstName;
    private String secondName;
    private Integer nationId;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private Collection<AutorOfLangEntity> autorOfLangsByAutorId;
    private NationAndLocationEntity nationAndLocationByNationId;

    public AutorsEntity() {}

    public AutorsEntity(String firstName, String secondName, Integer nationId, Date dateOfBirth, Date dateOfDeath, Collection<AutorOfLangEntity> autorOfLangsByAutorId, NationAndLocationEntity nationAndLocationByNationId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.nationId = nationId;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.autorOfLangsByAutorId = autorOfLangsByAutorId;
        this.nationAndLocationByNationId = nationAndLocationByNationId;
    }

    public static AutorsEntity readElem(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        AutorsEntity elem = em.find(AutorsEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(AutorsEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(AutorsEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }

    public static void updateFirstName(AutorsEntity elem, String firstName){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE AutorsEntity autor SET  autor.firstName = :firstName WHERE  autor.autor_id = :elem_id");
        query.setParameter("firstName", firstName);
        query.setParameter("elem_id", elem.getAutorId());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    public static void updateSecondName(AutorsEntity elem, String secondName){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE AutorsEntity autor SET  autor.secondName = :secindName WHERE  autor.autor_id = :elem_id");
        query.setParameter("secindName", secondName);
        query.setParameter("elem_id", elem.getAutorId());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    public static void updateDateOfDeath(AutorsEntity elem, Date dod){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE AutorsEntity autor SET  autor.dateOfDeath = :dod WHERE  autor.autor_id = :elem_id");
        query.setParameter("dod", dod);
        query.setParameter("elem_id", elem.getAutorId());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "autor_id", nullable = false)
    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = -1)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name", nullable = false, length = -1)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "nation_id", nullable = true)
    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    @Basic
    @Column(name = "date_of_birth", nullable = true)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "date_of_death", nullable = true)
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

        if (autorId != that.autorId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (nationId != null ? !nationId.equals(that.nationId) : that.nationId != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (dateOfDeath != null ? !dateOfDeath.equals(that.dateOfDeath) : that.dateOfDeath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autorId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (nationId != null ? nationId.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (dateOfDeath != null ? dateOfDeath.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "autorsByAutorId")
    public Collection<AutorOfLangEntity> getAutorOfLangsByAutorId() {
        return autorOfLangsByAutorId;
    }

    public void setAutorOfLangsByAutorId(Collection<AutorOfLangEntity> autorOfLangsByAutorId) {
        this.autorOfLangsByAutorId = autorOfLangsByAutorId;
    }

    @ManyToOne
    @JoinColumn(name = "nation_id", referencedColumnName = "nation_id", insertable = false, updatable = false)
    public NationAndLocationEntity getNationAndLocationByNationId() {
        return nationAndLocationByNationId;
    }

    public void setNationAndLocationByNationId(NationAndLocationEntity nationAndLocationByNationId) {
        this.nationAndLocationByNationId = nationAndLocationByNationId;
    }
}
