package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "РАСШИРЕНИЯ", schema = "s223552", catalog = "studs")
public class ExtensionsEntity implements Serializable {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
    public static EntityManager em = emf.createEntityManager();
    private static final int serialVersionUID = 1;

    private int extension_id;
    private String extension;

    public ExtensionsEntity() {}

    public ExtensionsEntity(int extension_id, String extension) {
        this.extension_id = extension_id;
        this.extension = extension;
    }

    public static ExtensionsEntity readElem(int id){
        em.getTransaction().begin();
        ExtensionsEntity elem = em.find(ExtensionsEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(ExtensionsEntity elem) {
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(ExtensionsEntity elem) {
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }

    public static void updateStatus(ExtensionsEntity elem, String ext){
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE ExtensionsEntity extension SET  extension.extension = :ext WHERE  extension.extension_id = :elem_id");
        query.setParameter("ext", ext);
        query.setParameter("elem_id", elem.getExtension_id());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ИД_РАСШИРЕНИЯ")
    public int getExtension_id() {
        return extension_id;
    }

    public void setExtension_id(int extension_id) {
        this.extension_id = extension_id;
    }

    @Basic
    @Column(name = "РАСШИРЕНИЕ")
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

        if (extension_id != that.extension_id) return false;
        if (extension != null ? !extension.equals(that.extension) : that.extension != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = extension_id;
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        return result;
    }
}
