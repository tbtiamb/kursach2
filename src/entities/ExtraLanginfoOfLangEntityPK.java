package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ExtraLanginfoOfLangEntityPK implements Serializable {
    private int langId;
    private int langinfoId;

    public ExtraLanginfoOfLangEntityPK() {
    }

    @Column(name = "lang_id", nullable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Column(name = "langinfo_id", nullable = false)
    @Id
    public int getLanginfoId() {
        return langinfoId;
    }

    public void setLanginfoId(int langinfoId) {
        this.langinfoId = langinfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtraLanginfoOfLangEntityPK that = (ExtraLanginfoOfLangEntityPK) o;

        if (langId != that.langId) return false;
        if (langinfoId != that.langinfoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = langId;
        result = 31 * result + langinfoId;
        return result;
    }
}
