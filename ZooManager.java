public class ZooManager {
    public static void main(String[] args) {
        // Create Animal object
        Animal animal = new Animal("Generic Animal", 5);
        System.out.println(animal.getInfo());
        System.out.println(animal.makeSound());
        
        System.out.println("--------------------");
        
        // Create Mammal object
        Mammal mammal = new Mammal("Lion", 3, "Golden");
        System.out.println(mammal.getInfo());
        System.out.println(mammal.makeSound());
    }
}