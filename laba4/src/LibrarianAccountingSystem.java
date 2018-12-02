import java.util.Scanner;

public class LibrarianAccountingSystem extends AccountingSystem {
    public void processRent(int id, boolean isInLibrary, String reader) {
        boolean succ = false;
        if (id < getCurrAmountOfRequests() || !getRequests()[id].isValid()) {
            System.out.println("Please, re-check your order id");
            succ = true;
        } else {
            for (Book b : getBooks()
            ) {
                if (getRequests()[id].getTitle().equals(b.getTitle())) {
                    b.setCurrentHolder(reader);
                    b.setAvailiable(false);
                    b.setInLibrary(isInLibrary);
                    b.setTimeOfRent(System.currentTimeMillis());
                    getRequests()[id].setValid(false);
                    System.out.println("Here is your book " + b.getTitle() + ". You've got 2 weeks to read it and return to the library. " +
                            "Otherwise, you'll be added to the black list");
                    succ = true;
                }
            }
        }
        if (!succ) {
            System.out.println("Ooops. Something went wrong");
        }
    }

    public void processRent(int id, boolean isInLibrary) {
        boolean succ = false;
        if (id < getCurrAmountOfRequests() || !getRequests()[id].isValid()) {
            System.out.println("Please, re-check your order id");
            succ = true;
        } else {
            try {
                for (Book b : getBooks()
                ) {
                    if (getRequests()[id].getTitle().equals(b.getTitle())) {
                        b.setCurrentHolder(getRequests()[id].getOrderer());
                        b.setAvailiable(false);
                        b.setInLibrary(isInLibrary);
                        b.setTimeOfRent(System.currentTimeMillis());
                        getRequests()[id].setValid(false);
                        System.out.println(getRequests()[id].getOrderer() + ", here is your book " + b.getTitle() + ". You've got 2 weeks to read it and return to the library. " +
                                "Otherwise, you'll be added to the black list");
                        succ = true;
                    }
                }

            } catch (Exception e) {
                System.out.println("Recheck ID!");
            }

        }
        if (!succ) {
            System.out.println("Ooops. Something went wrong");
        }
    }

    public void checkOutdates() {
        Reader[] readers = new Reader[10];
        int i = 0;
        for (Book b : getBooks()) {
            if (b.getTimeOfRent() + 14 * 24 * 60 * 60 * 1000 < System.currentTimeMillis() && b.getTimeOfRent() != 0) {
                readers[i] = new Reader(b.getCurrentHolder());
                i++;
            }
        }
        if (i == 0) {
            System.out.println("There are no current outdates");
        } else {
            for (int j = 0; j < i; j++) {
                System.out.println(readers[i]);
            }
            System.out.println("There are " + i + 1 + " debtors. Press 1 if you want to add all of them to the black list. Press anything else to exit checking");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextInt() == 1) {
                addToBlackList(readers);
            }
        }


    }

    public void addToBlackList(Reader[] reader) {
        for (Reader r : reader
        ) {
            for (Reader globalR : getReaders()
            ) {
                if (r.equals(globalR)) {
                    globalR.setInBlackList(true);
                    System.out.println("You've successfully added" + globalR.getName() + "to the black list");
                }
            }
        }


    }

    public void addToBlackList(String reader) {
        boolean succ = false;
        for (int i = 0; i < getCurrAmountOfReaders(); i++) {
            if (getReaders()[i].getName().equals(reader)) {
                getReaders()[i].setInBlackList(true);
                succ = true;
            }
        }
        if (succ) {
            System.out.println("You've successfully added " + reader + " to the black list");
        } else {
            System.out.println("There is no such user");
        }

        for (int i = 0; i < getCurrAmountOfReaders(); i++) {
            {
                if (getReaders()[i].isInBlackList()) {
                    System.out.println(getReaders()[i].getName());
                }
            }
        }
    }

    public void returnBook(String title) {
        //Book b = new Book(title)
        for (Book b : getBooks()
        ) {
            if (title.equals(b.getTitle())) {
                b.setTimeOfRent(0);
                b.setInLibrary(true);
                b.setAvailiable(true);
                b.setCurrentHolder("Librarian");
                System.out.println("Thank you for returning the book");
            }
        }
    }
}
