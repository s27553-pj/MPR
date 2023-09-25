import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Person person = null;
        try {
            person = new Person("Jan", 20);
        } catch(InvalidAgeException e){
            System.out.println("Złapano wyjątek " + e.getMessage());
        }
        try{
            Person person2 = new Person("Adam",-5);
        } catch(InvalidAgeException e){
            System.out.println("Złapano wyjątek" + e.getMessage());
        }
        person.setAge(-10);
        System.out.println("Imie: " + person.getName()+ " wiek: " + person.getAge());

        Person person3 =new Person("Magda",35);
        Person person4 = new Person("Andrzej",28);
        List<Person> immutablePersonList = List.of(person, person3, person4);
        System.out.println("Lista niemutowalna " + immutablePersonList);

        List<Person> mutablePersonList;
        mutablePersonList = new ArrayList<>();
        mutablePersonList.add(person);
        mutablePersonList.add(person3);
        mutablePersonList.add(person4);
        System.out.println("Lista mutowalna" + mutablePersonList);
    }
}