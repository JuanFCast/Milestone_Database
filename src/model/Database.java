package model;

import java.util.Random;

import util.AVL;

public class Database {

	private AVL<Person> perID;
	private AVL<Person> perName;
	private AVL<Person> perSurName;
	private AVL<Person> perFullName;
	public static String estatura;
	private String edad;
	private double cant = 100; 

	public Database(){

	}

	public void generateEstatura(){
		RandomGenerator e = new RandomGenerator(100, 200);
		estatura = (e.generateInt() + " cm");
		System.out.println(estatura = (e.generateInt() + " cm"));



	}

	public void generateAge(){
		RandomGenerator a = new RandomGenerator(0, 14);
		RandomGenerator b = new RandomGenerator(15, 24);
		RandomGenerator c = new RandomGenerator(25, 54);
		RandomGenerator d = new RandomGenerator(55, 64);
		RandomGenerator e = new RandomGenerator(64, 100);
		
		
		edad = (a.generateInt() + " años");
		
		
		
	}




}

