package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ВИД_ЭЛЕМЕНТА", schema = "s223552", catalog = "studs")
public class KindOfElementEntity implements Serializable {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
    public static EntityManager em = emf.createEntityManager();
    private static final int serialVersionUID = 1;

    private int kind_id;
    private String kind;
    private String subkind;


//    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ElementEntity> elements = new ArrayList<>();

    public KindOfElementEntity() {}

    public KindOfElementEntity(int kind_id, String kind, String subkind) {
        this.kind_id = kind_id;
        this.kind = kind;
        this.subkind = subkind;
    }

    public static KindOfElementEntity readElem(int id){
        em.getTransaction().begin();
        KindOfElementEntity elem = em.find(KindOfElementEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(KindOfElementEntity elem) {
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(KindOfElementEntity elem) {
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }


    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    @Column(name = "ИД_ВИДА")
    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }

    @Basic
    @Column(name = "ВИД")
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Basic
    @Column(name = "ПОДВИД")
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

        if (kind_id != that.kind_id) return false;
        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (subkind != null ? !subkind.equals(that.subkind) : that.subkind != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kind_id;
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        result = 31 * result + (subkind != null ? subkind.hashCode() : 0);
        return result;
    }
}
