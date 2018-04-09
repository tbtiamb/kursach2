package beans;

import data.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

import entities.*;


@LocalBean
@Stateful
public class LangsBean {
    public LangsBean() {
    }

    public List<AllLangData> getAllLangs() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select element from ElementsEntity element where element.kindId <= 4");
        List<AllLangData> allLangData = new ArrayList<AllLangData>();
        List<ElementsEntity> elements = query.getResultList();
        for (ElementsEntity element : elements) {
            KindData kindData = new KindData(
                    element.getKindOfElementByKindId().getKindId(),
                    element.getKindOfElementByKindId().getKind(),
                    element.getKindOfElementByKindId().getSubkind()
            );
            List<NationData> nationAndLocationList = new ArrayList<>();
            List<WhoSpeaksEntity> whoSpeaksList = (List<WhoSpeaksEntity>) element.getWhoSpeaksByElementId();
            for (WhoSpeaksEntity who : whoSpeaksList) {
                NationData nationData = new NationData(
                        who.getNationAndLocationByNationId().getNationId(),
                        who.getNationAndLocationByNationId().getNation(),
                        who.getNationAndLocationByNationId().getCountry(),
                        who.getNationAndLocationByNationId().getCity()
                );
                nationAndLocationList.add(nationData);
            }

            AllLangData allData = new AllLangData(
                    element.getElementId(),
                    element.getName(),
                    element.getKindId(),
                    element.getStatus(),
                    element.getNumberOfSpeakers(),
                    kindData,
                    nationAndLocationList
            );
            allLangData.add(allData);
        }
        return allLangData;
    }

    public List<AllProgLangData> getAllProgLangs() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select element from ElementsEntity element where element.kindId = 5");
        List<ElementsEntity> elements = query.getResultList();
        List<AllProgLangData> allProgLangDataList = new ArrayList<>();
        for (ElementsEntity element : elements) {
            List<AutorData> autorDataList = new ArrayList<>();
            List<CapabilityData> capabilityDataList = new ArrayList<>();
            List<ExtensionsData> extensionsDataList = new ArrayList<>();
            List<ParadigmsData> paradigmsDataList = new ArrayList<>();
            for (AutorOfLangEntity autor : element.getAutorOfLangsByElementId()) {
                AutorData autorData = new AutorData(
                        autor.getAutorsByAutorId().getAutorId(),
                        autor.getAutorsByAutorId().getFirstName(),
                        autor.getAutorsByAutorId().getSecondName(),
                        autor.getAutorsByAutorId().getNationId(),
                        autor.getAutorsByAutorId().getDateOfBirth(),
                        autor.getAutorsByAutorId().getDateOfDeath()
                );
                autorDataList.add(autorData);
            }
            for (CapabilitiesOfLangEntity capability : element.getCapabilitiesOfLangsByElementId()) {
                CapabilityData capabilityData = new CapabilityData(
                        capability.getCapabilitiesByCapabilityId().getCapabilityId(),
                        capability.getCapabilitiesByCapabilityId().getCapability(),
                        capability.getCapabilitiesByCapabilityId().getVersion()
                );
                capabilityDataList.add(capabilityData);
            }
            for (ExtensionsOfLangEntity extensions : element.getExtensionsOfLangsByElementId()) {
                ExtensionsData extensionsData = new ExtensionsData(
                        extensions.getExtensionsByExtensionId().getExtensionId(),
                        extensions.getExtensionsByExtensionId().getExtension()
                );
                extensionsDataList.add(extensionsData);
            }
            for (ParadigmsOfLangEntity paradigms : element.getParadigmsOfLangsByElementId()) {
                ParadigmsData paradigmsData = new ParadigmsData(
                        paradigms.getParadigmsByParadigmId().getParadigmId(),
                        paradigms.getParadigmsByParadigmId().getParadigm()
                );
                paradigmsDataList.add(paradigmsData);
            }
            KindData kindData = new KindData(
                    element.getKindOfElementByKindId().getKindId(),
                    element.getKindOfElementByKindId().getKind(),
                    element.getKindOfElementByKindId().getSubkind()
            );
            AllProgLangData allProgLangData = new AllProgLangData(
                    element.getElementId(),
                    element.getName(),
                    element.getKindId(),
                    autorDataList,
                    capabilityDataList,
                    kindData,
                    extensionsDataList,
                    paradigmsDataList
            );
            allProgLangDataList.add(allProgLangData);
        }
        return allProgLangDataList;
    }

    public AllLangData getLang(String language) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select element from ElementsEntity element where element.name = :language");
        query.setParameter("language", language);
        ElementsEntity element = (ElementsEntity) query.getSingleResult();
        KindData kindData = new KindData(
                element.getKindOfElementByKindId().getKindId(),
                element.getKindOfElementByKindId().getKind(),
                element.getKindOfElementByKindId().getSubkind()
        );
        List<NationData> nationAndLocationList = new ArrayList<>();
        List<WhoSpeaksEntity> whoSpeaksList = (List<WhoSpeaksEntity>) element.getWhoSpeaksByElementId();
        for (WhoSpeaksEntity who : whoSpeaksList) {
            NationData nationData = new NationData(
                    who.getNationAndLocationByNationId().getNationId(),
                    who.getNationAndLocationByNationId().getNation(),
                    who.getNationAndLocationByNationId().getCountry(),
                    who.getNationAndLocationByNationId().getCity()
            );
            nationAndLocationList.add(nationData);
        }
        AllLangData allData = new AllLangData(
                element.getElementId(),
                element.getName(),
                element.getKindId(),
                element.getStatus(),
                element.getNumberOfSpeakers(),
                kindData,
                nationAndLocationList
        );
        return allData;
    }

    public AllProgLangData getProgLangs(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select element from ElementsEntity element where element.name = :name");
        query.setParameter("name", name);
        ElementsEntity element = (ElementsEntity) query.getSingleResult();
        List<AutorData> autorDataList = new ArrayList<>();
        List<CapabilityData> capabilityDataList = new ArrayList<>();
        List<ExtensionsData> extensionsDataList = new ArrayList<>();
        List<ParadigmsData> paradigmsDataList = new ArrayList<>();
        for (AutorOfLangEntity autor : element.getAutorOfLangsByElementId()) {
            AutorData autorData = new AutorData(
                    autor.getAutorsByAutorId().getAutorId(),
                    autor.getAutorsByAutorId().getFirstName(),
                    autor.getAutorsByAutorId().getSecondName(),
                    autor.getAutorsByAutorId().getNationId(),
                    autor.getAutorsByAutorId().getDateOfBirth(),
                    autor.getAutorsByAutorId().getDateOfDeath()
            );
            autorDataList.add(autorData);
        }
        for (CapabilitiesOfLangEntity capability : element.getCapabilitiesOfLangsByElementId()) {
            CapabilityData capabilityData = new CapabilityData(
                    capability.getCapabilitiesByCapabilityId().getCapabilityId(),
                    capability.getCapabilitiesByCapabilityId().getCapability(),
                    capability.getCapabilitiesByCapabilityId().getVersion()
            );
            capabilityDataList.add(capabilityData);
        }
        for (ExtensionsOfLangEntity extensions : element.getExtensionsOfLangsByElementId()) {
            ExtensionsData extensionsData = new ExtensionsData(
                    extensions.getExtensionsByExtensionId().getExtensionId(),
                    extensions.getExtensionsByExtensionId().getExtension()
            );
            extensionsDataList.add(extensionsData);
        }
        for (ParadigmsOfLangEntity paradigms : element.getParadigmsOfLangsByElementId()) {
            ParadigmsData paradigmsData = new ParadigmsData(
                    paradigms.getParadigmsByParadigmId().getParadigmId(),
                    paradigms.getParadigmsByParadigmId().getParadigm()
            );
            paradigmsDataList.add(paradigmsData);
        }
        KindData kindData = new KindData(
                element.getKindOfElementByKindId().getKindId(),
                element.getKindOfElementByKindId().getKind(),
                element.getKindOfElementByKindId().getSubkind()
        );
        AllProgLangData allProgLangData = new AllProgLangData(
                element.getElementId(),
                element.getName(),
                element.getKindId(),
                autorDataList,
                capabilityDataList,
                kindData,
                extensionsDataList,
                paradigmsDataList
        );
        return allProgLangData;
    }
}