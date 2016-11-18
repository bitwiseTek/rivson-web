package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class LGAList {
	
private static Map<String, String> lgas = new TreeMap<String, String>();
	
	public static Map<String, String> listOfLGAs() {
		lgas.put("OA", "Obio-Akpor");
		lgas.put("EL", "Eleme");
		lgas.put("GK", "Gokana");
		lgas.put("KH", "Khana");
		lgas.put("OY", "Oyigbo");
		lgas.put("ON", "Opobo-Nkoro");
		lgas.put("AN", "Andoni");
		lgas.put("BO", "Bonny");
		lgas.put("DG", "Degema");
		lgas.put("AS", "Asari-Toru");
		lgas.put("AK", "Akuku-Toru");
		lgas.put("AB", "Abua-Odual");
		lgas.put("AW", "Ahoada-West");
		lgas.put("AE", "Ahoada-East");
		lgas.put("OE", "Ogba-Egbema-Ndoni");
		lgas.put("EM", "Emuoha");
		lgas.put("IK", "Ikwerre");
		lgas.put("OM", "Omuma");
		lgas.put("PH", "Port-Harcourt");
		lgas.put("OK", "Okrika");
		lgas.put("ET", "Etche");
		lgas.put("OG", "Ogu-Bolo");
		lgas.put("TA", "Tai");
		
		return lgas;
	}
	
	public static Map<String, String> getLGAs() {
		for (String lga : listOfLGAs().values()) {
			System.out.println(lga);
		}
		return lgas;
	}

}
