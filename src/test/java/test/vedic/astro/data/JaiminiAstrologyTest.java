package test.vedic.astro.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.enums.CharaKaraka;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.enums.ZodiacType;
import com.vedic.astro.service.PlanetPositionsDataService;
import com.vedic.astro.util.AshtakvargaChartUtil;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.CharaDashaUtil;
import com.vedic.astro.util.CharaKarakaUtil;
import com.vedic.astro.util.DateUtil;
import com.vedic.astro.util.DivChartUtil;
import com.vedic.astro.util.HouseUtil;
import com.vedic.astro.util.NakshatraUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.util.ZodiacUtil;
import com.vedic.astro.vo.AbsolutePlanetaryPositions;
import com.vedic.astro.vo.BirthChartCalcPrep;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class JaiminiAstrologyTest extends BaseUtilTest {

	@Autowired
	@Qualifier("zodiacUtil")
	private ZodiacUtil zodiacUtil;

	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;

	@Autowired
	@Qualifier("nakshatraUtil")
	private NakshatraUtil nakshatraUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;

	@Autowired
	@Qualifier("charaDashaUtil")
	private CharaDashaUtil charaDashaUtil;

	@Autowired
	@Qualifier("divChartUtil")
	private DivChartUtil divChartUtil;

	@Autowired
	@Qualifier("ashtakvargaChartUtil")
	private AshtakvargaChartUtil ashtakvargaChartUtil;

	@Resource
	PlanetPositionsDataService planetPositionsDataService;

	@Autowired
	@Qualifier("charaKarakaUtil")
	private CharaKarakaUtil charaKarakaUtil;

	// @Test
	public void testZodiacAspects() throws Exception {

		System.out.println("Fixed zodiac types =  "
				+ zodiacUtil.getZodiacsOfType(ZodiacType.Fixed));

		System.out.println("Movable zodiac types =  "
				+ zodiacUtil.getZodiacsOfType(ZodiacType.Movable));

		System.out.println("Dual zodiac types =  "
				+ zodiacUtil.getZodiacsOfType(ZodiacType.Dual));

		for (Zodiac zodiac : Zodiac.values()) {
			System.out.println(zodiac + " aspects "
					+ zodiacUtil.getAspectingZodiacs(zodiac));
		}
	}

	// @Test
	public void testKarakasInJaimini() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);
		System.out.println("absolutePlanetaryPositions ="
				+ absolutePlanetaryPositions);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		System.out.println("d1chart = " + d1Chart);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());

		System.out.println("Chara karakas = "
				+ birthChartCalcPrep.getCharakarakaMap());
		System.out.println("Charakaraka for marriage = "
				+ charaKarakaUtil.getCharaKarakaForHouse(House.H7));
		System.out.println("AmatyaCharakaraka  = "
				+ charaKarakaUtil.getImpactedHouses(CharaKaraka.AmatyaKaraka));
	}

	// @Test
	public void testArudhasInJaimini() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);
		System.out.println("absolutePlanetaryPositions ="
				+ absolutePlanetaryPositions);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		System.out.println("d1chart = " + d1Chart);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());

		System.out.println("Arudha = "
				+ relationshipUtil.prepareArudhas(birthChartCalcPrep));
	}

	// @Test
	public void testArgalaInJaimini() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);
		System.out.println("absolutePlanetaryPositions ="
				+ absolutePlanetaryPositions);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		System.out.println("d1chart = " + d1Chart);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());

		for (House house : House.values()) {

			Map<Integer, Set<Planet>> positivePlanets = birthChartUtil
					.getPositiveArgalaPlanets(house, birthChartCalcPrep);
			Map<Integer, Set<Planet>> negativePlanets = birthChartUtil
					.getNegativeArgalaPlanets(house, birthChartCalcPrep);

			System.out.println("house =" + house);
			System.out.println("positive planets = " + positivePlanets);

			System.out.println("negative planets = " + negativePlanets);

		}

		System.out.println("Chara karakas = "
				+ birthChartCalcPrep.getCharakarakaMap());
		System.out.println("Charakaraka for marriage = "
				+ charaKarakaUtil.getCharaKarakaForHouse(House.H7));
		System.out.println("AmatyaCharakaraka  = "
				+ charaKarakaUtil.getImpactedHouses(CharaKaraka.AmatyaKaraka));
	}

	// @Test
	public void testPlanetStrengthsInJaimini() throws Exception {
		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);

		/*
		 * AbsolutePlanetaryPositions absolutePlanetaryPositions =
		 * planetPositionsDataService.getPlanetPositionsData( "04/05/1969",
		 * "15:00:00", 10803);
		 */
		System.out.println("absolutePlanetaryPositions ="
				+ absolutePlanetaryPositions);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		System.out.println("d1chart = " + d1Chart);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());

		System.out.println("Planet strengths based on zodiac = "
				+ birthChartUtil
						.calcPlanetStrengthViaZodiac(birthChartCalcPrep));

		System.out.println("Planet strengths based on karaka = "
				+ birthChartUtil
						.calcPlanetStrengthForKaraka(birthChartCalcPrep));

		System.out.println("Planet strengths based on kendra = "
				+ birthChartUtil
						.calcPlanetStrengthsForKendra(birthChartCalcPrep));

		System.out.println("Planet strengths based on kartari = "
				+ birthChartUtil
						.calcPlanetStrengthForKartari(birthChartCalcPrep));

		System.out.println("Planet strengths based on Adhipati = "
				+ birthChartUtil
						.calcPlanetStrengthForAdhipati(birthChartCalcPrep));

		System.out.println("Planet strengths = "
				+ birthChartUtil
						.calcPlanetStrengthsInJaimini(birthChartCalcPrep));
	}

	// @Test
	public void testZodiacStrengthsInJaimini() throws Exception {
		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("16/08/2004", "09:16:00", 10304);

		/*
		 * AbsolutePlanetaryPositions absolutePlanetaryPositions =
		 * planetPositionsDataService.getPlanetPositionsData( "04/05/1969",
		 * "15:00:00", 10803);
		 */
		System.out.println("absolutePlanetaryPositions ="
				+ absolutePlanetaryPositions);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		System.out.println("d1chart = " + d1Chart);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());

		System.out.println("Zodiac strengths based on zodiac type = "
				+ zodiacUtil.calcZodiacStrengthsBasedOnType());

		System.out.println("Zodiac strengths based on karaka = "
				+ birthChartUtil
						.calcZodiacStrengthsOnKarakas(birthChartCalcPrep));

		System.out.println("Zodiac strengths based on planet count = "
				+ birthChartUtil
						.calcZodiacStrengthsOnPlanetCount(birthChartCalcPrep));

		System.out.println("Zodiac strengths based on aspect = "
				+ birthChartUtil
						.calcZodiacStrengthsOnAspect(birthChartCalcPrep));

		System.out.println("Zodiac strengths based on lord = "
				+ birthChartUtil
						.calcZodiacStrengthsOnLordOfHouse(birthChartCalcPrep));

		Map<Zodiac, Double> zodiacStrengths = birthChartUtil
				.calcZodiacStrengthsInJaimini(birthChartCalcPrep);
		System.out.println("Overall zodiac strengths = " + zodiacStrengths);

		Map<House, Double> houseStrengths = new HashMap<House, Double>();

		for (Zodiac zodiac : Zodiac.values()) {
			House house = birthChartCalcPrep.getZodiacToHouseMapping().get(
					zodiac);
			houseStrengths.put(house, zodiacStrengths.get(zodiac));
		}

		System.out.println("Overall house strengths = " + houseStrengths);
	}

	// @Test
	public void testCompareFamilyDataInJaimini() throws Exception {
		System.out.println("Sumeer = "
				+ getZodiacScores("20/12/1972", "17:10:00", 10304));

		System.out.println("Shailja = "
				+ getZodiacScores("07/10/1976", "05:30:00", 10304));

		System.out.println("Samarth = "
				+ getZodiacScores("23/12/2002", "17:55:00", 10304));

		System.out.println("Sambhi = "
				+ getZodiacScores("16/08/2004", "09:16:00", 10304));

		System.out.println("Sumeer = "
				+ getPlanetScores("20/12/1972", "17:10:00", 10304));

		System.out.println("Shailja = "
				+ getPlanetScores("07/10/1976", "05:30:00", 10304));

		System.out.println("Samarth = "
				+ getPlanetScores("23/12/2002", "17:55:00", 10304));

		System.out.println("Sambhi = "
				+ getPlanetScores("16/08/2004", "09:16:00", 10304));

	}

	// @Test
	public void testFamousPeopleInJaimini() throws Exception {
		System.out.println("Bill Gates = "
				+ getZodiacScores("28/10/1955", "20:58:00", 21932));

		System.out.println("Bill Gates = "
				+ getPlanetScores("28/10/1955", "20:58:00", 21932));

		System.out.println("Albert Eienstien houses = "
				+ getZodiacScores("14/03/1879", "11:30:00", 4249));

		System.out.println("Albert Eienstien planets = "
				+ getPlanetScores("14/03/1879", "11:30:00", 4249));

		System.out.println("Vivekananda houses = "
				+ getZodiacScores("12/01/1863", "06:20:00", 10436));

		System.out.println("Vivekananda planets = "
				+ getPlanetScores("12/01/1863", "06:20:00", 10436));

		System.out.println("Indira Gandhi houses = "
				+ getZodiacScores("19/11/1917", "23:11:00", 10805));

		System.out.println("Indira Gandhi planets = "
				+ getPlanetScores("19/11/1917", "23:11:00", 10805));
	}

	private Map<Zodiac, Double> getZodiacScores(String dob, String tob,
			Integer locationId) {
		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData(dob, tob, locationId);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());

		Map<Zodiac, Double> zodiacStrengths = birthChartUtil
				.calcNormalizedZodiacStrengthsInJaimini(birthChartCalcPrep);

		return zodiacStrengths;
	}

	private Map<Planet, Double> getPlanetScores(String dob, String tob,
			Integer locationId) {
		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData(dob, tob, locationId);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());

		Map<Planet, Double> planetStrengths = birthChartUtil
				.calcNormalizedPlanetStrengthsInJaimini(birthChartCalcPrep);

		System.out.println("charakas" + birthChartCalcPrep.getCharakarakaMap());

		return planetStrengths;
	}

	// @Test
	public void testArgalasInJaimini() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("07/10/1976", "05:30:00", 10304);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());
		System.out.println("birthChartCalcPrep" + birthChartCalcPrep);
		System.out.println("argalas = "
				+ birthChartUtil.calcHouseArgalas(birthChartCalcPrep));
	}

	@Test
	public void testCharaDashaInJaimini() throws Exception {
		
		  AbsolutePlanetaryPositions absolutePlanetaryPositions =
		  planetPositionsDataService.getPlanetPositionsData(
		  "20/12/1972","17:10:00", 10304);
		  
		  BirthChartData d1Chart = birthChartUtil.generateD1Chart(
		  absolutePlanetaryPositions); BirthChartCalcPrep birthChartCalcPrep =
		  relationshipUtil.preparePlanetsForCalc( d1Chart.getChartHouses());
		  System.out.println("birthChartCalcPrep" + birthChartCalcPrep);
		 
/*		for (Zodiac zodiac : Zodiac.values()) {
			System.out.println("dasha order for " + zodiac + " = " 
					+ charaDashaUtil.generateMahadashaOrder(zodiac));
		}
		
		Map<DashaTimePeriod, Zodiac> dashas = 
				charaDashaUtil.generateDashaInfo("20/12/1972", birthChartCalcPrep);
*/		
		System.out.println("current dasha period = "
				+ charaDashaUtil.getDashaAsOn(DateUtil.toDate("09/04/2013", "dd/MM/yyyy"), "20/12/1972", birthChartCalcPrep));
		System.out.println("Chara karakas = "
				+ birthChartCalcPrep.getCharakarakaMap());

	}

}