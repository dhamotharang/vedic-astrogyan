package test.vedic.astro.data;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.chain.shadbala.IshtaKashtaPhalaEvaluator;
import com.vedic.astro.chain.shadbala.PlanetAspectualStrengthEvaluator;
import com.vedic.astro.chain.shadbala.PlanetDirectionalStrengthEvaluator;
import com.vedic.astro.chain.shadbala.PlanetMotionalStrengthEvaluator;
import com.vedic.astro.chain.shadbala.PlanetNaturalStrengthEvaluator;
import com.vedic.astro.chain.shadbala.PlanetPositionalStrengthEvaluator;
import com.vedic.astro.chain.shadbala.PlanetTemporalStrengthEvaluator;
import com.vedic.astro.constant.Constants;
import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.PersonalBirthInfo;
import com.vedic.astro.domain.SunriseSunsetData;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.DivChartUtil;
import com.vedic.astro.util.HouseUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.vo.AbsolutePlanetaryPositions;
import com.vedic.astro.vo.PlanetAbsoluteLocation;
 
public class ShadbalaTest extends BaseUtilTest{
 
	@Autowired
	HouseUtil houseUtil;
	
	@Autowired
	DivChartUtil divChartUtil;
	
	@Autowired
	PlanetUtil planetUtil;

	@Autowired
	RelationshipUtil relationshipUtil;

	@Autowired
	BirthChartUtil birthChartUtil;

	@Autowired
	PlanetPositionalStrengthEvaluator planetPositionalStrengthEvaluator;

	@Autowired
	PlanetDirectionalStrengthEvaluator planetDirectionalStrengthEvaluator;

	@Autowired
	PlanetMotionalStrengthEvaluator planetMotionalStrengthEvaluator;
	
	@Autowired
	PlanetAspectualStrengthEvaluator planetAspectualStrengthEvaluator;

	@Autowired
	PlanetNaturalStrengthEvaluator planetNaturalStrengthEvaluator;

	@Autowired
	PlanetTemporalStrengthEvaluator planetTemporalStrengthEvaluator;

	@Autowired
	IshtaKashtaPhalaEvaluator ishtaKashtaPhalaEvaluator;


	//@Test
	public void testDivCharts() throws Exception {
		System.out.println("Starting up...      [Ok]");
		AbsolutePlanetaryPositions absolutePlanetaryPositions = new AbsolutePlanetaryPositions();
		absolutePlanetaryPositions.setLagna(86.43);
		
		PlanetAbsoluteLocation sun = new PlanetAbsoluteLocation(Planet.SUN, 146.37);
		PlanetAbsoluteLocation moon = new PlanetAbsoluteLocation(Planet.MON, 309.50);
		PlanetAbsoluteLocation mars = new PlanetAbsoluteLocation(Planet.MAR, 103.18);
		PlanetAbsoluteLocation mercury = new PlanetAbsoluteLocation(Planet.MER, 170.53);
		PlanetAbsoluteLocation jupiter = new PlanetAbsoluteLocation(Planet.JUP, 170.45);
		PlanetAbsoluteLocation venus = new PlanetAbsoluteLocation(Planet.VEN, 186.27);
		PlanetAbsoluteLocation saturn = new PlanetAbsoluteLocation(Planet.SAT, 166.43);
		PlanetAbsoluteLocation rahu = new PlanetAbsoluteLocation(Planet.RAH, 97.17);
		PlanetAbsoluteLocation ketu = new PlanetAbsoluteLocation(Planet.KET, 277.17);
		
		absolutePlanetaryPositions.addAbsolutePlanetPosition(sun);
		absolutePlanetaryPositions.addAbsolutePlanetPosition(moon);
		absolutePlanetaryPositions.addAbsolutePlanetPosition(mars);
		absolutePlanetaryPositions.addAbsolutePlanetPosition(mercury);
		absolutePlanetaryPositions.addAbsolutePlanetPosition(jupiter);
		absolutePlanetaryPositions.addAbsolutePlanetPosition(venus);
		absolutePlanetaryPositions.addAbsolutePlanetPosition(saturn);
		absolutePlanetaryPositions.addAbsolutePlanetPosition(rahu);
		absolutePlanetaryPositions.addAbsolutePlanetPosition(ketu);
		
		BirthChartData d1Chart = birthChartUtil.generateD1Chart(absolutePlanetaryPositions);
		System.out.println("D1 chart = " + birthChartUtil.generateD1Chart(absolutePlanetaryPositions));
//		System.out.println("D2 chart = " + divChartUtil.generateDivChart(BirthChartType.D2, null, d1Chart));
//		System.out.println("D3 chart = " + divChartUtil.generateDivChart(BirthChartType.D3, 
//			BaseEntityRefData.createDivisionalChartRefData().get(BirthChartType.D3), d1Chart));
		Context context = new ContextBase();
		context.put(Constants.BIRTH_CHART_DATA, d1Chart);
		
		PersonalBirthInfo personalBirthInfo = new PersonalBirthInfo();
		personalBirthInfo.setDob("09/13/1981");
		personalBirthInfo.setTob("01:30");
		personalBirthInfo.setSunriseSunsetData(new SunriseSunsetData("18:28", "06:05"));
		context.put(Constants.PERSONAL_BIRTH_INFO, personalBirthInfo);
				
	//	planetPositionalStrengthEvaluator.execute(context);
	//	planetDirectionalStrengthEvaluator.execute(context);
	//	planetMotionalStrengthEvaluator.execute(context);
	//	planetAspectualStrengthEvaluator.execute(context);
	//	planetNaturalStrengthEvaluator.execute(context);
	//	planetTemporalStrengthEvaluator.execute(context);
		
		ishtaKashtaPhalaEvaluator.execute(context);
		
	//	System.out.println("Mean latitude of SUN = " + planetUtil.getMeanLatitude(Planet.SUN, "09/13/1981"));
	//	System.out.println("Mean latitude of JUP = " + planetUtil.getMeanLatitude(Planet.JUP, "09/13/1981"));
	//	System.out.println("Mean latitude of MAR = " + planetUtil.getMeanLatitude(Planet.MAR, "09/13/1981"));
		
		System.out.println("Finised...          [Ok]");
	}
}
