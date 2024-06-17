package designPatterns.factoryMethods;


// Concrete implementation for Male
class Male implements Person {
    private String name;
    private int age;

    Male(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}

// Concrete implementation for Female
class Female implements Person {
    private String name;
    private int age;

    Female(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}
