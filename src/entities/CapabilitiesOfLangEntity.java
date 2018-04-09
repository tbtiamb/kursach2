package entities;

import javax.persistence.*;

@Entity
@Table(name = "capabilities_of_lang", schema = "s223552", catalog = "studs")
@IdClass(CapabilitiesOfLangEntityPK.class)
public class CapabilitiesOfLangEntity {
    private int langId;
    private int capabilityId;
    private ElementsEntity elementsByLangId;
    private CapabilitiesEntity capabilitiesByCapabilityId;

    public CapabilitiesOfLangEntity() {
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
    @Column(name = "capability_id", nullable = false)
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

        CapabilitiesOfLangEntity that = (CapabilitiesOfLangEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "lang_id", referencedColumnName = "element_id", nullable = false, insertable = false, updatable = false)
    public ElementsEntity getElementsByLangId() {
        return elementsByLangId;
    }

    public void setElementsByLangId(ElementsEntity elementsByLangId) {
        this.elementsByLangId = elementsByLangId;
    }

    @ManyToOne
    @JoinColumn(name = "capability_id", referencedColumnName = "capability_id", nullable = false, insertable = false, updatable = false)
    public CapabilitiesEntity getCapabilitiesByCapabilityId() {
        return capabilitiesByCapabilityId;
    }

    public void setCapabilitiesByCapabilityId(CapabilitiesEntity capabilitiesByCapabilityId) {
        this.capabilitiesByCapabilityId = capabilitiesByCapabilityId;
    }
}
