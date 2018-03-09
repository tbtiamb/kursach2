package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "КЛАСС_ЯЗЫКА", schema = "s223552", catalog = "studs")
@IdClass(ParadigmOfLangEntityPK.class)
public class ParadigmOfLangEntity implements Serializable {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
    public static EntityManager em = emf.createEntityManager();


    private int lang_id;
    private int paradigm_id;

    public ParadigmOfLangEntity() {}

    public ParadigmOfLangEntity(int lang_id, int paradigm_id) {
        this.lang_id = lang_id;
        this.paradigm_id = paradigm_id;
    }

    public static ParadigmOfLangEntity readElem(int id){
        em.getTransaction().begin();
        ParadigmOfLangEntity elem = em.find(ParadigmOfLangEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(ParadigmOfLangEntity elem) {
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(ParadigmOfLangEntity elem) {
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ИД_ПАРАДИГМЫ")
    public int getParadigm_id() {
        return paradigm_id;
    }

    public void setParadigm_id(int paradigm_id) {
        this.paradigm_id = paradigm_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParadigmOfLangEntity that = (ParadigmOfLangEntity) o;

        if (lang_id != that.lang_id) return false;
        if (paradigm_id != that.paradigm_id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lang_id;
        result = 31 * result + paradigm_id;
        return result;
    }
}
