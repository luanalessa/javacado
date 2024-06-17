package designPatterns.builder;


public class Person {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    
    private Person() {} // Private constructor to enforce Builder usage
    
    // Getters for optional fields
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    // Static nested Builder class
    public static class PersonBuilder {
        private String name;
        private int age;
        private String address;
        private String phoneNumber;
        
        // Default constructor
        public PersonBuilder() {}
        
        // Setter methods for optional fields
        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }
        
        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        
        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }
        
        public PersonBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        // Build method to construct the Person object using the PersonBuilder
        public Person build() {
            Person person = new Person();
            person.name = this.name;
            person.age = this.age;
            person.address = this.address;
            person.phoneNumber = this.phoneNumber;
            return person;
        }
    }
}
