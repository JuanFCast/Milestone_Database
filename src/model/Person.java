package model;

public class Person {
    
    private String id, name, surname, birth, height, nacionality;
    private Gender gender;
//    private Image photo;

    //Constructor
    public Person(String n, String s, Gender g, String b, String h, String na){
        RandomGenerator r = new RandomGenerator(1, 9);
        RandomGenerator d = new RandomGenerator(1, 3);

        id = "" + r.generateChar();
        for(int i = 1; i < 10; i++){
            int l = d.generateInt();
            if(l == 2){
                id += r.generateInt();
            } else{
                id += r.generateChar();
            }
        }
        name = n;
        surname = s;
        gender = g;
        birth = b;
        height = h;
        nacionality = na;
    }

    //Methods
    public String id(){
        return id;
    }
    public String name(){
        return name;
    }
    public String surname(){
        return surname;
    }
    public String fullName(){
        return name + " " + surname;
    }
    public String birth(){
        return birth;
    }
    public String gender(){
        return "" + gender;
    }
    public String height(){
        return height;
    }
    public String nacionality(){
        return nacionality;
    }
    
    public String toString() {
    	return "ID: "+ id + " | Name: " + name + " | LastName: " + surname;
    }

}
