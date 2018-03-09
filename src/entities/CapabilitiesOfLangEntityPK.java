package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CapabilitiesOfLangEntityPK implements Serializable {
    private int lang_id;
    private int capability_id;

    @Column(name = "ИД_ЯЗЫКА")
    @Id
    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    @Column(name = "ИД_ВОЗМОЖНОСТИ")
    @Id
    public int getCapability_id() {
        return capability_id;
    }

    public void setCapability_id(int capability_id) {
        this.capability_id = capability_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CapabilitiesOfLangEntityPK that = (CapabilitiesOfLangEntityPK) o;

        if (lang_id != that.lang_id) return false;
        if (capability_id != that.capability_id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lang_id;
        result = 31 * result + capability_id;
        return result;
    }
}
