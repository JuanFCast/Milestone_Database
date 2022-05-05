package model;

import util.AVL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import util.AVL;
import util.RBT;


public class Database {
	
	//Binary's Tree
	private RBT<Person> perID;
	private AVL<Person> perName;
	private AVL<Person> perSurName;
	private AVL<Person> perFullName;

	private final double MAXPOPULATION = 1100413410; 
	private final String NAME_PATH = "data/names.csv";
	private final String SURNAME_PATH = "data/Names_2010Census.csv";

	public Database() throws IOException{
		perID = new RBT<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.id().compareTo(p2.id());
			}
		});
		perName = new AVL<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.name().compareTo(p2.name());
			}
		});
		perSurName = new AVL<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.surname().compareTo(p2.surname());
			}
		});
		perFullName = new AVL<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.fullName().compareTo(p2.fullName());
			}
		});
	}
	
	public void generateDATA(double n) {
		
	}
	
	private Person generatePerson() {
		
		return null;
	}

	public String generateHeight(){
		RandomGenerator e = new RandomGenerator(100, 200);
		return (e.generateInt() + " cm");
	}

	public void generateAge(){
		RandomGenerator a = new RandomGenerator(0, 14);
		RandomGenerator b = new RandomGenerator(15, 24);
		RandomGenerator c = new RandomGenerator(25, 54);
		RandomGenerator d = new RandomGenerator(55, 64);
		RandomGenerator e = new RandomGenerator(64, 100);
		
		age = (a.generateInt() + " años");
	}
    
    public double getMAXPOPULATION() {
    	return MAXPOPULATION;
    }
}

