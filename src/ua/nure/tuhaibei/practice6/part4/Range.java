package ua.nure.tuhaibei.practice6.part4;

import java.util.Iterator;

public class Range implements Iterator<Integer>{
	 private int n;
     private int m;
     private int v;
     boolean reverse;

	public Range(int n, int m) {
		this.n = n;
		this.m = m;
	}
	public Range(int n, int m, boolean reverse) {
		this.n = n;
		this.m = m;
		this.reverse = reverse;
	}
	 
	
	@Override
	public boolean hasNext() {
		 return n <= m;
	}
	@Override
	public Integer next() {
		   if (!reverse) {
               v = n;
               n++;
           } else {
               v = m;
               m--;
           }
           return v;
       }
	
	
}
