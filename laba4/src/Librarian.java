import java.util.Scanner;

public class Librarian {
    Scanner scanner = new Scanner(System.in);
    private LibrarianAccountingSystem accountingSystem = new LibrarianAccountingSystem();

    public void giveBook() {
        int id;
        boolean b = false;
        System.out.println("Enter order ID");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Does reader want to read in the library (1) or take the book away (2)?");
        if (scanner.nextInt() == 1) b = true;
        scanner.nextLine();

        accountingSystem.processRent(id, b);
    }


    public void giveBook(int id, boolean isInLibary, String reader) {
        accountingSystem.processRent(id, isInLibary, reader);
    }

    public  void addToBlackList(){
        System.out.println("Who do you want ot add to th black list?");
        accountingSystem.addToBlackList(scanner.nextLine());
    }

    public void checkOutdatedRents(){
        accountingSystem.checkOutdates();
    }

    public void takeBook(String title) {
        accountingSystem.returnBook(title);
    }
}
