package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import util.RBT;

class RBTTest {
	
	private RBT<Person> rb;

	public void setupScenary1() {
		rb = new RBT<>(Comparator.comparing(Person::name));
	}
	
	@Test
	void add() {
		setupScenary1();
		boolean v = rb.add(new Person("Juan Camilo", "Ramirez", Gender.male, "21-06-1999", "171", "Colombian"));
		
		if(v == false) {
			fail("Not yet implemented");
		}
	}
	
	@Test
	void remove() {
		setupScenary1();
		rb.add(new Person("Juan Camilo", "Ramirez", Gender.male, "21-06-1999", "171", "Colombian"));
		try {
			rb.remove(new Person("Juan Camilo", "", null, "", "", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!rb.isEmpty()) {
			fail("Not yet implemented");
		}
	}
	
	@Test
	void search() {
		setupScenary1();
		rb.add(new Person("Juan Camilo", "Ramirez", Gender.male, "21-06-1999", "171", "Colombian"));
		
		Person p = rb.search(new Person("Juan Camilo", "", null, "", "", ""));
		
		if(p.name().equals("Juan Camilo") && p.surname().equals("Ramirez")) {
			
		} else {
			fail("Not yet implemented");
		}
	}

}
