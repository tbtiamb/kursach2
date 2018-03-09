package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ЭЛЕМЕНТ", schema = "s223552", catalog = "studs")
public class ElementEntity implements Serializable {
//    public final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
//    public static EntityManager em = emf.createEntityManager();
    private static final int serialVersionUID = 1;

    private int element_id;
    private String name;
    private Integer kind_id;
    private Boolean status;
    private Long numberOfSpeakers;

    public ElementEntity() {}

    public ElementEntity(int element_id, String name, Boolean status, Long numberOfSpeakers) {
        this.element_id = element_id;
        this.name = name;
        this.status = status;
        this.numberOfSpeakers = numberOfSpeakers;
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

    public static void updateStatus(ElementEntity elem, String state){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE ElementEntity element SET  element.status = :state WHERE  element.element_id = :elem_id");
        query.setParameter("state", state);
        query.setParameter("elem_id", elem.getElement_id());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    public static void updateNumberOfSpeakers(ElementEntity elem, String nos){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE ElementEntity element SET  element.numberOfSpeakers = :nos WHERE  element.element_id = :elem_id");
        query.setParameter("nos", nos);
        query.setParameter("elem_id", elem.getElement_id());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ИД_ЭЛЕМЕНТА")
    public int getElement_id() {
        return element_id;
    }

    public void setElement_id(int element_id) {
        this.element_id = element_id;
    }

    @Basic
    @Column(name = "НАЗВАНИЕ")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ИД_ВИДА")
    public Integer getKind_id() {
        return kind_id;
    }

    public void setKind_id(Integer kind_id) {
        this.kind_id = kind_id;
    }

    @Basic
    @Column(name = "СОСТОЯНИЕ")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ЧИСЛО_ГОВОРЯЩИХ")
    public Long getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(Long numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElementEntity that = (ElementEntity) o;

        if (element_id != that.element_id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (kind_id != null ? !kind_id.equals(that.kind_id) : that.kind_id != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (numberOfSpeakers != null ? !numberOfSpeakers.equals(that.numberOfSpeakers) : that.numberOfSpeakers != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = element_id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (kind_id != null ? kind_id.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (numberOfSpeakers != null ? numberOfSpeakers.hashCode() : 0);
        return result;
    }
}
