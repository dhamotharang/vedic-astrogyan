package test.vedic.astro.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vedic.astro.VedicAstroBootApplication;
import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.BirthPlanetaryPositions;
import com.vedic.astro.enums.Gender;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.vo.ChartHouse;
import com.vedic.astro.vo.HousePlanetInput;
import com.vedic.astro.vo.Member;
import com.vedic.astro.vo.PlanetPosition;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VedicAstroBootApplication.class)
public class BaseUtilTest {
	

	
	public Member prepareMember(){
		Member member = new Member();
		
	//	member.setBirthPlanetaryPositions(this.prepareLagnaData());
		member.setFirstName("Shailja");
		member.setLastName("Saxena");
		member.setGender(Gender.Female);
		member.setDob("10/07/1976");
		member.setCityCode("DL");
		member.setCountryCode("IND");
		
		return member;
	}
	
	
/*	public BirthPlanetaryPositions prepareLagnaData(){
		
		BirthPlanetaryPositions birthPlanetaryPositions = new BirthPlanetaryPositions();
		PlanetPosition lagna = new PlanetPosition();
		lagna.setZodiac(Zodiac.GEM);
		birthPlanetaryPositions.setLagna(lagna);
		
		List<PlanetPosition> planetPostions = new ArrayList<PlanetPosition>();
		planetPostions.add(new PlanetPosition(5.13,Zodiac.SAG,Planet.SUN));
		planetPostions.add(new PlanetPosition(6.20,Zodiac.GEM,Planet.MON));
		planetPostions.add(new PlanetPosition(29.36,Zodiac.LIB,Planet.MAR));
		planetPostions.add(new PlanetPosition(15.01,Zodiac.SCO,Planet.MER));
		planetPostions.add(new PlanetPosition(21.40,Zodiac.SAG,Planet.JUP));
		planetPostions.add(new PlanetPosition(8.38,Zodiac.SCO,Planet.VEN));
		planetPostions.add(new PlanetPosition(22.41,Zodiac.TAU,Planet.SAT));
		planetPostions.add(new PlanetPosition(23.18,Zodiac.SAG,Planet.RAH));
		planetPostions.add(new PlanetPosition(23.18,Zodiac.GEM,Planet.KET));
		
		birthPlanetaryPositions.setPlanetPositions(planetPostions);

		return birthPlanetaryPositions;
	}
*/	
	
	public BirthPlanetaryPositions prepareLagnaData(){
		
		BirthPlanetaryPositions birthPlanetaryPositions = new BirthPlanetaryPositions();
		PlanetPosition lagna = new PlanetPosition();
		lagna.setZodiac(Zodiac.VIR);
		birthPlanetaryPositions.setLagna(lagna);
		
		List<PlanetPosition> planetPostions = new ArrayList<PlanetPosition>();
		planetPostions.add(new PlanetPosition(20.18,Zodiac.VIR,Planet.SUN));
		planetPostions.add(new PlanetPosition(7.03,Zodiac.PIS,Planet.MON));
		planetPostions.add(new PlanetPosition(5.12,Zodiac.LIB,Planet.MAR));
		planetPostions.add(new PlanetPosition(2.24,Zodiac.VIR,Planet.MER));
		planetPostions.add(new PlanetPosition(7.10,Zodiac.TAU,Planet.JUP));
		planetPostions.add(new PlanetPosition(19.42,Zodiac.LIB,Planet.VEN));
		planetPostions.add(new PlanetPosition(20.58,Zodiac.CAN,Planet.SAT));
		planetPostions.add(new PlanetPosition(10.01,Zodiac.LIB,Planet.RAH));
		planetPostions.add(new PlanetPosition(10.01,Zodiac.ARE,Planet.KET));
		
		birthPlanetaryPositions.setPlanetPositions(planetPostions);

		return birthPlanetaryPositions;
	}
	
	
	
	
	public BirthChartData prepareData(){
		
		List<ChartHouse> houseInputRequestList = new ArrayList<ChartHouse>();

		ChartHouse h1 = new ChartHouse();
		h1.setZodiac(Zodiac.SCO);
		h1.setHouse(House.H1);

		List<HousePlanetInput> h1Planets = new ArrayList<HousePlanetInput>();

		HousePlanetInput h1p1 = new HousePlanetInput();
		h1p1.setPlanet(Planet.VEN);
		h1p1.setDegrees(10.0);
		
		HousePlanetInput h1p2 = new HousePlanetInput();
		h1p2.setPlanet(Planet.MON);
		h1p2.setDegrees(8.0);

		h1Planets.add(h1p1);
		h1Planets.add(h1p2);

		h1.setPlanets(h1Planets);

		ChartHouse h2 = new ChartHouse();
		h2.setZodiac(Zodiac.SAG);
		h2.setHouse(House.H2);

		List<HousePlanetInput> h2Planets = new ArrayList<HousePlanetInput>();
		h2.setPlanets(h2Planets);

		ChartHouse h3 = new ChartHouse();
		h3.setZodiac(Zodiac.CAP);
		h3.setHouse(House.H3);

		List<HousePlanetInput> h3Planets = new ArrayList<HousePlanetInput>();
		h3.setPlanets(h3Planets);

		ChartHouse h4 = new ChartHouse();
		h4.setZodiac(Zodiac.AQU);
		h4.setHouse(House.H4);

		List<HousePlanetInput> h4Planets = new ArrayList<HousePlanetInput>();
		h4.setPlanets(h4Planets);

		ChartHouse h5 = new ChartHouse();
		h5.setZodiac(Zodiac.PIS);
		h5.setHouse(House.H5);

		List<HousePlanetInput> h5Planets = new ArrayList<HousePlanetInput>();

		HousePlanetInput h5p1 = new HousePlanetInput();
		h5p1.setPlanet(Planet.SAT);
		h5p1.setDegrees(27.0);
		
		HousePlanetInput h5p2 = new HousePlanetInput();
		h5p2.setPlanet(Planet.RAH);
		h5p2.setDegrees(16.0);

		h5Planets.add(h5p1);
		h5Planets.add(h5p2);

		h5.setPlanets(h5Planets);

		ChartHouse h6 = new ChartHouse();
		h6.setZodiac(Zodiac.ARE);
		h6.setHouse(House.H6);

		List<HousePlanetInput> h6Planets = new ArrayList<HousePlanetInput>();
		h6.setPlanets(h6Planets);

		ChartHouse h7 = new ChartHouse();
		h7.setZodiac(Zodiac.TAU);
		h7.setHouse(House.H7);

		List<HousePlanetInput> h7Planets = new ArrayList<HousePlanetInput>();
		h7.setPlanets(h7Planets);

		ChartHouse h8 = new ChartHouse();
		h8.setZodiac(Zodiac.GEM);
		h8.setHouse(House.H8);

		List<HousePlanetInput> h8Planets = new ArrayList<HousePlanetInput>();
		h8.setPlanets(h8Planets);

		ChartHouse h9 = new ChartHouse();
		h9.setZodiac(Zodiac.CAN);
		h9.setHouse(House.H9);

		List<HousePlanetInput> h9Planets = new ArrayList<HousePlanetInput>();
		h9.setPlanets(h9Planets);

		ChartHouse h10 = new ChartHouse();
		h10.setZodiac(Zodiac.LEO);
		h10.setHouse(House.H10);

		List<HousePlanetInput> h10Planets = new ArrayList<HousePlanetInput>();

		HousePlanetInput h10p1 = new HousePlanetInput();
		h10p1.setPlanet(Planet.MAR);
		h10p1.setDegrees(26.0);

		h10Planets.add(h10p1);
		h10.setPlanets(h10Planets);

		ChartHouse h11 = new ChartHouse();
		h11.setZodiac(Zodiac.VIR);
		h11.setHouse(House.H11);

		List<HousePlanetInput> h11Planets = new ArrayList<HousePlanetInput>();

		HousePlanetInput h11p1 = new HousePlanetInput();
		h11p1.setPlanet(Planet.JUP);
		h11p1.setDegrees(2.0);

		HousePlanetInput h11p2 = new HousePlanetInput();
		h11p2.setPlanet(Planet.KET);
		h11p2.setDegrees(16.0);

		HousePlanetInput h11p3 = new HousePlanetInput();
		h11p3.setPlanet(Planet.MER);
		h11p3.setDegrees(22.0);

		h11Planets.add(h11p1);
		h11Planets.add(h11p2);
		h11Planets.add(h11p3);

		h11.setPlanets(h11Planets);

		ChartHouse h12 = new ChartHouse();
		h12.setZodiac(Zodiac.LEO);
		h12.setHouse(House.H12);

		List<HousePlanetInput> h12Planets = new ArrayList<HousePlanetInput>();

		HousePlanetInput h12p1 = new HousePlanetInput();
		h12p1.setPlanet(Planet.SUN);
		h12p1.setDegrees(7.0);

		h12Planets.add(h12p1);
		h12.setPlanets(h12Planets);

		houseInputRequestList.add(h1);
		houseInputRequestList.add(h2);
		houseInputRequestList.add(h3);
		houseInputRequestList.add(h4);
		houseInputRequestList.add(h5);
		houseInputRequestList.add(h6);
		houseInputRequestList.add(h7);
		houseInputRequestList.add(h8);
		houseInputRequestList.add(h9);
		houseInputRequestList.add(h10);
		houseInputRequestList.add(h11);
		houseInputRequestList.add(h12);

		BirthChartData chartData = new BirthChartData();
		chartData.setChartHouses(houseInputRequestList);

		return chartData;
	}
}
