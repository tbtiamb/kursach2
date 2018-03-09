package beans;

import entities.ElementEntity;
import entities.NationAndLocationEntity;
import entities.ВидЭлементаEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@LocalBean
@Stateful
public class LangsBean {
    public LangsBean() {
    }

//    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
//    public static EntityManager em = emf.createEntityManager();

    //private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
    //private  EntityManager em = emf.createEntityManager();
    public String getAllLangs(){
        return "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>123</title>\n" +
                "    <style>\n" +
                "        .listOfLangs {\n" +
                "            //height: %;\n" +
                "            height: 600px;\n" +
                "            width: 20%;\n" +
                "            min-width: 20%;\n" +
                "            background-color: #b3d4fc;\n" +
                "            overflow-y: scroll;\n" +
                "            position: relative;\n" +
                "            display: inline-block;\n" +
                "            float: left;\n" +
                "        }\n" +
                "\n" +
                "        .info {\n" +
                "            height: 600px;\n" +
                "            width: 80%;\n" +
                "            position: relative;\n" +
                "            display: inline-block;\n" +
                "            background-color: #555555;\n" +
                "        }\n" +
                "\n" +
                "        input[type=\"submit\"]{\n" +
                "            display: block;\n" +
                "            margin: 0% 7%;\n" +
                "           // height: 100%;\n" +
                "           // width:18%;\n" +
                "            -webkit-transition: all.9s ease;\n" +
                "            -moz-transition: all.9s ease;\n" +
                "            text-decoration:none;\n" +
                "            text-align:center;\n" +
                "            border:none;\n" +
                "            font-weight:bold;\n" +
                "            color: black;\n" +
                "            background-color: rgba(0,0,0,0);\n" +
                "\n" +
                "        }\n" +
                "        input[type=\"submit\"]:hover{\n" +
                "            background-color: rgba(0,0,0,.6);\n" +
                "            -webkit-box-shadow:0px 0px 8px #555, inset 0px 0px 1px #000;\n" +
                "            -moz-box-shadow: 0px 0px 8px #555,  inset 0px 0px 1px #000;\n" +
                "            box-shadow:0px 0px 8px #555, inset 0px 0px 1px #000;\n" +
                "            color: white;\n" +
                "        }\n" +
                "        input[type=\"submit\"]:active{\n" +
                "            background-color: rgba(0,0,0,.6);\n" +
                "\n" +
                "        }\n" +
                "    </style>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"listOfLangs\">\n" +
                "<input type='submit' name='lang' value='Абхазский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Адыгейский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Азербайджанский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Албанский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Английский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Арабский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Армянский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Башкирский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Белорусский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Бенгальский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Болгарский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Боснийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Булгарский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Бурятский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Венгерский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Вьетнамский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Гавайский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Готский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Гренландский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Греческий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Грузинский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнеанглийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древневерхненемецкий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнегреческий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнееврейский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнеисландский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнеперсидский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнерусский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Ижорский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Ингушский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Индонезийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Ирландский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Исландский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Испанский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Итальянский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Коми' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Корейский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Китайский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Кумыкский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Лаосский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Латинский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Латышский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Литовский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Люксембургский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Македонский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Малагасийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Малайский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Мальтийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Молдавский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Монгольский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Неаполитанский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Немецкий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Непальский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Нидерландский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Норвежский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Окинавский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Осетинский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Османский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Персидский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Печенежский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Польский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Пушту' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Пьемонтский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Румынский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Русский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сербский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сингальский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сирийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сицилийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Словацкий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Словенский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сомалийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сунданский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Табасаранский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Тагальский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Таджикский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Таитянский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Татарский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Тибетский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Тувинский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Турецкий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Туркменский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Удмуртский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Удэгейский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Узбекский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Уйгурский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Украинский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Финский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Французский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Хазарский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Хакасский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Хинди' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Хорватский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Эстонский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Японский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "\n" +
                "</div>\n" +
                "<div class=\"info\">\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }

    public String getLang(String language) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Languages");
        final EntityManager em = emf.createEntityManager();
        long noS = 1;
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<ElementEntity> c = qb.createQuery(ElementEntity.class);

        Root<ElementEntity> element = c.from(ElementEntity.class);
        c.select(element).where(qb.equal(element.get("name"), language));
        //ElementEntity el = (ElementEntity) element;
        noS = em.createQuery(c).getSingleResult().getNumberOfSpeakers();

        //String name =
//        Query getNoS = em.createQuery("select element from ElementEntity element where element.name = :language");
//        getNoS.setParameter("language", language);
//        ElementEntity element = (ElementEntity) getNoS.getSingleResult();
//        //noS = getNoS.getFirstResult();
//        noS = element.getNumberOfSpeakers();
        String kindString = "";
        Query getKind = em.createQuery("select kind from ВидЭлементаEntity kind where kind.идВида = (select element.kind_id from ElementEntity element where element.name = :language)");
        getKind.setParameter("language", language);
//        Query getKind = em.createQuery("select author from AutorsEntity author");
        ВидЭлементаEntity kind = (ВидЭлементаEntity)getKind.getSingleResult();
        kindString = kind.getВид();
        kindString += " ";
        kindString += kind.getПодвид();

        Query getNation = em.createQuery("SELECT nation FROM NationAndLocationEntity nation WHERE nation.nation_id = (select speaker.nation_id from WhoSpeakEntity speaker  WHERE speaker.lang_id = (SELECT element.element_id from ElementEntity element where element.name = :language ))");
        //em.createQuery("select speaker from WhoSpeakEntity speaker  WHERE speaker.lang_id = (SELECT element.element_id from ElementEntity element where element.name = :language )");
        getNation.setParameter("language", language);
        NationAndLocationEntity nation = (NationAndLocationEntity)getNation.getSingleResult();
        String nationString = nation.getNation() + " " + nation.getCity() + " " + nation.getCountry();
        emf.close();
        em.close();
        return "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>123</title>\n" +
                "    <style>\n" +
                "        .listOfLangs {\n" +
                "            //height: %;\n" +
                "            height: 600px;\n" +
                "            width: 20%;\n" +
                "            min-width: 20%;\n" +
                "            background-color: #b3d4fc;\n" +
                "            overflow-y: scroll;\n" +
                "            position: relative;\n" +
                "            display: inline-block;\n" +
                "            float: left;\n" +
                "        }\n" +
                "\n" +
                "        .info {\n" +
                "            height: 600px;\n" +
                "            width: 80%;\n" +
                "            position: relative;\n" +
                "            display: inline-block;\n" +
                "            background-color: #555555;\n" +
                "        }\n" +
                "\n" +
                "        input[type=\"submit\"]{\n" +
                "            display: block;\n" +
                "            margin: 0% 7%;\n" +
                "           // height: 100%;\n" +
                "           // width:18%;\n" +
                "            -webkit-transition: all.9s ease;\n" +
                "            -moz-transition: all.9s ease;\n" +
                "            text-decoration:none;\n" +
                "            text-align:center;\n" +
                "            border:none;\n" +
                "            font-weight:bold;\n" +
                "            color: black;\n" +
                "            background-color: rgba(0,0,0,0);\n" +
                "\n" +
                "        }\n" +
                "        input[type=\"submit\"]:hover{\n" +
                "            background-color: rgba(0,0,0,.6);\n" +
                "            -webkit-box-shadow:0px 0px 8px #555, inset 0px 0px 1px #000;\n" +
                "            -moz-box-shadow: 0px 0px 8px #555,  inset 0px 0px 1px #000;\n" +
                "            box-shadow:0px 0px 8px #555, inset 0px 0px 1px #000;\n" +
                "            color: white;\n" +
                "        }\n" +
                "        input[type=\"submit\"]:active{\n" +
                "            background-color: rgba(0,0,0,.6);\n" +
                "\n" +
                "        }\n" +
                "    </style>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"listOfLangs\">\n" +
                "<input type='submit' name='lang' value='Абхазский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Адыгейский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Азербайджанский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Албанский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Английский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Арабский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Армянский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Башкирский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Белорусский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Бенгальский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Болгарский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Боснийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Булгарский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Бурятский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Венгерский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Вьетнамский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Гавайский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Готский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Гренландский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Греческий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Грузинский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнеанглийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древневерхненемецкий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнегреческий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнееврейский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнеисландский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнеперсидский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Древнерусский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Ижорский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Ингушский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Индонезийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Ирландский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Исландский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Испанский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Итальянский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Коми' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Корейский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Китайский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Кумыкский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Лаосский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Латинский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Латышский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Литовский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Люксембургский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Македонский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Малагасийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Малайский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Мальтийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Молдавский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Монгольский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Неаполитанский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Немецкий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Непальский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Нидерландский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Норвежский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Окинавский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Осетинский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Османский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Персидский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Печенежский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Польский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Пушту' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Пьемонтский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Румынский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Русский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сербский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сингальский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сирийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сицилийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Словацкий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Словенский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сомалийский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Сунданский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Табасаранский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Тагальский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Таджикский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Таитянский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Татарский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Тибетский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Тувинский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Турецкий язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Туркменский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Удмуртский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Удэгейский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Узбекский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Уйгурский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Украинский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Финский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Французский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Хазарский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Хакасский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Хинди' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Хорватский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Эстонский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "<input type='submit' name='lang' value='Японский язык' onclick =\"location.href='./langs?lang=' + this.value\">\n" +
                "\n" +
                "</div>\n" +
                "<div class=\"info\">\n" + noS + " " + kindString + " " + nationString +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }

}
