package designPatterns.factoryMethods;


public class Main {
    public static void main(String[] args) {
        // Using MaleFactory to create a Male person
        PersonFactory maleFactory = new MaleFactory();
        Person malePerson = maleFactory.createPerson("Johny", 35);

        // Using FemaleFactory to create a Female person
        PersonFactory femaleFactory = new FemaleFactory();
        Person femalePerson = femaleFactory.createPerson("Alice", 30);

        // Printing information of the created persons
        System.out.println("Male Person:");
        System.out.println("Name: " + malePerson.getName());
        System.out.println("Age: " + malePerson.getAge());

        System.out.println("\nFemale Person:");
        System.out.println("Name: " + femalePerson.getName());
        System.out.println("Age: " + femalePerson.getAge());
    }
}
