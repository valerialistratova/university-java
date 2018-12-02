public class Dot {
    private int y;
    private int x;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Dot(int x, int y) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + "}";
    }
    @Override
    public boolean equals(Object d2) {
        Dot d = (Dot)d2;
        if(d.x == x && d.y == y)
            return true;
        return false;
    }
}
