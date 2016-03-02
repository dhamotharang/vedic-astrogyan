package test.vedic.astro.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.MemberAnalysis;
import com.vedic.astro.domain.SubComponentOutcome;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.repository.MemberAnalysisRepository;
import com.vedic.astro.service.MemberProfileService;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class MemberProfileServiceTest extends BaseUtilTest {

	@Autowired
	@Qualifier("memberProfileService")
	private MemberProfileService memberProfileService;

	@Autowired
	@Qualifier("memberAnalysisRepository")
	private MemberAnalysisRepository memberAnalysisRepository;

	@Test
	public void testCreateMemberAnalysis() throws Exception {

		List<MemberAnalysis> memberAnalysisList = new ArrayList<MemberAnalysis>();
		MemberAnalysis memberAnalysis1 = new MemberAnalysis();

		memberAnalysis1.setPredictionSystem(PredictionSystem.Prashara);
		memberAnalysis1.setAnalysisGroup(AnalysisGroup.ChartAnalysis);
		memberAnalysis1.setComponentCode("COMP1");

		List<SubComponentOutcome> subComponentOutcomes = 
				new ArrayList<SubComponentOutcome>();

		subComponentOutcomes.add(new SubComponentOutcome("SUB-COMP1", "TMP-1"));
		subComponentOutcomes.add(new SubComponentOutcome("SUB-COMP2", "MT-OUT1"));
		subComponentOutcomes.add(new SubComponentOutcome("SUB-COMP3", "SUNM"));

		memberAnalysis1.setMemberId("56b5029c1b3a745432b941e3");
		memberAnalysis1.setSubcomponentOutcomes(subComponentOutcomes);

		MemberAnalysis memberAnalysis2 = new MemberAnalysis();

		memberAnalysis2.setPredictionSystem(PredictionSystem.Prashara);
		memberAnalysis2.setAnalysisGroup(AnalysisGroup.ChartAnalysis);
		memberAnalysis2.setComponentCode("COMP2");

		List<SubComponentOutcome> subComponentOutcomes2 = 
				new ArrayList<SubComponentOutcome>();

		subComponentOutcomes2.add(new SubComponentOutcome("SUB-COMP2-1", "H5-L"));

		memberAnalysis2.setMemberId("56b5029c1b3a745432b941e3");
		memberAnalysis2.setSubcomponentOutcomes(subComponentOutcomes2);

		memberAnalysisList.add(memberAnalysis1);
		memberAnalysisList.add(memberAnalysis2);

		memberAnalysisRepository.save(memberAnalysisList);
	}

}