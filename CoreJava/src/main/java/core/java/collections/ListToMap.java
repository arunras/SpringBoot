package core.java.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import core.java.pojo.Student;

public class ListToMap {
	
	// List to Mapp - Collectors.toMap()
	public void convertListToMap () {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "Wolverine", 1.0));
		list.add(new Student(2, "Jean", 2.0));
		list.add(new Student(3, "Megnato", 3.0));
		list.add(new Student(4, "Storm", 3.5));
		list.add(new Student(5, "Black", 4.0));
		
		// key = id, value = name
		Map<Integer, String> map1 = list.stream().collect(
        Collectors.toMap(Student::getId, Student::getName)
        );
		System.out.println("Result 1: " + map1);
		
		// key = name, value = gpa
		Map<String, Double> map2 = list.stream().collect(
        Collectors.toMap(x -> x.getName(), x -> x.getGpa())
        );
		System.out.println("Result 2: " + map2);
	}
	
	// List to Map - Duplicated Key
	public void convertListToMapDuplicatedKey () {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "Wolverine", 1.0));
		list.add(new Student(2, "Jean", 2.0));
		list.add(new Student(3, "Megnato", 3.0));
		list.add(new Student(4, "Storm", 3.5));
		list.add(new Student(5, "Black", 4.0));
		list.add(new Student(5, "Storm", 4.0));
		
		// key = name, value = id
		Map<String, Integer> map1 = list.stream().collect(
        Collectors.toMap(Student::getName, Student::getId, (oldKey, newKey) -> newKey)
        );
		System.out.println("Result 1: " + map1);
	}
	
//List to Map - Sort & Collect
	public void convertListToMapSort () {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "Wolverine", 1.0));
		list.add(new Student(2, "Jean", 2.0));
		list.add(new Student(3, "Megnato", 3.0));
		list.add(new Student(4, "Storm", 3.5));
		list.add(new Student(5, "Black", 4.0));
		
		// key = name, value = id
		Map<Integer, String> map1 = list.stream()
      .sorted(Comparator.comparingInt(Student::getId).reversed())
      .collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
		System.out.println("Sorted: " + map1);
	}
}
