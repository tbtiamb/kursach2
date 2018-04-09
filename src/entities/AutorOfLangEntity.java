package entities;

import javax.persistence.*;

@Entity
@Table(name = "autor_of_lang", schema = "s223552", catalog = "studs")
@IdClass(AutorOfLangEntityPK.class)
public class AutorOfLangEntity {
    private int langId;
    private int autorId;
    private ElementsEntity elementsByLangId;
    private AutorsEntity autorsByAutorId;

    public AutorOfLangEntity() {
    }

    @Id
    @Column(name = "lang_id", nullable = false)
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Id
    @Column(name = "autor_id", nullable = false)
    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutorOfLangEntity that = (AutorOfLangEntity) o;

        if (langId != that.langId) return false;
        if (autorId != that.autorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = langId;
        result = 31 * result + autorId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "lang_id", referencedColumnName = "element_id", nullable = false, insertable = false, updatable = false)
    public ElementsEntity getElementsByLangId() {
        return elementsByLangId;
    }

    public void setElementsByLangId(ElementsEntity elementsByLangId) {
        this.elementsByLangId = elementsByLangId;
    }

    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "autor_id", nullable = false, insertable = false, updatable = false)
    public AutorsEntity getAutorsByAutorId() {
        return autorsByAutorId;
    }

    public void setAutorsByAutorId(AutorsEntity autorsByAutorId) {
        this.autorsByAutorId = autorsByAutorId;
    }
}
