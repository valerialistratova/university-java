public class Triangle {
    private Dot A;
    private Dot B;
    private Dot C;

    public Triangle(Dot A, Dot B, Dot C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public double getP()
    {
        return getLength(A, B) + getLength(B, C) + getLength(A, C);
    }

    private double getLength(Dot d1, Dot d2){
        int x1 = d1.getX();
        int x2 = d2.getX();
        int y1 = d1.getY();
        int y2 = d2.getY();
        return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    }
    @Override
    public boolean equals(Object t1) {
        Triangle t = (Triangle)t1;
        Dot A1 = t.A;
        Dot B1 = t.B;
        Dot C1 = t.C;
        if(A.equals(A1) || A.equals(B1) || A.equals(C1))
            if(B.equals(A1) || B.equals(B1) || B.equals(C1))
                if(C.equals(A1) || C.equals(B1) || C.equals(C1))
                    return true;
        return false;
    }
    @Override
    public String toString(){
        return A.toString() + " " + B.toString() + " " + C.toString() + " P = "+ getP();
    }
    public void print(){
        System.out.printf("%-10s %-10s %-10s P = %.2f\n", A.toString(), B.toString(), C.toString(), getP());
    }
}
