package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CapabilitiesOfLangEntityPK implements Serializable {
    private int langId;
    private int capabilityId;

    public CapabilitiesOfLangEntityPK() {
    }

    @Column(name = "lang_id", nullable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Column(name = "capability_id", nullable = false)
    @Id
    public int getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(int capabilityId) {
        this.capabilityId = capabilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CapabilitiesOfLangEntityPK that = (CapabilitiesOfLangEntityPK) o;

        if (langId != that.langId) return false;
        if (capabilityId != that.capabilityId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = langId;
        result = 31 * result + capabilityId;
        return result;
    }
}
