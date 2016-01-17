package test.vedic.astro.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.repository.PersonalInfoRepository;
import com.vedic.astro.vo.PersonalInfo;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class PersonRepositoryTest extends BaseUtilTest{

	@Autowired
	@Qualifier("personalInfoRepository")
	private PersonalInfoRepository personalInfoRepository;
	

	@Test
	public void testCreatePersonalInfo() throws Exception {
		PersonalInfo personalInfo = super.preparePersonalInfo();
		PersonalInfo savedPersonalInfo = personalInfoRepository.save(personalInfo);
        System.out.println(savedPersonalInfo);    		
	}
}