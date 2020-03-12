package ua.nure.tuhaibei.practice6.part4;


public class Part4 {

	 public static void main(String[] args) {
	        Range revers = new Range(3, 7, true);
	        Range withOutRevers = new Range(3, 7);
	        
	        while (withOutRevers.hasNext()) {
	            System.out.println(withOutRevers.next());
	        }
	        	        
	        while (revers.hasNext()) {
	            System.out.println(revers.next());
	        }
	        
	    }
	
}
