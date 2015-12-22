package test.vedic.astro.data;

import javax.annotation.Resource;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vedic.astro.chain.ChainRunner;
 
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/chain-config.xml" })
public class ChainTest {
 
	@Resource
	ChainRunner chainRunner;
 
	@Test
	public void driveTheChain() {
		System.out.println("Starting up...      [Ok]");
		Context context = new ContextBase();
		context.put("NAME", "Sumeer");
		
		chainRunner.runChain( "pingPongChain", context );
		System.out.println("Finised...          [Ok]");
	}
}
