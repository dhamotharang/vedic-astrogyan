package migration.vedic.astro.transit.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.ProfileAspect;
import com.vedic.astro.repository.ProfileAspectRepository;

import test.vedic.astro.data.BaseUtilTest;

public class ProfileHierachySetupTest extends BaseUtilTest {
 
	@Autowired
	@Qualifier("profileAspectRepository")
	private ProfileAspectRepository profileAspectRepository;

	@Test
	public void setupProfileData() {
		List<ProfileAspect> profileHierachy = new ArrayList<ProfileAspect>();

		ProfileAspect profileAspect1 = new ProfileAspect("ASP1", "Parent 1");
		ProfileAspect profileAspect2 = new ProfileAspect("ASP2", "Parent 2");
		ProfileAspect profileAspect3 = new ProfileAspect("ASP3", "Parent 3");

		ProfileAspect profileAspect11 = new ProfileAspect("SUB-ASP11", "Child 1.1", "ASP1");
		ProfileAspect profileAspect12 = new ProfileAspect("SUB-ASP12", "Child 1.2", "ASP1");

		ProfileAspect profileAspect111 = new ProfileAspect("SUB-ASP111", "Child 1.1.1", "SUB-ASP11");
		ProfileAspect profileAspect112 = new ProfileAspect("SUB-ASP112", "Child 1.1.2", "SUB-ASP11");

		ProfileAspect profileAspect21 = new ProfileAspect("SUB-ASP21", "Child 2.1", "ASP2");
		ProfileAspect profileAspect22 = new ProfileAspect("SUB-ASP22", "Child 2.2", "ASP2");

		ProfileAspect profileAspect211 = new ProfileAspect("SUB-ASP211", "Child 2.1.1", "SUB-ASP21");
		ProfileAspect profileAspect212 = new ProfileAspect("SUB-ASP212", "Child 2.1.2", "SUB-ASP21");

		ProfileAspect profileAspect31 = new ProfileAspect("SUB-ASP31", "Child 3.1", "ASP3");
		ProfileAspect profileAspect32 = new ProfileAspect("SUB-ASP32", "Child 3.2", "ASP3");
		ProfileAspect profileAspect33 = new ProfileAspect("SUB-ASP33", "Child 3.3", "ASP3");

		ProfileAspect profileAspect311 = new ProfileAspect("SUB-ASP311", "Child 3.1.1", "SUB-ASP31");
		ProfileAspect profileAspect312 = new ProfileAspect("SUB-ASP312", "Child 3.1.2", "SUB-ASP32");

		profileHierachy.add(profileAspect1);
		profileHierachy.add(profileAspect2);
		profileHierachy.add(profileAspect3);

		profileHierachy.add(profileAspect11);
		profileHierachy.add(profileAspect12);

		profileHierachy.add(profileAspect111);
		profileHierachy.add(profileAspect112);

		profileHierachy.add(profileAspect21);
		profileHierachy.add(profileAspect22);

		profileHierachy.add(profileAspect31);
		profileHierachy.add(profileAspect32);
		profileHierachy.add(profileAspect33);
		profileHierachy.add(profileAspect211);
		profileHierachy.add(profileAspect212);
		profileHierachy.add(profileAspect311);
		profileHierachy.add(profileAspect312);

		profileAspectRepository.save(profileHierachy);
	}
	
	}
