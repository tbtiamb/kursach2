package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "extra_langinfo_of_lang", schema = "s223552", catalog = "studs")
@IdClass(ExtraLanginfoOfLangEntityPK.class)
public class ExtraLanginfoOfLangEntity {
    private int langId;
    private int langinfoId;
    private String textValue;
    private Integer numberValue;
    private Date date;
    private ElementsEntity elementsByLangId;
    private ExtraLanginfoEntity extraLanginfoByLanginfoId;

    public ExtraLanginfoOfLangEntity() {
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
    @Column(name = "langinfo_id", nullable = false)
    public int getLanginfoId() {
        return langinfoId;
    }

    public void setLanginfoId(int langinfoId) {
        this.langinfoId = langinfoId;
    }

    @Basic
    @Column(name = "text_value", nullable = true, length = -1)
    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    @Basic
    @Column(name = "number_value", nullable = true)
    public Integer getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(Integer numberValue) {
        this.numberValue = numberValue;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtraLanginfoOfLangEntity that = (ExtraLanginfoOfLangEntity) o;

        if (langId != that.langId) return false;
        if (langinfoId != that.langinfoId) return false;
        if (textValue != null ? !textValue.equals(that.textValue) : that.textValue != null) return false;
        if (numberValue != null ? !numberValue.equals(that.numberValue) : that.numberValue != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = langId;
        result = 31 * result + langinfoId;
        result = 31 * result + (textValue != null ? textValue.hashCode() : 0);
        result = 31 * result + (numberValue != null ? numberValue.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
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
    @JoinColumn(name = "langinfo_id", referencedColumnName = "langinfo_id", nullable = false, insertable = false, updatable = false)
    public ExtraLanginfoEntity getExtraLanginfoByLanginfoId() {
        return extraLanginfoByLanginfoId;
    }

    public void setExtraLanginfoByLanginfoId(ExtraLanginfoEntity extraLanginfoByLanginfoId) {
        this.extraLanginfoByLanginfoId = extraLanginfoByLanginfoId;
    }
}
