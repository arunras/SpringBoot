package core.java.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToList {
	
	
	public void convertMapToList() {
		Map <Integer, String> map = new HashMap<>();
		map.put(100, "Wolverine");
		map.put(200, "Jean");
		map.put(300, "Megnato");
		map.put(400, "Storm");
		map.put(500, "Black");
		
		// Convert all Map keys to a List
		List<Integer> listKey = new ArrayList<>(map.keySet());
		
	  // Convert all Map values to a List
		List<String> listValues = new ArrayList<>(map.values());
		
		System.out.println("List Keys: " + listKey);
		System.out.println("List Values: " + listValues);
		
		// Java 8, convert all Map keys to a List
		List<Integer> listKey8 = map.keySet().stream().collect(Collectors.toList());
		System.out.println("List8 Keys: " + listKey8);
		
		// Java 8, convert all Map keys to a List
		List<String> listValues8 = map.values().stream().collect(Collectors.toList());
		System.out.println("List8 Keys: " + listValues8);
		
		// Java 8, filter
		List<String> listNameFilter8 = map.values().stream()
				.filter(x -> !"Storm".equalsIgnoreCase(x))
				.collect(Collectors.toList());
		
		System.out.println("\nList Name Fildered forEach()");
		listNameFilter8.forEach(System.out::println);
	}
}
