package com.convert;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

	@GetMapping("/number")
	public String intToRoman(@RequestParam("numVal") int num) {
		try {
			return convertToRoman(num);
		} catch (Exception e) {
			return "Could not convert " + num;
		}
	}

	/**
	 * Converts the given integer to Roman numerals
	 * 
	 * @param num
	 * @return Roman numerals
	 */
	public String convertToRoman(int num) {
		String[] thousands = { "", "M", "MM", "MMM" };
		String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + units[num % 10];
	}

}