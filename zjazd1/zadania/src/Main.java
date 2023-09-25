import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.HashSet.newHashSet;

public class Main {
    public static void main(String[] args) {

        Person person =null;
        //zadanie 2
        try{
            person = new Person("Jan", 25);
        }catch(InvalidAgeException e){
            System.out.println("złapano wyjątek " + e.getMessage());
        }
        System.out.println("Mam na imie: " + person.getName() + " mam lat: " + person.getAge());
        Person person2 = new Person("Magda", 35);
        Person person3 = new Person("Andrzej", 28);
        //zadanie 3
        List<Person> personlist = List.of(person, person2, person3);
        System.out.println("Lista osob: " + personlist);
        Set<Person> personset = new HashSet<>();
        personset.add(person);
        personset.add(person2);
        personset.add(person3);
        System.out.println("set osob: " + personset);
        Map<Integer, Person> mapaosob =Map.of(1,person,2,person2,3,person3);
        System.out.println("mapa ososb: " +mapaosob);
        //zadanie 4.1
        personlist.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());
        List<Integer> agelist = personlist.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());
        Integer agesum = agelist.stream()
                .reduce(0,(sum,value) -> sum +value);
        System.out.println("suma lat: " + agesum);
        double averAge = agesum / personlist.size();
        System.out.println("Srednia wieku: " + averAge);
        //zadanie 4.2
        List<String> namelist =personlist.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("Lista tylko z imionami: " +namelist);
        //zadanie 4.3
        List<Person> agegreaterthan25 = personlist.stream()
                .filter(p->p.getAge()>25)
                .toList();
        System.out.println("Lista powyzej 25 lat" +agegreaterthan25);
        //zadanie 4.4
        List<Person> sortedlist= personlist.stream()
                .sorted(Comparator.comparing(Person::getName))
                .toList();
        System.out.println("Lista posortowana: " + sortedlist);
        //zadanie 4.5
        personlist.stream()
                .forEach(System.out::println);
        //zadanie 4.6
       Optional<Person> minageperson = personlist.stream()
                .min(Comparator.comparingInt(Person::getAge));
       minageperson.ifPresentOrElse(p -> System.out.println("minimaly wiek to " +p.getAge()),
               ()-> System.out.println("Nie odnaleziono żadnej osoby"));
       Optional<Person> maxageperson = personlist.stream()
               .max(Comparator.comparingInt(Person::getAge));
        maxageperson.ifPresentOrElse(p -> System.out.println("maksymalny wiek to "  +p.getAge()),
                ()-> System.out.println("Nie odnaleziono żadnej osoby"));
    }
}