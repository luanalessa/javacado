package designPatterns.builder;

public class Main {
    public static void main(String[] args) {
        // Example usage of the Builder to create Person objects
        
        // Creating a Person object with name and age
        Person person1 = new Person.PersonBuilder()
                                .setName("Alice")
                                .setAge(30)
                                .build();
        
        // Creating a Person object with all fields
        Person person2 = new Person.PersonBuilder()
                                .setName("Bob")
                                .setAge(25)
                                .setAddress("123 Main St")
                                .setPhoneNumber("555-1234")
                                .build();
        
        // Printing information of the created objects
        System.out.println("Person 1:");
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Address: " + person1.getAddress());
        System.out.println("Phone Number: " + person1.getPhoneNumber());
        
        System.out.println("\nPerson 2:");
        System.out.println("Name: " + person2.getName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Address: " + person2.getAddress());
        System.out.println("Phone Number: " + person2.getPhoneNumber());
    }
}
