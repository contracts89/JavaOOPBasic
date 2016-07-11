package problem13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

/**
 * Created by Radoslav on 8.7.2016 г..
 */

abstract class Square{
    private int size;

    public Square(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class Rectangle extends Square{

    private int length;

    public Rectangle(int size) {
        super(size);
        this.setLength(length);
    }

    public Rectangle(int size, int length) {
        super(size);
        this.setLength(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

class CorDraw{
    private int width;
    private int length;

    public CorDraw(int width, int length) {
        this.setWidth(width);
        this.setLength(length);
    }

    public CorDraw(int width) {
        this.setWidth(width);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void draw(int width){
        StringBuilder firstAndLastLine = new StringBuilder();
        firstAndLastLine.append("|");
        for (int i = 0; i < width; i++) {
            firstAndLastLine.append("-");
        }
        firstAndLastLine.append("|");
        StringBuilder body = new StringBuilder();
        for (int i = 0; i < width - 2; i++) {
            body.append("|");
            for (int j = 0; j < width; j++) {
                body.append(" ");
            }
            body.append("|\n");
        }

        System.out.println(firstAndLastLine);
        System.out.print(body);
        System.out.print(firstAndLastLine);
    }

    public void draw(int width, int length){
        StringBuilder firstAndLastLine = new StringBuilder();
        firstAndLastLine.append("|");
        for (int i = 0; i < width; i++) {
            firstAndLastLine.append("-");
        }
        firstAndLastLine.append("|");
        StringBuilder body = new StringBuilder();
        for (int i = 0; i < length - 2; i++) {
            body.append("|");
            for (int j = 0; j < width; j++) {
                body.append(" ");
            }
            body.append("|\n");
        }

        System.out.println(firstAndLastLine);
        System.out.print(body);
        System.out.print(firstAndLastLine);
    }
}
public class DrawingTool {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String figure = sc.readLine();
        switch (figure){
            case "Square":
                int size = Integer.parseInt(sc.readLine());
                Rectangle square = new Rectangle(size);
                CorDraw cd = new CorDraw(size);
                cd.draw(size);
                break;
            case "Rectangle":
                int width = Integer.parseInt(sc.readLine());
                int length = Integer.parseInt(sc.readLine());
                Rectangle rectangle = new Rectangle(width, length);
                CorDraw cd2 = new CorDraw(width, length);
                cd2.draw(width, length);
                break;
        }

    }
}
