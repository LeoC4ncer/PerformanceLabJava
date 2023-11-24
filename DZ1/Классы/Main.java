import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        int ammountOfCats = rnd.nextInt(3) + 1;
        int ammountOfDogs = rnd.nextInt(3) + 1;
        int ammountOfTigers = rnd.nextInt(3) + 1;
        int amountOfDolphins = rnd.nextInt(3) + 1;
        int amountOfCrocodiles = rnd.nextInt(3) + 1;

        ArrayList<Animal> animals = new ArrayList<Animal>();
        for (int i = 1; i <= ammountOfCats; i++)
            animals.add(new Cat("Cat " + String.valueOf(i)));

        for (int i = 1; i <= ammountOfDogs; i++)
            animals.add(new Dog("Dog " + String.valueOf(i)));

        for (int i = 1; i <= ammountOfTigers; i++)
            animals.add(new Tiger("Tiger " + String.valueOf(i)));

        for (int i = 1; i <= amountOfDolphins; i++)
            animals.add(new Dolphin("Dolphin " + String.valueOf(i)));

        for (int i = 1; i <= amountOfCrocodiles; i++)
            animals.add(new Crocodile("Crocodile " + String.valueOf(i)));

        System.out.println("Количество котов: " + ammountOfCats);
        System.out.println("Количество собак: " + ammountOfDogs);
        System.out.println("Количество тигров: " + ammountOfTigers);
        System.out.println("Количество дельфинов: " + amountOfDolphins);
        System.out.println("Количество крокодилов: " + amountOfCrocodiles);

        int distance = rnd.nextInt(1000) + 1;
        for (Animal animal : animals)
        {
            animal.run(distance);
            animal.swim(distance);
        }

    }
}

