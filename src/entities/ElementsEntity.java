package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "elements", schema = "s223552", catalog = "studs")
public class ElementsEntity {
    private int elementId;
    private String name;
    private Integer kindId;
    private Boolean status;
    private Long numberOfSpeakers;
    private Collection<AutorOfLangEntity> autorOfLangsByElementId;
    private Collection<CapabilitiesOfLangEntity> capabilitiesOfLangsByElementId;
    private KindOfElementEntity kindOfElementByKindId;
    private Collection<ExtensionsOfLangEntity> extensionsOfLangsByElementId;
    private Collection<ExtraLanginfoOfLangEntity> extraLanginfoOfLangsByElementId;
    private HierarchyEntity hierarchyByElementId;
    private Collection<ParadigmsOfLangEntity> paradigmsOfLangsByElementId;
    private Collection<WhoSpeaksEntity> whoSpeaksByElementId;

    public ElementsEntity() {}

    public ElementsEntity(String name, Integer kindId, Boolean status, Long numberOfSpeakers) {
        this.name = name;
        this.kindId = kindId;
        this.status = status;
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public static ElementsEntity readElem(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ElementsEntity elem = em.find(ElementsEntity.class, id);
        em.getTransaction().commit();
        return elem;
    }

    public static void addElem(ElementsEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
    }

    public static void removeElem(ElementsEntity elem) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(elem);
        em.getTransaction().commit();
    }

    public static void updateStatus(ElementsEntity elem, String state){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE ElementsEntity element SET  element.status = :state WHERE  element.elementId = :elem_id");
        query.setParameter("state", state);
        query.setParameter("elem_id", elem.getElementId());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }

    public static void updateNumberOfSpeakers(ElementsEntity elem, String nos){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE ElementsEntity element SET  element.numberOfSpeakers = :nos WHERE  element.elementId = :elem_id");
        query.setParameter("nos", nos);
        query.setParameter("elem_id", elem.getElementId());
        int rowCount = query.executeUpdate();
        em.getTransaction().commit();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "element_id", nullable = false)
    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "kind_id", nullable = true)
    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "number_of_speakers", nullable = true)
    public Long getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(Long numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElementsEntity that = (ElementsEntity) o;

        if (elementId != that.elementId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (kindId != null ? !kindId.equals(that.kindId) : that.kindId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (numberOfSpeakers != null ? !numberOfSpeakers.equals(that.numberOfSpeakers) : that.numberOfSpeakers != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = elementId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (kindId != null ? kindId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (numberOfSpeakers != null ? numberOfSpeakers.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "elementsByLangId")
    public Collection<AutorOfLangEntity> getAutorOfLangsByElementId() {
        return autorOfLangsByElementId;
    }

    public void setAutorOfLangsByElementId(Collection<AutorOfLangEntity> autorOfLangsByElementId) {
        this.autorOfLangsByElementId = autorOfLangsByElementId;
    }

    @OneToMany(mappedBy = "elementsByLangId")
    public Collection<CapabilitiesOfLangEntity> getCapabilitiesOfLangsByElementId() {
        return capabilitiesOfLangsByElementId;
    }

    public void setCapabilitiesOfLangsByElementId(Collection<CapabilitiesOfLangEntity> capabilitiesOfLangsByElementId) {
        this.capabilitiesOfLangsByElementId = capabilitiesOfLangsByElementId;
    }

    @ManyToOne
    @JoinColumn(name = "kind_id", referencedColumnName = "kind_id", insertable = false, updatable = false)
    public KindOfElementEntity getKindOfElementByKindId() {
        return kindOfElementByKindId;
    }

    public void setKindOfElementByKindId(KindOfElementEntity kindOfElementByKindId) {
        this.kindOfElementByKindId = kindOfElementByKindId;
    }

    @OneToMany(mappedBy = "elementsByLangId")
    public Collection<ExtensionsOfLangEntity> getExtensionsOfLangsByElementId() {
        return extensionsOfLangsByElementId;
    }

    public void setExtensionsOfLangsByElementId(Collection<ExtensionsOfLangEntity> extensionsOfLangsByElementId) {
        this.extensionsOfLangsByElementId = extensionsOfLangsByElementId;
    }

    @OneToMany(mappedBy = "elementsByLangId")
    public Collection<ExtraLanginfoOfLangEntity> getExtraLanginfoOfLangsByElementId() {
        return extraLanginfoOfLangsByElementId;
    }

    public void setExtraLanginfoOfLangsByElementId(Collection<ExtraLanginfoOfLangEntity> extraLanginfoOfLangsByElementId) {
        this.extraLanginfoOfLangsByElementId = extraLanginfoOfLangsByElementId;
    }

    @OneToOne(mappedBy = "elementsByElement")
    public HierarchyEntity getHierarchyByElementId() {
        return hierarchyByElementId;
    }

    public void setHierarchyByElementId(HierarchyEntity hierarchyByElementId) {
        this.hierarchyByElementId = hierarchyByElementId;
    }

    @OneToMany(mappedBy = "elementsByLangId")
    public Collection<ParadigmsOfLangEntity> getParadigmsOfLangsByElementId() {
        return paradigmsOfLangsByElementId;
    }

    public void setParadigmsOfLangsByElementId(Collection<ParadigmsOfLangEntity> paradigmsOfLangsByElementId) {
        this.paradigmsOfLangsByElementId = paradigmsOfLangsByElementId;
    }

    @OneToMany(mappedBy = "elementsByLangId")
    public Collection<WhoSpeaksEntity> getWhoSpeaksByElementId() {
        return whoSpeaksByElementId;
    }

    public void setWhoSpeaksByElementId(Collection<WhoSpeaksEntity> whoSpeaksByElementId) {
        this.whoSpeaksByElementId = whoSpeaksByElementId;
    }
}
