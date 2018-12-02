import java.util.HashSet;
import java.util.Scanner;

//Множина типу HashSet,
//        яка містить об’єкти
//        "Точка", що описуються
//        як (x, y)
//
//        Створити множину точок заданої кількості. Потім
//        визначити три різні точки, що складають трикутник
//        найбільшого периметру.

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int length;

        System.out.println("Enter the amount of dots");
        length = scanner.nextInt();

        Utils utils = new Utils();
        HashSet<Dot> dots = utils.fillDots(length);
        Triangles triangles = new Triangles(dots);

        System.out.print("All dots: ");
        for (Dot d:dots) {
            System.out.print(d.toString() + "  ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("All triangles:");
        triangles.print();
        System.out.println("");
        System.out.print("Max perimetr: ");
        triangles.getMaxP().print();
    }
}
