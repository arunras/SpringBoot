package core.java;

import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) {
		/*
		MapToList mapToList = new MapToList();
		mapToList.convertMapToList();
		*/
		Comparator<String> c =
	      (String lhs, String rhs) ->
	        {
	          System.out.println("I am comparing " +
	                             lhs + " to " + rhs);
	          return lhs.compareTo(rhs);
	        };
	    int result = c.compare("Hello", "World");
	  System.out.println(result);
	}
}
