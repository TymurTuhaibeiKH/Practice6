package ua.nure.tuhaibei.practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {

	private List<Integer> list;

	public Parking(int size) {
		this.list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			list.add(0);
		}

	}

	public boolean arrive(int k) {
		if (k < 0 || k > list.size()) {
			throw new IllegalArgumentException();
		}

		if (list.get(k).equals(0)) {
			list.set(k, 1);
			return true;
		} else {			
			for (int i = k + 1; i < list.size(); i++) {
				if (list.get(i).equals(0)) {
					list.set(i, 1);
					return true;
				}
				if(list.size() <= i + 1) {
						for (int j = 0; j < list.size(); j++) {
							if(list.get(j).equals(0)) {
								list.set(j, 1);
								return true;
							}
						}
				}
			}
		} 
		return false;
	}
	
	public boolean depart(int k) {
		if (k < 0 || k > list.size()) {
			throw new IllegalArgumentException();
		}
		if(!list.get(k).equals(0)) {
			list.set(k, 0);
			return true;
		}
		return false;
	}

	public void print() {
		System.out.println(list);
	}
	
}
