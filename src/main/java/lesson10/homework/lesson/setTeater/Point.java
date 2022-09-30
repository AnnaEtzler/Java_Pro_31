package lesson10.homework.lesson.setTeater;

import java.util.Objects;

public class Point implements Comparable<Point>{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y; // 31*((7*x)+y) + z
        return result;
    }

    @Override
    public int compareTo(Point o) {
        if(x != o.x){
            return x - o.x;
        }
        if(y != o.y){
            return y - o.y;
        }
        return 0;
    }
}
