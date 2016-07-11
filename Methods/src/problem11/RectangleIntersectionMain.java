package problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Radoslav on 10.7.2016 г..
 */
class Rectangle{
    private String id;
    private Double width;
    private Double height;
    private Double horizontalLeftCorner;
    private Double verticalLeftCorner;

    public Rectangle(String id, Double width, Double height, Double horizontalLeftCorner, Double verticalLeftCorner) {
        this.setId(id);
        this.setWidth(width);
        this.setHeight(height);
        this.setHorizontalLeftCorner(horizontalLeftCorner);
        this.setVerticalLeftCorner(verticalLeftCorner);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getHorizontalLeftCorner() {
        return horizontalLeftCorner;
    }

    public void setHorizontalLeftCorner(Double horizontalLeftCorner) {
        this.horizontalLeftCorner = horizontalLeftCorner;
    }

    public Double getVerticalLeftCorner() {
        return verticalLeftCorner;
    }

    public void setVerticalLeftCorner(Double verticalLeftCorner) {
        this.verticalLeftCorner = verticalLeftCorner;
    }

    public boolean checkRectanglesInterstection(Rectangle rectangle2){
        Double x1 = this.getHorizontalLeftCorner();
        Double y1 = this.getVerticalLeftCorner();
        Double h1 = this.getHeight();
        Double w1 = this.getWidth();
        Double x2 = rectangle2.getHorizontalLeftCorner();
        Double y2 = rectangle2.getVerticalLeftCorner();
        Double h2 = rectangle2.getHeight();
        Double w2 = rectangle2.getWidth();
        if (x1+w1<x2 || x2+w2<x1 || y1+h1<y2 || y2+h2<y1){
            return false;
        }else {
            return true;
        }
    }
}
public class RectangleIntersectionMain {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Integer[] firstLine = Arrays.stream(sc.readLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        int numberOfRectangles = firstLine[0];
        int intersectionChecks = firstLine[1];
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < numberOfRectangles; i++) {
            String[] tokens = sc.readLine().split("\\s+");
            String id = tokens[0];
            Double width = Double.parseDouble(tokens[1]);
            Double height = Double.parseDouble(tokens[2]);
            Double horizontal = Double.parseDouble(tokens[3]);
            Double vertical = Double.parseDouble(tokens[4]);
            Rectangle rectangle = new Rectangle(id, width, height, horizontal, vertical);
            rectangles.add(rectangle);
        }

        for (int i = 0; i < intersectionChecks; i++) {
            String[] tokens = sc.readLine().split("\\s+");
            String firstID = tokens[0];
            String secondID = tokens[1];
            Rectangle firstRectangleToCheck = null;
            Rectangle secondRectangleToCheck = null;

            for (Rectangle rectangle : rectangles) {
                if(rectangle.getId().equals(firstID)){
                    firstRectangleToCheck = rectangle;
                }else if(rectangle.getId().equals(secondID)){
                    secondRectangleToCheck = rectangle;
                }
            }
            System.out.println(firstRectangleToCheck.checkRectanglesInterstection(secondRectangleToCheck));

        }
    }

}
