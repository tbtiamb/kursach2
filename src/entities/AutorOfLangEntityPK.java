package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AutorOfLangEntityPK implements Serializable {
    private int langId;
    private int autorId;

    public AutorOfLangEntityPK() {
    }

    @Column(name = "lang_id", nullable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Column(name = "autor_id", nullable = false)
    @Id
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

        AutorOfLangEntityPK that = (AutorOfLangEntityPK) o;

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
}
