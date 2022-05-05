package model;

import util.AVL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

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
	
	public void generate(double data) throws IOException{
		for (int i = 0; i<data ;i++) {
			Person p = generatePerson();
			perID.add(p);
		}
	}

	public String generateHeight(){
		RandomGenerator e = new RandomGenerator(100, 200);
		return (e.generateInt() + " cm");
		
	}
	
	public LocalDate generateBirth() { 
		return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))); 
	}

	

	public Person generatePerson() throws IOException{
		RandomGenerator rn = new RandomGenerator(1, 6782);
		RandomGenerator rl = new RandomGenerator(2, 162254);
		int n = rn.generateInt();
		String name = generateName(n);
		String lastName = generateLastName(rl.generateInt());
		Gender gender = generateGender(n);
		String birth = generateBirth()+"";
		String height = generateHeight();
		String nacionality = "Colobia";
		return new Person(name, lastName, gender, birth, height, nacionality);
	}
	
	public String generateName(int r) throws IOException{
		BufferedReader bn = new BufferedReader(new FileReader(NAME_PATH));
		String n = "";
		
		for (int i= 0; i<r; i++) {
			n=bn.readLine();
			
			
		}
		String [] name = n.split(","); 		
		return name[0];
		
	}
	
	public String generateLastName(int r) throws IOException{
		BufferedReader bl = new BufferedReader(new FileReader(SURNAME_PATH));
		String n = "";
		
		

		
		for (int i= 0; i<r; i++) {
			n=bl.readLine();
			
			
		}
		String [] lastName = n.split(","); 		
		return lastName[0];
	}
	
	public Gender generateGender(int g) throws IOException{
		BufferedReader bg = new BufferedReader(new FileReader(NAME_PATH));
		String ge = "";
		
		for (int i= 0; i<g; i++) {
			ge = bg.readLine();
		}
		
		String [] lastName = ge.split(",");
		
		if (lastName[1].equals("boy")) {
			return Gender.male;
		}else
			return Gender.female;
	}
	
	
	public String generateNacionality(){
		return null;

	}


	public double getMAXPOPULATION() {
		return MAXPOPULATION;
	}
	
	


}

