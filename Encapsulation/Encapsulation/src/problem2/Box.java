package problem2;

/**
 * Created by Radoslav on 11.7.2016 г..
 */
public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeght(height);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeght(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calcVolume(){
        return this.width * this.height * this.length;
    }

    public double calcLateralSurfaceArea(){
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calcSurfaceArea(){
        return (2 * this.length * this.height) + (2 * this.length * this.width) + (2 * this.width * this.height);
    }
}
