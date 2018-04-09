package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "extensions", schema = "s223552", catalog = "studs")
public class ExtensionsEntity {
    private int extensionId;
    private String extension;
    private Collection<ExtensionsOfLangEntity> extensionsOfLangsByExtensionId;

    public ExtensionsEntity() {}

    public ExtensionsEntity(String extension, Collection<ExtensionsOfLangEntity> extensionsOfLangsByExtensionId) {
        this.extension = extension;
        this.extensionsOfLangsByExtensionId = extensionsOfLangsByExtensionId;
    }

    public static ExtensionsEntity readElem(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ExtensionsEntity elem = em.find(ExtensionsEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(ExtensionsEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(ExtensionsEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }

    public static void updateStatus(ExtensionsEntity elem, String ext){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE ExtensionsEntity extension SET  extension.extension = :ext WHERE  extension.extensionId = :elem_id");
        query.setParameter("ext", ext);
        query.setParameter("elem_id", elem.getExtensionId());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "extension_id", nullable = false)
    public int getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(int extensionId) {
        this.extensionId = extensionId;
    }

    @Basic
    @Column(name = "extension", nullable = false, length = -1)
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtensionsEntity that = (ExtensionsEntity) o;

        if (extensionId != that.extensionId) return false;
        if (extension != null ? !extension.equals(that.extension) : that.extension != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = extensionId;
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "extensionsByExtensionId")
    public Collection<ExtensionsOfLangEntity> getExtensionsOfLangsByExtensionId() {
        return extensionsOfLangsByExtensionId;
    }

    public void setExtensionsOfLangsByExtensionId(Collection<ExtensionsOfLangEntity> extensionsOfLangsByExtensionId) {
        this.extensionsOfLangsByExtensionId = extensionsOfLangsByExtensionId;
    }
}
