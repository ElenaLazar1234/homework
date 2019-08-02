package week5.TreeSet;

import java.util.Comparator;

public class TreeSet {

    public static void main(String[] args) {

            Comparator<Person> comparatorForName = new Comparator<Person>() {
            public int compare(Person person1, Person person2) {
                int compareByName = person1.getName().compareTo(person2.getName());
                int compareByAge = Integer.compare(person1.getAge(),person2.getAge());
                if (compareByName == 0) {
                    return compareByAge;
                }
                return compareByName;
            }
        };

        java.util.TreeSet<Person> newSet = new java.util.TreeSet<>(comparatorForName);

            newSet.add(new Person("Dan", 25));
            newSet.add(new Person("Dan", 10));
            newSet.add(new Person("Elena", 9));

            for(Person person : newSet){
                System.out.println(person.getName() + person.getAge());
              }
    }
}

