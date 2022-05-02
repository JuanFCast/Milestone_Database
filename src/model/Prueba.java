package model;

import java.time.LocalDate; 
import java.time.Period; 
import java.util.Random;

public class Prueba { 
	
	public static LocalDate randomBirthday() { 
		return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))); 
	} 
	
	public static void main(String[] args) { 
		System.out.println("randomDate: " + randomBirthday()); 
	} 
}



