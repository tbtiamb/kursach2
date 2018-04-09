package data;

import java.sql.Date;

public class AutorData {
    public int autorId;
    public String firstName;
    public String secondName;
    public Integer nationId;
    public Date dateOfBirth;
    public Date dateOfDeath;

    public AutorData(int autorId, String firstName, String secondName, Integer nationId, Date dateOfBirth, Date dateOfDeath) {
        this.autorId = autorId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.nationId = nationId;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }
}
