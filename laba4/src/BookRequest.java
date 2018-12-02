public class BookRequest {
    private int id;
    private String title;
    private String orderer;
    private boolean isValid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrderer() {
        return orderer;
    }

    public void setOrderer(String orderer) {
        this.orderer = orderer;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public BookRequest(int id, String title, String orderer) {
        this.id = id;
        this.title = title;
        this.orderer = orderer;
        isValid = true;
    }

    public BookRequest(){}
}
