package entities;

import javax.persistence.*;

@Entity
@Table(name = "extensions_of_lang", schema = "s223552", catalog = "studs")
@IdClass(ExtensionsOfLangEntityPK.class)
public class ExtensionsOfLangEntity {
    private int langId;
    private int extensionId;
    private ElementsEntity elementsByLangId;
    private ExtensionsEntity extensionsByExtensionId;

    public ExtensionsOfLangEntity() {
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
    @Column(name = "extension_id", nullable = false)
    public int getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(int extensionId) {
        this.extensionId = extensionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtensionsOfLangEntity that = (ExtensionsOfLangEntity) o;

        if (langId != that.langId) return false;
        if (extensionId != that.extensionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = langId;
        result = 31 * result + extensionId;
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
    @JoinColumn(name = "extension_id", referencedColumnName = "extension_id", nullable = false, insertable = false, updatable = false)
    public ExtensionsEntity getExtensionsByExtensionId() {
        return extensionsByExtensionId;
    }

    public void setExtensionsByExtensionId(ExtensionsEntity extensionsByExtensionId) {
        this.extensionsByExtensionId = extensionsByExtensionId;
    }
}
