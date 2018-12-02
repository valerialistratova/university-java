import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the file path");
        String path = scanner.nextLine();
        System.out.println("Please, enter file name");
        String name = scanner.nextLine();
        FileUtils fileUtils = new FileUtils(path, name);

        System.out.println("The file: ");
        fileUtils.print("./new.txt");
        fileUtils.processText();
        System.out.println("");
        System.out.println("=====================================");
        System.out.println("");
        fileUtils.print("./output.txt");
    }
}
