package lesson4.lines;

import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Figure {
    private List<Point> points = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("PolyLine points= ");
        for (Point p : points) {
            result.append("(").append(p.getX()).append(", ").append(p.getY()).append(")");
        }
        return result.toString();
    }

    public PolyLine(List<Point> points) {
        this.points = points;
    }


    public void appendPoint(Point p) {
        points.add(p);
    }


    @Override
    public double getLength() {
        double result = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            double resultx = Math.pow(points.get(i).getX() - points.get(i + 1).getX(), 2);
            double resultY = Math.pow(points.get(i).getY() - points.get(i + 1).getY(), 2);
            result += Math.sqrt(resultx + resultY);
        }
        result += Math.sqrt(
                Math.pow(points.get(points.size()-1).getX() - points.get(0).getX(), 2) + Math.pow(points.get(points.size()-1).getY() - points.get(0).getY(), 2));
        return result;
    }
}