import java.util.HashSet;

public class Triangles {
    private HashSet<Triangle> triangles;

    public Triangles(HashSet<Dot> dots)
    {
        triangles = new HashSet<Triangle>();
        init(dots);
    }
    private void init(HashSet<Dot> dots) {
        for(Dot d1 : dots) {
            for (Dot d2 : dots) {
                if(d1.equals(d2)) continue;
                for (Dot d3 : dots) {
                    if(d1.equals(d3) || d2.equals(d3)) continue;
                    add(new Triangle(d1, d2, d3));
                }
            }
        }
    }
    private void add(Triangle t1)
    {
        for (Triangle t:triangles) {
            if(t.equals(t1)) return;
        }
        triangles.add(t1);
    }
    public Triangle getMaxP(){
        double maxP = 0;
        Triangle maxT = null;
        for(Triangle t:triangles){
            double P = t.getP();
            if (maxP < P) {
                maxP = t.getP();
                maxT = t;
            }
        }
        return maxT;
    }
    public void print(){
        for(Triangle t:triangles) {
            t.print();
        }
    }
}
