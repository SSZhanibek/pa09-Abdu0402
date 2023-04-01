import java.util.ArrayList;

public class GenericMethod {
    public static void main(String[] args) {
        
    
        Complex[] complexes = {
            new Complex(3, 4),
            new Complex(5, 12),
            new Complex(8, 6),
            new Complex(13, 13),
        };
        System.out.println(sum3(complexes));
    }

    public static double sum(ArrayList<Number> numbers) {
        double total = 0;
        for (Number number: numbers) {
            total += number.doubleValue();
        }
        return total;
    }

    public static double sum2(ArrayList<? extends Number> numbers) {
        double total = 0;
        for (Number number: numbers) {
            total += number.doubleValue();
        }
        return total;
    }

    public static <T extends Number> double sum3(T[] numbers) {
        double total = 0;
        for (T element: numbers) {
            total += element.doubleValue();
        }
        return total;
    }
}
