package net.myrts.codingkata8;

/**
 * @author <a href="mailto:vzhovtiuk@gmail.com">Vitaliy Zhovtyuk</a>
 *         Date: 4/29/16
 *         Time: 11:26 AM
 */
public class Person {
    private final String name;
    private final int age;
    private String nationality;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(int age, String name, String nationality) {
        this.age = age;
        this.name = name;
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
