package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "kind_of_element", schema = "s223552", catalog = "studs")
public class KindOfElementEntity implements Serializable{
    private int kindId;
    private String kind;
    private String subkind;
    private Collection<ElementsEntity> elementsByKindId;

    public KindOfElementEntity() {}

    public KindOfElementEntity(String kind, String subkind) {
        this.kind = kind;
        this.subkind = subkind;
    //    this.elementsByKindId = elementsByKindId;
    }

    public static KindOfElementEntity readElem(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        KindOfElementEntity elem = em.find(KindOfElementEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(KindOfElementEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(KindOfElementEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kind_id", nullable = false)
    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }

    @Basic
    @Column(name = "kind", nullable = false, length = -1)
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Basic
    @Column(name = "subkind", nullable = false, length = -1)
    public String getSubkind() {
        return subkind;
    }

    public void setSubkind(String subkind) {
        this.subkind = subkind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KindOfElementEntity that = (KindOfElementEntity) o;

        if (kindId != that.kindId) return false;
        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (subkind != null ? !subkind.equals(that.subkind) : that.subkind != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kindId;
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        result = 31 * result + (subkind != null ? subkind.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kindOfElementByKindId")
    public Collection<ElementsEntity> getElementsByKindId() {
        return elementsByKindId;
    }

    public void setElementsByKindId(Collection<ElementsEntity> elementsByKindId) {
        this.elementsByKindId = elementsByKindId;
    }
}
