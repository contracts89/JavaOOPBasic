package problem1;

/**
 * Created by Radoslav on 11.7.2016 г..
 */
public class Box {
    private double length;
    private double width;
    private double heght;

    public Box(double length, double width, double heght) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeght(heght);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeght() {
        return heght;
    }

    public void setHeght(double heght) {
        this.heght = heght;
    }

    public double calcVolume(){
        return this.getLength() * this.getHeght() * this.getWidth();
    }

    public double calcLateralSurfaceArea(){
        return 2*(this.getLength()*this.getHeght()) + 2*(this.getWidth()*this.getHeght());
    }

    public double calcSurfaceArea(){
        return 2*(this.getWidth()*this.getLength()) + 2*(this.getLength()*this.getHeght()) + 2*(this.getWidth()*this.getHeght());
    }
}
