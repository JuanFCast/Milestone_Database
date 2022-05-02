package model;

<<<<<<< HEAD
=======
import util.AVL;
=======
import java.io.BufferedReader;
import java.io.FileReader;
>>>>>>> 8a95ec6707bb9b8f8f0f01714eb234491c5bc3fe
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
	
	private String age;

	public Database() throws IOException{
		perID = new RBT<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.id().compareTo(p2.id());
			}
		});
	}

	public void generateHeight(){
		RandomGenerator e = new RandomGenerator(100, 200);
		String height = "";
		height = (e.generateInt() + " cm");
		System.out.println(height = (e.generateInt() + " cm"));
	}

	public void generateAge(){
		RandomGenerator a = new RandomGenerator(0, 14);
		RandomGenerator b = new RandomGenerator(15, 24);
		RandomGenerator c = new RandomGenerator(25, 54);
		RandomGenerator d = new RandomGenerator(55, 64);
		RandomGenerator e = new RandomGenerator(64, 100);
		
		age = (a.generateInt() + " años");
		
	}

    public void generate(){
    	
    }
    
    public double getMAXPOPULATION() {
    	return MAXPOPULATION;
    }

}

