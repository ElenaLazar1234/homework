package week5.TreeSet;

public class Person {
    private String name;
    private Integer age;

    public Person(String newName,int newAge){
        this.name= newName;
        this.age=newAge;

    }
    public String getName(){
        return name;
    }


    public int getAge(){
        return age;
    }
}