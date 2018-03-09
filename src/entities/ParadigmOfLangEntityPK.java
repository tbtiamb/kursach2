package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ParadigmOfLangEntityPK implements Serializable {
    private int lang_id;
    private int paradigm_id;

    @Column(name = "ИД_ЯЗЫКА")
    @Id
    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    @Column(name = "ИД_ПАРАДИГМЫ")
    @Id
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

        ParadigmOfLangEntityPK that = (ParadigmOfLangEntityPK) o;

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
