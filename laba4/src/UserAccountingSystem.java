public class UserAccountingSystem extends AccountingSystem{

    public void processRequest(String title, String reader) {
        boolean succ = false;
        if (!isInBlackList(reader)) {
            for (Book book : getBooks()
            ) {
                if (book.getTitle().equals(title)) {
                    if (book.isAvailiable()) {
                        createNewOrder(title, reader);
                        succ = true;
                    } else {
                        System.out.println("Currently the book is not available. Please, try later.");
                        succ = true;
                    }
                }
            }
            if (!succ) {
                System.out.println("Sorry, we don't have the book you want");
            }

        } else {
            System.out.println("You are in the black list of our library");
        }
    }

    private boolean isInBlackList(String reader) {
        for (int i = 0; i < getCurrAmountOfReaders(); i++) {
            if(reader.equals(getReaders()[i].getName())){
                return getReaders()[i].isInBlackList();
            }
        }return true;
    }

    public void createNewOrder(String title, String reader) {
        setCurrAmountOfRequests(getCurrAmountOfRequests()+1);
        getRequests()[getCurrAmountOfRequests()] = new BookRequest(getCurrAmountOfRequests(), title, reader);
        for (Book b : getBooks()) {
            if (b.getTitle().equals(title)) {
                b.setAvailiable(false);
                b.setCurrentHolder(reader);
                System.out.println("Your order number is " + getCurrAmountOfRequests());
            }
        }
    }


    public void checkRegistrity(String name) {
        boolean isReg = false;
        for (int i = 0; i < getCurrAmountOfReaders(); i++) {
            if (getReaders()[i].getName().equals(name)){
                isReg = true;
                break;
            }
        }
        if (isReg){
            System.out.println("Welcome back to the library, "+ name);
        } else {
            getReaders()[getCurrAmountOfReaders()] = new Reader(name);
            setCurrAmountOfReaders(getCurrAmountOfReaders()+1);
            System.out.println("You are here for the first time. We've added you to our list of users");
        }
    }
}
