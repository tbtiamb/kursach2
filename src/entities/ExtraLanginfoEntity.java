package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "extra_langinfo", schema = "s223552", catalog = "studs")
public class ExtraLanginfoEntity {
    private int langinfoId;
    private String name;
    private Collection<ExtraLanginfoOfLangEntity> extraLanginfoOfLangsByLanginfoId;

    public ExtraLanginfoEntity() {
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
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtraLanginfoEntity that = (ExtraLanginfoEntity) o;

        if (langinfoId != that.langinfoId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = langinfoId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "extraLanginfoByLanginfoId")
    public Collection<ExtraLanginfoOfLangEntity> getExtraLanginfoOfLangsByLanginfoId() {
        return extraLanginfoOfLangsByLanginfoId;
    }

    public void setExtraLanginfoOfLangsByLanginfoId(Collection<ExtraLanginfoOfLangEntity> extraLanginfoOfLangsByLanginfoId) {
        this.extraLanginfoOfLangsByLanginfoId = extraLanginfoOfLangsByLanginfoId;
    }
}
