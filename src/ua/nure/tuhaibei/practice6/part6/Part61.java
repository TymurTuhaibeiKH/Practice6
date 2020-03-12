package ua.nure.tuhaibei.practice6.part6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Part61 {
	public static void frequency(String text) {
        Map<String, Integer> maxWords = new TreeMap<>(Collections.reverseOrder());
        String[] txtArr = text.trim().split(" ");
        txtArr = removeNullValue(txtArr);

        Map<String, Integer> frequencyList = new LinkedHashMap<>();
        for (int i = 0; i < txtArr.length; i++) {
            int count = 1;
            for (int j = 0; j < txtArr.length; j++) {
                if (i == j) {
                    continue;
                }

                if (frequencyList.containsKey(txtArr[i])) {
                    break;
                }

                if (txtArr[j].equals(txtArr[i])) {
                    count++;
                }
            }
            if (!frequencyList.containsKey(txtArr[i])) {
                frequencyList.put(txtArr[i], count);
            }
        }

        for (int i = 0; i < 3; i++) {
            String maxWord = "";
            int maxCount = 1;
            for (Map.Entry<String, Integer> element : frequencyList.entrySet()) {
                if (element.getValue() > maxCount && !maxWords.containsKey(element.getKey())) {
                    maxWord = element.getKey();
                    maxCount = element.getValue();
                }
            }
            maxWords.put(maxWord, maxCount);
        }


        for (Map.Entry<String, Integer> elem : maxWords.entrySet()) {
            System.out.println(elem.getKey() + " ==> " + elem.getValue());
        }
    }
	
	 public static String[] removeNullValue(String[] firstArray) {
	        List<String> list = new ArrayList<>();
	        for (String s : firstArray) {
	            if (s != null && s.length() > 0) {
	                list.add(s);
	            }
	        }

	        return list.toArray(new String[0]);
	    }

}
