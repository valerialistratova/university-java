public class InputException extends Exception {
    enum Situations{
        ID,
        YEAR,
        PRICE
    }
    public InputException (Situations s){
        super("The " + s + " value is too big or too small");

    }
}
