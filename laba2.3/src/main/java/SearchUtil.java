public class SearchUtil {

    private int amount;
    public SearchUtil(int amount) {
        this.amount = amount;
    }

    public Car[] findByBrand(Car[] cars, String brand) {
        int i = 0;
        Car[] temp = new Car[amount];
        System.out.println("The results of search by brand: ");
        for (Car car:cars
        ) {
            if (car.getBrand().equals(brand)){
                temp[i] = car;
                i++;
            }
        }
        if (i == 0){showNoMatches();
            Main.logger.info("Search by brand finished with no result");
            return null;
        }else {
            Car[] result = new Car[i];
            for (int j = 0; j < i; j++) {
                result[j] = temp[j];
            }
            Main.logger.info("Search by brand finished with " + result.length + " result");
            return result;
        }
    }

    public Car[] findByModelAndYear(Car[] cars, String model, int year) {
        int i = 0;
        Car[] temp = new Car[amount];
        System.out.println("The results of search by model and age: ");
        for (Car car:cars){
            if (car.getModel().equals(model) && 2018 - car.getYear() > year){
                temp[i] = car;
                i++;
            }
        }
        if (i == 0){showNoMatches();
            Main.logger.info("Search by model and age finished with no result");
            return null;
        }else {
            Car[] result = new Car[i];
            for (int j = 0; j < i; j++) {
                result[j] = temp[j];
            }
            Main.logger.info("Search by model and age finished with " + result.length + " results");
            return result;
        }
    }

    public Car[] findByYearAndPrice(Car[] cars, int year, double price) {
        int i = 0;
        Car[] temp = new Car[amount];
        System.out.println("The results of search by year and minimal price are");
        for (Car car : cars){
            if (car.getYear() == year && car.getPrice() > price){
                temp[i] = car;
                i++;
            }
        }
        if (i == 0){showNoMatches();
            Main.logger.info("Search by year and minimal price finished with no result");
            return null;
        }else {
            Car[] result = new Car[i];
            for (int j = 0; j < i; j++) {
                result[j] = temp[j];
            }
            Main.logger.info("Search by brand minimal price finished with " + result.length + " results");
            return result;
        }
    }
    private void showNoMatches(){
        System.out.println("No matches");
    }
}
