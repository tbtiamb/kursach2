package entities;

import javax.persistence.*;

@Entity
@Table(name = "paradigms_of_lang", schema = "s223552", catalog = "studs")
@IdClass(ParadigmsOfLangEntityPK.class)
public class ParadigmsOfLangEntity {
    private int langId;
    private int paradigmId;
    private ElementsEntity elementsByLangId;
    private ParadigmsEntity paradigmsByParadigmId;

    public ParadigmsOfLangEntity() {
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
    @Column(name = "paradigm_id", nullable = false)
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

        ParadigmsOfLangEntity that = (ParadigmsOfLangEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "lang_id", referencedColumnName = "element_id", nullable = false, insertable = false, updatable = false)
    public ElementsEntity getElementsByLangId() {
        return elementsByLangId;
    }

    public void setElementsByLangId(ElementsEntity elementsByLangId) {
        this.elementsByLangId = elementsByLangId;
    }

    @ManyToOne
    @JoinColumn(name = "paradigm_id", referencedColumnName = "paradigm_id", nullable = false, insertable = false, updatable = false)
    public ParadigmsEntity getParadigmsByParadigmId() {
        return paradigmsByParadigmId;
    }

    public void setParadigmsByParadigmId(ParadigmsEntity paradigmsByParadigmId) {
        this.paradigmsByParadigmId = paradigmsByParadigmId;
    }
}
