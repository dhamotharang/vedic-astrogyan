package test.vedic.astro.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.util.EncryptionUtil;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class EncryptionUtilTest extends BaseUtilTest {
	
	@Autowired
	@Qualifier("encryptionUtil")
	private EncryptionUtil encryptionUtil;
	
    
	@Test
	public void testEncryption() throws Exception {

		System.out.println(encryptionUtil.encrypt("carlos123"));
	}
}