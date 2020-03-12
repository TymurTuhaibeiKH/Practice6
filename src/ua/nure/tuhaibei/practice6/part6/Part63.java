package ua.nure.tuhaibei.practice6.part6;

import java.util.ArrayList;
import java.util.List;

public class Part63 {
	  public static void duplicates(String text) {
	        List<String> listDuplicates = new ArrayList<>();
	        String[] txtArr = text.trim().split(" ");
	        txtArr = removeNullValue(txtArr);

	        int maxCountDuplicates = 3;
	        int countDuplicates = 0;
	        for (int i = 0; i < txtArr.length; i++) {
	            for (int j = 0; j < txtArr.length; j++) {
	                if (i == j) {
	                    continue;
	                }

	                if (txtArr[j].equals(txtArr[i]) && !listDuplicates.contains(txtArr[i])) {
	                    listDuplicates.add(txtArr[i]);
	                    countDuplicates++;
	                    break;
	                }
	            }
	            if (countDuplicates == maxCountDuplicates) {
	                break;
	            }
	        }

	        for (String s : listDuplicates) {
	            System.out.println(new StringBuilder(s.toUpperCase()).reverse());
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
