package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AutorOfLangEntityPK implements Serializable {
    private int lang_id;
    private int autor_id;

    @Column(name = "ИД_ЯЗЫКА")
    @Id
    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    @Column(name = "ИД_АВТОРА")
    @Id
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

        AutorOfLangEntityPK that = (AutorOfLangEntityPK) o;

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
