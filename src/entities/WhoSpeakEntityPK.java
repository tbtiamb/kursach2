package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class WhoSpeakEntityPK implements Serializable {
    private int lang_id;
    private int nation_id;

    @Column(name = "ИД_ЯЗЫКА")
    @Id
    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    @Column(name = "ИД_НАЦИОНАЛЬНОСТИ")
    @Id
    public int getNation_id() {
        return nation_id;
    }

    public void setNation_id(int nation_id) {
        this.nation_id = nation_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WhoSpeakEntityPK that = (WhoSpeakEntityPK) o;

        if (lang_id != that.lang_id) return false;
        if (nation_id != that.nation_id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lang_id;
        result = 31 * result + nation_id;
        return result;
    }
}
