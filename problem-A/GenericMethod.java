import java.util.ArrayList;

public class GenericMethod {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<Number>();
        numbers.add(1);
        numbers.add(1.2);
        numbers.add(3.14f);
        byte b = 1;
        numbers.add(b);
        short sh = 122;
        numbers.add(sh);

        // System.out.println(numbers);
        add(numbers);

        Integer[] intNumbers = {1, 2, 3, 4, 5};
        Double[] doubleNumbers = {1.1, 2.2, 3.3};
        System.out.println(GenericMethod.<Integer>add(intNumbers));
        System.out.println(GenericMethod.<Double>add(doubleNumbers));
    }

    public static void add(ArrayList<Number> numbers) {
        double total = 0;
        for (Number number: numbers) {
            // if (number instanceof Integer) {
            //     total += number.intValue();
            // } else if (number instanceof Double) {
            //     total += number.doubleValue();
            // } else if (number instanceof Float) {
            //     total += (Float) number;
            // } else if (number instanceof Byte) {
            //     total += (Byte) number;
            // } else if (number instanceof Short) {
            //     total += (Short) number;
            // }
            // System.out.println(number.getClass().getName());
            total += number.doubleValue();
        }
        System.out.println(total);
    }

    public static <T extends Number> double add(T[] values) {
        double total = 0;
        for (int i = 0; i < values.length; i++) {
            total += values[i].doubleValue();
        }
        return total;
    }
}
