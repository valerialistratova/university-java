public class Book {
    private String title;
    private boolean isAvailiable;
    private String currentHolder;
    private boolean isInLibrary;
    private long timeOfRent;

    public Book(String title, boolean isAvailiable, String currentHolder, boolean isInLibrary, long timeOfRent) {
        this.title = title;
        this.isAvailiable = isAvailiable;
        this.currentHolder = currentHolder;
        this.isInLibrary = isInLibrary;
        this.timeOfRent = timeOfRent;
    }

    //for inserting new books in accounting system
    public Book(String title) {
        this.title = title;
        isAvailiable = true;
        currentHolder = "Library";
        isInLibrary = true;
        timeOfRent = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailiable() {
        return isAvailiable;
    }

    public void setAvailiable(boolean availiable) {
        isAvailiable = availiable;
    }

    public String getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(String currentHolder) {
        this.currentHolder = currentHolder;
    }

    public boolean isInLibrary() {
        return isInLibrary;
    }

    public void setInLibrary(boolean inLibrary) {
        isInLibrary = inLibrary;
    }

    public long getTimeOfRent() {
        return timeOfRent;
    }

    public void setTimeOfRent(long timeOfRent) {
        this.timeOfRent = timeOfRent;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isAvailiable=" + isAvailiable +
                ", currentHolder='" + currentHolder + '\'' +
                ", isInLibrary=" + isInLibrary +
                ", timeOfRent=" + timeOfRent +
                '}';
    }
}
