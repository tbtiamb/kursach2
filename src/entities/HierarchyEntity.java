package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "hierarchy", schema = "s223552", catalog = "studs")
public class HierarchyEntity {
    private int element;
    private Integer parent;
    private Integer level;
    private ElementsEntity elementsByElement;
    private HierarchyEntity hierarchyByParent;
    private Collection<HierarchyEntity> hierarchiesByElement;

    public HierarchyEntity() {}

    public HierarchyEntity(int element, Integer parent, Integer level, ElementsEntity elementsByElement, HierarchyEntity hierarchyByParent, Collection<HierarchyEntity> hierarchiesByElement) {
        this.element = element;
        this.parent = parent;
        this.level = level;
        this.elementsByElement = elementsByElement;
        this.hierarchyByParent = hierarchyByParent;
        this.hierarchiesByElement = hierarchiesByElement;
    }

    public static HierarchyEntity readElem(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        HierarchyEntity elem = em.find(HierarchyEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(HierarchyEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(HierarchyEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "element", nullable = false)
    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    @Basic
    @Column(name = "parent", nullable = true)
    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Basic
    @Column(name = "level", nullable = true)
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
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = element;
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "element", referencedColumnName = "element_id", nullable = false, insertable = false, updatable = false)
    public ElementsEntity getElementsByElement() {
        return elementsByElement;
    }

    public void setElementsByElement(ElementsEntity elementsByElement) {
        this.elementsByElement = elementsByElement;
    }

    @ManyToOne
    @JoinColumn(name = "parent", referencedColumnName = "element", insertable = false, updatable = false)
    public HierarchyEntity getHierarchyByParent() {
        return hierarchyByParent;
    }

    public void setHierarchyByParent(HierarchyEntity hierarchyByParent) {
        this.hierarchyByParent = hierarchyByParent;
    }

    @OneToMany(mappedBy = "hierarchyByParent")
    public Collection<HierarchyEntity> getHierarchiesByElement() {
        return hierarchiesByElement;
    }

    public void setHierarchiesByElement(Collection<HierarchyEntity> hierarchiesByElement) {
        this.hierarchiesByElement = hierarchiesByElement;
    }
}
