package model;

public class Person{

	private String name;
	private String lastName;
	private String birhday;			//mm-dd-yy
	private String gender;
	private double height;
	private String code;
	private String nationality;
	
	public Person(String name, String lastName, String birhday, String gender, double height, String nationality) {
		this.name = name;
		this.lastName = lastName;
		this.birhday = birhday;
		this.gender = gender;
		this.height = height;
		code = "";
		this.nationality = nationality;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirhday() {
		return birhday;
	}
	public void setBirhday(String birhday) {
		this.birhday = birhday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public int comparebyname(String aname) {
		return name.compareTo(aname);
	}
	
	public int comparebylastname(String alastname) {
		return lastName.compareTo(alastname);
	}
	
	public int comparebyfullname(String afullname) {
		String fullname = (name+" "+lastName);
		return fullname.compareTo(afullname);
	}
	
	public int comparebycode(String acode) {
		return code.compareTo(acode);
	}
		
}
