package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "capabilities", schema = "s223552", catalog = "studs")
public class CapabilitiesEntity {
    private int capabilityId;
    private String capability;
    private String version;
    private Collection<CapabilitiesOfLangEntity> capabilitiesOfLangsByCapabilityId;

    public CapabilitiesEntity() {}

    public CapabilitiesEntity(String capability, String version, Collection<CapabilitiesOfLangEntity> capabilitiesOfLangsByCapabilityId) {
        this.capability = capability;
        this.version = version;
        this.capabilitiesOfLangsByCapabilityId = capabilitiesOfLangsByCapabilityId;
    }

    public static CapabilitiesEntity readElem(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CapabilitiesEntity elem = em.find(CapabilitiesEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(CapabilitiesEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(CapabilitiesEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }

    public static void updateVersion(CapabilitiesEntity elem, String vers){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE CapabilitiesEntity capability SET  capability.version = :vers WHERE  capability.capability_id = :elem_id");
        query.setParameter("vers", vers);
        query.setParameter("elem_id", elem.getCapabilityId());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "capability_id", nullable = false)
    public int getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(int capabilityId) {
        this.capabilityId = capabilityId;
    }

    @Basic
    @Column(name = "capability", nullable = false, length = -1)
    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    @Basic
    @Column(name = "version", nullable = true, length = -1)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CapabilitiesEntity that = (CapabilitiesEntity) o;

        if (capabilityId != that.capabilityId) return false;
        if (capability != null ? !capability.equals(that.capability) : that.capability != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = capabilityId;
        result = 31 * result + (capability != null ? capability.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "capabilitiesByCapabilityId")
    public Collection<CapabilitiesOfLangEntity> getCapabilitiesOfLangsByCapabilityId() {
        return capabilitiesOfLangsByCapabilityId;
    }

    public void setCapabilitiesOfLangsByCapabilityId(Collection<CapabilitiesOfLangEntity> capabilitiesOfLangsByCapabilityId) {
        this.capabilitiesOfLangsByCapabilityId = capabilitiesOfLangsByCapabilityId;
    }
}
