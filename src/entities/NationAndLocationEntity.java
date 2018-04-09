package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "nation_and_location", schema = "s223552", catalog = "studs")
public class NationAndLocationEntity {
    private int nationId;
    private String nation;
    private String country;
    private String city;
    private Collection<AutorsEntity> autorsByNationId;
    private Collection<WhoSpeaksEntity> whoSpeaksByNationId;

    public NationAndLocationEntity() {}

    public NationAndLocationEntity(String nation, String country, String city, Collection<AutorsEntity> autorsByNationId, Collection<WhoSpeaksEntity> whoSpeaksByNationId) {
        this.nation = nation;
        this.country = country;
        this.city = city;
    }

    public static ElementsEntity readElem(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ElementsEntity elem = em.find(ElementsEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(ElementsEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(ElementsEntity elem) {
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
        Query query = em.createQuery("UPDATE NationAndLocationEntity element SET  element.country = :newCountry WHERE  element.nationId = :elem_id");
        query.setParameter("newCountry", elem);
        query.setParameter("elem_id", elem.getNationId());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    public static void updateCity(NationAndLocationEntity elem, String newCity){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE NationAndLocationEntity element SET  element.city = :newCity WHERE  element.nationId = :elem_id");
        query.setParameter("newCity", elem);
        query.setParameter("elem_id", elem.getNationId());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nation_id", nullable = false)
    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    @Basic
    @Column(name = "nation", nullable = true, length = -1)
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Basic
    @Column(name = "country", nullable = false, length = -1)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city", nullable = true, length = -1)
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

        if (nationId != that.nationId) return false;
        if (nation != null ? !nation.equals(that.nation) : that.nation != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nationId;
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "nationAndLocationByNationId")
    public Collection<AutorsEntity> getAutorsByNationId() {
        return autorsByNationId;
    }

    public void setAutorsByNationId(Collection<AutorsEntity> autorsByNationId) {
        this.autorsByNationId = autorsByNationId;
    }

    @OneToMany(mappedBy = "nationAndLocationByNationId")
    public Collection<WhoSpeaksEntity> getWhoSpeaksByNationId() {
        return whoSpeaksByNationId;
    }

    public void setWhoSpeaksByNationId(Collection<WhoSpeaksEntity> whoSpeaksByNationId) {
        this.whoSpeaksByNationId = whoSpeaksByNationId;
    }
}
