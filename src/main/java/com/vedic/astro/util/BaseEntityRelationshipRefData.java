package com.vedic.astro.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vedic.astro.domain.EntityRelationshipRefData;
import com.vedic.astro.domain.EntityRelationshipValue;
import com.vedic.astro.domain.ZodiacDegreeRange;
import com.vedic.astro.enums.EntityRelationshipType;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HouseType;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetHouseImpact;
import com.vedic.astro.enums.PlanetPlanetRelationship;
import com.vedic.astro.enums.PlanetPlanetRelationshipResult;
import com.vedic.astro.enums.PlanetZodiacImpact;
import com.vedic.astro.enums.Signification;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.vo.PlanetPlanetRelationshipInput;

public class BaseEntityRelationshipRefData {

	public static EntityRelationshipRefData createPlanet_PlanetRelRefData() {

		EntityRelationshipRefData entityRelationshipRefData = new EntityRelationshipRefData();
		entityRelationshipRefData
				.setEntityRelationshipType(EntityRelationshipType.PLANET_PLANET);

		Map<String, Map<String, EntityRelationshipValue>> entityRelationshipRefMap = new HashMap<String, Map<String, EntityRelationshipValue>>();

		Map<String, EntityRelationshipValue> jupMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> ketMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> rahMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> venMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> merMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> satMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> marMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> sunMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> monMap = new HashMap<String, EntityRelationshipValue>();

		EntityRelationshipValue jup_ketValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_rahValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_marValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_venValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_sunValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_monValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_satValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_merValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_jupValue = new EntityRelationshipValue();

		jup_ketValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		jup_rahValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		jup_venValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		jup_marValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		jup_sunValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		jup_monValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		jup_satValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		jup_merValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		jup_jupValue.setPlanetImpact(PlanetPlanetRelationship.Friend);

		jupMap.put(Planet.KET.name(), jup_ketValue);
		jupMap.put(Planet.RAH.name(), jup_rahValue);
		jupMap.put(Planet.MAR.name(), jup_marValue);
		jupMap.put(Planet.VEN.name(), jup_venValue);
		jupMap.put(Planet.SAT.name(), jup_satValue);
		jupMap.put(Planet.SUN.name(), jup_sunValue);
		jupMap.put(Planet.MON.name(), jup_monValue);
		jupMap.put(Planet.MER.name(), jup_merValue);
		jupMap.put(Planet.JUP.name(), jup_jupValue);

		EntityRelationshipValue sat_ketValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_rahValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_marValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_venValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_sunValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_monValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_jupValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_merValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_satValue = new EntityRelationshipValue();

		sat_ketValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		sat_rahValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		sat_venValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		sat_marValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		sat_sunValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		sat_monValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		sat_jupValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		sat_merValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		sat_satValue.setPlanetImpact(PlanetPlanetRelationship.Friend);

		satMap.put(Planet.KET.name(), sat_ketValue);
		satMap.put(Planet.RAH.name(), sat_rahValue);
		satMap.put(Planet.MAR.name(), sat_marValue);
		satMap.put(Planet.VEN.name(), sat_venValue);
		satMap.put(Planet.JUP.name(), sat_jupValue);
		satMap.put(Planet.SUN.name(), sat_sunValue);
		satMap.put(Planet.MON.name(), sat_monValue);
		satMap.put(Planet.MER.name(), sat_merValue);
		satMap.put(Planet.SAT.name(), sat_satValue);

		EntityRelationshipValue mer_ketValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_rahValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_marValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_venValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_sunValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_monValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_jupValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_satValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_merValue = new EntityRelationshipValue();

		mer_ketValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		mer_rahValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		mer_venValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		mer_marValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		mer_sunValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		mer_monValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		mer_satValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		mer_jupValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		mer_merValue.setPlanetImpact(PlanetPlanetRelationship.Friend);

		merMap.put(Planet.KET.name(), mer_ketValue);
		merMap.put(Planet.RAH.name(), mer_rahValue);
		merMap.put(Planet.MAR.name(), mer_marValue);
		merMap.put(Planet.VEN.name(), mer_venValue);
		merMap.put(Planet.JUP.name(), mer_jupValue);
		merMap.put(Planet.SUN.name(), mer_sunValue);
		merMap.put(Planet.MON.name(), mer_monValue);
		merMap.put(Planet.SAT.name(), mer_satValue);
		merMap.put(Planet.MER.name(), mer_merValue);

		EntityRelationshipValue ven_ketValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_rahValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_marValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_merValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_sunValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_monValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_jupValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_satValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_venValue = new EntityRelationshipValue();

		ven_ketValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		ven_rahValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		ven_jupValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		ven_marValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		ven_sunValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		ven_monValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		ven_satValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		ven_merValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		ven_venValue.setPlanetImpact(PlanetPlanetRelationship.Friend);

		venMap.put(Planet.KET.name(), ven_ketValue);
		venMap.put(Planet.RAH.name(), ven_rahValue);
		venMap.put(Planet.MAR.name(), ven_marValue);
		venMap.put(Planet.MER.name(), ven_merValue);
		venMap.put(Planet.JUP.name(), ven_jupValue);
		venMap.put(Planet.SUN.name(), ven_sunValue);
		venMap.put(Planet.MON.name(), ven_monValue);
		venMap.put(Planet.SAT.name(), ven_satValue);
		venMap.put(Planet.VEN.name(), ven_venValue);

		EntityRelationshipValue mar_ketValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_rahValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_venValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_merValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_sunValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_monValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_jupValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_satValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_marValue = new EntityRelationshipValue();

		mar_ketValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		mar_rahValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		mar_jupValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		mar_venValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		mar_sunValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		mar_monValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		mar_satValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		mar_merValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		mar_marValue.setPlanetImpact(PlanetPlanetRelationship.Friend);

		marMap.put(Planet.KET.name(), mar_ketValue);
		marMap.put(Planet.RAH.name(), mar_rahValue);
		marMap.put(Planet.VEN.name(), mar_venValue);
		marMap.put(Planet.MER.name(), mar_merValue);
		marMap.put(Planet.JUP.name(), mar_jupValue);
		marMap.put(Planet.SUN.name(), mar_sunValue);
		marMap.put(Planet.MON.name(), mar_monValue);
		marMap.put(Planet.SAT.name(), mar_satValue);
		marMap.put(Planet.MAR.name(), mar_marValue);

		EntityRelationshipValue sun_ketValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_rahValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_venValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_merValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_marValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_monValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_jupValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_satValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_sunValue = new EntityRelationshipValue();

		sun_ketValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		sun_rahValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		sun_jupValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		sun_venValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		sun_marValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		sun_monValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		sun_satValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		sun_merValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		sun_sunValue.setPlanetImpact(PlanetPlanetRelationship.Friend);

		sunMap.put(Planet.KET.name(), sun_ketValue);
		sunMap.put(Planet.RAH.name(), sun_rahValue);
		sunMap.put(Planet.VEN.name(), sun_venValue);
		sunMap.put(Planet.MER.name(), sun_merValue);
		sunMap.put(Planet.JUP.name(), sun_jupValue);
		sunMap.put(Planet.MAR.name(), sun_marValue);
		sunMap.put(Planet.MON.name(), sun_monValue);
		sunMap.put(Planet.SAT.name(), sun_satValue);
		sunMap.put(Planet.SUN.name(), sun_sunValue);

		EntityRelationshipValue mon_ketValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_rahValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_venValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_merValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_marValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_sunValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_jupValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_satValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_monValue = new EntityRelationshipValue();

		mon_ketValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		mon_rahValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		mon_jupValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		mon_venValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		mon_marValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		mon_sunValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		mon_satValue.setPlanetImpact(PlanetPlanetRelationship.Neutral);
		mon_merValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		mon_monValue.setPlanetImpact(PlanetPlanetRelationship.Friend);

		monMap.put(Planet.KET.name(), mon_ketValue);
		monMap.put(Planet.RAH.name(), mon_rahValue);
		monMap.put(Planet.VEN.name(), mon_venValue);
		monMap.put(Planet.MER.name(), mon_merValue);
		monMap.put(Planet.JUP.name(), mon_jupValue);
		monMap.put(Planet.SUN.name(), mon_sunValue);
		monMap.put(Planet.MAR.name(), mon_marValue);
		monMap.put(Planet.SAT.name(), mon_satValue);
		monMap.put(Planet.MON.name(), mon_monValue);

		EntityRelationshipValue ket_monValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_rahValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_venValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_merValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_marValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_sunValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_jupValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_satValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_ketValue = new EntityRelationshipValue();

		ket_monValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		ket_rahValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		ket_jupValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		ket_venValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		ket_marValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		ket_sunValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		ket_satValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		ket_merValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		ket_ketValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);

		ketMap.put(Planet.MON.name(), ket_monValue);
		ketMap.put(Planet.RAH.name(), ket_rahValue);
		ketMap.put(Planet.VEN.name(), ket_venValue);
		ketMap.put(Planet.MER.name(), ket_merValue);
		ketMap.put(Planet.JUP.name(), ket_jupValue);
		ketMap.put(Planet.SUN.name(), ket_sunValue);
		ketMap.put(Planet.MAR.name(), ket_marValue);
		ketMap.put(Planet.SAT.name(), ket_satValue);
		ketMap.put(Planet.KET.name(), ket_ketValue);

		EntityRelationshipValue rah_monValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_ketValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_venValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_merValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_marValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_sunValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_jupValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_satValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_rahValue = new EntityRelationshipValue();

		rah_monValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		rah_ketValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		rah_jupValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		rah_venValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		rah_marValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		rah_sunValue.setPlanetImpact(PlanetPlanetRelationship.Enemy);
		rah_satValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		rah_merValue.setPlanetImpact(PlanetPlanetRelationship.Friend);
		rah_rahValue.setPlanetImpact(PlanetPlanetRelationship.Friend);

		rahMap.put(Planet.MON.name(), rah_monValue);
		rahMap.put(Planet.KET.name(), rah_ketValue);
		rahMap.put(Planet.VEN.name(), rah_venValue);
		rahMap.put(Planet.MER.name(), rah_merValue);
		rahMap.put(Planet.JUP.name(), rah_jupValue);
		rahMap.put(Planet.SUN.name(), rah_sunValue);
		rahMap.put(Planet.MAR.name(), rah_marValue);
		rahMap.put(Planet.SAT.name(), rah_satValue);
		rahMap.put(Planet.RAH.name(), rah_rahValue);

		entityRelationshipRefMap.put(Planet.JUP.name(), jupMap);
		entityRelationshipRefMap.put(Planet.SAT.name(), satMap);
		entityRelationshipRefMap.put(Planet.MAR.name(), marMap);
		entityRelationshipRefMap.put(Planet.MER.name(), merMap);
		entityRelationshipRefMap.put(Planet.VEN.name(), venMap);
		entityRelationshipRefMap.put(Planet.SUN.name(), sunMap);
		entityRelationshipRefMap.put(Planet.MON.name(), monMap);
		entityRelationshipRefMap.put(Planet.KET.name(), ketMap);
		entityRelationshipRefMap.put(Planet.RAH.name(), rahMap);

		entityRelationshipRefData.setData(entityRelationshipRefMap);

		return entityRelationshipRefData;
	}

	public static EntityRelationshipRefData createPlanet_HouseRelRefData() {

		EntityRelationshipRefData entityRelationshipRefData = new EntityRelationshipRefData();
		entityRelationshipRefData
				.setEntityRelationshipType(EntityRelationshipType.PLANET_HOUSE);

		Map<String, Map<String, EntityRelationshipValue>> entityRelationshipRefMap = new HashMap<String, Map<String, EntityRelationshipValue>>();

		Map<String, EntityRelationshipValue> jupMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> ketMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> rahMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> venMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> merMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> satMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> marMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> sunMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> monMap = new HashMap<String, EntityRelationshipValue>();

		EntityRelationshipValue sat_h1Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h2Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h3Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h4Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h5Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h6Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h7Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h8Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h9Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h10Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h11Value = new EntityRelationshipValue();
		EntityRelationshipValue sat_h12Value = new EntityRelationshipValue();

		sat_h1Value.setHouseImpact(PlanetHouseImpact.Asleep);
		sat_h2Value.setHouseImpact(PlanetHouseImpact.Neutral);
		sat_h3Value.setHouseImpact(PlanetHouseImpact.Happy);
		sat_h4Value.setHouseImpact(PlanetHouseImpact.Sad);
		sat_h5Value.setHouseImpact(PlanetHouseImpact.Sad);
		sat_h6Value.setHouseImpact(PlanetHouseImpact.Happy);
		sat_h7Value.setHouseImpact(PlanetHouseImpact.Fully_Awakened);
		sat_h8Value.setHouseImpact(PlanetHouseImpact.Sad);
		sat_h9Value.setHouseImpact(PlanetHouseImpact.Sad);
		sat_h10Value.setHouseImpact(PlanetHouseImpact.Happy);
		sat_h11Value.setHouseImpact(PlanetHouseImpact.Happy);
		sat_h12Value.setHouseImpact(PlanetHouseImpact.Sad);

		satMap.put(House.H1.name(), sat_h1Value);
		satMap.put(House.H2.name(), sat_h2Value);
		satMap.put(House.H3.name(), sat_h3Value);
		satMap.put(House.H4.name(), sat_h4Value);
		satMap.put(House.H5.name(), sat_h5Value);
		satMap.put(House.H6.name(), sat_h6Value);
		satMap.put(House.H7.name(), sat_h7Value);
		satMap.put(House.H8.name(), sat_h8Value);
		satMap.put(House.H9.name(), sat_h9Value);
		satMap.put(House.H10.name(), sat_h10Value);
		satMap.put(House.H11.name(), sat_h11Value);
		satMap.put(House.H12.name(), sat_h12Value);

		EntityRelationshipValue jup_h1Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h2Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h3Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h4Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h5Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h6Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h7Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h8Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h9Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h10Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h11Value = new EntityRelationshipValue();
		EntityRelationshipValue jup_h12Value = new EntityRelationshipValue();

		jup_h1Value.setHouseImpact(PlanetHouseImpact.Fully_Awakened);
		jup_h2Value.setHouseImpact(PlanetHouseImpact.Sad);
		jup_h3Value.setHouseImpact(PlanetHouseImpact.Neutral);
		jup_h4Value.setHouseImpact(PlanetHouseImpact.Happy);
		jup_h5Value.setHouseImpact(PlanetHouseImpact.Happy);
		jup_h6Value.setHouseImpact(PlanetHouseImpact.Sad);
		jup_h7Value.setHouseImpact(PlanetHouseImpact.Asleep);
		jup_h8Value.setHouseImpact(PlanetHouseImpact.Neutral);
		jup_h9Value.setHouseImpact(PlanetHouseImpact.Happy);
		jup_h10Value.setHouseImpact(PlanetHouseImpact.Sad);
		jup_h11Value.setHouseImpact(PlanetHouseImpact.Happy);
		jup_h12Value.setHouseImpact(PlanetHouseImpact.Happy);

		jupMap.put(House.H1.name(), jup_h1Value);
		jupMap.put(House.H2.name(), jup_h2Value);
		jupMap.put(House.H3.name(), jup_h3Value);
		jupMap.put(House.H4.name(), jup_h4Value);
		jupMap.put(House.H5.name(), jup_h5Value);
		jupMap.put(House.H6.name(), jup_h6Value);
		jupMap.put(House.H7.name(), jup_h7Value);
		jupMap.put(House.H8.name(), jup_h8Value);
		jupMap.put(House.H9.name(), jup_h9Value);
		jupMap.put(House.H10.name(), jup_h10Value);
		jupMap.put(House.H11.name(), jup_h11Value);
		jupMap.put(House.H12.name(), jup_h12Value);

		EntityRelationshipValue sun_h1Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h2Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h3Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h4Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h5Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h6Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h7Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h8Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h9Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h10Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h11Value = new EntityRelationshipValue();
		EntityRelationshipValue sun_h12Value = new EntityRelationshipValue();

		sun_h1Value.setHouseImpact(PlanetHouseImpact.Happy);
		sun_h2Value.setHouseImpact(PlanetHouseImpact.Neutral);
		sun_h3Value.setHouseImpact(PlanetHouseImpact.Neutral);
		sun_h4Value.setHouseImpact(PlanetHouseImpact.Asleep);
		sun_h5Value.setHouseImpact(PlanetHouseImpact.Happy);
		sun_h6Value.setHouseImpact(PlanetHouseImpact.Sad);
		sun_h7Value.setHouseImpact(PlanetHouseImpact.Sad);
		sun_h8Value.setHouseImpact(PlanetHouseImpact.Sad);
		sun_h9Value.setHouseImpact(PlanetHouseImpact.Happy);
		sun_h10Value.setHouseImpact(PlanetHouseImpact.Fully_Awakened);
		sun_h11Value.setHouseImpact(PlanetHouseImpact.Neutral);
		sun_h12Value.setHouseImpact(PlanetHouseImpact.Sad);

		sunMap.put(House.H1.name(), sun_h1Value);
		sunMap.put(House.H2.name(), sun_h2Value);
		sunMap.put(House.H3.name(), sun_h3Value);
		sunMap.put(House.H4.name(), sun_h4Value);
		sunMap.put(House.H5.name(), sun_h5Value);
		sunMap.put(House.H6.name(), sun_h6Value);
		sunMap.put(House.H7.name(), sun_h7Value);
		sunMap.put(House.H8.name(), sun_h8Value);
		sunMap.put(House.H9.name(), sun_h9Value);
		sunMap.put(House.H10.name(), sun_h10Value);
		sunMap.put(House.H11.name(), sun_h11Value);
		sunMap.put(House.H12.name(), sun_h12Value);

		EntityRelationshipValue mon_h1Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h2Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h3Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h4Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h5Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h6Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h7Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h8Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h9Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h10Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h11Value = new EntityRelationshipValue();
		EntityRelationshipValue mon_h12Value = new EntityRelationshipValue();

		mon_h1Value.setHouseImpact(PlanetHouseImpact.Neutral);
		mon_h2Value.setHouseImpact(PlanetHouseImpact.Neutral);
		mon_h3Value.setHouseImpact(PlanetHouseImpact.Neutral);
		mon_h4Value.setHouseImpact(PlanetHouseImpact.Fully_Awakened);
		mon_h5Value.setHouseImpact(PlanetHouseImpact.Neutral);
		mon_h6Value.setHouseImpact(PlanetHouseImpact.Neutral);
		mon_h7Value.setHouseImpact(PlanetHouseImpact.Happy);
		mon_h8Value.setHouseImpact(PlanetHouseImpact.Neutral);
		mon_h9Value.setHouseImpact(PlanetHouseImpact.Happy);
		mon_h10Value.setHouseImpact(PlanetHouseImpact.Asleep);
		mon_h11Value.setHouseImpact(PlanetHouseImpact.Happy);
		mon_h12Value.setHouseImpact(PlanetHouseImpact.Happy);

		monMap.put(House.H1.name(), mon_h1Value);
		monMap.put(House.H2.name(), mon_h2Value);
		monMap.put(House.H3.name(), mon_h3Value);
		monMap.put(House.H4.name(), mon_h4Value);
		monMap.put(House.H5.name(), mon_h5Value);
		monMap.put(House.H6.name(), mon_h6Value);
		monMap.put(House.H7.name(), mon_h7Value);
		monMap.put(House.H8.name(), mon_h8Value);
		monMap.put(House.H9.name(), mon_h9Value);
		monMap.put(House.H10.name(), mon_h10Value);
		monMap.put(House.H11.name(), mon_h11Value);
		monMap.put(House.H12.name(), mon_h12Value);

		EntityRelationshipValue mer_h1Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h2Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h3Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h4Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h5Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h6Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h7Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h8Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h9Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h10Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h11Value = new EntityRelationshipValue();
		EntityRelationshipValue mer_h12Value = new EntityRelationshipValue();

		mer_h1Value.setHouseImpact(PlanetHouseImpact.Fully_Awakened);
		mer_h2Value.setHouseImpact(PlanetHouseImpact.Sad);
		mer_h3Value.setHouseImpact(PlanetHouseImpact.Happy);
		mer_h4Value.setHouseImpact(PlanetHouseImpact.Sad);
		mer_h5Value.setHouseImpact(PlanetHouseImpact.Happy);
		mer_h6Value.setHouseImpact(PlanetHouseImpact.Happy);
		mer_h7Value.setHouseImpact(PlanetHouseImpact.Asleep);
		mer_h8Value.setHouseImpact(PlanetHouseImpact.Sad);
		mer_h9Value.setHouseImpact(PlanetHouseImpact.Sad);
		mer_h10Value.setHouseImpact(PlanetHouseImpact.Happy);
		mer_h11Value.setHouseImpact(PlanetHouseImpact.Happy);
		mer_h12Value.setHouseImpact(PlanetHouseImpact.Sad);

		merMap.put(House.H1.name(), mer_h1Value);
		merMap.put(House.H2.name(), mer_h2Value);
		merMap.put(House.H3.name(), mer_h3Value);
		merMap.put(House.H4.name(), mer_h4Value);
		merMap.put(House.H5.name(), mer_h5Value);
		merMap.put(House.H6.name(), mer_h6Value);
		merMap.put(House.H7.name(), mer_h7Value);
		merMap.put(House.H8.name(), mer_h8Value);
		merMap.put(House.H9.name(), mer_h9Value);
		merMap.put(House.H10.name(), mer_h10Value);
		merMap.put(House.H11.name(), mer_h11Value);
		merMap.put(House.H12.name(), mer_h12Value);

		EntityRelationshipValue ven_h1Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h2Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h3Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h4Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h5Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h6Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h7Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h8Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h9Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h10Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h11Value = new EntityRelationshipValue();
		EntityRelationshipValue ven_h12Value = new EntityRelationshipValue();

		ven_h1Value.setHouseImpact(PlanetHouseImpact.Happy);
		ven_h2Value.setHouseImpact(PlanetHouseImpact.Happy);
		ven_h3Value.setHouseImpact(PlanetHouseImpact.Sad);
		ven_h4Value.setHouseImpact(PlanetHouseImpact.Fully_Awakened);
		ven_h5Value.setHouseImpact(PlanetHouseImpact.Happy);
		ven_h6Value.setHouseImpact(PlanetHouseImpact.Sad);
		ven_h7Value.setHouseImpact(PlanetHouseImpact.Happy);
		ven_h8Value.setHouseImpact(PlanetHouseImpact.Sad);
		ven_h9Value.setHouseImpact(PlanetHouseImpact.Happy);
		ven_h10Value.setHouseImpact(PlanetHouseImpact.Asleep);
		ven_h11Value.setHouseImpact(PlanetHouseImpact.Happy);
		ven_h12Value.setHouseImpact(PlanetHouseImpact.Happy);

		venMap.put(House.H1.name(), ven_h1Value);
		venMap.put(House.H2.name(), ven_h2Value);
		venMap.put(House.H3.name(), ven_h3Value);
		venMap.put(House.H4.name(), ven_h4Value);
		venMap.put(House.H5.name(), ven_h5Value);
		venMap.put(House.H6.name(), ven_h6Value);
		venMap.put(House.H7.name(), ven_h7Value);
		venMap.put(House.H8.name(), ven_h8Value);
		venMap.put(House.H9.name(), ven_h9Value);
		venMap.put(House.H10.name(), ven_h10Value);
		venMap.put(House.H11.name(), ven_h11Value);
		venMap.put(House.H12.name(), ven_h12Value);

		EntityRelationshipValue rah_h1Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h2Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h3Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h4Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h5Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h6Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h7Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h8Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h9Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h10Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h11Value = new EntityRelationshipValue();
		EntityRelationshipValue rah_h12Value = new EntityRelationshipValue();

		rah_h1Value.setHouseImpact(PlanetHouseImpact.Happy);
		rah_h2Value.setHouseImpact(PlanetHouseImpact.Happy);
		rah_h3Value.setHouseImpact(PlanetHouseImpact.Happy);
		rah_h4Value.setHouseImpact(PlanetHouseImpact.Sad);
		rah_h5Value.setHouseImpact(PlanetHouseImpact.Happy);
		rah_h6Value.setHouseImpact(PlanetHouseImpact.Fully_Awakened);
		rah_h7Value.setHouseImpact(PlanetHouseImpact.Sad);
		rah_h8Value.setHouseImpact(PlanetHouseImpact.Sad);
		rah_h9Value.setHouseImpact(PlanetHouseImpact.Sad);
		rah_h10Value.setHouseImpact(PlanetHouseImpact.Happy);
		rah_h11Value.setHouseImpact(PlanetHouseImpact.Happy);
		rah_h12Value.setHouseImpact(PlanetHouseImpact.Asleep);

		rahMap.put(House.H1.name(), rah_h1Value);
		rahMap.put(House.H2.name(), rah_h2Value);
		rahMap.put(House.H3.name(), rah_h3Value);
		rahMap.put(House.H4.name(), rah_h4Value);
		rahMap.put(House.H5.name(), rah_h5Value);
		rahMap.put(House.H6.name(), rah_h6Value);
		rahMap.put(House.H7.name(), rah_h7Value);
		rahMap.put(House.H8.name(), rah_h8Value);
		rahMap.put(House.H9.name(), rah_h9Value);
		rahMap.put(House.H10.name(), rah_h10Value);
		rahMap.put(House.H11.name(), rah_h11Value);
		rahMap.put(House.H12.name(), rah_h12Value);

		EntityRelationshipValue ket_h1Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h2Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h3Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h4Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h5Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h6Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h7Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h8Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h9Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h10Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h11Value = new EntityRelationshipValue();
		EntityRelationshipValue ket_h12Value = new EntityRelationshipValue();

		ket_h1Value.setHouseImpact(PlanetHouseImpact.Sad);
		ket_h2Value.setHouseImpact(PlanetHouseImpact.Sad);
		ket_h3Value.setHouseImpact(PlanetHouseImpact.Sad);
		ket_h4Value.setHouseImpact(PlanetHouseImpact.Happy);
		ket_h5Value.setHouseImpact(PlanetHouseImpact.Sad);
		ket_h6Value.setHouseImpact(PlanetHouseImpact.Asleep);
		ket_h7Value.setHouseImpact(PlanetHouseImpact.Sad);
		ket_h8Value.setHouseImpact(PlanetHouseImpact.Happy);
		ket_h9Value.setHouseImpact(PlanetHouseImpact.Happy);
		ket_h10Value.setHouseImpact(PlanetHouseImpact.Sad);
		ket_h11Value.setHouseImpact(PlanetHouseImpact.Sad);
		ket_h12Value.setHouseImpact(PlanetHouseImpact.Fully_Awakened);

		ketMap.put(House.H1.name(), ket_h1Value);
		ketMap.put(House.H2.name(), ket_h2Value);
		ketMap.put(House.H3.name(), ket_h3Value);
		ketMap.put(House.H4.name(), ket_h4Value);
		ketMap.put(House.H5.name(), ket_h5Value);
		ketMap.put(House.H6.name(), ket_h6Value);
		ketMap.put(House.H7.name(), ket_h7Value);
		ketMap.put(House.H8.name(), ket_h8Value);
		ketMap.put(House.H9.name(), ket_h9Value);
		ketMap.put(House.H10.name(), ket_h10Value);
		ketMap.put(House.H11.name(), ket_h11Value);
		ketMap.put(House.H12.name(), ket_h12Value);

		EntityRelationshipValue mar_h1Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h2Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h3Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h4Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h5Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h6Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h7Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h8Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h9Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h10Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h11Value = new EntityRelationshipValue();
		EntityRelationshipValue mar_h12Value = new EntityRelationshipValue();

		mar_h1Value.setHouseImpact(PlanetHouseImpact.Happy);
		mar_h2Value.setHouseImpact(PlanetHouseImpact.Sad);
		mar_h3Value.setHouseImpact(PlanetHouseImpact.Happy);
		mar_h4Value.setHouseImpact(PlanetHouseImpact.Sad);
		mar_h5Value.setHouseImpact(PlanetHouseImpact.Happy);
		mar_h6Value.setHouseImpact(PlanetHouseImpact.Sad);
		mar_h7Value.setHouseImpact(PlanetHouseImpact.Neutral);
		mar_h8Value.setHouseImpact(PlanetHouseImpact.Happy);
		mar_h9Value.setHouseImpact(PlanetHouseImpact.Neutral);
		mar_h10Value.setHouseImpact(PlanetHouseImpact.Fully_Awakened);
		mar_h11Value.setHouseImpact(PlanetHouseImpact.Happy);
		mar_h12Value.setHouseImpact(PlanetHouseImpact.Sad);

		marMap.put(House.H1.name(), mar_h1Value);
		marMap.put(House.H2.name(), mar_h2Value);
		marMap.put(House.H3.name(), mar_h3Value);
		marMap.put(House.H4.name(), mar_h4Value);
		marMap.put(House.H5.name(), mar_h5Value);
		marMap.put(House.H6.name(), mar_h6Value);
		marMap.put(House.H7.name(), mar_h7Value);
		marMap.put(House.H8.name(), mar_h8Value);
		marMap.put(House.H9.name(), mar_h9Value);
		marMap.put(House.H10.name(), mar_h10Value);
		marMap.put(House.H11.name(), mar_h11Value);
		marMap.put(House.H12.name(), mar_h12Value);

		entityRelationshipRefMap.put(Planet.JUP.name(), jupMap);
		entityRelationshipRefMap.put(Planet.SAT.name(), satMap);
		entityRelationshipRefMap.put(Planet.MAR.name(), marMap);
		entityRelationshipRefMap.put(Planet.MER.name(), merMap);
		entityRelationshipRefMap.put(Planet.VEN.name(), venMap);
		entityRelationshipRefMap.put(Planet.SUN.name(), sunMap);
		entityRelationshipRefMap.put(Planet.MON.name(), monMap);
		entityRelationshipRefMap.put(Planet.KET.name(), ketMap);
		entityRelationshipRefMap.put(Planet.RAH.name(), rahMap);

		entityRelationshipRefData.setData(entityRelationshipRefMap);

		return entityRelationshipRefData;

	}

	public static EntityRelationshipRefData createPlanet_ZodiacRelRefData() {

		EntityRelationshipRefData entityRelationshipRefData = new EntityRelationshipRefData();
		entityRelationshipRefData
				.setEntityRelationshipType(EntityRelationshipType.PLANET_ZODIAC);

		Map<String, Map<String, EntityRelationshipValue>> entityRelationshipRefMap = new HashMap<String, Map<String, EntityRelationshipValue>>();

		Map<String, EntityRelationshipValue> jupMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> ketMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> rahMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> venMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> merMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> satMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> marMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> sunMap = new HashMap<String, EntityRelationshipValue>();
		Map<String, EntityRelationshipValue> monMap = new HashMap<String, EntityRelationshipValue>();

		EntityRelationshipValue sat_areValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_tauValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_gemValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_canValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_leoValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_virValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_libValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_scoValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_sagValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_capValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_aquValue = new EntityRelationshipValue();
		EntityRelationshipValue sat_pisValue = new EntityRelationshipValue();

		sat_areValue.setZodiacImpact(PlanetZodiacImpact.Debiliated);
		sat_tauValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sat_gemValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sat_canValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		sat_leoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sat_virValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sat_libValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		sat_scoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sat_sagValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sat_capValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		sat_aquValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		sat_pisValue.setZodiacImpact(PlanetZodiacImpact.Neutral);

		satMap.put(Zodiac.ARE.name(), sat_areValue);
		satMap.put(Zodiac.TAU.name(), sat_tauValue);
		satMap.put(Zodiac.GEM.name(), sat_gemValue);
		satMap.put(Zodiac.CAN.name(), sat_canValue);
		satMap.put(Zodiac.LEO.name(), sat_leoValue);
		satMap.put(Zodiac.VIR.name(), sat_virValue);
		satMap.put(Zodiac.LIB.name(), sat_libValue);
		satMap.put(Zodiac.SCO.name(), sat_scoValue);
		satMap.put(Zodiac.SAG.name(), sat_sagValue);
		satMap.put(Zodiac.CAP.name(), sat_capValue);
		satMap.put(Zodiac.AQU.name(), sat_aquValue);
		satMap.put(Zodiac.PIS.name(), sat_pisValue);

		EntityRelationshipValue jup_areValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_tauValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_gemValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_canValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_leoValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_virValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_libValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_scoValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_sagValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_capValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_aquValue = new EntityRelationshipValue();
		EntityRelationshipValue jup_pisValue = new EntityRelationshipValue();

		jup_areValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		jup_tauValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		jup_gemValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		jup_canValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		jup_leoValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		jup_virValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		jup_libValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		jup_scoValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		jup_sagValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		jup_capValue.setZodiacImpact(PlanetZodiacImpact.Debiliated);
		jup_aquValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		jup_pisValue.setZodiacImpact(PlanetZodiacImpact.Owner);

		jupMap.put(Zodiac.ARE.name(), jup_areValue);
		jupMap.put(Zodiac.TAU.name(), jup_tauValue);
		jupMap.put(Zodiac.GEM.name(), jup_gemValue);
		jupMap.put(Zodiac.CAN.name(), jup_canValue);
		jupMap.put(Zodiac.LEO.name(), jup_leoValue);
		jupMap.put(Zodiac.VIR.name(), jup_virValue);
		jupMap.put(Zodiac.LIB.name(), jup_libValue);
		jupMap.put(Zodiac.SCO.name(), jup_scoValue);
		jupMap.put(Zodiac.SAG.name(), jup_sagValue);
		jupMap.put(Zodiac.CAP.name(), jup_capValue);
		jupMap.put(Zodiac.AQU.name(), jup_aquValue);
		jupMap.put(Zodiac.PIS.name(), jup_pisValue);

		EntityRelationshipValue sun_areValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_tauValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_gemValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_canValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_leoValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_virValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_libValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_scoValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_sagValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_capValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_aquValue = new EntityRelationshipValue();
		EntityRelationshipValue sun_pisValue = new EntityRelationshipValue();

		sun_areValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		sun_tauValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sun_gemValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sun_canValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sun_leoValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		sun_virValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sun_libValue.setZodiacImpact(PlanetZodiacImpact.Debiliated);
		sun_scoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sun_sagValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sun_capValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sun_aquValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		sun_pisValue.setZodiacImpact(PlanetZodiacImpact.Neutral);

		sunMap.put(Zodiac.ARE.name(), sun_areValue);
		sunMap.put(Zodiac.TAU.name(), sun_tauValue);
		sunMap.put(Zodiac.GEM.name(), sun_gemValue);
		sunMap.put(Zodiac.CAN.name(), sun_canValue);
		sunMap.put(Zodiac.LEO.name(), sun_leoValue);
		sunMap.put(Zodiac.VIR.name(), sun_virValue);
		sunMap.put(Zodiac.LIB.name(), sun_libValue);
		sunMap.put(Zodiac.SCO.name(), sun_scoValue);
		sunMap.put(Zodiac.SAG.name(), sun_sagValue);
		sunMap.put(Zodiac.CAP.name(), sun_capValue);
		sunMap.put(Zodiac.AQU.name(), sun_aquValue);
		sunMap.put(Zodiac.PIS.name(), sun_pisValue);

		EntityRelationshipValue mon_areValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_tauValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_gemValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_canValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_leoValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_virValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_libValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_scoValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_sagValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_capValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_aquValue = new EntityRelationshipValue();
		EntityRelationshipValue mon_pisValue = new EntityRelationshipValue();

		mon_areValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mon_tauValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		mon_gemValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mon_canValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		mon_leoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mon_virValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mon_libValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mon_scoValue.setZodiacImpact(PlanetZodiacImpact.Debiliated);
		mon_sagValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mon_capValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		mon_aquValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mon_pisValue.setZodiacImpact(PlanetZodiacImpact.Neutral);

		monMap.put(Zodiac.ARE.name(), mon_areValue);
		monMap.put(Zodiac.TAU.name(), mon_tauValue);
		monMap.put(Zodiac.GEM.name(), mon_gemValue);
		monMap.put(Zodiac.CAN.name(), mon_canValue);
		monMap.put(Zodiac.LEO.name(), mon_leoValue);
		monMap.put(Zodiac.VIR.name(), mon_virValue);
		monMap.put(Zodiac.LIB.name(), mon_libValue);
		monMap.put(Zodiac.SCO.name(), mon_scoValue);
		monMap.put(Zodiac.SAG.name(), mon_sagValue);
		monMap.put(Zodiac.CAP.name(), mon_capValue);
		monMap.put(Zodiac.AQU.name(), mon_aquValue);
		monMap.put(Zodiac.PIS.name(), mon_pisValue);

		EntityRelationshipValue mar_areValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_tauValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_gemValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_canValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_leoValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_virValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_libValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_scoValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_sagValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_capValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_aquValue = new EntityRelationshipValue();
		EntityRelationshipValue mar_pisValue = new EntityRelationshipValue();

		mar_areValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		mar_tauValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mar_gemValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mar_canValue.setZodiacImpact(PlanetZodiacImpact.Debiliated);
		mar_leoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mar_virValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mar_libValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		mar_scoValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		mar_sagValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mar_capValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		mar_aquValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mar_pisValue.setZodiacImpact(PlanetZodiacImpact.Sad);

		marMap.put(Zodiac.ARE.name(), mar_areValue);
		marMap.put(Zodiac.TAU.name(), mar_tauValue);
		marMap.put(Zodiac.GEM.name(), mar_gemValue);
		marMap.put(Zodiac.CAN.name(), mar_canValue);
		marMap.put(Zodiac.LEO.name(), mar_leoValue);
		marMap.put(Zodiac.VIR.name(), mar_virValue);
		marMap.put(Zodiac.LIB.name(), mar_libValue);
		marMap.put(Zodiac.SCO.name(), mar_scoValue);
		marMap.put(Zodiac.SAG.name(), mar_sagValue);
		marMap.put(Zodiac.CAP.name(), mar_capValue);
		marMap.put(Zodiac.AQU.name(), mar_aquValue);
		marMap.put(Zodiac.PIS.name(), mar_pisValue);

		EntityRelationshipValue mer_areValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_tauValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_gemValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_canValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_leoValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_virValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_libValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_scoValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_sagValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_capValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_aquValue = new EntityRelationshipValue();
		EntityRelationshipValue mer_pisValue = new EntityRelationshipValue();

		mer_areValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mer_tauValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mer_gemValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		mer_canValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mer_leoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mer_virValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		mer_libValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mer_scoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mer_sagValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		mer_capValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mer_aquValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		mer_pisValue.setZodiacImpact(PlanetZodiacImpact.Debiliated);

		merMap.put(Zodiac.ARE.name(), mer_areValue);
		merMap.put(Zodiac.TAU.name(), mer_tauValue);
		merMap.put(Zodiac.GEM.name(), mer_gemValue);
		merMap.put(Zodiac.CAN.name(), mer_canValue);
		merMap.put(Zodiac.LEO.name(), mer_leoValue);
		merMap.put(Zodiac.VIR.name(), mer_virValue);
		merMap.put(Zodiac.LIB.name(), mer_libValue);
		merMap.put(Zodiac.SCO.name(), mer_scoValue);
		merMap.put(Zodiac.SAG.name(), mer_sagValue);
		merMap.put(Zodiac.CAP.name(), mer_capValue);
		merMap.put(Zodiac.AQU.name(), mer_aquValue);
		merMap.put(Zodiac.PIS.name(), mer_pisValue);

		EntityRelationshipValue ven_areValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_tauValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_gemValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_canValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_leoValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_virValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_libValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_scoValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_sagValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_capValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_aquValue = new EntityRelationshipValue();
		EntityRelationshipValue ven_pisValue = new EntityRelationshipValue();

		ven_areValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ven_tauValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		ven_gemValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ven_canValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ven_leoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ven_virValue.setZodiacImpact(PlanetZodiacImpact.Debiliated);
		ven_libValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		ven_scoValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		ven_sagValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ven_capValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ven_aquValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ven_pisValue.setZodiacImpact(PlanetZodiacImpact.Exalted);

		venMap.put(Zodiac.ARE.name(), ven_areValue);
		venMap.put(Zodiac.TAU.name(), ven_tauValue);
		venMap.put(Zodiac.GEM.name(), ven_gemValue);
		venMap.put(Zodiac.CAN.name(), ven_canValue);
		venMap.put(Zodiac.LEO.name(), ven_leoValue);
		venMap.put(Zodiac.VIR.name(), ven_virValue);
		venMap.put(Zodiac.LIB.name(), ven_libValue);
		venMap.put(Zodiac.SCO.name(), ven_scoValue);
		venMap.put(Zodiac.SAG.name(), ven_sagValue);
		venMap.put(Zodiac.CAP.name(), ven_capValue);
		venMap.put(Zodiac.AQU.name(), ven_aquValue);
		venMap.put(Zodiac.PIS.name(), ven_pisValue);

		EntityRelationshipValue rah_areValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_tauValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_gemValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_canValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_leoValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_virValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_libValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_scoValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_sagValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_capValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_aquValue = new EntityRelationshipValue();
		EntityRelationshipValue rah_pisValue = new EntityRelationshipValue();

		rah_areValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		rah_tauValue.setZodiacImpact(PlanetZodiacImpact.Owner);
		rah_gemValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		rah_canValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		rah_leoValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		rah_virValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		rah_libValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		rah_scoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		rah_sagValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		rah_capValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		rah_aquValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		rah_pisValue.setZodiacImpact(PlanetZodiacImpact.Debiliated);

		rahMap.put(Zodiac.ARE.name(), rah_areValue);
		rahMap.put(Zodiac.TAU.name(), rah_tauValue);
		rahMap.put(Zodiac.GEM.name(), rah_gemValue);
		rahMap.put(Zodiac.CAN.name(), rah_canValue);
		rahMap.put(Zodiac.LEO.name(), rah_leoValue);
		rahMap.put(Zodiac.VIR.name(), rah_virValue);
		rahMap.put(Zodiac.LIB.name(), rah_libValue);
		rahMap.put(Zodiac.SCO.name(), rah_scoValue);
		rahMap.put(Zodiac.SAG.name(), rah_sagValue);
		rahMap.put(Zodiac.CAP.name(), rah_capValue);
		rahMap.put(Zodiac.AQU.name(), rah_aquValue);
		rahMap.put(Zodiac.PIS.name(), rah_pisValue);

		EntityRelationshipValue ket_areValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_tauValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_gemValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_canValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_leoValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_virValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_libValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_scoValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_sagValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_capValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_aquValue = new EntityRelationshipValue();
		EntityRelationshipValue ket_pisValue = new EntityRelationshipValue();

		ket_areValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		ket_tauValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		ket_gemValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		ket_canValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ket_leoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ket_virValue.setZodiacImpact(PlanetZodiacImpact.Debiliated);
		ket_libValue.setZodiacImpact(PlanetZodiacImpact.Sad);
		ket_scoValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ket_sagValue.setZodiacImpact(PlanetZodiacImpact.Exalted);
		ket_capValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ket_aquValue.setZodiacImpact(PlanetZodiacImpact.Neutral);
		ket_pisValue.setZodiacImpact(PlanetZodiacImpact.Owner);

		ketMap.put(Zodiac.ARE.name(), ket_areValue);
		ketMap.put(Zodiac.TAU.name(), ket_tauValue);
		ketMap.put(Zodiac.GEM.name(), ket_gemValue);
		ketMap.put(Zodiac.CAN.name(), ket_canValue);
		ketMap.put(Zodiac.LEO.name(), ket_leoValue);
		ketMap.put(Zodiac.VIR.name(), ket_virValue);
		ketMap.put(Zodiac.LIB.name(), ket_libValue);
		ketMap.put(Zodiac.SCO.name(), ket_scoValue);
		ketMap.put(Zodiac.SAG.name(), ket_sagValue);
		ketMap.put(Zodiac.CAP.name(), ket_capValue);
		ketMap.put(Zodiac.AQU.name(), ket_aquValue);
		ketMap.put(Zodiac.PIS.name(), ket_pisValue);

		entityRelationshipRefMap.put(Planet.JUP.name(), jupMap);
		entityRelationshipRefMap.put(Planet.SAT.name(), satMap);
		entityRelationshipRefMap.put(Planet.MAR.name(), marMap);
		entityRelationshipRefMap.put(Planet.MER.name(), merMap);
		entityRelationshipRefMap.put(Planet.VEN.name(), venMap);
		entityRelationshipRefMap.put(Planet.SUN.name(), sunMap);
		entityRelationshipRefMap.put(Planet.MON.name(), monMap);
		entityRelationshipRefMap.put(Planet.KET.name(), ketMap);
		entityRelationshipRefMap.put(Planet.RAH.name(), rahMap);

		entityRelationshipRefData.setData(entityRelationshipRefMap);

		return entityRelationshipRefData;

	}

	public static Map<Planet, Zodiac> getDebilatedPlanetZodiacMap() {
		Map<Planet, Zodiac> debilatedPlanetZodiacMap = new HashMap<Planet, Zodiac>(
				9);

		debilatedPlanetZodiacMap.put(Planet.SUN, Zodiac.LIB);
		debilatedPlanetZodiacMap.put(Planet.MON, Zodiac.SCO);
		debilatedPlanetZodiacMap.put(Planet.MER, Zodiac.PIS);
		debilatedPlanetZodiacMap.put(Planet.VEN, Zodiac.VIR);
		debilatedPlanetZodiacMap.put(Planet.MAR, Zodiac.CAN);
		debilatedPlanetZodiacMap.put(Planet.SAT, Zodiac.ARE);
		debilatedPlanetZodiacMap.put(Planet.RAH, Zodiac.SCO);
		debilatedPlanetZodiacMap.put(Planet.KET, Zodiac.PIS);
		debilatedPlanetZodiacMap.put(Planet.JUP, Zodiac.CAP);

		return debilatedPlanetZodiacMap;
	}

	public static Map<Planet, Zodiac> getExaltedPlanetZodiacMap() {
		Map<Planet, Zodiac> exaltedPlanetZodiacMap = new HashMap<Planet, Zodiac>(
				9);

		exaltedPlanetZodiacMap.put(Planet.SUN, Zodiac.ARE);
		exaltedPlanetZodiacMap.put(Planet.MON, Zodiac.TAU);
		exaltedPlanetZodiacMap.put(Planet.MER, Zodiac.VIR);
		exaltedPlanetZodiacMap.put(Planet.VEN, Zodiac.PIS);
		exaltedPlanetZodiacMap.put(Planet.MAR, Zodiac.CAP);
		exaltedPlanetZodiacMap.put(Planet.SAT, Zodiac.LIB);
		exaltedPlanetZodiacMap.put(Planet.RAH, Zodiac.TAU);
		exaltedPlanetZodiacMap.put(Planet.KET, Zodiac.VIR);
		exaltedPlanetZodiacMap.put(Planet.JUP, Zodiac.CAN);

		return exaltedPlanetZodiacMap;
	}

	public static List<Integer> getTemporaryFriendPlanetHouses() {

		List<Integer> temporaryFriendPlanetHouses = new ArrayList<Integer>();

		temporaryFriendPlanetHouses.add(2);
		temporaryFriendPlanetHouses.add(3);
		temporaryFriendPlanetHouses.add(4);
		temporaryFriendPlanetHouses.add(10);
		temporaryFriendPlanetHouses.add(11);
		temporaryFriendPlanetHouses.add(12);

		return temporaryFriendPlanetHouses;
	}

	public static List<Integer> getTemporaryEnemyPlanetHouses() {

		List<Integer> temporaryEnemyPlanetHouses = new ArrayList<Integer>();

		temporaryEnemyPlanetHouses.add(1);
		temporaryEnemyPlanetHouses.add(5);
		temporaryEnemyPlanetHouses.add(6);
		temporaryEnemyPlanetHouses.add(7);
		temporaryEnemyPlanetHouses.add(8);
		temporaryEnemyPlanetHouses.add(9);

		return temporaryEnemyPlanetHouses;
	}

	public static Map<PlanetPlanetRelationshipInput, PlanetPlanetRelationshipResult> getPlanetPlanetRelationshipMatrix() {

		Map<PlanetPlanetRelationshipInput, PlanetPlanetRelationshipResult> relationshipMap = new HashMap<PlanetPlanetRelationshipInput, PlanetPlanetRelationshipResult>();

		relationshipMap.put(new PlanetPlanetRelationshipInput(
				PlanetPlanetRelationship.Friend,
				PlanetPlanetRelationship.Friend),
				PlanetPlanetRelationshipResult.FastFriend);
		relationshipMap.put(new PlanetPlanetRelationshipInput(
				PlanetPlanetRelationship.Friend,
				PlanetPlanetRelationship.Neutral),
				PlanetPlanetRelationshipResult.Friend);
		relationshipMap.put(
				new PlanetPlanetRelationshipInput(
						PlanetPlanetRelationship.Friend,
						PlanetPlanetRelationship.Enemy),
				PlanetPlanetRelationshipResult.Neutral);
		relationshipMap.put(new PlanetPlanetRelationshipInput(
				PlanetPlanetRelationship.Enemy,
				PlanetPlanetRelationship.Neutral),
				PlanetPlanetRelationshipResult.Enemy);
		relationshipMap.put(
				new PlanetPlanetRelationshipInput(
						PlanetPlanetRelationship.Enemy,
						PlanetPlanetRelationship.Friend),
				PlanetPlanetRelationshipResult.Neutral);
		relationshipMap.put(
				new PlanetPlanetRelationshipInput(
						PlanetPlanetRelationship.Enemy,
						PlanetPlanetRelationship.Enemy),
				PlanetPlanetRelationshipResult.BitterEnemy);

		return relationshipMap;
	}

	public static Map<Planet, Map<Zodiac, Double>> getPlanetOddEvenZodiacRelationshipMatrix() {

		Map<Planet, Map<Zodiac, Double>> relationshipMap = new HashMap<Planet, Map<Zodiac, Double>>();

		Map<Zodiac, Double> evenZodiacScoreMap = new HashMap<Zodiac, Double>();
		Map<Zodiac, Double> oddZodiacScoreMap = new HashMap<Zodiac, Double>();
		
		for (Zodiac zodiac : Zodiac.values()) {
			if (zodiac.isEven()) {
				evenZodiacScoreMap.put(zodiac, 15.0);
				oddZodiacScoreMap.put(zodiac, 0.0);
			}
			else{
				evenZodiacScoreMap.put(zodiac, 0.0);
				oddZodiacScoreMap.put(zodiac, 15.0);
			}
		}

		relationshipMap.put(Planet.MON, evenZodiacScoreMap);
		relationshipMap.put(Planet.VEN, evenZodiacScoreMap);
		
		relationshipMap.put(Planet.SUN, oddZodiacScoreMap);
		relationshipMap.put(Planet.MAR, oddZodiacScoreMap);
		relationshipMap.put(Planet.MER, oddZodiacScoreMap);
		relationshipMap.put(Planet.SAT, oddZodiacScoreMap);
		relationshipMap.put(Planet.JUP, oddZodiacScoreMap);
		
		return relationshipMap;
	}

	public static Map<HouseType, Double> getKendraBalaScoreMap(){
		
		Map<HouseType, Double> kendraBalaScoreMap = new HashMap<HouseType, Double>();
		
		kendraBalaScoreMap.put(HouseType.Kendra, 60.0);
		kendraBalaScoreMap.put(HouseType.Panapara, 30.0);
		kendraBalaScoreMap.put(HouseType.Apoklim, 15.0);
		
		return kendraBalaScoreMap;
	}
	
	public static Map<Planet, House> getDirectionalStrengthMapping(){
		
		Map<Planet, House> directionalStrengthMap = new HashMap<Planet, House>(7);
		
		directionalStrengthMap.put(Planet.JUP, House.H7);
		directionalStrengthMap.put(Planet.MER, House.H7);
		directionalStrengthMap.put(Planet.MON, House.H10);
		directionalStrengthMap.put(Planet.VEN, House.H10);
		directionalStrengthMap.put(Planet.SAT, House.H1);
		directionalStrengthMap.put(Planet.MAR, House.H4);
		directionalStrengthMap.put(Planet.SUN, House.H4);
		
		return directionalStrengthMap;
	}
	
	public static Map<Planet,Map<House,List<Signification>>> getPlanetSignificationsMap(){
		
		Map<Planet,Map<House,List<Signification>>> significationsMap = new HashMap<Planet,Map<House,List<Signification>>>();
		
		Map<House,List<Signification>> sunMap = new HashMap<House,List<Signification>>();
		Map<House,List<Signification>> moonMap = new HashMap<House,List<Signification>>();
		Map<House,List<Signification>> mercuryMap = new HashMap<House,List<Signification>>();
		Map<House,List<Signification>> venusMap = new HashMap<House,List<Signification>>();
		Map<House,List<Signification>> marsMap = new HashMap<House,List<Signification>>();
		Map<House,List<Signification>> jupiterMap = new HashMap<House,List<Signification>>();
		Map<House,List<Signification>> saturnMap = new HashMap<House,List<Signification>>();
		Map<House,List<Signification>> rahuMap = new HashMap<House,List<Signification>>();
		Map<House,List<Signification>> ketuMap = new HashMap<House,List<Signification>>();
		
		List<Signification> sunH1List = new ArrayList<Signification>();
		sunH1List.add(Signification.Body);
		
		List<Signification> sunH2List = new ArrayList<Signification>();
		sunH2List.add(Signification.Dynasty);
		sunH2List.add(Signification.RightEyeMale);

		List<Signification> sunH3List = new ArrayList<Signification>();
		
		List<Signification> sunH4List = new ArrayList<Signification>();
		sunH4List.add(Signification.Heart);

		List<Signification> sunH5List = new ArrayList<Signification>();
		sunH5List.add(Signification.StomachOrAbdomen);

		List<Signification> sunH6List = new ArrayList<Signification>();
		sunH6List.add(Signification.FireOrInflammation);

		List<Signification> sunH7List = new ArrayList<Signification>();

		List<Signification> sunH8List = new ArrayList<Signification>();
		
		List<Signification> sunH9List = new ArrayList<Signification>();
		sunH9List.add(Signification.Father);

		List<Signification> sunH10List = new ArrayList<Signification>();
		sunH10List.add(Signification.RankOrStatusOrFame);

		List<Signification> sunH11List = new ArrayList<Signification>();

		List<Signification> sunH12List = new ArrayList<Signification>();
		sunH12List.add(Signification.PlaceOfBirth);
		sunH12List.add(Signification.LeftEyeFemale);


		sunMap.put(House.H1, sunH1List);
		sunMap.put(House.H2, sunH2List);
	    sunMap.put(House.H3, sunH3List);
		sunMap.put(House.H4, sunH4List);
		sunMap.put(House.H5, sunH5List);
		sunMap.put(House.H6, sunH6List);
		sunMap.put(House.H7, sunH7List);
		sunMap.put(House.H8, sunH8List);
		sunMap.put(House.H9, sunH9List);
		sunMap.put(House.H10, sunH10List);
		sunMap.put(House.H11, sunH11List);
		sunMap.put(House.H12, sunH12List);
		
    	List<Signification> moonH1List = new ArrayList<Signification>();
    	moonH1List.add(Signification.Infancy);
    	moonH1List.add(Signification.PlaceOfBirth);
		
		List<Signification> moonH2List = new ArrayList<Signification>();
		moonH2List.add(Signification.Food);
		moonH2List.add(Signification.FaceOrMouth);
		moonH2List.add(Signification.RightEyeFemale);

		List<Signification> moonH3List = new ArrayList<Signification>();
		moonH3List.add(Signification.ShortJourneys);
		moonH3List.add(Signification.UpperLung);
		
		List<Signification> moonH4List = new ArrayList<Signification>();
		moonH4List.add(Signification.LowerLung);
		moonH4List.add(Signification.Breasts);
		moonH4List.add(Signification.Mind);
		moonH4List.add(Signification.Mother);
		moonH4List.add(Signification.ResidenceOrHome);

		List<Signification> moonH5List = new ArrayList<Signification>();
		moonH5List.add(Signification.Emotions);
		
		List<Signification> moonH6List = new ArrayList<Signification>();

		List<Signification> moonH7List = new ArrayList<Signification>();
		moonH7List.add(Signification.OvariesOrUterus);
		moonH7List.add(Signification.PregnancyOrConception);
		moonH7List.add(Signification.DistantResidence);

		List<Signification> moonH8List = new ArrayList<Signification>();
		moonH8List.add(Signification.SeaCruise);
		
		List<Signification> moonH9List = new ArrayList<Signification>();

		List<Signification> moonH10List = new ArrayList<Signification>();

		List<Signification> moonH11List = new ArrayList<Signification>();

		List<Signification> moonH12List = new ArrayList<Signification>();
		moonH12List.add(Signification.LeftEyeMale);
		moonH12List.add(Signification.Sleep);
		moonH12List.add(Signification.Consiousness);
		moonH12List.add(Signification.DreamOrSubconsiousness);

		moonMap.put(House.H1, moonH1List);
		moonMap.put(House.H2, moonH2List);
	    moonMap.put(House.H3, moonH3List);
		moonMap.put(House.H4, moonH4List);
		moonMap.put(House.H5, moonH5List);
		moonMap.put(House.H6, moonH6List);
		moonMap.put(House.H7, moonH7List);
		moonMap.put(House.H8, moonH8List);
		moonMap.put(House.H9, moonH9List);
		moonMap.put(House.H10, moonH10List);
		moonMap.put(House.H11, moonH11List);
		moonMap.put(House.H12, moonH12List);
		
    	List<Signification> mercuryH1List = new ArrayList<Signification>();
		
		List<Signification> mercuryH2List = new ArrayList<Signification>();
		mercuryH2List.add(Signification.EarlyChildhood3to12);
		mercuryH2List.add(Signification.SmellOrNose);
		mercuryH2List.add(Signification.Speech);

		List<Signification> mercuryH3List = new ArrayList<Signification>();
		mercuryH3List.add(Signification.CommunicationOrLetter);
		mercuryH3List.add(Signification.Speech);
		
		List<Signification> mercuryH4List = new ArrayList<Signification>();
		mercuryH4List.add(Signification.Education);
		mercuryH4List.add(Signification.Clan);
		mercuryH4List.add(Signification.Friends);
		mercuryH4List.add(Signification.Relatives);
		
		List<Signification> mercuryH5List = new ArrayList<Signification>();
		mercuryH5List.add(Signification.Amusement);
		mercuryH5List.add(Signification.Intelligence);
		
		List<Signification> mercuryH6List = new ArrayList<Signification>();
		mercuryH6List.add(Signification.SmallInsterstine);
		mercuryH6List.add(Signification.MaternalUncle);
		
		List<Signification> mercuryH7List = new ArrayList<Signification>();
		mercuryH7List.add(Signification.Business);
		mercuryH7List.add(Signification.Trade);

		List<Signification> mercuryH8List = new ArrayList<Signification>();
		
		List<Signification> mercuryH9List = new ArrayList<Signification>();

		List<Signification> mercuryH10List = new ArrayList<Signification>();

		List<Signification> mercuryH11List = new ArrayList<Signification>();

		List<Signification> mercuryH12List = new ArrayList<Signification>();


		mercuryMap.put(House.H1, mercuryH1List);
		mercuryMap.put(House.H2, mercuryH2List);
	    mercuryMap.put(House.H3, mercuryH3List);
		mercuryMap.put(House.H4, mercuryH4List);
		mercuryMap.put(House.H5, mercuryH5List);
		mercuryMap.put(House.H6, mercuryH6List);
		mercuryMap.put(House.H7, mercuryH7List);
		mercuryMap.put(House.H8, mercuryH8List);
		mercuryMap.put(House.H9, mercuryH9List);
		mercuryMap.put(House.H10, mercuryH10List);
		mercuryMap.put(House.H11, mercuryH11List);
		mercuryMap.put(House.H12, mercuryH12List);

    	List<Signification> venusH1List = new ArrayList<Signification>();
		
		List<Signification> venusH2List = new ArrayList<Signification>();
		venusH2List.add(Signification.Jewellery);
		venusH2List.add(Signification.UpperNeckOrThroat);
		venusH2List.add(Signification.Poetry);

		List<Signification> venusH3List = new ArrayList<Signification>();
		venusH3List.add(Signification.MusicOrDance);
		venusH3List.add(Signification.Sport);
		venusH3List.add(Signification.LowerNeck);
		
		List<Signification> venusH4List = new ArrayList<Signification>();
		venusH4List.add(Signification.Pleasure);
		venusH4List.add(Signification.Vehicle);
		
		List<Signification> venusH5List = new ArrayList<Signification>();
		venusH5List.add(Signification.Romance);
		venusH5List.add(Signification.Entertainment);
		
		List<Signification> venusH6List = new ArrayList<Signification>();
		venusH6List.add(Signification.Kidneys);
		
		List<Signification> venusH7List = new ArrayList<Signification>();
		venusH7List.add(Signification.Ureter);
		venusH7List.add(Signification.Bladder);
		venusH7List.add(Signification.Partnership);
		venusH7List.add(Signification.SexAct);
		venusH7List.add(Signification.MarriagePartner);
				
		List<Signification> venusH8List = new ArrayList<Signification>();
		venusH8List.add(Signification.Sexuality);
		venusH8List.add(Signification.FemaleGenital);
		
		List<Signification> venusH9List = new ArrayList<Signification>();

		List<Signification> venusH10List = new ArrayList<Signification>();

		List<Signification> venusH11List = new ArrayList<Signification>();

		List<Signification> venusH12List = new ArrayList<Signification>();
		venusH12List.add(Signification.SexualPleasure);

		venusMap.put(House.H1, venusH1List);
		venusMap.put(House.H2, venusH2List);
	    venusMap.put(House.H3, venusH3List);
		venusMap.put(House.H4, venusH4List);
		venusMap.put(House.H5, venusH5List);
		venusMap.put(House.H6, venusH6List);
		venusMap.put(House.H7, venusH7List);
		venusMap.put(House.H8, venusH8List);
		venusMap.put(House.H9, venusH9List);
		venusMap.put(House.H10, venusH10List);
		venusMap.put(House.H11, venusH11List);
		venusMap.put(House.H12, venusH12List);

    	List<Signification> marsH1List = new ArrayList<Signification>();
    	marsH1List.add(Signification.EarlyAge1to3);
		
		List<Signification> marsH2List = new ArrayList<Signification>();

		List<Signification> marsH3List = new ArrayList<Signification>();
		marsH3List.add(Signification.Courage);
		marsH3List.add(Signification.YoungerSiblings);
		
		List<Signification> marsH4List = new ArrayList<Signification>();
		marsH4List.add(Signification.ImmovableProperty);
		
		List<Signification> marsH5List = new ArrayList<Signification>();

		List<Signification> marsH6List = new ArrayList<Signification>();
		marsH6List.add(Signification.EnemiesOrDisputesOrLitigation);
		marsH6List.add(Signification.Accident);
		marsH6List.add(Signification.Competition);
		marsH6List.add(Signification.Injury);
		
		List<Signification> marsH7List = new ArrayList<Signification>();
		marsH7List.add(Signification.MaleGenitals);
		
		List<Signification> marsH8List = new ArrayList<Signification>();
		marsH8List.add(Signification.Killing);
		
		List<Signification> marsH9List = new ArrayList<Signification>();

		List<Signification> marsH10List = new ArrayList<Signification>();
		marsH10List.add(Signification.ExecutiveAuthority);
		
		List<Signification> marsH11List = new ArrayList<Signification>();

		List<Signification> marsH12List = new ArrayList<Signification>();


		marsMap.put(House.H1, marsH1List);
		marsMap.put(House.H2, marsH2List);
	    marsMap.put(House.H3, marsH3List);
		marsMap.put(House.H4, marsH4List);
		marsMap.put(House.H5, marsH5List);
		marsMap.put(House.H6, marsH6List);
		marsMap.put(House.H7, marsH7List);
		marsMap.put(House.H8, marsH8List);
		marsMap.put(House.H9, marsH9List);
		marsMap.put(House.H10, marsH10List);
		marsMap.put(House.H11, marsH11List);
		marsMap.put(House.H12, marsH12List);

    	List<Signification> jupiterH1List = new ArrayList<Signification>();
		
		List<Signification> jupiterH2List = new ArrayList<Signification>();
		jupiterH2List.add(Signification.WealthOrBankBalance);

		List<Signification> jupiterH3List = new ArrayList<Signification>();
		jupiterH3List.add(Signification.SenseOfHearing);
		
		List<Signification> jupiterH4List = new ArrayList<Signification>();
		jupiterH4List.add(Signification.Happiness);
		jupiterH4List.add(Signification.Liver);
		
		List<Signification> jupiterH5List = new ArrayList<Signification>();
		jupiterH5List.add(Signification.Liver);
		jupiterH5List.add(Signification.LoveForDivine);
		jupiterH5List.add(Signification.Creativity);
		jupiterH5List.add(Signification.Children);
		jupiterH5List.add(Signification.GallBladder);
		jupiterH5List.add(Signification.Scholarship);
		
		List<Signification> jupiterH6List = new ArrayList<Signification>();
		jupiterH6List.add(Signification.Pancreas);

		List<Signification> jupiterH7List = new ArrayList<Signification>();
        jupiterH7List.add(Signification.PersonOfHusband);
        jupiterH7List.add(Signification.ProminenceInSociety);
        
		List<Signification> jupiterH8List = new ArrayList<Signification>();
		jupiterH8List.add(Signification.SuddenUnearnedIncome);
		
		List<Signification> jupiterH9List = new ArrayList<Signification>();
		jupiterH9List.add(Signification.GoodFortune);
		jupiterH9List.add(Signification.LongInlandJourneyOrPilgrimage);
		jupiterH9List.add(Signification.HigherEducation);
		jupiterH9List.add(Signification.ReligiousInclination);
		
		List<Signification> jupiterH10List = new ArrayList<Signification>();
		jupiterH10List.add(Signification.ManagerialAbility);
				
		List<Signification> jupiterH11List = new ArrayList<Signification>();
		jupiterH11List.add(Signification.SenseOfHearing);
		jupiterH11List.add(Signification.ElderSibling);
		jupiterH11List.add(Signification.IncomeGainSuccess);
		
		List<Signification> jupiterH12List = new ArrayList<Signification>();

		jupiterMap.put(House.H1, jupiterH1List);
		jupiterMap.put(House.H2, jupiterH2List);
	    jupiterMap.put(House.H3, jupiterH3List);
		jupiterMap.put(House.H4, jupiterH4List);
		jupiterMap.put(House.H5, jupiterH5List);
		jupiterMap.put(House.H6, jupiterH6List);
		jupiterMap.put(House.H7, jupiterH7List);
		jupiterMap.put(House.H8, jupiterH8List);
		jupiterMap.put(House.H9, jupiterH9List);
		jupiterMap.put(House.H10, jupiterH10List);
		jupiterMap.put(House.H11, jupiterH11List);
		jupiterMap.put(House.H12, jupiterH12List);

    	List<Signification> saturnH1List = new ArrayList<Signification>();
    	saturnH1List.add(Signification.Hair);
		
		List<Signification> saturnH2List = new ArrayList<Signification>();
		saturnH2List.add(Signification.Teeth);
		
		List<Signification> saturnH3List = new ArrayList<Signification>();
		
		List<Signification> saturnH4List = new ArrayList<Signification>();
		saturnH4List.add(Signification.Agriculture);
		saturnH4List.add(Signification.CommonManOrMasses);
		saturnH4List.add(Signification.Discomfort);
		

		List<Signification> saturnH5List = new ArrayList<Signification>();

		List<Signification> saturnH6List = new ArrayList<Signification>();
		saturnH6List.add(Signification.Debts);
		saturnH6List.add(Signification.DiseaseObstracle);
		saturnH6List.add(Signification.LargeInterstine);
		saturnH6List.add(Signification.ServiceOrServantOrSubordinate);
		saturnH6List.add(Signification.BodilyExertion);
		saturnH6List.add(Signification.Worries);
		
		List<Signification> saturnH7List = new ArrayList<Signification>();
		saturnH7List.add(Signification.LargeInterstine);
		
		List<Signification> saturnH8List = new ArrayList<Signification>();
		saturnH8List.add(Signification.DangerOrDeath);
		saturnH8List.add(Signification.BreakOrSetbackOrHumiliation);
		saturnH8List.add(Signification.History);
		saturnH8List.add(Signification.Longevity);
		saturnH8List.add(Signification.Colon);
		saturnH8List.add(Signification.SorrowOrSetback);
		
		List<Signification> saturnH9List = new ArrayList<Signification>();
		saturnH9List.add(Signification.LegalAffairs);
		
		List<Signification> saturnH10List = new ArrayList<Signification>();
		saturnH10List.add(Signification.Knees);
		saturnH10List.add(Signification.ProfessionOrDeedOrLivelihood);

		List<Signification> saturnH11List = new ArrayList<Signification>();
		saturnH11List.add(Signification.AnklesOrShins);
		
		List<Signification> saturnH12List = new ArrayList<Signification>();
		saturnH12List.add(Signification.Feet);
		saturnH12List.add(Signification.LossesOrSeperationOrExpenditure);

		saturnMap.put(House.H1, saturnH1List);
		saturnMap.put(House.H2, saturnH2List);
	    saturnMap.put(House.H3, saturnH3List);
		saturnMap.put(House.H4, saturnH4List);
		saturnMap.put(House.H5, saturnH5List);
		saturnMap.put(House.H6, saturnH6List);
		saturnMap.put(House.H7, saturnH7List);
		saturnMap.put(House.H8, saturnH8List);
		saturnMap.put(House.H9, saturnH9List);
		saturnMap.put(House.H10, saturnH10List);
		saturnMap.put(House.H11, saturnH11List);
		saturnMap.put(House.H12, saturnH12List);

    	List<Signification> rahuH1List = new ArrayList<Signification>();
		
		List<Signification> rahuH2List = new ArrayList<Signification>();

		List<Signification> rahuH3List = new ArrayList<Signification>();
		rahuH3List.add(Signification.Illusion);
		rahuH3List.add(Signification.Photography);
		
		List<Signification> rahuH4List = new ArrayList<Signification>();
		rahuH4List.add(Signification.Riots);

		List<Signification> rahuH5List = new ArrayList<Signification>();
		rahuH5List.add(Signification.DiplomacyOrDiplomat);
		rahuH5List.add(Signification.GameOfChance);
		rahuH5List.add(Signification.PaternalGrandfather);

		List<Signification> rahuH6List = new ArrayList<Signification>();
		rahuH6List.add(Signification.Fraud);
		
		List<Signification> rahuH7List = new ArrayList<Signification>();
		rahuH7List.add(Signification.Stranger);
		rahuH7List.add(Signification.MaternalGrandmother);
		
		List<Signification> rahuH8List = new ArrayList<Signification>();
		rahuH8List.add(Signification.UndiagonasableDisease);
		rahuH8List.add(Signification.Secret);
		rahuH8List.add(Signification.Research);
		rahuH8List.add(Signification.ViceOrFilthOrSin);
		
		List<Signification> rahuH9List = new ArrayList<Signification>();
		rahuH9List.add(Signification.JourneyAbroad);

		List<Signification> rahuH10List = new ArrayList<Signification>();

		List<Signification> rahuH11List = new ArrayList<Signification>();

		List<Signification> rahuH12List = new ArrayList<Signification>();
		rahuH12List.add(Signification.ImprisonmentOrPhysicalRestraint);


		rahuMap.put(House.H1, rahuH1List);
		rahuMap.put(House.H2, rahuH2List);
	    rahuMap.put(House.H3, rahuH3List);
		rahuMap.put(House.H4, rahuH4List);
		rahuMap.put(House.H5, rahuH5List);
		rahuMap.put(House.H6, rahuH6List);
		rahuMap.put(House.H7, rahuH7List);
		rahuMap.put(House.H8, rahuH8List);
		rahuMap.put(House.H9, rahuH9List);
		rahuMap.put(House.H10, rahuH10List);
		rahuMap.put(House.H11, rahuH11List);
		rahuMap.put(House.H12, rahuH12List);

    	List<Signification> ketuH1List = new ArrayList<Signification>();
		
		List<Signification> ketuH2List = new ArrayList<Signification>();

		List<Signification> ketuH3List = new ArrayList<Signification>();
		
		List<Signification> ketuH4List = new ArrayList<Signification>();

		List<Signification> ketuH5List = new ArrayList<Signification>();
		ketuH5List.add(Signification.MantraRecitation);

		List<Signification> ketuH6List = new ArrayList<Signification>();
		ketuH6List.add(Signification.AstralBeingOrPoltergeist);
		
		List<Signification> ketuH7List = new ArrayList<Signification>();

		List<Signification> ketuH8List = new ArrayList<Signification>();
		ketuH8List.add(Signification.PsychicPowerOrOccult);
		
		List<Signification> ketuH9List = new ArrayList<Signification>();
		ketuH9List.add(Signification.SpritualPursuit);
		
		List<Signification> ketuH10List = new ArrayList<Signification>();

		List<Signification> ketuH11List = new ArrayList<Signification>();

		List<Signification> ketuH12List = new ArrayList<Signification>();
		ketuH12List.add(Signification.PaternalGrandmother);
		ketuH12List.add(Signification.MaternalGrandfather);
		ketuH12List.add(Signification.Nirvana);
		ketuH12List.add(Signification.SuperconciousnessOrMysticism);

		ketuMap.put(House.H1, ketuH1List);
		ketuMap.put(House.H2, ketuH2List);
	    ketuMap.put(House.H3, ketuH3List);
		ketuMap.put(House.H4, ketuH4List);
		ketuMap.put(House.H5, ketuH5List);
		ketuMap.put(House.H6, ketuH6List);
		ketuMap.put(House.H7, ketuH7List);
		ketuMap.put(House.H8, ketuH8List);
		ketuMap.put(House.H9, ketuH9List);
		ketuMap.put(House.H10, ketuH10List);
		ketuMap.put(House.H11, ketuH11List);
		ketuMap.put(House.H12, ketuH12List);

		significationsMap.put(Planet.SUN, sunMap);
		significationsMap.put(Planet.MON, moonMap);
		significationsMap.put(Planet.MER, mercuryMap);
		significationsMap.put(Planet.VEN, venusMap);
		significationsMap.put(Planet.MAR, marsMap);
		significationsMap.put(Planet.JUP, jupiterMap);
		significationsMap.put(Planet.SAT, saturnMap);
		significationsMap.put(Planet.RAH, rahuMap);
		significationsMap.put(Planet.KET, ketuMap);
		
		return significationsMap;
	}
	
	public static Map<Integer, Double> getScoreMappingBasedOnPlanetCount(){
		Map<Integer, Double> planetCountToScoreMap = new HashMap<Integer, Double>();
		
		planetCountToScoreMap.put(0, 0.0);
		planetCountToScoreMap.put(1, 60.0);
		planetCountToScoreMap.put(2, 75.0);
		planetCountToScoreMap.put(3, 90.0);
		planetCountToScoreMap.put(4, 105.0);
		planetCountToScoreMap.put(5, 120.0);
		planetCountToScoreMap.put(6, 135.0);
		planetCountToScoreMap.put(7, 150.0);
		planetCountToScoreMap.put(8, 165.0);
		
		return planetCountToScoreMap;
	}
	
	public static Map<Zodiac, Planet> getSecondaryLords(){
		Map<Zodiac, Planet> secondaryLords = new HashMap<Zodiac, Planet>();
		
		secondaryLords.put(Zodiac.SCO, Planet.KET);
		secondaryLords.put(Zodiac.AQU, Planet.RAH);
		
		return secondaryLords;
	}
	
	public static Map<ZodiacDegreeRange, Planet> getKakshaMapping(){
		
		Map<ZodiacDegreeRange, Planet> kakshaMap = new HashMap<ZodiacDegreeRange, Planet>();
		
		kakshaMap.put(new ZodiacDegreeRange(0.0, 3.75), Planet.SAT);
		kakshaMap.put(new ZodiacDegreeRange(3.75, 7.5), Planet.JUP);
		kakshaMap.put(new ZodiacDegreeRange(7.5, 11.25), Planet.MAR);
		kakshaMap.put(new ZodiacDegreeRange(11.25, 15.0), Planet.SUN);
		kakshaMap.put(new ZodiacDegreeRange(15.0, 18.75), Planet.VEN);
		kakshaMap.put(new ZodiacDegreeRange(18.75, 22.5), Planet.MER);
		kakshaMap.put(new ZodiacDegreeRange(22.5, 26.25), Planet.MON);
		kakshaMap.put(new ZodiacDegreeRange(26.25, 30.0), Planet.ASC);
		
		return kakshaMap;
	}
}
