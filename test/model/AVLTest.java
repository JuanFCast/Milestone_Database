package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import util.AVL;
import util.Node;

class AVLTest {
	
	public void setupScenary1() {

	}

	@Test
	void testAdd() {
		setupScenary1();

		Node<Person> c = new Node<>(new Person("Childe", "", Gender.male, "01/04/2003", "1.64", "Colombiano"));
		Node<Person> b = new Node<>(new Person("Beidu", "", Gender.female, "01/04/2003", "1.64", "Colombiano"));
		Node<Person> a = new Node<>(new Person("Ayaka", "", Gender.female, "01/04/2003", "1.64", "Colombiano"));
		Node<Person> d = new Node<>(new Person("Diona", "", Gender.female, "01/04/2003", "1.64", "Colombiano"));
		Node<Person> b1 = new Node<>(new Person("Benet", "", Gender.male, "01/04/2003", "1.64", "Colombiano"));
		AVL<Person> avl = new AVL<>(new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.name().compareTo(p2.name());
			}
		});

		assertTrue(true);

	}

}
