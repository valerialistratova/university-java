import org.apache.log4j.Logger;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Car[] cars;
    private static SearchUtil searchUtil;
    final static Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args) {
        logger.info("started successfully");
        String model;
        int age;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 for manual entering. Press 2 for automatic insertion");
        if (scanner.nextInt() == 1) {
            try {
                manualEnter();
            } catch (InputException e) {
                logger.info("wrong input detected");
                logger.info("application stopped");
                e.printStackTrace();
                return;
            }
        } else {
            automaticEnter();
        }
        logger.info("cars' info entered");
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
        logger.info("all operations complete");
        logger.info("application finished");
    }

    private static void printCars(Car[] cars) {
        int i = 1;
        if (cars != null) {
            for (Car car : cars
            ) {
                System.out.format("%2d", i);
                i++;
                for (String s : car.toString().split(",")
                ) {
                    System.out.format("|    " + "%30s", s + "    |");
                }

                System.out.println();
            }
        }
    }


    private static void automaticEnter() {
        int carsAmount = 10;
        searchUtil = new SearchUtil(carsAmount);
        cars = new Car[carsAmount];
        Random random = new Random();

        String[] brands = {"BMW", "Mercedes", "Lexus", "Tesla"};
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

    private static void manualEnter() throws InputException {
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
            int temp = scanner.nextInt();
            if (temp < 0 || temp > 999999) {
                throw new InputException(InputException.Situations.ID);
            } else {
                cars[i].setId(temp);
                scanner.nextLine();
            }


            System.out.println("Enter car's year");
            temp = scanner.nextInt();
            if (temp < 1945 || temp > 2018) {
                throw new InputException(InputException.Situations.YEAR);
            } else {
                cars[i].setYear(temp);
                scanner.nextLine();
            }

            System.out.println("Enter register number");
            cars[i].setRegisteredNumber(scanner.nextLine());

            System.out.println("Enter the price");
            temp = scanner.nextInt();
            if (temp < 100) {
                throw new InputException(InputException.Situations.PRICE);
            } else {
                cars[i].setPrice(temp);
                scanner.nextLine();
            }

        }

    }
}
