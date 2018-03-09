package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ВОЗМОЖНОСТИ_ЯЗЫКА", schema = "s223552", catalog = "studs")
@IdClass(CapabilitiesOfLangEntityPK.class)
public class CapabilitiesOfLangEntity implements Serializable {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
    public static EntityManager em = emf.createEntityManager();

    private int lang_id;
    private int capability_id;

    public CapabilitiesOfLangEntity() {}

    public CapabilitiesOfLangEntity(int lang_id, int capability_id) {
        this.lang_id = lang_id;
        this.capability_id = capability_id;
    }

    public static CapabilitiesOfLangEntity readElem(int id){
        em.getTransaction().begin();
        CapabilitiesOfLangEntity elem = em.find(CapabilitiesOfLangEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(CapabilitiesOfLangEntity elem) {
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(CapabilitiesOfLangEntity elem) {
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }

    @Id
    @Column(name = "ИД_ЯЗЫКА")
    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    @Id
    @Column(name = "ИД_ВОЗМОЖНОСТИ")
    public int getCapability_id() {
        return capability_id;
    }

    public void setCapability_id(int capability_id) {
        this.capability_id = capability_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CapabilitiesOfLangEntity that = (CapabilitiesOfLangEntity) o;

        if (lang_id != that.lang_id) return false;
        if (capability_id != that.capability_id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lang_id;
        result = 31 * result + capability_id;
        return result;
    }
}
