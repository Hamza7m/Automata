package otomata_odevi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _20670310030_FTS_Makinasi {
	public static Map<String, Map<String, String[][]>> FST = new HashMap<>();
	static ArrayList<String> durumler = new ArrayList<String>();
	static ArrayList<String> giris = new ArrayList<String>();
	static ArrayList<String> gecisDurum = new ArrayList<String>();
	static ArrayList<String> cikis = new ArrayList<String>();

	public static void islem(String line) {
		String[] parts = line.split("\\t", 2);

		if (parts.length == 2) {
			String content = parts[1].trim().substring(1, parts[1].length() - 1);

			String[] transitions = content.split("\\)\\s*\\(");

			for (String transition : transitions) {
				String[] transitionParts = transition.split(",");

				if (transitionParts.length == 2) {
					gecisDurum.add(transitionParts[0].trim());

					cikis.add(transitionParts[1].trim());
					setTo();

				}
			}

		}

	}

	public static void setTo() {
	    int size = gecisDurum.size();
	    String[][] mergedArray = new String[size][2];

	    int i = 0;
	    for (String gecis : gecisDurum) {
	        mergedArray[i][0] = gecis;
	        i++;
	    }

	    i = 0;
	    for (String output : cikis) {
	        mergedArray[i][1] = output;
	        i++;
	    }

	    int mergedArrayIndex = 0;
	    int mergedArrayLen = mergedArray.length;
	    for (String stat : durumler) {
	        Map<String, String[][]> innerMap = new HashMap<>();

	        for (String input : giris) {
	            if (mergedArrayIndex < mergedArrayLen) {
	                String[] mergedValue = mergedArray[mergedArrayIndex];

	                String[][] transitionArray = new String[1][2];
	                transitionArray[0][0] = mergedValue[0];
	                if (mergedValue.length > 1) {
	                    transitionArray[0][1] = mergedValue[1];
	                }
	                innerMap.put(input, transitionArray);
	                mergedArrayIndex++;
	            }
	        }

	        FST.put(stat, innerMap);
	    }
	}

	}

