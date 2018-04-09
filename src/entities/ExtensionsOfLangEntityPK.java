package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ExtensionsOfLangEntityPK implements Serializable {
    private int langId;
    private int extensionId;

    public ExtensionsOfLangEntityPK() {
    }

    @Column(name = "lang_id", nullable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Column(name = "extension_id", nullable = false)
    @Id
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

        ExtensionsOfLangEntityPK that = (ExtensionsOfLangEntityPK) o;

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
}
