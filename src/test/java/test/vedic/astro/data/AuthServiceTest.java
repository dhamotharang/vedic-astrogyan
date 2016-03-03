package test.vedic.astro.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.dto.UserCredentialsDTO;
import com.vedic.astro.dto.UserDTO;
import com.vedic.astro.dto.UserInfoDTO;
import com.vedic.astro.enums.UserRole;
import com.vedic.astro.service.AdminService;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class AuthServiceTest extends BaseUtilTest{

	@Autowired
	@Qualifier("authService")
	private AdminService authService;
	
	//@Test
	public void testCreateUserInfo() throws Exception {
		
		UserInfoDTO userInfo = new UserInfoDTO();
		userInfo.setEmail("sumeer.saxena@gmail.com");
		userInfo.setFirstName("Sumeer");
		userInfo.setLastName("Saxena");
		userInfo.setPassword("carlos123");
		userInfo.setRole(UserRole.Admin);
		
		String pid = authService.save(userInfo);
		
        System.out.println(pid);    		
	}
	
	@Test
	public void testLogin() throws Exception {
		
		UserCredentialsDTO userCredentials = new UserCredentialsDTO();
		userCredentials.setEmail("sumeer.saxena@gmail.com");
		userCredentials.setPassword("carlos123");
		
		UserDTO userDTO = authService.login(userCredentials);
		
        System.out.println(userDTO);    		
	}
}