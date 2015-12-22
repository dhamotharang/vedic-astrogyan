package com.vedic.astro.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ListIterator;

import org.antlr.stringtemplate.StringTemplate;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.PlanetTransitData;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.util.DateUtil;
import com.vedic.astro.vo.AbsolutePlanetaryPositions;
import com.vedic.astro.vo.PlanetAbsoluteLocation;

@Service("planetPositionsDataService")
@Transactional
public class PlanetPositionsDataService {

	@Value("${planet.positions.data}")
	public String PLANET_POSITIONS_DATA;

	public AbsolutePlanetaryPositions getPlanetPositionsData(String dob,
			String tob, Integer locationId) {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = new AbsolutePlanetaryPositions();

		Document doc = null;
		String url = null;

		StringTemplate urlTemplate = new StringTemplate(PLANET_POSITIONS_DATA);
		urlTemplate.setAttribute("locationId", locationId);
		urlTemplate.setAttribute("dob", dob);
		urlTemplate.setAttribute("tob", tob);

		try {

			url = urlTemplate.toString();
	//		System.out.println("url = " + url);

			// Create a URL for the desired page
			Connection con = Jsoup
					.connect(url)
					.userAgent(
							"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
					.timeout(1000000);
			Connection.Response resp = con.execute();
			if (resp.statusCode() == 200) {
				doc = con.get();
			}

			Elements elements = doc.getElementsByClass("hinduTable");
			ListIterator<Element> elementsItr = elements.listIterator(1);

			while (elementsItr.hasNext()) {

				Element element = elementsItr.next();
				Elements trElements = element.getElementsByTag("tr");
				ListIterator<Element> trElementsItr = trElements.listIterator();

				while (trElementsItr.hasNext()) {
					Element trElement = trElementsItr.next();
					Elements tdElements = trElement.getElementsByTag("td");

					if (!tdElements.isEmpty()) {
						PlanetAbsoluteLocation planetAbsoluteLocation = convertToPlanetPositionData(
								tdElements.get(0).text(), tdElements.get(5)
										.text());
						if (planetAbsoluteLocation.getPlanet() != null) {
							if (planetAbsoluteLocation.getPlanet().equals(
									Planet.ASC)) {
								absolutePlanetaryPositions
										.setLagna(planetAbsoluteLocation
												.getDegrees());

							} else {
								absolutePlanetaryPositions
										.addAbsolutePlanetPosition(planetAbsoluteLocation);

							}
						}
					}
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return absolutePlanetaryPositions;

	}

	private PlanetAbsoluteLocation convertToPlanetPositionData(
			String planetString, String position) {

		PlanetAbsoluteLocation planetAbsoluteLocation = null;
		String planetAsString = planetString.substring(0,
				planetString.indexOf("(")).trim();
		Planet planet = Planet.fromEnglishName(planetAsString);
//		System.out.println("planet = " + planet);
		Double degrees = Double.valueOf(position);

//		System.out.println("degrees = " + degrees);

		planetAbsoluteLocation = new PlanetAbsoluteLocation(planet, degrees);

		return planetAbsoluteLocation;
	}

}
