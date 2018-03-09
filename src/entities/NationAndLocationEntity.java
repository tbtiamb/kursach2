package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "НАЦИОНАЛЬНОСТЬ_И_МЕСТОПОЛОЖЕНИЕ", schema = "s223552", catalog = "studs")
public class NationAndLocationEntity implements Serializable {
//    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
//    public static EntityManager em = emf.createEntityManager();
    private static final int serialVersionUID = 1;

    private int nation_id;
    private String nation;
    private String country;
    private String city;

    public NationAndLocationEntity() {}

    public NationAndLocationEntity(int nation_id, String nation, String country, String city) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        this.nation_id = nation_id;
        this.nation = nation;
        this.country = country;
        this.city = city;
    }

    public static ElementEntity readElem(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ElementEntity elem = em.find(ElementEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(ElementEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(ElementEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }

    public static void updateCountry(NationAndLocationEntity elem, String newCountry){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE NationAndLocationEntity element SET  element.country = :newCountry WHERE  element.nation_id = :elem_id");
        query.setParameter("newCountry", elem);
        query.setParameter("elem_id", elem.getNation_id());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    public static void updateCity(NationAndLocationEntity elem, String newCity){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE NationAndLocationEntity element SET  element.city = :newCity WHERE  element.nation_id = :elem_id");
        query.setParameter("newCity", elem);
        query.setParameter("elem_id", elem.getNation_id());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ИД_НАЦИОНАЛЬНОСТИ")
    public int getNation_id() {
        return nation_id;
    }

    public void setNation_id(int nation_id) {
        this.nation_id = nation_id;
    }

    @Basic
    @Column(name = "НАЦИОНАЛЬНОСТЬ")
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Basic
    @Column(name = "СТРАНА")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "ГОРОД")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NationAndLocationEntity that = (NationAndLocationEntity) o;

        if (nation_id != that.nation_id) return false;
        if (nation != null ? !nation.equals(that.nation) : that.nation != null)
            return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nation_id;
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
