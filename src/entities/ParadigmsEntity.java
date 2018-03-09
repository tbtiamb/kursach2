package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ПАРАДИГМЫ", schema = "s223552", catalog = "studs")
public class ParadigmsEntity implements Serializable {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
    public static EntityManager em = emf.createEntityManager();
    private static final int serialVersionUID = 1;

    private int paradigm_id;
    private String paradigm;

    public ParadigmsEntity() {}

    public ParadigmsEntity(int paradigm_id, String paradigm) {
        this.paradigm_id = paradigm_id;
        this.paradigm = paradigm;
    }

    public static ParadigmsEntity readElem(int id){
        em.getTransaction().begin();
        ParadigmsEntity elem = em.find(ParadigmsEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(ParadigmsEntity elem) {
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(ParadigmsEntity elem) {
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ИД_ПАРАДИГМЫ")
    public int getParadigm_id() {
        return paradigm_id;
    }

    public void setParadigm_id(int paradigm_id) {
        this.paradigm_id = paradigm_id;
    }

    @Basic
    @Column(name = "ПАРАДИГМА")
    public String getParadigm() {
        return paradigm;
    }

    public void setParadigm(String paradigm) {
        this.paradigm = paradigm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParadigmsEntity that = (ParadigmsEntity) o;

        if (paradigm_id != that.paradigm_id) return false;
        if (paradigm != null ? !paradigm.equals(that.paradigm) : that.paradigm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paradigm_id;
        result = 31 * result + (paradigm != null ? paradigm.hashCode() : 0);
        return result;
    }
}
