package lesson4.lines;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Figure {

    private List<Point> points = new ArrayList<>();


    public Rectangle(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Rectangle points= ");
        for (Point p: points){
            result.append("(").append(p.getX()).append(", ").append(p.getY()).append(")");
        }
        return result.toString();
    }


    @Override
    public double getLength() {
        if(points.size() != 4){
            System.out.println("This is a not Rectangle");
            return 0;
        }
        double result = 0;

        for (int i = 0; i < 3; i++) {
            double resultx = Math.pow(points.get(i).getX() - points.get(i+1).getX(), 2);
            double resultY = Math.pow(points.get(i).getY() - points.get(i+1).getY(), 2);
            result += Math.sqrt(resultx + resultY);
            if( i == 1){
                result += Math.sqrt(resultx + resultY);
            }

        }
        return result;
    }
}
