package migration.vedic.astro.transit.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.HouseStrength;
import com.vedic.astro.domain.HouseStrengths;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.repository.HouseStrengthRepository;

import test.vedic.astro.data.BaseUtilTest;

public class HouseServiceTest extends BaseUtilTest {

	@Autowired
	@Qualifier("houseStrengthRepository")
	private HouseStrengthRepository houseStrengthRepository;

	@Test
	public void setupHouseStrength() {
		
		HouseStrengths houseStrengths1 = new HouseStrengths();
		houseStrengths1.setMemberId("56b5029c1b3a745432b941e3");
		houseStrengths1.setPredictionSystem(PredictionSystem.Prashara);
		
		List<HouseStrength> houseStrengthList1 = new ArrayList<HouseStrength>();
		
		houseStrengthList1.add(new HouseStrength(House.H1, 26.89));
		houseStrengthList1.add(new HouseStrength(House.H2, 12.67));
		houseStrengthList1.add(new HouseStrength(House.H3, 36.00));
		houseStrengthList1.add(new HouseStrength(House.H4, 45.67));
		houseStrengthList1.add(new HouseStrength(House.H5, 20.23));
		houseStrengthList1.add(new HouseStrength(House.H6, 45.70));
		houseStrengthList1.add(new HouseStrength(House.H7, 52.56));
		houseStrengthList1.add(new HouseStrength(House.H8, 36.00));
		houseStrengthList1.add(new HouseStrength(House.H9, 45.67));
		houseStrengthList1.add(new HouseStrength(House.H10, 20.23));
		houseStrengthList1.add(new HouseStrength(House.H11, 45.70));
		houseStrengthList1.add(new HouseStrength(House.H12, 52.56));
		
		houseStrengths1.setStrengths(houseStrengthList1);
		houseStrengthRepository.save(houseStrengths1);
	
		HouseStrengths houseStrengths2 = new HouseStrengths();
		houseStrengths2.setMemberId("56b5029c1b3a745432b941e3");
		houseStrengths2.setPredictionSystem(PredictionSystem.Ashtavarga);
		
		List<HouseStrength> houseStrengthList2 = new ArrayList<HouseStrength>();
		
		houseStrengthList2.add(new HouseStrength(House.H1, 36.89));
		houseStrengthList2.add(new HouseStrength(House.H2, 22.67));
		houseStrengthList2.add(new HouseStrength(House.H3, 26.00));
		houseStrengthList2.add(new HouseStrength(House.H4, 35.67));
		houseStrengthList2.add(new HouseStrength(House.H5, 40.23));
		houseStrengthList2.add(new HouseStrength(House.H6, 55.70));
		houseStrengthList2.add(new HouseStrength(House.H7, 32.56));
		houseStrengthList2.add(new HouseStrength(House.H8, 56.00));
		houseStrengthList2.add(new HouseStrength(House.H9, 35.67));
		houseStrengthList2.add(new HouseStrength(House.H10, 40.23));
		houseStrengthList2.add(new HouseStrength(House.H11, 15.70));
		houseStrengthList2.add(new HouseStrength(House.H12, 32.56));
		
		houseStrengths2.setStrengths(houseStrengthList2);
		houseStrengthRepository.save(houseStrengths2);
	
		}
}