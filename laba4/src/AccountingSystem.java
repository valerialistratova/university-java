
public abstract class AccountingSystem {


    public int getCurrAmountOfRequests() {
        return LibraryDB.getInstance().getCurrAmountOfRequests();
    }

    public void setCurrAmountOfRequests(int currAmountOfRequests) {
        LibraryDB.getInstance().setCurrAmountOfRequests(currAmountOfRequests);
    }

    public int getCurrAmountOfReaders() {
         return LibraryDB.getInstance().getCurrAmountOfReaders();
    }

    public void setCurrAmountOfReaders(int currAmountOfReaders) {
        LibraryDB.getInstance().setCurrAmountOfReaders(currAmountOfReaders);
    }

    public Book[] getBooks() {
        return LibraryDB.getInstance().getBooks();
    }

    public void setBooks(Book[] books) {
        LibraryDB.getInstance().setBooks(books);
    }

    public Reader[] getReaders() {
        return LibraryDB.getInstance().getReaders();
    }

    public void setReaders(Reader[] readers) {
        LibraryDB.getInstance().setReaders(readers);
    }

    public BookRequest[] getRequests() {
        return LibraryDB.getInstance().getRequests();
    }

    public void setRequests(BookRequest[] requests) {
        LibraryDB.getInstance().setRequests(requests);
    }

    public AccountingSystem() {
    }

}
