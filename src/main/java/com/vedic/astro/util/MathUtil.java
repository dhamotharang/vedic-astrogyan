package com.vedic.astro.util;

import java.math.BigDecimal;

import com.vedic.astro.enums.DecimalPlace;

public class MathUtil {

	private MathUtil() {
	}

	public static Integer calcDegreesInMinutes(Double value) {

		Double decimalValue = value - value.intValue();
		return value.intValue() * 60
				+ new Long(Math.round(decimalValue * 100)).intValue();
	}

	public static double round(double x, int scale) {
		return round(x, scale, BigDecimal.ROUND_HALF_UP);
	}

	public static double round(double x, int scale, int roundingMethod) {
		try {
			return (new BigDecimal(Double.toString(x)).setScale(scale,
					roundingMethod)).doubleValue();
		} catch (NumberFormatException ex) {
			if (Double.isInfinite(x)) {
				return x;
			} else {
				return Double.NaN;
			}
		}
	}

	public static int place(Integer number, DecimalPlace decimalPlace) {
		int unit = (number / decimalPlace.getValue()) % 10;
		return unit * decimalPlace.getValue();
	}

	public static void main(String[] args) {
		System.out.println(place(29840, DecimalPlace.Unit));
	}
}
