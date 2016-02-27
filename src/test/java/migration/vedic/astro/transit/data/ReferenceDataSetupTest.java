package migration.vedic.astro.transit.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.ReferenceData;
import com.vedic.astro.dto.ReferenceDataDTO;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.NakDashaSystem;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Yoga;
import com.vedic.astro.enums.ZodDashaSystem;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.repository.ReferenceDataRepository;

import test.vedic.astro.data.BaseUtilTest;

public class ReferenceDataSetupTest extends BaseUtilTest {

	@Autowired
	@Qualifier("referenceDataRepository")
	private ReferenceDataRepository referenceDataRepository;

	// @Test
	public void setupPlanetsData() {
		ReferenceData referenceData = new ReferenceData();
		referenceData.setName("planets");

		List<ReferenceDataDTO> referenceDataList = new ArrayList<ReferenceDataDTO>();
		for (Planet planet : Planet.values()) {

			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			referenceDataDTO.setCode(planet.name());
			referenceDataDTO.setName(planet.getEnglishName());

			referenceDataList.add(referenceDataDTO);
		}
		referenceData.setData(referenceDataList);
		referenceDataRepository.save(referenceData);
	}

	// @Test
	public void setupHouseData() {
		ReferenceData referenceData = new ReferenceData();
		referenceData.setName("houses");

		List<ReferenceDataDTO> referenceDataList = new ArrayList<ReferenceDataDTO>();
		for (House house : House.values()) {

			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			referenceDataDTO.setCode(house.name());
			referenceDataDTO.setName(house.name());

			referenceDataList.add(referenceDataDTO);
		}
		referenceData.setData(referenceDataList);
		referenceDataRepository.save(referenceData);
	}

	// @Test
	public void setupNakData() {
		ReferenceData referenceData = new ReferenceData();
		referenceData.setName("naks");

		List<ReferenceDataDTO> referenceDataList = new ArrayList<ReferenceDataDTO>();
		for (Nakshatra nak : Nakshatra.values()) {

			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			referenceDataDTO.setCode(nak.name());
			referenceDataDTO.setName(nak.name());

			referenceDataList.add(referenceDataDTO);
		}
		referenceData.setData(referenceDataList);
		referenceDataRepository.save(referenceData);
	}

	// @Test
	public void setupYogaData() {
		ReferenceData referenceData = new ReferenceData();
		referenceData.setName("yogas");

		List<ReferenceDataDTO> referenceDataList = new ArrayList<ReferenceDataDTO>();
		for (Yoga yoga : Yoga.values()) {

			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			referenceDataDTO.setCode(yoga.name());
			referenceDataDTO.setName(yoga.name());

			referenceDataList.add(referenceDataDTO);
		}
		referenceData.setData(referenceDataList);
		referenceDataRepository.save(referenceData);
	}

	// @Test
	public void setupVargaData() {
		ReferenceData referenceData = new ReferenceData();
		referenceData.setName("vargas");

		List<ReferenceDataDTO> referenceDataList = new ArrayList<ReferenceDataDTO>();
		for (BirthChartType birthChartType : BirthChartType.values()) {

			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			referenceDataDTO.setCode(birthChartType.name());
			referenceDataDTO.setName(birthChartType.getName());

			referenceDataList.add(referenceDataDTO);
		}
		referenceData.setData(referenceDataList);
		referenceDataRepository.save(referenceData);
	}

	//@Test
	public void setupZodiacData() {
		ReferenceData referenceData = new ReferenceData();
		referenceData.setName("zodiacs");

		List<ReferenceDataDTO> referenceDataList = new ArrayList<ReferenceDataDTO>();
		for (Zodiac zodiac : Zodiac.values()) {

			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			referenceDataDTO.setCode(zodiac.name());
			referenceDataDTO.setName(zodiac.getEnglishName());

			referenceDataList.add(referenceDataDTO);
		}
		referenceData.setData(referenceDataList);
		referenceDataRepository.save(referenceData);
	}
	
	//@Test
	public void setupComponentData() {
		ReferenceData referenceData = new ReferenceData();
		referenceData.setName("analysis_sources");

		List<ReferenceDataDTO> referenceDataList = new ArrayList<ReferenceDataDTO>();
		for (AnalysisGroup analysisGroup : AnalysisGroup.values()) {

			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			referenceDataDTO.setCode(analysisGroup.name());
			referenceDataDTO.setName(analysisGroup.getDesc());

			referenceDataList.add(referenceDataDTO);
		}
		referenceData.setData(referenceDataList);
		referenceDataRepository.save(referenceData);
	}
	
	//@Test
	public void setupNakDashas() {
		ReferenceData referenceData = new ReferenceData();
		referenceData.setName("nak_dashas");

		List<ReferenceDataDTO> referenceDataList = new ArrayList<ReferenceDataDTO>();
		for (NakDashaSystem nakdashaSystem : NakDashaSystem.values()) {

			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			referenceDataDTO.setCode(nakdashaSystem.name());
			referenceDataDTO.setName(nakdashaSystem.getDescription());

			referenceDataList.add(referenceDataDTO);
		}
		referenceData.setData(referenceDataList);
		referenceDataRepository.save(referenceData);
	}

	//@Test
	public void setupZodDashas() {
		ReferenceData referenceData = new ReferenceData();
		referenceData.setName("zod_dashas");

		List<ReferenceDataDTO> referenceDataList = new ArrayList<ReferenceDataDTO>();
		for (ZodDashaSystem zodDashaSystem : ZodDashaSystem.values()) {

			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			referenceDataDTO.setCode(zodDashaSystem.name());
			referenceDataDTO.setName(zodDashaSystem.getDescription());

			referenceDataList.add(referenceDataDTO);
		}
		referenceData.setData(referenceDataList);
		referenceDataRepository.save(referenceData);
	}

	@Test
	public void setupTransitPlanetsData() {
		ReferenceData referenceData = new ReferenceData();
		referenceData.setName("transit_planets");

		List<ReferenceDataDTO> referenceDataList = new ArrayList<ReferenceDataDTO>();
		for (Planet planet : Planet.values()) {

			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			referenceDataDTO.setCode(planet.name());
			referenceDataDTO.setName(planet.getEnglishName());

			referenceDataList.add(referenceDataDTO);
		}
		referenceData.setData(referenceDataList);
		referenceDataRepository.save(referenceData);
	}

}
