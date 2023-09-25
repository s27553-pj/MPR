public class Person {
    private Integer age;
    private String name;

    public Person(String name, Integer age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Wiek nie moze byc mniejszy od 0");
        } else if (age > 100) {
            throw new InvalidAgeException("Wiek nie moze byc wiekszy od 100");
        }
        this.age = age;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Wiek nie moze byc mniejszy od 0");
        } else if (age > 100) {
            throw new InvalidAgeException("Wiek nie moze byc wiekszy od 100");
        }
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Osoba: Person{" + "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
