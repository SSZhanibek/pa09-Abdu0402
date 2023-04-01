import java.util.Arrays;
public class Main {public static void main(String[] args) {
    GeometricObject[] g = {new Circle(7), new Circle(8),new Rectangle(9, 4), new Rectangle(11, 8)};
    System.out.println("Before sorting:");
    for (GeometricObject a:g) {
        System.out.println(a);
    }
    System.out.println();
    System.out.println("After sorting:");
    Arrays.sort(g);
    for (GeometricObject a:g) {
        System.out.println(a);
    }
}
    public static abstract class GeometricObject implements Comparable<GeometricObject>{
        public abstract double getArea();
        @Override
        public int compareTo(GeometricObject o){
            if(o.getArea() > this.getArea())return -1;
            else if(o.getArea() < this.getArea())return 1;
            return 0;
        }
    }
    public static class Circle extends GeometricObject{private int radius;
        public Circle(int radius) {
            this.radius = radius;
        }
        public double getArea(){
            return radius * radius * 3.14;
        }
        public String toString(){
            return "Circle : " + this.getArea();
        }
    }
    public static class Rectangle extends GeometricObject{
        private int width = 1;
        private int height = 1;
        public Rectangle(int width, int height){
            this.width = width;
            this.height = height;
        }
        @Override
        public double getArea() {
            return this.height * this.width;
        }
        public String toString(){
            return "Rectangle : " + this.getArea();
        }
    }}
