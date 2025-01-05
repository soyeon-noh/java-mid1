package lang.object.toString;

public class Dog {

    private String dogName;
    private int age;

    // com + n
    // com + a
    public Dog(String dogName, int age) {
        this.dogName = dogName;
        this.age = age;
    }

    // Generate -> toString
    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", age=" + age +
                '}';
    }
}
