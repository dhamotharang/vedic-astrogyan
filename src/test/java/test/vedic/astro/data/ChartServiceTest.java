package test.vedic.astro.data;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.VargaBirthChartData;
import com.vedic.astro.dto.RashiChartHouseDTO;
import com.vedic.astro.dto.VargaChartHouseDTO;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.repository.BirthChartRepository;
import com.vedic.astro.repository.VargaChartRepository;
import com.vedic.astro.service.ChartService;
import com.vedic.astro.util.DivChartUtil;
import com.vedic.astro.util.RelationshipUtil;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class ChartServiceTest extends BaseUtilTest{

	@Autowired
	@Qualifier("chartService")
	private ChartService chartService;
	
	@Autowired
	@Qualifier("birthChartRepository")
	private BirthChartRepository birthChartRepository;
	
	@Autowired
	@Qualifier("vargaChartRepository")
	private VargaChartRepository vargaChartRepository;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;
	
	@Autowired
	@Qualifier("divChartUtil")
	private DivChartUtil divChartUtil;
	
	//@Test
	public void testBirthChart() throws Exception {
		
		List<RashiChartHouseDTO> chartHouseList = 
				chartService.getRashiChart("56b5029c1b3a745432b941e3");
		
		System.out.println(chartHouseList);
		
	}
	
	//@Test
	public void testGenerateCharts() throws Exception {
		Optional<BirthChartData> birthChartData = 
				birthChartRepository.findByPid("56b5029c1b3a745432b941e3");
		
		VargaBirthChartData d2Chart = divChartUtil.generateDivChart(BirthChartType.D2, birthChartData.get());
		vargaChartRepository.save(d2Chart);
	
		VargaBirthChartData d3Chart = divChartUtil.generateDivChart(BirthChartType.D3, birthChartData.get());
		vargaChartRepository.save(d3Chart);

		VargaBirthChartData d4Chart = divChartUtil.generateDivChart(BirthChartType.D4, birthChartData.get());
		vargaChartRepository.save(d4Chart);

		VargaBirthChartData d5Chart = divChartUtil.generateDivChart(BirthChartType.D5, birthChartData.get());
		vargaChartRepository.save(d5Chart);

		VargaBirthChartData d7Chart = divChartUtil.generateDivChart(BirthChartType.D7, birthChartData.get());
		vargaChartRepository.save(d7Chart);

		VargaBirthChartData d9Chart = divChartUtil.generateDivChart(BirthChartType.D9, birthChartData.get());
		vargaChartRepository.save(d9Chart);

		VargaBirthChartData d10Chart = divChartUtil.generateDivChart(BirthChartType.D10, birthChartData.get());
		vargaChartRepository.save(d10Chart);

		VargaBirthChartData d12Chart = divChartUtil.generateDivChart(BirthChartType.D12, birthChartData.get());
		vargaChartRepository.save(d12Chart);

		VargaBirthChartData d16Chart = divChartUtil.generateDivChart(BirthChartType.D16, birthChartData.get());
		vargaChartRepository.save(d16Chart);

	}
	
	@Test
	public void testGetVargaChart() throws Exception {
		List<VargaChartHouseDTO> vargaChart = chartService.getVargaChart(BirthChartType.D3, "56b5029c1b3a745432b941e3");
		System.out.println(vargaChart);
	}
}