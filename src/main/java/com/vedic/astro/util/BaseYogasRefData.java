package com.vedic.astro.util;

import java.util.HashMap;
import java.util.Map;

import com.vedic.astro.domain.YogaDetails;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Yoga;
import com.vedic.astro.enums.YogaCategory;
import com.vedic.astro.enums.Zodiac;

public class BaseYogasRefData {

	public static Map<Yoga, YogaDetails> createNabhasYogasRefData() {
		Map<Yoga, YogaDetails> nabhasYogas = new HashMap<Yoga, YogaDetails>();

		YogaDetails rajjuYogaDetails = new YogaDetails(
				"Max planets in Movable zodiacs, Asc movable sign", false,
				YogaCategory.Nabhas, Yoga.Rajju);

		rajjuYogaDetails
				.addPositive("Ambitious, moves from place to place in search of name & fame");
		rajjuYogaDetails.addPositive("Fast decision making");
		rajjuYogaDetails.addPositive("Adapts fast to changing situations");
		rajjuYogaDetails.addNegative("Fickle-minded, indecisive");
		rajjuYogaDetails.addNegative("Does not amass much wealth & assets");

		rajjuYogaDetails.addZodiacsInvolved(Zodiac.ARE);
		rajjuYogaDetails.addZodiacsInvolved(Zodiac.CAN);
		rajjuYogaDetails.addZodiacsInvolved(Zodiac.LIB);
		rajjuYogaDetails.addZodiacsInvolved(Zodiac.CAP);

		rajjuYogaDetails.addHousesInvolved(House.H1);

		nabhasYogas.put(Yoga.Rajju, rajjuYogaDetails);

		YogaDetails moosalYogaDetails = new YogaDetails(
				"Max planets in Fixed zodiacs, Asc fixed sign", false,
				YogaCategory.Nabhas, Yoga.Moosal);

		moosalYogaDetails.addPositive("Wealthy, learned and proud");
		moosalYogaDetails.addPositive("Decisive, famous");
		moosalYogaDetails.addPositive("Man of principles");
		moosalYogaDetails.addPositive("Blessed with many children");
		moosalYogaDetails.addNegative("Rigid in approach, unwilling to change");

		moosalYogaDetails.addZodiacsInvolved(Zodiac.TAU);
		moosalYogaDetails.addZodiacsInvolved(Zodiac.LEO);
		moosalYogaDetails.addZodiacsInvolved(Zodiac.SCO);
		moosalYogaDetails.addZodiacsInvolved(Zodiac.AQU);

		moosalYogaDetails.addHousesInvolved(House.H1);

		nabhasYogas.put(Yoga.Moosal, moosalYogaDetails);

		YogaDetails nalaYogaDetails = new YogaDetails(
				"Max planets in Dual zodiacs, Asc dual sign", false,
				YogaCategory.Nabhas, Yoga.Nala);

		nalaYogaDetails
				.addPositive("Mix of Spirituality & Intellect (JUP & MER)");
		nalaYogaDetails.addPositive("Found of near and dear ones");
		nalaYogaDetails.addPositive("Clever & Resolute");
		nalaYogaDetails.addNegative("Of fluctuating wealth");
		nalaYogaDetails.addNegative("Defective in limbs");

		nalaYogaDetails.addZodiacsInvolved(Zodiac.GEM);
		nalaYogaDetails.addZodiacsInvolved(Zodiac.VIR);
		nalaYogaDetails.addZodiacsInvolved(Zodiac.SAG);
		nalaYogaDetails.addZodiacsInvolved(Zodiac.PIS);

		nalaYogaDetails.addHousesInvolved(House.H1);

		nabhasYogas.put(Yoga.Nala, nalaYogaDetails);

		YogaDetails maalaYogaDetails = new YogaDetails(
				"Kendra houses with only benefics, no malefics", false,
				YogaCategory.Nabhas, Yoga.Maala);
		
		maalaYogaDetails.addPositive("Enjoyments, wealth, prosperity");
		maalaYogaDetails.addPositive("Good food, clothes and vehicles");
		maalaYogaDetails.addPositive("Good orator");

		maalaYogaDetails.addHousesInvolved(House.H1);
		maalaYogaDetails.addHousesInvolved(House.H4);
		maalaYogaDetails.addHousesInvolved(House.H7);
		maalaYogaDetails.addHousesInvolved(House.H10);
		
		nabhasYogas.put(Yoga.Maala, maalaYogaDetails);

		YogaDetails sarpaYogaDetails = new YogaDetails(
				"Kendra houses with only malefics, no benefics", false,
				YogaCategory.Nabhas, Yoga.Sarpa);

		sarpaYogaDetails.addNegative("Poor, crooked, miserable");
		sarpaYogaDetails
				.addNegative("Destitude and dependence on others for sustainance");

		sarpaYogaDetails.addHousesInvolved(House.H1);
		sarpaYogaDetails.addHousesInvolved(House.H4);
		sarpaYogaDetails.addHousesInvolved(House.H7);
		sarpaYogaDetails.addHousesInvolved(House.H10);
		
		nabhasYogas.put(Yoga.Sarpa, sarpaYogaDetails);

		YogaDetails gadaYogaDetails = new YogaDetails(
				"Adjacent Kendra houses 1st & 4th have maximum planets", false,
				YogaCategory.Nabhas, Yoga.Gada);

		gadaYogaDetails.addPositive("Wealthy Industrious and Prosperous");
		gadaYogaDetails.addPositive("Well learned in Mantra, Tantra & music");
		gadaYogaDetails.addNegative("Envious of others");
		
		gadaYogaDetails.addHousesInvolved(House.H1);
		gadaYogaDetails.addHousesInvolved(House.H4);
		
		nabhasYogas.put(Yoga.Gada, gadaYogaDetails);

		YogaDetails shankhaYogaDetails = new YogaDetails(
				"Adjacent Kendra houses 4th & 7th have maximum planets", false,
				YogaCategory.Nabhas, Yoga.Shankha);

		shankhaYogaDetails.addPositive("Wealthy Industrious and Prosperous");
		shankhaYogaDetails.addPositive("Well learned in Mantra, Tantra & music");
		shankhaYogaDetails.addNegative("Envious of others");
		
		shankhaYogaDetails.addHousesInvolved(House.H4);
		shankhaYogaDetails.addHousesInvolved(House.H7);
		
		nabhasYogas.put(Yoga.Shankha, shankhaYogaDetails);

		YogaDetails vibhukaYogaDetails = new YogaDetails(
				"Adjacent Kendra houses 7th & 10th have maximum planets", false,
				YogaCategory.Nabhas, Yoga.Vibhuka);

		vibhukaYogaDetails.addPositive("Wealthy Industrious and Prosperous");
		vibhukaYogaDetails.addPositive("Well learned in Mantra, Tantra & music");
		vibhukaYogaDetails.addNegative("Envious of others");
		
		vibhukaYogaDetails.addHousesInvolved(House.H7);
		vibhukaYogaDetails.addHousesInvolved(House.H10);
		
		nabhasYogas.put(Yoga.Vibhuka, vibhukaYogaDetails);

		YogaDetails dhwajaYogaDetails = new YogaDetails(
				"Adjacent Kendra houses 10th & Asc have maximum planets", false,
				YogaCategory.Nabhas, Yoga.Dhwaja);

		dhwajaYogaDetails.addPositive("Wealthy Industrious and Prosperous");
		dhwajaYogaDetails.addPositive("Well learned in Mantra, Tantra & music");
		dhwajaYogaDetails.addNegative("Envious of others");
		
		dhwajaYogaDetails.addHousesInvolved(House.H10);
		dhwajaYogaDetails.addHousesInvolved(House.H1);
		
		nabhasYogas.put(Yoga.Dhwaja, dhwajaYogaDetails);

		YogaDetails shakataYogaDetails = new YogaDetails(
				"Majority of planets in Asc and 7th house", false,
				YogaCategory.Nabhas, Yoga.Shakata);

		shakataYogaDetails.addNegative("Confusion and conflict due to opposing Kendra houses");
		shakataYogaDetails.addNegative("Struggles all life, hardwork does not pay back");
		shakataYogaDetails.addNegative("Discord with wife");
		shakataYogaDetails.addNegative("Ill health, penury and privations");
		shakataYogaDetails.addNegative("Planets in other houses (based on placement & strength) can save the person");
		
		shakataYogaDetails.addHousesInvolved(House.H1);
		shakataYogaDetails.addHousesInvolved(House.H7);
		
		nabhasYogas.put(shakataYogaDetails.getYoga(), shakataYogaDetails);

		YogaDetails pakshiYogaDetails = new YogaDetails(
				"Majority of planets in 4th and 10th house", false,
				YogaCategory.Nabhas, Yoga.Pakshi);

		pakshiYogaDetails.addNegative("Always on move, cannot stay at a place like a bird");
		pakshiYogaDetails.addNegative("Transporter, Ambassador, Wanderer");
		pakshiYogaDetails.addNegative("Profession have transfers");
		pakshiYogaDetails.addPositive("Travel is profession oriented");
		pakshiYogaDetails.addPositive("Professionally going to do good, Career focussed");
		
		pakshiYogaDetails.addHousesInvolved(House.H4);
		pakshiYogaDetails.addHousesInvolved(House.H10);

		nabhasYogas.put(pakshiYogaDetails.getYoga(), pakshiYogaDetails);

		YogaDetails vajraYogaDetails = new YogaDetails(
				"Benefics in lagna & 7th and malefics in 4th and 10th", false,
				YogaCategory.Nabhas, Yoga.Vajra);

		vajraYogaDetails.addNegative("Middle life is full of suffering");
		vajraYogaDetails.addNegative("Money earned is less in proportion to efforts done");
		vajraYogaDetails.addPositive("Person has good early and later part of life");
		vajraYogaDetails.addPositive("Good looking, hardworking, courageous");
		vajraYogaDetails.addPositive("Placement of planets outside Kendra may help");
		
		vajraYogaDetails.addHousesInvolved(House.H1);
		vajraYogaDetails.addHousesInvolved(House.H4);
		vajraYogaDetails.addHousesInvolved(House.H7);
		vajraYogaDetails.addHousesInvolved(House.H10);
		
		nabhasYogas.put(vajraYogaDetails.getYoga(), vajraYogaDetails);

		YogaDetails yavaYogaDetails = new YogaDetails(
				"Malefics in lagna & 7th and benefics in 4th and 10th", false,
				YogaCategory.Nabhas, Yoga.Yava);

		yavaYogaDetails.addPositive("Consistent in nature");
		yavaYogaDetails.addPositive("Follow restraint and auspicious pursuits");
		yavaYogaDetails.addPositive("Charitable and Good family life");
		
		yavaYogaDetails.addHousesInvolved(House.H1);
		yavaYogaDetails.addHousesInvolved(House.H4);
		yavaYogaDetails.addHousesInvolved(House.H7);
		yavaYogaDetails.addHousesInvolved(House.H10);
		
		nabhasYogas.put(yavaYogaDetails.getYoga(), yavaYogaDetails);

		YogaDetails kamalaYogaDetails = new YogaDetails(
				"All planets in Kendra houses", false,
				YogaCategory.Nabhas, Yoga.Kamala);

		kamalaYogaDetails.addPositive("Strengthens the chart, cancels many affliations");
		kamalaYogaDetails.addPositive("Good looking");
		kamalaYogaDetails.addPositive("Long life");
		kamalaYogaDetails.addPositive("Spiritual inclination");
		kamalaYogaDetails.addNegative("No planet is wealth giving houses like 2,5,9 and 11");
		
		kamalaYogaDetails.addHousesInvolved(House.H1);
		kamalaYogaDetails.addHousesInvolved(House.H4);
		kamalaYogaDetails.addHousesInvolved(House.H7);
		kamalaYogaDetails.addHousesInvolved(House.H10);
		
		nabhasYogas.put(kamalaYogaDetails.getYoga(), kamalaYogaDetails);

		YogaDetails vaapiYogaDetails = new YogaDetails(
				"All or most planets not in Kendra houses", false,
				YogaCategory.Nabhas, Yoga.Vaapi);

		vaapiYogaDetails.addPositive("Good for wealth");
		vaapiYogaDetails.addPositive("Desire to earn money is more");
		vaapiYogaDetails.addPositive("Influential person in society");
		vaapiYogaDetails.addPositive("Interested in fine arts");
		vaapiYogaDetails.addNegative("Does not keep good health");
		
		vaapiYogaDetails.addHousesInvolved(House.H2);
		vaapiYogaDetails.addHousesInvolved(House.H3);
		vaapiYogaDetails.addHousesInvolved(House.H5);
		vaapiYogaDetails.addHousesInvolved(House.H6);
		
		vaapiYogaDetails.addHousesInvolved(House.H8);
		vaapiYogaDetails.addHousesInvolved(House.H9);
		vaapiYogaDetails.addHousesInvolved(House.H11);
		vaapiYogaDetails.addHousesInvolved(House.H12);
		
		nabhasYogas.put(vaapiYogaDetails.getYoga(), vaapiYogaDetails);

		YogaDetails dharmaYogaDetails = new YogaDetails(
				"All or most planets in Dharma houses", false,
				YogaCategory.Nabhas, Yoga.Dharma);

		dharmaYogaDetails.addPositive("Profession & Family dutiful oriented person");
		dharmaYogaDetails.addPositive("Virtous deeds");
		
		dharmaYogaDetails.addHousesInvolved(House.H1);
		dharmaYogaDetails.addHousesInvolved(House.H5);
		dharmaYogaDetails.addHousesInvolved(House.H9);
		
		nabhasYogas.put(dharmaYogaDetails.getYoga(), dharmaYogaDetails);

		YogaDetails arthaYogaDetails = new YogaDetails(
				"All or most planets in Artha houses", false,
				YogaCategory.Nabhas, Yoga.Artha);

		arthaYogaDetails.addPositive("Wealth, profession oriented goal");
		arthaYogaDetails.addPositive("Material pursuits");
		
		arthaYogaDetails.addHousesInvolved(House.H2);
		arthaYogaDetails.addHousesInvolved(House.H6);
		arthaYogaDetails.addHousesInvolved(House.H10);
		
		nabhasYogas.put(arthaYogaDetails.getYoga(), arthaYogaDetails);

		YogaDetails kaamaYogaDetails = new YogaDetails(
				"All or most planets in Kama houses", false,
				YogaCategory.Nabhas, Yoga.Kama);

		kaamaYogaDetails.addPositive("Pleasure seeking oriented goal");
		kaamaYogaDetails.addPositive("Sensual pursuits");
		
		kaamaYogaDetails.addHousesInvolved(House.H3);
		kaamaYogaDetails.addHousesInvolved(House.H7);
		kaamaYogaDetails.addHousesInvolved(House.H11);
		
		nabhasYogas.put(kaamaYogaDetails.getYoga(), kaamaYogaDetails);

		YogaDetails mokshaYogaDetails = new YogaDetails(
				"All or most planets in Moksha houses", false,
				YogaCategory.Nabhas, Yoga.Moksha);

		mokshaYogaDetails.addPositive("Renunciation from artha, kama and dharma");
		mokshaYogaDetails.addPositive("Salvation pursuits");
		
		mokshaYogaDetails.addHousesInvolved(House.H4);
		mokshaYogaDetails.addHousesInvolved(House.H8);
		mokshaYogaDetails.addHousesInvolved(House.H12);
		
		nabhasYogas.put(mokshaYogaDetails.getYoga(), mokshaYogaDetails);

		YogaDetails yoopaYogaDetails = new YogaDetails(
				"All or Most planets in 1st to 4th Houses", false,
				YogaCategory.Nabhas, Yoga.Yoopa);

		yoopaYogaDetails.addPositive("Person is physically confined to his/her home");
		yoopaYogaDetails.addPositive("All efforts/initiatives are done enjoying luxuries of home");
		
		yoopaYogaDetails.addHousesInvolved(House.H1);
		yoopaYogaDetails.addHousesInvolved(House.H2);
		yoopaYogaDetails.addHousesInvolved(House.H3);
		yoopaYogaDetails.addHousesInvolved(House.H4);
		
		nabhasYogas.put(yoopaYogaDetails.getYoga(), yoopaYogaDetails);

		YogaDetails sharaYogaDetails = new YogaDetails(
				"All or Most planets in 4th to 7th Houses", false,
				YogaCategory.Nabhas, Yoga.Shara);

		sharaYogaDetails.addPositive("Efforts oriented towards sensual life");
		sharaYogaDetails.addPositive("Money earned from distant place from home");
		sharaYogaDetails.addPositive("Competition, courage to fight enemies");
		
		sharaYogaDetails.addHousesInvolved(House.H4);
		sharaYogaDetails.addHousesInvolved(House.H5);
		sharaYogaDetails.addHousesInvolved(House.H6);
		sharaYogaDetails.addHousesInvolved(House.H7);
		
		nabhasYogas.put(sharaYogaDetails.getYoga(), sharaYogaDetails);

		YogaDetails shaktiYogaDetails = new YogaDetails(
				"All or Most planets in 7th to 10th Houses", false,
				YogaCategory.Nabhas, Yoga.Shakti);

		shaktiYogaDetails.addPositive("Outgoing, Long lived & fighters");
		shaktiYogaDetails.addPositive("Life with fluctuations");
		
		
		shaktiYogaDetails.addHousesInvolved(House.H7);
		shaktiYogaDetails.addHousesInvolved(House.H8);
		shaktiYogaDetails.addHousesInvolved(House.H9);
		shaktiYogaDetails.addHousesInvolved(House.H10);
		
		nabhasYogas.put(shaktiYogaDetails.getYoga(), shaktiYogaDetails);

		YogaDetails dandaYogaDetails = new YogaDetails(
				"All or Most planets in 10th to 1st Houses", false,
				YogaCategory.Nabhas, Yoga.Danda);

		dandaYogaDetails.addNegative("Punishments from past karmas");
		dandaYogaDetails.addPositive("Spiritual pursuits, wanderer");
		dandaYogaDetails.addPositive("Profession involving foreign travel");
		
		dandaYogaDetails.addHousesInvolved(House.H10);
		dandaYogaDetails.addHousesInvolved(House.H11);
		dandaYogaDetails.addHousesInvolved(House.H12);
		dandaYogaDetails.addHousesInvolved(House.H1);
		
		nabhasYogas.put(dandaYogaDetails.getYoga(), dandaYogaDetails);

		return nabhasYogas;
	}
}