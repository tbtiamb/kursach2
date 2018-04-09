package data;

import java.util.List;

public class AllProgLangData {
    public int elementId;
    public String name;
    public Integer kindId;
    public List<AutorData> autorsList;
    public List<CapabilityData> capabilitiesList;
    public KindData kindData;
    public List<ExtensionsData> extensionsList;
    public List<ParadigmsData> paradigmsList;

    public AllProgLangData(int elementId, String name, Integer kindId, List<AutorData> autorsList, List<CapabilityData> capabilitiesList, KindData kindData, List<ExtensionsData> extensionsList, List<ParadigmsData> paradigmsList) {
        this.elementId = elementId;
        this.name = name;
        this.kindId = kindId;
        this.autorsList = autorsList;
        this.capabilitiesList = capabilitiesList;
        this.kindData = kindData;
        this.extensionsList = extensionsList;
        this.paradigmsList = paradigmsList;
    }
}