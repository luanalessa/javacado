package designPatterns.factoryMethods;

interface PersonFactory {
    Person createPerson(String name, int age);
}

// Concrete implementation of PersonFactory for creating Male objects
class MaleFactory implements PersonFactory {
    @Override
    public Person createPerson(String name, int age) {
        return new Male(name, age);
    }
}

// Concrete implementation of PersonFactory for creating Female objects
class FemaleFactory implements PersonFactory {
    @Override
    public Person createPerson(String name, int age) {
        return new Female(name, age);
    }
}