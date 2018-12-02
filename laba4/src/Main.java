import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Welcome to my virtual library!");
        boolean esc = false;
        while (!esc){

            System.out.println("If you want to choose your role, press 1. If you want to escape, press 2");

            switch (scanner.nextInt()){
                case 1: chooseRole(); break;
                case 2: esc = true; break;
                default: {System.out.println("You pressed wrong number. You are automatically sent to choosing your role");
                    chooseRole(); break;}
            }
        }

    }

    private static void chooseRole(){
        System.out.println("Please, choose your role: press 1 to be a librarian, press 2 to be a reader.");
        if(scanner.nextInt() == 1){
            scanner.nextLine();
            librarianCycle();
        }else{
            scanner.nextLine();
            readerCycle();
        }
    }

    private static void readerCycle() {
        boolean esc = false;
        System.out.println("Please, enter your name, Reader");
        Reader reader = new Reader(scanner.nextLine(), new UserAccountingSystem());
        printReaderInfo(reader);
        while (!esc){
            System.out.println(reader.getName() + ", choose the operation 1-3 or press 4 to get INFO. Press any other number to escape Reader mode");
            switch (scanner.nextInt()){ case 1: reader.sendRequest(); break;
                case 2: reader.getBook(); break;
                case 3: reader.returnBook(); break;
                case 4: printReaderInfo(reader); break;
                default: esc = true; break;}
        }
    }


    private static void librarianCycle() {
        boolean esc = false;
        Librarian librarian = new Librarian();
        printLibrarianInfo();
        while (!esc){
            System.out.println("Choose the operation 1-3 or press 4 to get INFO. Press any other number to escape Librarian mode");
            switch (scanner.nextInt()){ case 1: librarian.giveBook(); break;
                case 2: librarian.checkOutdatedRents(); break;
                case 3: librarian.addToBlackList(); break;
                case 4: printLibrarianInfo(); break;
                default: esc = true; break;}
        }
    }

    private static void printLibrarianInfo(){
        System.out.println("------------INFO----------------");
        System.out.println("You are Librarian. You can do these operations: ");
        System.out.println("Press 1 to give a book");
        System.out.println("Press 2 to check if there are debtors");
        System.out.println("Press 3 to add a reader to black list");
    }

    private static void printReaderInfo(Reader reader){
        System.out.println("------------INFO----------------");
        System.out.println("You are Reader " + reader.getName() + ". You can do these operations: ");
        System.out.println("Press 1 to order a book");
        System.out.println("Press 2 to ask librarian to give you a book");
        System.out.println("Press 3 to return your book");
    }
}
