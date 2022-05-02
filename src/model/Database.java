package model;

import util.AVL;

public class Database {

	private final double MAXPOPULATION = 100; 
	private AVL<Person> perID;
	private AVL<Person> perName;
	private AVL<Person> perSurName;
	private AVL<Person> perFullName;
	private String age;
	

	public Database(){

	}

	public void generateEstatura(){
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

}

