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

import com.vedic.astro.domain.SunriseSunsetData;

@Service("sunriseSunsetDataService")
@Transactional
public class SunriseSunsetDataService {

	@Value("${sunrise.sunset.data}")
	public String SUNRISE_SUNSET_DATA;

	public SunriseSunsetData getSunriseSunsetData(int locationId, String dob) {

		Document doc = null;
		String url = null;

		StringTemplate urlTemplate = new StringTemplate(SUNRISE_SUNSET_DATA);
		urlTemplate.setAttribute("locationId", locationId);
		urlTemplate.setAttribute("dob", dob);

		SunriseSunsetData sunriseSunsetData = null;

		try {

			url = urlTemplate.toString();
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
			elements.remove(0);
			elements.remove(1);

			ListIterator<Element> elementsItr = elements.listIterator();

			while (elementsItr.hasNext()) {

				Element element = elementsItr.next();
				Elements divElements = element.getElementsByTag("div");
				sunriseSunsetData = convertToSunriseSunsetData(
						divElements.get(1).text(), divElements.get(2).text());
			}

			System.out.println("sunriseSunsetData = " + sunriseSunsetData);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sunriseSunsetData;

	}

	private SunriseSunsetData convertToSunriseSunsetData(String sunrise,
			String sunset) {

		String sunriseTime = sunrise.substring(sunrise.indexOf("=") + 1,
				sunrise.length()).trim();

		String sunsetTime = sunset.substring(sunset.indexOf("=") + 1,
				sunset.length()).trim();

		return new SunriseSunsetData(sunriseTime, sunsetTime);
	}

}
