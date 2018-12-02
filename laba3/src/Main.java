import java.util.Random;
import java.util.Scanner;

public class Main {


    private static Car[] cars;
    private static SearchUtil searchUtil;

    public static void main(String [] args){
        String model;
        int age;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 for manual entering. Press 2 for automatic insertion");
        if (scanner.nextInt()==1){
            manualEnter();
        } else {
            automaticEnter();
        }

        printCars(cars);
        scanner.nextLine();
        System.out.println("Enter the car's brand you want to search");
        printCars(searchUtil.findByBrand(cars, scanner.nextLine()));
        System.out.println("-------------------------");

        System.out.println("Enter the car's model");
        model = scanner.nextLine();
        System.out.println("Enter the car's minimal period of usage");
        printCars(searchUtil.findByModelAndYear(cars, model, scanner.nextInt()));
        System.out.println("-------------------------");

        System.out.println("Enter the car's year of creation");
        age = scanner.nextInt();
        System.out.println("Enter the minimal price");
        printCars(searchUtil.findByYearAndPrice(cars, age, scanner.nextDouble()));
    }

    private static void printCars(Car[] cars) {
        int i = 1;
        if (cars!=null){
            for (Car car:cars
        ) {
            System.out.format("%2d",i);
            i++;
            for (String s:car.toString().split(",")
            ) {
                System.out.format("|    " + "%30s",s + "    |");
            }

            System.out.println();
        }}
    }


    private static void automaticEnter() {
        int carsAmount = 10;
        searchUtil = new SearchUtil(carsAmount);
        cars = new Car[carsAmount];
        Random random = new Random();

        String[] brands = {"BMW","Mercedes","Lexus", "Tesla"};
        String[] models = {"Model A", "Model B", "Model C", "Model D"};
        String[] colors = {"Red", "Black", "White", "Blue", "Green"};


        for (int i = 0; i < carsAmount; i++) {
            cars[i] = new Car();
            cars[i].setBrand(brands[random.nextInt(4)]);
            cars[i].setModel(models[random.nextInt(4)]);
            cars[i].setColor(colors[random.nextInt(5)]);
            cars[i].setId(random.nextInt(999999));
            cars[i].setRegisteredNumber("AA" + (1000 + random.nextInt(8999)) + "AX");
//            cars[i].setPrice(Double.parseDouble(new DecimalFormat("##.##").format(
//                    10000 + random.nextInt(30000) + random.nextDouble())));
            cars[i].setPrice(random.nextInt(30000) + 2000);
            cars[i].setYear(1999 + random.nextInt(19));
        }

    }

    private static void manualEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of cars");
        int amount = scanner.nextInt();
        scanner.nextLine();
        cars = new Car[amount];
        searchUtil = new SearchUtil(amount);

        for (int i = 0; i < amount; i++) {
            cars[i] = new Car();
            System.out.println("You are entering values for car number " + (i + 1));

            System.out.println("Enter brand");
            cars[i].setBrand(scanner.nextLine());

            System.out.println("Enter model");
            cars[i].setModel(scanner.nextLine());

            System.out.println("Enter color");
            cars[i].setColor(scanner.nextLine());

            System.out.println("Enter id (from 0 to 999 999)");
            cars[i].setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Enter car's year");
            cars[i].setYear(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Enter register number");
            cars[i].setRegisteredNumber(scanner.nextLine());

            System.out.println("Enter the price");
            cars[i].setPrice(scanner.nextInt());
            scanner.nextLine();
        }

    }
}
