package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "АВТОР_ЯЗЫКА", schema = "s223552", catalog = "studs")
@IdClass(AutorOfLangEntityPK.class)
public class AutorOfLangEntity implements Serializable{
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
    public static EntityManager em = emf.createEntityManager();
    
    private int lang_id;
    private int autor_id;

    public AutorOfLangEntity() {}

    public AutorOfLangEntity(int lang_id, int autor_id) {
        this.lang_id = lang_id;
        this.autor_id = autor_id;
    }

    public static AutorOfLangEntity readElem(int id){
        em.getTransaction().begin();
        AutorOfLangEntity elem = em.find(AutorOfLangEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(AutorOfLangEntity elem) {
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(AutorOfLangEntity elem) {
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
    @Column(name = "ИД_АВТОРА")
    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutorOfLangEntity that = (AutorOfLangEntity) o;

        if (lang_id != that.lang_id) return false;
        if (autor_id != that.autor_id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lang_id;
        result = 31 * result + autor_id;
        return result;
    }
}
