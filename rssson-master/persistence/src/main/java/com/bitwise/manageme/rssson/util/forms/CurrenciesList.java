package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class CurrenciesList {

private static Map<String, String> currencies = new TreeMap<String, String>();
	
	public static Map<String, String> listOfCurrencies() {
		currencies.put("NG", "NGN");
		currencies.put("US", "USD");
		currencies.put("UK", "GBP");
		currencies.put("JP", "YEN");
		
		return currencies;
	}
	
	public static Map<String, String> getCurrencies() {
		for (String currency : listOfCurrencies().values()) {
			System.out.println(currency);
		}
		return currencies;
	}
}
