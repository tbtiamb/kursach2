package data;

import entities.*;

import java.util.Collection;
import java.util.List;

public class AllLangData {
    public int elementId;
    public String name;
    public Integer kindId;
    public Boolean status;
    public Long numberOfSpeakers;
    public KindData kindData;
    //public Collection<WhoSpeaksEntity> whoSpeaksByElementId;
    public List<NationData> nationAndLocation;

    public AllLangData(int elementId, String name, Integer kindId, Boolean status, Long numberOfSpeakers, KindData kindData, List<NationData> nationAndLocation) {
        this.elementId = elementId;
        this.name = name;
        this.kindId = kindId;
        this.status = status;
        this.numberOfSpeakers = numberOfSpeakers;
        this.kindData = kindData;
        this.nationAndLocation = nationAndLocation;
    }
}

