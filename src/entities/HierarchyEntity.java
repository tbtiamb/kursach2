package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ИЕРАРХИЯ", schema = "s223552", catalog = "studs")
public class HierarchyEntity implements Serializable {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
    public static EntityManager em = emf.createEntityManager();
    private static final int serialVersionUID = 1;

    private int element;
    private Integer level;

    public HierarchyEntity() {
    }

    public HierarchyEntity(int element, Integer level) {
        this.element = element;
        this.level = level;
    }

    public static HierarchyEntity readElem(int id){
        em.getTransaction().begin();
        HierarchyEntity elem = em.find(HierarchyEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(HierarchyEntity elem) {
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(HierarchyEntity elem) {
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ЭЛЕМЕНТ")
    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    @Basic
    @Column(name = "УРОВЕНЬ")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HierarchyEntity that = (HierarchyEntity) o;

        if (element != that.element) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = element;
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }
}
