package test.vedic.astro.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.enums.Dasha;
import com.vedic.astro.util.DateUtil;
import com.vedic.astro.util.VimshotriDashaUtil;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class DashaUtilTest extends BaseUtilTest{

	@Autowired
	@Qualifier("vimshotriDashaUtil")
	private VimshotriDashaUtil vimshotriDashaUtil;
	
	@Test
	public void testDivideDasha() throws Exception {
		
		System.out.println(vimshotriDashaUtil.divideIntoDashasPeriods(Dasha.JUPITER, DateUtil.toDate("20/12/1972", "MM/dd/yyyy"),DateUtil.toDate("20/12/1982", "MM/dd/yyyy"))); 
		
	}

	
}