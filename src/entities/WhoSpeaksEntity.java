package entities;

import javax.persistence.*;

@Entity
@Table(name = "who_speaks", schema = "s223552", catalog = "studs")
@IdClass(WhoSpeaksEntityPK.class)
public class WhoSpeaksEntity {
    private int langId;
    private int nationId;
    private ElementsEntity elementsByLangId;
    private NationAndLocationEntity nationAndLocationByNationId;

    public WhoSpeaksEntity() {
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
    @Column(name = "nation_id", nullable = false)
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

        WhoSpeaksEntity that = (WhoSpeaksEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "lang_id", referencedColumnName = "element_id", nullable = false, insertable = false, updatable = false)
    public ElementsEntity getElementsByLangId() {
        return elementsByLangId;
    }

    public void setElementsByLangId(ElementsEntity elementsByLangId) {
        this.elementsByLangId = elementsByLangId;
    }

    @ManyToOne
    @JoinColumn(name = "nation_id", referencedColumnName = "nation_id", nullable = false, insertable = false, updatable = false)
    public NationAndLocationEntity getNationAndLocationByNationId() {
        return nationAndLocationByNationId;
    }

    public void setNationAndLocationByNationId(NationAndLocationEntity nationAndLocationByNationId) {
        this.nationAndLocationByNationId = nationAndLocationByNationId;
    }
}
