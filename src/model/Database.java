package model;

import util.AVL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import util.RBT;


public class Database {
	
	//Binary's Tree
	private RBT<Person> perID;
	private AVL<Person> perName;
	private AVL<Person> perSurName;
	private AVL<Person> perFullName;
	private List<Person> lperName;
	private List<Person> lperSurName;
	private List<Person> lperFullName;

	private final double MAXPOPULATION = 1100413410; 
	private final String NAME_PATH = "data/names.csv";
	private final String SURNAME_PATH = "data/Names_2010Census.csv";
	
	private HashMap<Integer, String> names;
	private HashMap<Integer, String> lastNames;
	private HashMap<Integer, String> genders;
	
	

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
		
		names = new HashMap<>();
		lastNames = new HashMap<>();
		genders = new HashMap<>();
		configHash();
	}
	
	public void generate() throws IOException{
		Person p = generatePerson();
		perID.add(p);
		perName.add(p);
		perSurName.add(p);
		perFullName.add(p);
	}
	
	private Person generatePerson() throws IOException{
		RandomGenerator rn = new RandomGenerator(1, 6782);
		RandomGenerator rl = new RandomGenerator(2, 162254);
		int n = rn.generateInt();
		String name = generateName(n);
		String lastName = generateLastName(rl.generateInt());
		Gender gender = generateGender(n);
		LocalDate birth = generateBirth();
		String height = generateHeight();
		String nacionality = "Colombia";
		return new Person(name, lastName, gender, birth, height, nacionality);
	}

	private String generateHeight(){
		RandomGenerator e = new RandomGenerator(100, 200);
		return (e.generateInt() + " cm");
	}
	
	private LocalDate generateBirth() { 
		return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))); 
	}
	
	private String generateName(int r) throws IOException{
		return names.get(r);
	}
	
	private String generateLastName(int r) throws IOException{		
		return lastNames.get(r);
	}
	
	private Gender generateGender(int g) throws IOException{
		String gender = genders.get(g);
		
		if (gender.equals("boy")) {
			return Gender.male;
		}else
			return Gender.female;
	}
	
	
	public String generateNacionality(){
		return null;
	}
	
	private void configHash() throws IOException {
		BufferedReader bn = new BufferedReader(new FileReader(NAME_PATH));
		BufferedReader bl = new BufferedReader(new FileReader(SURNAME_PATH));
		
		for(int i = 1; i <= 6782; i++) {
			String n = bn.readLine();
			
			String p[] = n.split(",");
			
			names.put(i, p[0]);
			genders.put(i, p[1]);
		}
		
		for(int i = 1; i <= 162254; i++) {
			String n = bl.readLine();
			String p[] = n.split(",");

			lastNames.put(i, p[0]);
		}
		
		bn.close();
		bl.close();	
	}

	public double getMAXPOPULATION() {
		return MAXPOPULATION;
	}

	public List<Person> getLperID(String s) {
		List<Person> aux = perID.listInOrder();
		List<Person> lperID = new ArrayList<>();
		
		for (Person person : aux) {
			if(person.id().contains(s)) {
				lperID.add(person);
			}
		}
		return lperID;
	}

	public List<Person> getLperName(String s) {
		lperName = new ArrayList<>();
		List<Person> a = perName.searchList();
		for (Person person : a) {
			if(person.name().contains(s)) {
				lperName.add(person);
			}
		}
		return lperName;
	}

	public List<Person> getLperSurName(String s) {
		lperSurName = new ArrayList<>();
		List<Person> a = perSurName.searchList();
		for (Person person : a) {
			if(person.surname().contains(s)) {
				lperSurName.add(person);
			}
		}
		return lperSurName;
	}

	public List<Person> getLperFullName(String s) {
		lperFullName = new ArrayList<>();
		List<Person> a = perFullName.searchList();
		for (Person person : a) {
			if(person.fullName().contains(s)) {
				lperFullName.add(person);
			}
		}
		return lperFullName;
	}
	
	public boolean remove(Person p) throws Exception {
		perID.remove(p);
		perName.delete(p);
		perSurName.delete(p);
		perFullName.delete(p);
		
		return true;
	}
	
	public boolean update(Person p, Person aux) throws Exception {
		perID.remove(p);
		perName.delete(p);
		perSurName.delete(p);
		perFullName.delete(p);
		
		perID.add(aux);
		perName.add(aux);
		perSurName.add(aux);
		perFullName.add(aux);
		
		return true;
	}
	
}

