import java.util.Scanner;

public class Reader {

    private UserAccountingSystem accountingSystem;// = new UserAccountingSystem();
    private Librarian librarian;

    private String name;
    private boolean isInBlackList;

    public boolean isInBlackList() {
        return isInBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        isInBlackList = inBlackList;
    }

    public Reader(String name, boolean isInBlackList) {
        this.name = name;
        this.isInBlackList = isInBlackList;
    }


    public Reader(String name, UserAccountingSystem userAccountingSystem) {
        this.name = name;
        this.isInBlackList = false;
        accountingSystem = userAccountingSystem;
        accountingSystem.checkRegistrity(name);
        librarian = new Librarian();
    }

    public Reader(String name){
        this.name = name;
        isInBlackList = false;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public void sendRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the title of the book which you would like to order");
        accountingSystem.processRequest(scanner.nextLine(), name);
    }
    public void getBook(){
        Scanner scanner = new Scanner(System.in);
        int id;
        boolean b = false;
        System.out.println("Please, enter id of the order");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Do you want to read it in the library (1) or take away (2)?");
        if (scanner.nextInt() == 1) b = true;
        scanner.nextLine();
        librarian.giveBook(id, b, getName());
    }
    public void returnBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the title of the book you want to return");
        librarian.takeBook(scanner.nextLine());
    }
}
