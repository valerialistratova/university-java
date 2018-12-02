public class LibraryDB {
    private static LibraryDB libraryDB;

    public static LibraryDB getInstance() {
        if (libraryDB == null) {
            libraryDB = new LibraryDB();
        }
        return libraryDB;
    }

    public static LibraryDB getLibraryDB() {
        return libraryDB;
    }

    public static void setLibraryDB(LibraryDB libraryDB) {
        LibraryDB.libraryDB = libraryDB;
    }

    public int getCurrAmountOfRequests() {
        return currAmountOfRequests;
    }

    public void setCurrAmountOfRequests(int currAmountOfRequests) {
        this.currAmountOfRequests = currAmountOfRequests;
    }

    public int getCurrAmountOfReaders() {
        return currAmountOfReaders;
    }

    public void setCurrAmountOfReaders(int currAmountOfReaders) {
        this.currAmountOfReaders = currAmountOfReaders;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Reader[] getReaders() {
        return readers;
    }

    public void setReaders(Reader[] readers) {
        this.readers = readers;
    }

    public BookRequest[] getRequests() {
        return requests;
    }

    public void setRequests(BookRequest[] requests) {
        this.requests = requests;
    }

    private LibraryDB() {

        for (int i = 0; i < 10; i++) {
            requests[i] = new BookRequest();
        }
        readers[0] = new Reader("Vasya");
        readers[1] = new Reader("Petya");
        readers[2] = new Reader("Masha");
        readers[3] = new Reader("Kolya");
        currAmountOfReaders = 4;
    }


    private int currAmountOfRequests = 0;
    private int currAmountOfReaders = 0;
    private Book[] books = {new Book(""), new Book("Kolobok"), new Book("Scrum"), new Book("Azbuka"), new Book("Starik i more"), new Book("Cvety dlia Eldzhernona"), new Book("Odisseya")};
    private Reader[] readers = new Reader[10];
    private BookRequest[] requests = new BookRequest[10];
}
