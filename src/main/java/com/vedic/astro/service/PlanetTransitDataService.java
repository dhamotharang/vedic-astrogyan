package com.vedic.astro.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
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

@Service("planetTransitDataService")
@Transactional
public class PlanetTransitDataService {

	@Value("${planet.transit.data}")
	public String PLANET_TRANSIT_DATA;
	
	public List<PlanetTransitData> getPlanetTransitData(Planet planet,
			int fromYear, int toYear) {
		List<PlanetTransitData> yearRangeData = new ArrayList<PlanetTransitData>();
		for (int i = fromYear; i <= toYear; i++) {
			List<PlanetTransitData> yearData = getPlanetTransitData(planet, i);
			yearRangeData.addAll(yearData);
		}

		return yearRangeData;
	}

	public List<PlanetTransitData> getPlanetTransitData(Planet planet, int year) {

		List<PlanetTransitData> yearData = new ArrayList<PlanetTransitData>();

		Document doc = null;
		String url = null;

		StringTemplate urlTemplate = new StringTemplate(PLANET_TRANSIT_DATA);
		urlTemplate.setAttribute("planet", planet.getHindiName().toLowerCase());

		try {

			url = urlTemplate.toString() + "?year=" + year;
			System.out.println("url = " + url);

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

			Elements elements = doc.getElementsByClass("festBlocksBackground");
			ListIterator<Element> elementsItr = elements.listIterator(0);

			
			while (elementsItr.hasNext()) {

				Element element = elementsItr.next();
				Elements trElements = element.getElementsByClass("dpPgTbl");
				ListIterator<Element> trElementsItr = trElements.listIterator();

				while (trElementsItr.hasNext()) {
					Element trElement = trElementsItr.next();
					yearData.add(convertToPlanetTransitData(planet, trElement.getElementsByClass("yogaInfoSingleTi")
							.text(),
							trElement.getElementsByClass("yogaInfoSingle")
									.text()));
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return yearData;

	}

	private PlanetTransitData convertToPlanetTransitData(Planet planet, String movement, String date) {

		String zodHindiName = movement.substring(movement.indexOf("to") + 3,
				movement.length()).trim();
		String dateInString = date.substring(0, date.indexOf("(")).trim();
		PlanetTransitData planetTransitData = new PlanetTransitData(planet, DateUtil.toDate(dateInString, "MMM dd, yyyy"), Zodiac.fromHindiName(zodHindiName));
	    
		return planetTransitData;
	}

}
