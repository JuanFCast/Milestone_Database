package ui;

import java.util.Comparator;
import java.util.List;

import model.Person;
import util.RBT;

public class MainT {

	public static void main(String [] juank) {
		RBT<Person> rb = new RBT<>(Comparator.comparing(Person::name));
		
		rb.add(new Person("Juan", "", null, "", "", ""));
		rb.add(new Person("Moises", "", null, "", "", ""));
		rb.add(new Person("Abraham", "", null, "", "", ""));
		rb.add(new Person("Luisa", "", null, "", "", ""));
		
		List<Person> l = rb.listInOrder();
		
		for (Person person : l) {
			if(person.name().contains("a")) {
				System.out.println(person + " contiene la a");
			}
			
			System.out.println(person);
		}
		
	}
	
}
