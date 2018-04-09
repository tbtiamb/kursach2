package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class WhoSpeaksEntityPK implements Serializable {
    private int langId;
    private int nationId;

    public WhoSpeaksEntityPK() {
    }

    @Column(name = "lang_id", nullable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Column(name = "nation_id", nullable = false)
    @Id
    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WhoSpeaksEntityPK that = (WhoSpeaksEntityPK) o;

        if (langId != that.langId) return false;
        if (nationId != that.nationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = langId;
        result = 31 * result + nationId;
        return result;
    }
}
