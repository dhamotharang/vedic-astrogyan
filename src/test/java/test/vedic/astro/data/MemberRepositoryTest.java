package test.vedic.astro.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.Member;
import com.vedic.astro.repository.MemberRepository;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class MemberRepositoryTest extends BaseUtilTest{

	@Autowired
	@Qualifier("memberRepository")
	private MemberRepository memberRepository;
	

	@Test
	public void testCreateMember() throws Exception {
		Member member = super.prepareMember();
		Member savedMember = memberRepository.save(member);
        System.out.println(savedMember);    		
	}
}