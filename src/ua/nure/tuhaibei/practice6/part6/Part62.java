package ua.nure.tuhaibei.practice6.part6;

import java.util.ArrayList;
import java.util.List;

public class Part62 {
	 public static void length(String text) {
	        List<String> maxWords = new ArrayList<>();
	        String[] txtArr = text.trim().split(" ");
	        for (int j = 0; j < 3; j++) {
	            String max = txtArr[0];
	            for (int i = 1; i < txtArr.length; i++) {
	                if (txtArr[i].length() > max.length() && !maxWords.contains(txtArr[i])) {
	                    max = txtArr[i];
	                }
	            }
	            maxWords.add(max);
	        }

	        maxWords.sort((o1, o2) -> o2.length() - o1.length());
	        for (String s : maxWords) {
	            System.out.println(s + " ==> " + s.length());
	        }
	    }
}
