package ua.nure.tuhaibei.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Part2 {
	
	  private static final int N = 10000;
	  private static final int K = 4;
	    
	  public static long  removeByIterator(List<Integer> list, int k) {
		  long before = System.currentTimeMillis();
		  int i = 0;
	        Iterator<?> it;
	        while (list.size() != 1) {

	            it = list.iterator();
	            while (it.hasNext()) {
	                it.next();
	                i++;
	                if (i == k) {
	                    it.remove();
	                    i = 0;
	                }
	            }
	        }
	        long after = System.currentTimeMillis();
			return after - before;
	    }

	    public static long  removeByIndex(List<Integer> list, int k) {
			long before = System.currentTimeMillis();
	        int ri = 0;
	        while (!list.isEmpty()) {
	            int index = ri + k - 1;

	            if (index > list.size() - 1) {
	                index %= list.size();
	            }
	            list.remove(index);
	            ri = index;
	        }
	        long after = System.currentTimeMillis();
	        return after - before;
	    }

	    public static List<Integer> init(List<Integer> list) {
	        for(int i = 0; i < N; i++) {
	            list.add(new Random().nextInt());
	        }
			return list;
	    }

	    public static void main(String[] args) {
	    	List<Integer> arrayList = init(new ArrayList<>());
	        List<Integer> linkedList = init(new LinkedList<>());

	        System.out.println("ArrayList#Index: " + removeByIndex(arrayList, K) + " ms");
	        System.out.println("LinkedList#Index: " + removeByIndex(linkedList, K) + " ms");

	        arrayList = init(new ArrayList<>());
	        linkedList = init(new LinkedList<>());

	        System.out.println("ArrayList#Iterator: " + removeByIterator(arrayList, K) + " ms");
	        System.out.println("LinkedList#Iterator: " + removeByIterator(linkedList, K) + " ms");
	    }
}
