package uz.as.statbel.repository;

import org.springframework.stereotype.Repository;
import uz.as.statbel.domain.Municipality;

import java.util.*;
import java.util.stream.Collectors;

//@Repository
public class HardCodedGeographicalClassifRepo implements GeographicalClassificationRepo {

    private static final Map<String, String> NIS_CACHE = new HashMap<>();

    static {
        NIS_CACHE.put("'S GRAVENBRAKEL", "55004");
        NIS_CACHE.put("AALST", "41002");
        NIS_CACHE.put("AALTER", "44001");
        NIS_CACHE.put("AARLEN", "81001");
        NIS_CACHE.put("AARSCHOT", "24001");
        NIS_CACHE.put("AARTSELAAR", "11001");
        NIS_CACHE.put("AAT", "51004");
        NIS_CACHE.put("AFFLIGEM", "23105");
        NIS_CACHE.put("AISEAU-PRESLES", "52074");
        NIS_CACHE.put("ALKEN", "73001");
        NIS_CACHE.put("ALVERINGEM", "38002");
        NIS_CACHE.put("AMAY", "61003");
        NIS_CACHE.put("AMEL", "63001");
        NIS_CACHE.put("ANDENNE", "92003");
        NIS_CACHE.put("ANDERLECHT", "21001");
        NIS_CACHE.put("ANDERLUES", "56001");
        NIS_CACHE.put("ANHÉE", "91005");
        NIS_CACHE.put("ANS", "62003");
        NIS_CACHE.put("ANTHISNES", "61079");
        NIS_CACHE.put("ANTOING", "57003");
        NIS_CACHE.put("ANTWERPEN", "11002");
        NIS_CACHE.put("ANZEGEM", "34002");
        NIS_CACHE.put("ARDOOIE", "37020");
        NIS_CACHE.put("ARENDONK", "13001");
        NIS_CACHE.put("ARRONDISSEMENT AALST", "41000");
        NIS_CACHE.put("ARRONDISSEMENT AARLEN", "81000");
        NIS_CACHE.put("ARRONDISSEMENT AAT", "51000");
        NIS_CACHE.put("ARRONDISSEMENT ANTWERPEN", "11000");
        NIS_CACHE.put("ARRONDISSEMENT BASTENAKEN", "82000");
        NIS_CACHE.put("ARRONDISSEMENT BERGEN", "53000");
        NIS_CACHE.put("ARRONDISSEMENT BORGWORM", "64000");
        NIS_CACHE.put("ARRONDISSEMENT BRUGGE", "31000");
        NIS_CACHE.put("ARRONDISSEMENT BRUSSEL HOOFDSTAD", "21000");
        NIS_CACHE.put("ARRONDISSEMENT CHARLEROI", "52000");
        NIS_CACHE.put("ARRONDISSEMENT DENDERMONDE", "42000");
        NIS_CACHE.put("ARRONDISSEMENT DIKSMUIDE", "32000");
        NIS_CACHE.put("ARRONDISSEMENT DINANT", "91000");
        NIS_CACHE.put("ARRONDISSEMENT DOORNIK", "57000");
        NIS_CACHE.put("ARRONDISSEMENT EEKLO", "43000");
        NIS_CACHE.put("ARRONDISSEMENT GENT", "44000");
        NIS_CACHE.put("ARRONDISSEMENT HALLE-VILVOORDE", "23000");
        NIS_CACHE.put("ARRONDISSEMENT HASSELT", "71000");
        NIS_CACHE.put("ARRONDISSEMENT HOEI", "61000");
        NIS_CACHE.put("ARRONDISSEMENT IEPER", "33000");
        NIS_CACHE.put("ARRONDISSEMENT KORTRIJK", "34000");
        NIS_CACHE.put("ARRONDISSEMENT LEUVEN", "24000");
        NIS_CACHE.put("ARRONDISSEMENT LUIK", "62000");
        NIS_CACHE.put("ARRONDISSEMENT MAASEIK", "72000");
        NIS_CACHE.put("ARRONDISSEMENT MARCHE-EN-FAMENNE", "83000");
        NIS_CACHE.put("ARRONDISSEMENT MECHELEN", "12000");
        NIS_CACHE.put("ARRONDISSEMENT MOESKROEN", "54000");
        NIS_CACHE.put("ARRONDISSEMENT NAMEN", "92000");
        NIS_CACHE.put("ARRONDISSEMENT NEUFCHÂTEAU", "84000");
        NIS_CACHE.put("ARRONDISSEMENT NIJVEL", "25000");
        NIS_CACHE.put("ARRONDISSEMENT OOSTENDE", "35000");
        NIS_CACHE.put("ARRONDISSEMENT OUDENAARDE", "45000");
        NIS_CACHE.put("ARRONDISSEMENT PHILIPPEVILLE", "93000");
        NIS_CACHE.put("ARRONDISSEMENT ROESELARE", "36000");
        NIS_CACHE.put("ARRONDISSEMENT SINT-NIKLAAS", "46000");
        NIS_CACHE.put("ARRONDISSEMENT THUIN", "56000");
        NIS_CACHE.put("ARRONDISSEMENT TIELT", "37000");
        NIS_CACHE.put("ARRONDISSEMENT TONGEREN", "73000");
        NIS_CACHE.put("ARRONDISSEMENT TURNHOUT", "13000");
        NIS_CACHE.put("ARRONDISSEMENT VERVIERS", "63000");
        NIS_CACHE.put("ARRONDISSEMENT VEURNE", "38000");
        NIS_CACHE.put("ARRONDISSEMENT VIRTON", "85000");
        NIS_CACHE.put("ARRONDISSEMENT ZINNIK", "55000");
        NIS_CACHE.put("AS", "71002");
        NIS_CACHE.put("ASSE", "23002");
        NIS_CACHE.put("ASSENEDE", "43002");
        NIS_CACHE.put("ASSESSE", "92006");
        NIS_CACHE.put("ATTERT", "81003");
        NIS_CACHE.put("AUBANGE", "81004");
        NIS_CACHE.put("AUBEL", "63003");
        NIS_CACHE.put("AVELGEM", "34003");
        NIS_CACHE.put("AWANS", "62006");
        NIS_CACHE.put("AYWAILLE", "62009");
        NIS_CACHE.put("BRUSSELS HOOFDSTEDELIJK GEWEST", "4000");
        NIS_CACHE.put("BAARLE-HERTOG", "13002");
        NIS_CACHE.put("BAELEN", "63004");
        NIS_CACHE.put("BALEN", "13003");
        NIS_CACHE.put("BASTENAKEN", "82003");
        NIS_CACHE.put("BEAUMONT", "56005");
        NIS_CACHE.put("BEAURAING", "91013");
        NIS_CACHE.put("BEERNEM", "31003");
        NIS_CACHE.put("BEERSE", "13004");
        NIS_CACHE.put("BEERSEL", "23003");
        NIS_CACHE.put("BEGIJNENDIJK", "24007");
        NIS_CACHE.put("BEKKEVOORT", "24008");
        NIS_CACHE.put("BELOEIL", "51008");
        NIS_CACHE.put("BERGEN", "53053");
        NIS_CACHE.put("BERINGEN", "71004");
        NIS_CACHE.put("BERLAAR", "12002");
        NIS_CACHE.put("BERLARE", "42003");
        NIS_CACHE.put("BERLOZ", "64008");
        NIS_CACHE.put("BERNISSART", "51009");
        NIS_CACHE.put("BERTEM", "24009");
        NIS_CACHE.put("BERTOGNE", "82005");
        NIS_CACHE.put("BERTRIX", "84009");
        NIS_CACHE.put("BEVEKOM", "25005");
        NIS_CACHE.put("BEVER", "23009");
        NIS_CACHE.put("BEVEREN", "46003");
        NIS_CACHE.put("BEYNE-HEUSAY", "62015");
        NIS_CACHE.put("BIERBEEK", "24011");
        NIS_CACHE.put("BILZEN", "73006");
        NIS_CACHE.put("BINCHE", "56011");
        NIS_CACHE.put("BITSINGEN", "62011");
        NIS_CACHE.put("BIÈVRE", "91015");
        NIS_CACHE.put("BLANKENBERGE", "31004");
        NIS_CACHE.put("BLÉGNY", "62119");
        NIS_CACHE.put("BOCHOLT", "72003");
        NIS_CACHE.put("BOECHOUT", "11004");
        NIS_CACHE.put("BONHEIDEN", "12005");
        NIS_CACHE.put("BOOM", "11005");
        NIS_CACHE.put("BOORTMEERBEEK", "24014");
        NIS_CACHE.put("BORGLOON", "73009");
        NIS_CACHE.put("BORGWORM", "64074");
        NIS_CACHE.put("BORNEM", "12007");
        NIS_CACHE.put("BORSBEEK", "11007");
        NIS_CACHE.put("BOUILLON", "84010");
        NIS_CACHE.put("BOUSSU", "53014");
        NIS_CACHE.put("BOUTERSEM", "24016");
        NIS_CACHE.put("BRAIVES", "64015");
        NIS_CACHE.put("BRAKEL", "45059");
        NIS_CACHE.put("BRASSCHAAT", "11008");
        NIS_CACHE.put("BRECHT", "11009");
        NIS_CACHE.put("BREDENE", "35002");
        NIS_CACHE.put("BREE", "72004");
        NIS_CACHE.put("BRUGELETTE", "51012");
        NIS_CACHE.put("BRUGGE", "31005");
        NIS_CACHE.put("BRUNEHAUT", "57093");
        NIS_CACHE.put("BRUSSEL", "21004");
        NIS_CACHE.put("BUGGENHOUT", "42004");
        NIS_CACHE.put("BURDINNE", "61010");
        NIS_CACHE.put("BURG-REULAND", "63087");
        NIS_CACHE.put("BÜLLINGEN", "63012");
        NIS_CACHE.put("BÜTGENBACH", "63013");
        NIS_CACHE.put("CELLES", "57018");
        NIS_CACHE.put("CERFONTAINE", "93010");
        NIS_CACHE.put("CHAPELLE-LEZ-HERLAIMONT", "52010");
        NIS_CACHE.put("CHARLEROI", "52011");
        NIS_CACHE.put("CHASTRE", "25117");
        NIS_CACHE.put("CHAUDFONTAINE", "62022");
        NIS_CACHE.put("CHAUMONT-GISTOUX", "25018");
        NIS_CACHE.put("CHIMAY", "56016");
        NIS_CACHE.put("CHINY", "85007");
        NIS_CACHE.put("CHIÈVRES", "51014");
        NIS_CACHE.put("CHÂTELET", "52012");
        NIS_CACHE.put("CINEY", "91030");
        NIS_CACHE.put("CLAVIER", "61012");
        NIS_CACHE.put("COLFONTAINE", "53082");
        NIS_CACHE.put("COMBLAIN-AU-PONT", "62026");
        NIS_CACHE.put("COURCELLES", "52015");
        NIS_CACHE.put("COURT-SAINT-ETIENNE", "25023");
        NIS_CACHE.put("COUVIN", "93014");
        NIS_CACHE.put("CRISNÉE", "64021");
        NIS_CACHE.put("DALHEM", "62027");
        NIS_CACHE.put("DAMME", "31006");
        NIS_CACHE.put("DAVERDISSE", "84016");
        NIS_CACHE.put("DE HAAN", "35029");
        NIS_CACHE.put("DE PANNE", "38008");
        NIS_CACHE.put("DE PINTE", "44012");
        NIS_CACHE.put("DEERLIJK", "34009");
        NIS_CACHE.put("DEINZE", "44011");
        NIS_CACHE.put("DENDERLEEUW", "41011");
        NIS_CACHE.put("DENDERMONDE", "42006");
        NIS_CACHE.put("DENTERGEM", "37002");
        NIS_CACHE.put("DESSEL", "13006");
        NIS_CACHE.put("DESTELBERGEN", "44013");
        NIS_CACHE.put("DIEPENBEEK", "71011");
        NIS_CACHE.put("DIEST", "24020");
        NIS_CACHE.put("DIKSMUIDE", "32003");
        NIS_CACHE.put("DILBEEK", "23016");
        NIS_CACHE.put("DILSEN-STOKKEM", "72041");
        NIS_CACHE.put("DINANT", "91034");
        NIS_CACHE.put("DISON", "63020");
        NIS_CACHE.put("DOISCHE", "93018");
        NIS_CACHE.put("DONCEEL", "64023");
        NIS_CACHE.put("DOORNIK", "57081");
        NIS_CACHE.put("DOUR", "53020");
        NIS_CACHE.put("DROGENBOS", "23098");
        NIS_CACHE.put("DUFFEL", "12009");
        NIS_CACHE.put("DURBUY", "83012");
        NIS_CACHE.put("ECAUSSINNES", "55050");
        NIS_CACHE.put("EDEGEM", "11013");
        NIS_CACHE.put("EDINGEN", "55010");
        NIS_CACHE.put("EEKLO", "43005");
        NIS_CACHE.put("EGHEZÉE", "92035");
        NIS_CACHE.put("EIGENBRAKEL", "25014");
        NIS_CACHE.put("ELSENE", "21009");
        NIS_CACHE.put("ELZELE", "51017");
        NIS_CACHE.put("ENGIS", "61080");
        NIS_CACHE.put("EREZÉE", "83013");
        NIS_CACHE.put("ERPE-MERE", "41082");
        NIS_CACHE.put("ERQUELINNES", "56022");
        NIS_CACHE.put("ESNEUX", "62032");
        NIS_CACHE.put("ESSEN", "11016");
        NIS_CACHE.put("ESTAIMPUIS", "57027");
        NIS_CACHE.put("ESTINNES", "56085");
        NIS_CACHE.put("ETALLE", "85009");
        NIS_CACHE.put("ETTERBEEK", "21005");
        NIS_CACHE.put("EUPEN", "63023");
        NIS_CACHE.put("EVERE", "21006");
        NIS_CACHE.put("EVERGEM", "44019");
        NIS_CACHE.put("FAIMES", "64076");
        NIS_CACHE.put("FARCIENNES", "52018");
        NIS_CACHE.put("FAUVILLERS", "82009");
        NIS_CACHE.put("FERNELMONT", "92138");
        NIS_CACHE.put("FERRIÈRES", "61019");
        NIS_CACHE.put("FEXHE-LE-HAUT-CLOCHER", "64025");
        NIS_CACHE.put("FLEURUS", "52021");
        NIS_CACHE.put("FLOREFFE", "92045");
        NIS_CACHE.put("FLORENNES", "93022");
        NIS_CACHE.put("FLORENVILLE", "85011");
        NIS_CACHE.put("FLÉMALLE", "62120");
        NIS_CACHE.put("FLÉRON", "62038");
        NIS_CACHE.put("FONTAINE-L'EVÊQUE", "52022");
        NIS_CACHE.put("FOSSES-LA-VILLE", "92048");
        NIS_CACHE.put("FRAMERIES", "53028");
        NIS_CACHE.put("FRASNES-LEZ-ANVAING", "51065");
        NIS_CACHE.put("FROIDCHAPELLE", "56029");
        NIS_CACHE.put("GALMAARDEN", "23023");
        NIS_CACHE.put("GANSHOREN", "21008");
        NIS_CACHE.put("GAVERE", "44020");
        NIS_CACHE.put("GEDINNE", "91054");
        NIS_CACHE.put("GEEL", "13008");
        NIS_CACHE.put("GEER", "64029");
        NIS_CACHE.put("GEETBETS", "24028");
        NIS_CACHE.put("GELDENAKEN", "25048");
        NIS_CACHE.put("GEMBLOUX", "92142");
        NIS_CACHE.put("GENEPIEN", "25031");
        NIS_CACHE.put("GENK", "71016");
        NIS_CACHE.put("GENT", "44021");
        NIS_CACHE.put("GERAARDSBERGEN", "41018");
        NIS_CACHE.put("GERPINNES", "52025");
        NIS_CACHE.put("GESVES", "92054");
        NIS_CACHE.put("GINGELOM", "71017");
        NIS_CACHE.put("GISTEL", "35005");
        NIS_CACHE.put("GLABBEEK", "24137");
        NIS_CACHE.put("GOOIK", "23024");
        NIS_CACHE.put("GOUVY", "82037");
        NIS_CACHE.put("GRAVEN", "25037");
        NIS_CACHE.put("GRIMBERGEN", "23025");
        NIS_CACHE.put("GROBBENDONK", "13010");
        NIS_CACHE.put("GRÂCE-HOLLOGNE", "62118");
        NIS_CACHE.put("HET RIJK", "1000");
        NIS_CACHE.put("HAACHT", "24033");
        NIS_CACHE.put("HAALTERT", "41024");
        NIS_CACHE.put("HABAY", "85046");
        NIS_CACHE.put("HALEN", "71020");
        NIS_CACHE.put("HALLE", "23027");
        NIS_CACHE.put("HAM", "71069");
        NIS_CACHE.put("HAM-SUR-HEURE-NALINNES", "56086");
        NIS_CACHE.put("HAMME", "42008");
        NIS_CACHE.put("HAMOIR", "61024");
        NIS_CACHE.put("HAMOIS", "91059");
        NIS_CACHE.put("HAMONT-ACHEL", "72037");
        NIS_CACHE.put("HANNUIT", "64034");
        NIS_CACHE.put("HARELBEKE", "34013");
        NIS_CACHE.put("HASSELT", "71022");
        NIS_CACHE.put("HASTIÈRE", "91142");
        NIS_CACHE.put("HAVELANGE", "91064");
        NIS_CACHE.put("HECHTEL-EKSEL", "72038");
        NIS_CACHE.put("HEERS", "73022");
        NIS_CACHE.put("HEIST-OP-DEN-BERG", "12014");
        NIS_CACHE.put("HEMIKSEM", "11018");
        NIS_CACHE.put("HENSIES", "53039");
        NIS_CACHE.put("HERBEUMONT", "84029");
        NIS_CACHE.put("HERENT", "24038");
        NIS_CACHE.put("HERENTALS", "13011");
        NIS_CACHE.put("HERENTHOUT", "13012");
        NIS_CACHE.put("HERK-DE-STAD", "71024");
        NIS_CACHE.put("HERNE", "23032");
        NIS_CACHE.put("HERSELT", "13013");
        NIS_CACHE.put("HERSTAL", "62051");
        NIS_CACHE.put("HERSTAPPE", "73028");
        NIS_CACHE.put("HERVE", "63035");
        NIS_CACHE.put("HERZELE", "41027");
        NIS_CACHE.put("HEUSDEN-ZOLDER", "71070");
        NIS_CACHE.put("HEUVELLAND", "33039");
        NIS_CACHE.put("HOEGAARDEN", "24041");
        NIS_CACHE.put("HOEI", "61031");
        NIS_CACHE.put("HOEILAART", "23033");
        NIS_CACHE.put("HOESELT", "73032");
        NIS_CACHE.put("HOLSBEEK", "24043");
        NIS_CACHE.put("HONNELLES", "53083");
        NIS_CACHE.put("HOOGLEDE", "36006");
        NIS_CACHE.put("HOOGSTRATEN", "13014");
        NIS_CACHE.put("HOREBEKE", "45062");
        NIS_CACHE.put("HOTTON", "83028");
        NIS_CACHE.put("HOUFFALIZE", "82014");
        NIS_CACHE.put("HOUTHALEN-HELCHTEREN", "72039");
        NIS_CACHE.put("HOUTHULST", "32006");
        NIS_CACHE.put("HOUYET", "91072");
        NIS_CACHE.put("HOVE", "11021");
        NIS_CACHE.put("HULDENBERG", "24045");
        NIS_CACHE.put("HULSHOUT", "13016");
        NIS_CACHE.put("HÉLÉCINE", "25118");
        NIS_CACHE.put("HÉRON", "61028");
        NIS_CACHE.put("ICHTEGEM", "35006");
        NIS_CACHE.put("IEPER", "33011");
        NIS_CACHE.put("INCOURT", "25043");
        NIS_CACHE.put("INGELMUNSTER", "36007");
        NIS_CACHE.put("ITTER", "25044");
        NIS_CACHE.put("IZEGEM", "36008");
        NIS_CACHE.put("JABBEKE", "31012");
        NIS_CACHE.put("JALHAY", "63038");
        NIS_CACHE.put("JEMEPPE-SUR-SAMBRE", "92140");
        NIS_CACHE.put("JETTE", "21010");
        NIS_CACHE.put("JUPRELLE", "62060");
        NIS_CACHE.put("JURBEKE", "53044");
        NIS_CACHE.put("KALMTHOUT", "11022");
        NIS_CACHE.put("KAMPENHOUT", "23038");
        NIS_CACHE.put("KAPELLE-OP-DEN-BOS", "23039");
        NIS_CACHE.put("KAPELLEN", "11023");
        NIS_CACHE.put("KAPRIJKE", "43007");
        NIS_CACHE.put("KASTEELBRAKEL", "25015");
        NIS_CACHE.put("KASTERLEE", "13017");
        NIS_CACHE.put("KEERBERGEN", "24048");
        NIS_CACHE.put("KELMIS", "63040");
        NIS_CACHE.put("KINROOI", "72018");
        NIS_CACHE.put("KLUISBERGEN", "45060");
        NIS_CACHE.put("KNESSELARE", "44029");
        NIS_CACHE.put("KNOKKE-HEIST", "31043");
        NIS_CACHE.put("KOEKELARE", "32010");
        NIS_CACHE.put("KOEKELBERG", "21011");
        NIS_CACHE.put("KOKSIJDE", "38014");
        NIS_CACHE.put("KOMEN-WAASTEN", "54010");
        NIS_CACHE.put("KONTICH", "11024");
        NIS_CACHE.put("KORTEMARK", "32011");
        NIS_CACHE.put("KORTENAKEN", "24054");
        NIS_CACHE.put("KORTENBERG", "24055");
        NIS_CACHE.put("KORTESSEM", "73040");
        NIS_CACHE.put("KORTRIJK", "34022");
        NIS_CACHE.put("KRAAINEM", "23099");
        NIS_CACHE.put("KRUIBEKE", "46013");
        NIS_CACHE.put("KRUISHOUTEM", "45017");
        NIS_CACHE.put("KUURNE", "34023");
        NIS_CACHE.put("LA BRUYÈRE", "92141");
        NIS_CACHE.put("LA LOUVIÈRE", "55022");
        NIS_CACHE.put("LA ROCHE-EN-ARDENNE", "83031");
        NIS_CACHE.put("LAAKDAL", "13053");
        NIS_CACHE.put("LAARNE", "42010");
        NIS_CACHE.put("LANAKEN", "73042");
        NIS_CACHE.put("LANDEN", "24059");
        NIS_CACHE.put("LANGEMARK-POELKAPELLE", "33040");
        NIS_CACHE.put("LASNE", "25119");
        NIS_CACHE.put("LE ROEULX", "55035");
        NIS_CACHE.put("LEBBEKE", "42011");
        NIS_CACHE.put("LEDE", "41034");
        NIS_CACHE.put("LEDEGEM", "36010");
        NIS_CACHE.put("LENDELEDE", "34025");
        NIS_CACHE.put("LENNIK", "23104");
        NIS_CACHE.put("LENS", "53046");
        NIS_CACHE.put("LEOPOLDSBURG", "71034");
        NIS_CACHE.put("LES BONS VILLERS", "52075");
        NIS_CACHE.put("LESSEN", "55023");
        NIS_CACHE.put("LEUVEN", "24062");
        NIS_CACHE.put("LEUZE-EN-HAINAUT", "57094");
        NIS_CACHE.put("LIBIN", "84035");
        NIS_CACHE.put("LIBRAMONT-CHEVIGNY", "84077");
        NIS_CACHE.put("LICHTERVELDE", "36011");
        NIS_CACHE.put("LIEDEKERKE", "23044");
        NIS_CACHE.put("LIER", "12021");
        NIS_CACHE.put("LIERDE", "45063");
        NIS_CACHE.put("LIERNEUX", "63045");
        NIS_CACHE.put("LIJSEM", "64047");
        NIS_CACHE.put("LILLE", "13019");
        NIS_CACHE.put("LIMBURG", "63046");
        NIS_CACHE.put("LINKEBEEK", "23100");
        NIS_CACHE.put("LINT", "11025");
        NIS_CACHE.put("LINTER", "24133");
        NIS_CACHE.put("LO-RENINGE", "32030");
        NIS_CACHE.put("LOBBES", "56044");
        NIS_CACHE.put("LOCHRISTI", "44034");
        NIS_CACHE.put("LOKEREN", "46014");
        NIS_CACHE.put("LOMMEL", "72020");
        NIS_CACHE.put("LONDERZEEL", "23045");
        NIS_CACHE.put("LONTZEN", "63048");
        NIS_CACHE.put("LOVENDEGEM", "44036");
        NIS_CACHE.put("LUBBEEK", "24066");
        NIS_CACHE.put("LUIK", "62063");
        NIS_CACHE.put("LUMMEN", "71037");
        NIS_CACHE.put("LÉGLISE", "84033");
        NIS_CACHE.put("MAARKEDAL", "45064");
        NIS_CACHE.put("MAASEIK", "72021");
        NIS_CACHE.put("MAASMECHELEN", "73107");
        NIS_CACHE.put("MACHELEN", "23047");
        NIS_CACHE.put("MALDEGEM", "43010");
        NIS_CACHE.put("MALLE", "11057");
        NIS_CACHE.put("MALMEDY", "63049");
        NIS_CACHE.put("MANAGE", "52043");
        NIS_CACHE.put("MANHAY", "83055");
        NIS_CACHE.put("MARCHE-EN-FAMENNE", "83034");
        NIS_CACHE.put("MARCHIN", "61039");
        NIS_CACHE.put("MARTELANGE", "81013");
        NIS_CACHE.put("MECHELEN", "12025");
        NIS_CACHE.put("MEERHOUT", "13021");
        NIS_CACHE.put("MEEUWEN-GRUITRODE", "72040");
        NIS_CACHE.put("MEISE", "23050");
        NIS_CACHE.put("MEIX-DEVANT-VIRTON", "85024");
        NIS_CACHE.put("MELLE", "44040");
        NIS_CACHE.put("MENEN", "34027");
        NIS_CACHE.put("MERBES-LE-CHÂTEAU", "56049");
        NIS_CACHE.put("MERCHTEM", "23052");
        NIS_CACHE.put("MERELBEKE", "44043");
        NIS_CACHE.put("MERKSPLAS", "13023");
        NIS_CACHE.put("MESEN", "33016");
        NIS_CACHE.put("MESSANCY", "81015");
        NIS_CACHE.put("METTET", "92087");
        NIS_CACHE.put("MEULEBEKE", "37007");
        NIS_CACHE.put("MIDDELKERKE", "35011");
        NIS_CACHE.put("MODAVE", "61041");
        NIS_CACHE.put("MOERBEKE", "44045");
        NIS_CACHE.put("MOESKROEN", "54007");
        NIS_CACHE.put("MOL", "13025");
        NIS_CACHE.put("MOMIGNIES", "56051");
        NIS_CACHE.put("MONT-SAINT-GUIBERT", "25068");
        NIS_CACHE.put("MONT-DE-L'ENCLUS", "57095");
        NIS_CACHE.put("MONTIGNY-LE-TILLEUL", "52048");
        NIS_CACHE.put("MOORSLEDE", "36012");
        NIS_CACHE.put("MORLANWELZ", "56087");
        NIS_CACHE.put("MORTSEL", "11029");
        NIS_CACHE.put("MUSSON", "85026");
        NIS_CACHE.put("NAMEN", "92094");
        NIS_CACHE.put("NANDRIN", "61043");
        NIS_CACHE.put("NASSOGNE", "83040");
        NIS_CACHE.put("NAZARETH", "44048");
        NIS_CACHE.put("NEERPELT", "72025");
        NIS_CACHE.put("NEUFCHÂTEAU", "84043");
        NIS_CACHE.put("NEUPRÉ", "62121");
        NIS_CACHE.put("NEVELE", "44049");
        NIS_CACHE.put("NIEL", "11030");
        NIS_CACHE.put("NIEUWERKERKEN", "71045");
        NIS_CACHE.put("NIEUWPOORT", "38016");
        NIS_CACHE.put("NIJLEN", "12026");
        NIS_CACHE.put("NIJVEL", "25072");
        NIS_CACHE.put("NINOVE", "41048");
        NIS_CACHE.put("OERLE", "64056");
        NIS_CACHE.put("OHEY", "92097");
        NIS_CACHE.put("OLEN", "13029");
        NIS_CACHE.put("OLNE", "63057");
        NIS_CACHE.put("ONHAYE", "91103");
        NIS_CACHE.put("OOSTENDE", "35013");
        NIS_CACHE.put("OOSTERZELE", "44052");
        NIS_CACHE.put("OOSTKAMP", "31022");
        NIS_CACHE.put("OOSTROZEBEKE", "37010");
        NIS_CACHE.put("OPGLABBEEK", "71047");
        NIS_CACHE.put("OPWIJK", "23060");
        NIS_CACHE.put("OPZULLIK", "55039");
        NIS_CACHE.put("ORP-JAUCHE", "25120");
        NIS_CACHE.put("OTTIGNIES-LOUVAIN-LA-NEUVE", "25121");
        NIS_CACHE.put("OUD-HEVERLEE", "24086");
        NIS_CACHE.put("OUD-TURNHOUT", "13031");
        NIS_CACHE.put("OUDENAARDE", "45035");
        NIS_CACHE.put("OUDENBURG", "35014");
        NIS_CACHE.put("OUDERGEM", "21002");
        NIS_CACHE.put("OUFFET", "61048");
        NIS_CACHE.put("OUPEYE", "62079");
        NIS_CACHE.put("OVERIJSE", "23062");
        NIS_CACHE.put("OVERPELT", "72029");
        NIS_CACHE.put("PALISEUL", "84050");
        NIS_CACHE.put("PECQ", "57062");
        NIS_CACHE.put("PEER", "72030");
        NIS_CACHE.put("PEPINGEN", "23064");
        NIS_CACHE.put("PEPINSTER", "63058");
        NIS_CACHE.put("PERWIJS", "25084");
        NIS_CACHE.put("PHILIPPEVILLE", "93056");
        NIS_CACHE.put("PITTEM", "37011");
        NIS_CACHE.put("PLOMBIÈRES", "63088");
        NIS_CACHE.put("PONT-À-CELLES", "52055");
        NIS_CACHE.put("POPERINGE", "33021");
        NIS_CACHE.put("PROFONDEVILLE", "92101");
        NIS_CACHE.put("PROVINCIE ANTWERPEN", "10000");
        NIS_CACHE.put("PROVINCIE HENEGOUWEN", "50000");
        NIS_CACHE.put("PROVINCIE LIMBURG", "70000");
        NIS_CACHE.put("PROVINCIE LUIK", "60000");
        NIS_CACHE.put("PROVINCIE LUXEMBURG", "80000");
        NIS_CACHE.put("PROVINCIE NAMEN", "90000");
        NIS_CACHE.put("PROVINCIE OOST-VLAANDEREN", "40000");
        NIS_CACHE.put("PROVINCIE VLAAMS-BRABANT", "20001");
        NIS_CACHE.put("PROVINCIE WAALS-BRABANT", "20002");
        NIS_CACHE.put("PROVINCIE WEST-VLAANDEREN", "30000");
        NIS_CACHE.put("PUTTE", "12029");
        NIS_CACHE.put("PUURS", "12030");
        NIS_CACHE.put("PÉRUWELZ", "57064");
        NIS_CACHE.put("QUAREGNON", "53065");
        NIS_CACHE.put("QUIÉVRAIN", "53068");
        NIS_CACHE.put("QUÉVY", "53084");
        NIS_CACHE.put("RAEREN", "63061");
        NIS_CACHE.put("RAMILLIES", "25122");
        NIS_CACHE.put("RANST", "11035");
        NIS_CACHE.put("RAVELS", "13035");
        NIS_CACHE.put("REBECQ", "25123");
        NIS_CACHE.put("REMICOURT", "64063");
        NIS_CACHE.put("RENDEUX", "83044");
        NIS_CACHE.put("RETIE", "13036");
        NIS_CACHE.put("RIEMST", "73066");
        NIS_CACHE.put("RIJKEVORSEL", "13037");
        NIS_CACHE.put("RIXENSART", "25091");
        NIS_CACHE.put("ROCHEFORT", "91114");
        NIS_CACHE.put("ROESELARE", "36015");
        NIS_CACHE.put("RONSE", "45041");
        NIS_CACHE.put("ROOSDAAL", "23097");
        NIS_CACHE.put("ROTSELAAR", "24094");
        NIS_CACHE.put("ROUVROY", "85047");
        NIS_CACHE.put("RUISELEDE", "37012");
        NIS_CACHE.put("RUMES", "57072");
        NIS_CACHE.put("RUMST", "11037");
        NIS_CACHE.put("SAINT-GEORGES-SUR-MEUSE", "64065");
        NIS_CACHE.put("SAINT-GHISLAIN", "53070");
        NIS_CACHE.put("SAINT-HUBERT", "84059");
        NIS_CACHE.put("SAINT-LÉGER", "85034");
        NIS_CACHE.put("SAINT-NICOLAS", "62093");
        NIS_CACHE.put("SAINTE-ODE", "82038");
        NIS_CACHE.put("SAMBREVILLE", "92137");
        NIS_CACHE.put("SANKT VITH", "63067");
        NIS_CACHE.put("SCHAARBEEK", "21015");
        NIS_CACHE.put("SCHELLE", "11038");
        NIS_CACHE.put("SCHERPENHEUVEL-ZICHEM", "24134");
        NIS_CACHE.put("SCHILDE", "11039");
        NIS_CACHE.put("SCHOTEN", "11040");
        NIS_CACHE.put("SENEFFE", "52063");
        NIS_CACHE.put("SERAING", "62096");
        NIS_CACHE.put("SINT-AGATHA-BERCHEM", "21003");
        NIS_CACHE.put("SINT-AMANDS", "12034");
        NIS_CACHE.put("SINT-GENESIUS-RODE", "23101");
        NIS_CACHE.put("SINT-GILLIS", "21013");
        NIS_CACHE.put("SINT-GILLIS-WAAS", "46020");
        NIS_CACHE.put("SINT-JANS-MOLENBEEK", "21012");
        NIS_CACHE.put("SINT-JOOST-TEN-NODE", "21014");
        NIS_CACHE.put("SINT-KATELIJNE-WAVER", "12035");
        NIS_CACHE.put("SINT-LAMBRECHTS-WOLUWE", "21018");
        NIS_CACHE.put("SINT-LAUREINS", "43014");
        NIS_CACHE.put("SINT-LIEVENS-HOUTEM", "41063");
        NIS_CACHE.put("SINT-MARTENS-LATEM", "44064");
        NIS_CACHE.put("SINT-NIKLAAS", "46021");
        NIS_CACHE.put("SINT-PIETERS-LEEUW", "23077");
        NIS_CACHE.put("SINT-PIETERS-WOLUWE", "21019");
        NIS_CACHE.put("SINT-TRUIDEN", "71053");
        NIS_CACHE.put("SIVRY-RANCE", "56088");
        NIS_CACHE.put("SOMBREFFE", "92114");
        NIS_CACHE.put("SOMME-LEUZE", "91120");
        NIS_CACHE.put("SOUMAGNE", "62099");
        NIS_CACHE.put("SPA", "63072");
        NIS_CACHE.put("SPIERE-HELKIJN", "34043");
        NIS_CACHE.put("SPRIMONT", "62100");
        NIS_CACHE.put("STABROEK", "11044");
        NIS_CACHE.put("STADEN", "36019");
        NIS_CACHE.put("STAVELOT", "63073");
        NIS_CACHE.put("STEENOKKERZEEL", "23081");
        NIS_CACHE.put("STEKENE", "46024");
        NIS_CACHE.put("STOUMONT", "63075");
        NIS_CACHE.put("TELLIN", "84068");
        NIS_CACHE.put("TEMSE", "46025");
        NIS_CACHE.put("TENNEVILLE", "83049");
        NIS_CACHE.put("TERHULPEN", "25050");
        NIS_CACHE.put("TERNAT", "23086");
        NIS_CACHE.put("TERVUREN", "24104");
        NIS_CACHE.put("TESSENDERLO", "71057");
        NIS_CACHE.put("THEUX", "63076");
        NIS_CACHE.put("THIMISTER-CLERMONT", "63089");
        NIS_CACHE.put("THUIN", "56078");
        NIS_CACHE.put("TIELT", "37015");
        NIS_CACHE.put("TIELT-WINGE", "24135");
        NIS_CACHE.put("TIENEN", "24107");
        NIS_CACHE.put("TINLOT", "61081");
        NIS_CACHE.put("TINTIGNY", "85039");
        NIS_CACHE.put("TONGEREN", "73083");
        NIS_CACHE.put("TORHOUT", "31033");
        NIS_CACHE.put("TREMELO", "24109");
        NIS_CACHE.put("TROIS-PONTS", "63086");
        NIS_CACHE.put("TROOZ", "62122");
        NIS_CACHE.put("TUBEKE", "25105");
        NIS_CACHE.put("TURNHOUT", "13040");
        NIS_CACHE.put("UKKEL", "21016");
        NIS_CACHE.put("VLAAMS GEWEST", "2000");
        NIS_CACHE.put("VAUX-SUR-SÛRE", "82036");
        NIS_CACHE.put("VERLAINE", "61063");
        NIS_CACHE.put("VERVIERS", "63079");
        NIS_CACHE.put("VEURNE", "38025");
        NIS_CACHE.put("VIELSALM", "82032");
        NIS_CACHE.put("VILLERS-LA-VILLE", "25107");
        NIS_CACHE.put("VILLERS-LE-BOUILLET", "61068");
        NIS_CACHE.put("VILVOORDE", "23088");
        NIS_CACHE.put("VIROINVAL", "93090");
        NIS_CACHE.put("VIRTON", "85045");
        NIS_CACHE.put("VLETEREN", "33041");
        NIS_CACHE.put("VLOESBERG", "51019");
        NIS_CACHE.put("VOEREN", "73109");
        NIS_CACHE.put("VORSELAAR", "13044");
        NIS_CACHE.put("VORST", "21007");
        NIS_CACHE.put("VOSSELAAR", "13046");
        NIS_CACHE.put("VRESSE-SUR-SEMOIS", "91143");
        NIS_CACHE.put("WAALS GEWEST", "3000");
        NIS_CACHE.put("WAARSCHOOT", "44072");
        NIS_CACHE.put("WAASMUNSTER", "42023");
        NIS_CACHE.put("WACHTEBEKE", "44073");
        NIS_CACHE.put("WALCOURT", "93088");
        NIS_CACHE.put("WALHAIN", "25124");
        NIS_CACHE.put("WANZE", "61072");
        NIS_CACHE.put("WAREGEM", "34040");
        NIS_CACHE.put("WASSEIGES", "64075");
        NIS_CACHE.put("WATERLOO", "25110");
        NIS_CACHE.put("WATERMAAL-BOSVOORDE", "21017");
        NIS_CACHE.put("WAVER", "25112");
        NIS_CACHE.put("WEISMES", "63080");
        NIS_CACHE.put("WELKENRAEDT", "63084");
        NIS_CACHE.put("WELLEN", "73098");
        NIS_CACHE.put("WELLIN", "84075");
        NIS_CACHE.put("WEMMEL", "23102");
        NIS_CACHE.put("WERVIK", "33029");
        NIS_CACHE.put("WESTERLO", "13049");
        NIS_CACHE.put("WETTEREN", "42025");
        NIS_CACHE.put("WEVELGEM", "34041");
        NIS_CACHE.put("WEZEMBEEK-OPPEM", "23103");
        NIS_CACHE.put("WEZET", "62108");
        NIS_CACHE.put("WICHELEN", "42026");
        NIS_CACHE.put("WIELSBEKE", "37017");
        NIS_CACHE.put("WIJNEGEM", "11050");
        NIS_CACHE.put("WILLEBROEK", "12040");
        NIS_CACHE.put("WINGENE", "37018");
        NIS_CACHE.put("WOMMELGEM", "11052");
        NIS_CACHE.put("WORTEGEM-PETEGEM", "45061");
        NIS_CACHE.put("WUUSTWEZEL", "11053");
        NIS_CACHE.put("YVOIR", "91141");
        NIS_CACHE.put("ZANDHOVEN", "11054");
        NIS_CACHE.put("ZAVENTEM", "23094");
        NIS_CACHE.put("ZEDELGEM", "31040");
        NIS_CACHE.put("ZELE", "42028");
        NIS_CACHE.put("ZELZATE", "43018");
        NIS_CACHE.put("ZEMST", "23096");
        NIS_CACHE.put("ZINGEM", "45057");
        NIS_CACHE.put("ZINNIK", "55040");
        NIS_CACHE.put("ZOERSEL", "11055");
        NIS_CACHE.put("ZOMERGEM", "44080");
        NIS_CACHE.put("ZONHOVEN", "71066");
        NIS_CACHE.put("ZONNEBEKE", "33037");
        NIS_CACHE.put("ZOTTEGEM", "41081");
        NIS_CACHE.put("ZOUTLEEUW", "24130");
        NIS_CACHE.put("ZUIENKERKE", "31042");
        NIS_CACHE.put("ZULTE", "44081");
        NIS_CACHE.put("ZUTENDAAL", "71067");
        NIS_CACHE.put("ZWALM", "45065");
        NIS_CACHE.put("ZWEVEGEM", "34042");
        NIS_CACHE.put("ZWIJNDRECHT", "11056");
    }

    @Override
    public Optional<Municipality> findMainMuncipality(String mainMunicipality) {
        Objects.requireNonNull(mainMunicipality, "mainMunicipality cannot be null");

        final String upperCased = mainMunicipality.toUpperCase();
        final String nisCode = NIS_CACHE.get(upperCased);
        if (nisCode == null) {
            return Optional.empty();
        } else {
            return Optional.of(new Municipality(nisCode, null /** TODO krcl **/, mainMunicipality));
        }
    }

    @Override
    public List<Municipality> getAllMainMunicipalities() {
        return NIS_CACHE.entrySet().stream()
                .map(entry -> new Municipality(entry.getKey(), null /**  **/, entry.getValue()))
                .collect(Collectors.toList());
    }
}
