package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "paradigms", schema = "s223552", catalog = "studs")
public class ParadigmsEntity {
    private int paradigmId;
    private String paradigm;
    private Collection<ParadigmsOfLangEntity> paradigmsOfLangsByParadigmId;

    public ParadigmsEntity() {
    }

    public ParadigmsEntity(String paradigm, Collection<ParadigmsOfLangEntity> paradigmsOfLangsByParadigmId) {
        this.paradigm = paradigm;
        this.paradigmsOfLangsByParadigmId = paradigmsOfLangsByParadigmId;
    }

    public static ParadigmsEntity readElem(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ParadigmsEntity elem = em.find(ParadigmsEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(ParadigmsEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(ParadigmsEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "paradigm_id", nullable = false)
    public int getParadigmId() {
        return paradigmId;
    }

    public void setParadigmId(int paradigmId) {
        this.paradigmId = paradigmId;
    }

    @Basic
    @Column(name = "paradigm", nullable = false, length = -1)
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

        if (paradigmId != that.paradigmId) return false;
        if (paradigm != null ? !paradigm.equals(that.paradigm) : that.paradigm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paradigmId;
        result = 31 * result + (paradigm != null ? paradigm.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "paradigmsByParadigmId")
    public Collection<ParadigmsOfLangEntity> getParadigmsOfLangsByParadigmId() {
        return paradigmsOfLangsByParadigmId;
    }

    public void setParadigmsOfLangsByParadigmId(Collection<ParadigmsOfLangEntity> paradigmsOfLangsByParadigmId) {
        this.paradigmsOfLangsByParadigmId = paradigmsOfLangsByParadigmId;
    }
}
