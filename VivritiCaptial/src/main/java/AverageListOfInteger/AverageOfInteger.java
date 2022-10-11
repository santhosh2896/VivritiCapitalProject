package AverageListOfInteger;

import java.util.ArrayList;
import java.util.List;

public class AverageOfInteger {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		byStreamAPI(list);
	}

	public static void byStreamAPI(List<Integer> list) {
		double average = list.stream().mapToInt(num->num).average().getAsDouble();
		
		System.out.println(average);
		
	}

}
