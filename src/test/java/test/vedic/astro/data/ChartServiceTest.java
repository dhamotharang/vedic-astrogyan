package test.vedic.astro.data;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.dto.ChartHouseDTO;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.service.ChartService;

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
	
	@Test
	public void testBirthChart() throws Exception {
		
		List<ChartHouseDTO> chartHouseList = 
				chartService.getChart(BirthChartType.D1, "56b5029c1b3a745432b941e3");
		
		System.out.println(chartHouseList);
		
	}
}