package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ParadigmsOfLangEntityPK implements Serializable {
    private int langId;
    private int paradigmId;

    public ParadigmsOfLangEntityPK() {
    }

    @Column(name = "lang_id", nullable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Column(name = "paradigm_id", nullable = false)
    @Id
    public int getParadigmId() {
        return paradigmId;
    }

    public void setParadigmId(int paradigmId) {
        this.paradigmId = paradigmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParadigmsOfLangEntityPK that = (ParadigmsOfLangEntityPK) o;

        if (langId != that.langId) return false;
        if (paradigmId != that.paradigmId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = langId;
        result = 31 * result + paradigmId;
        return result;
    }
}
