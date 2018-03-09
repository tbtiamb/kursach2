package entities;

import javax.persistence.*;

@Entity
@Table(name = "ВИД_ЭЛЕМЕНТА", schema = "s223552", catalog = "studs")
public class ВидЭлементаEntity {
    private int идВида;
    private String вид;
    private String подвид;

    @Id
    @Column(name = "ИД_ВИДА")
    public int getИдВида() {
        return идВида;
    }

    public void setИдВида(int идВида) {
        this.идВида = идВида;
    }

    @Basic
    @Column(name = "ВИД")
    public String getВид() {
        return вид;
    }

    public void setВид(String вид) {
        this.вид = вид;
    }

    @Basic
    @Column(name = "ПОДВИД")
    public String getПодвид() {
        return подвид;
    }

    public void setПодвид(String подвид) {
        this.подвид = подвид;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ВидЭлементаEntity that = (ВидЭлементаEntity) o;

        if (идВида != that.идВида) return false;
        if (вид != null ? !вид.equals(that.вид) : that.вид != null) return false;
        if (подвид != null ? !подвид.equals(that.подвид) : that.подвид != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = идВида;
        result = 31 * result + (вид != null ? вид.hashCode() : 0);
        result = 31 * result + (подвид != null ? подвид.hashCode() : 0);
        return result;
    }
}
