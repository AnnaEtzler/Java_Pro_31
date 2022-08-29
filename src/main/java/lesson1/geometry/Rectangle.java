package lesson1.geometry;

public class Rectangle {
    private Point sw;
    private Point ne;

    public Rectangle(Point sw, Point ne) {
        this.sw = sw;
        this.ne = ne;
    }

    public int getArea(){
        int i =  ne.getX() - sw.getX();
        int j =  ne.getY() - sw.getY() ;

        return i*j;
    }
}
