public class Main {
    public static void main(String[] args) {
        Integer[][] m1 = new Integer[][]{{1, 2}, {3, 4}};
        Integer[][] m2 = new Integer[][]{{1, 1}, {1, 1}};
        IntegerMatrix integerMatrix = new IntegerMatrix();

        // Perform matrix operations
        Integer[][] sum = integerMatrix.addMatrix(m1, m2);
        Integer[][] product = integerMatrix.multiplyMatrix(m1, m2);
        Integer min = integerMatrix.minMatrix(m1, m2);

        // Print results
        System.out.println("m1 + m2 = ");
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("m1 * m2 = ");
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMinimum value = " + min);
    }
}


class IntegerMatrix extends GenericMatrix<Integer> {

    @Override
    /** Add two integers */
    protected Integer add(Integer o1, Integer o2) {
        return o1 + o2;
    }

    @Override
    /** Multiply two integers */
    protected Integer multiply(Integer o1, Integer o2) {
        return o1 * o2;
    }

    @Override
    /** Specify zero for an integer */
    protected Integer zero() {
        return 0;
    }

    /** Find the minimum value between two matrices */
    public Integer minMatrix(Integer[][] matrix1, Integer[][] matrix2) {
        // Check bounds of the two matrices
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
            throw new RuntimeException("The matrices do not have the same size");
        }
        Integer min = matrix1[0][0];
        // Find the minimum value
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] < min) {
                    min = matrix1[i][j];
                }
                if (matrix2[i][j] < min) {
                    min = matrix2[i][j];
                }
            }
        }
        return min;
    }
}


abstract class GenericMatrix<E extends Number> {

    /**
     * Abstract method for adding two elements of the matrices
     */
    protected abstract E add(E o1, E o2);

    /**
     * Abstract method for multiplying two elements of the matrices
     */
    protected abstract E multiply(E o1, E o2);

    /**
     * Abstract method for defining zero for the matrix element
     */
    protected abstract E zero();

    /**
     * Add two matrices
     */
    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
        // Check bounds of the two matrices
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
            throw new RuntimeException("The matrices do not have the same size");
        }
        E[][] result = (E[][]) new Integer[matrix1.length][matrix1[0].length];
        // Perform addition
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    }

    /** Multiply two matrices */
    /**
     * Multiply two matrices
     */
    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        // Check bounds
        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException("The matrices do not have compatible size");
        }

        // Create result matrix
        E[][] result = (E[][]) new Integer[matrix1.length][matrix2[0].length];

        // Perform multiplication of two matrices
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();

                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }

        return result;
    }

    /**
     * Find the smallest value among two matrices
     */
    public E minMatrix(E[][] matrix1, E[][] matrix2) {
        E min = matrix1[0][0];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j].doubleValue() < min.doubleValue()) {
                    min = matrix1[i][j];
                }
            }
        }

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                if (matrix2[i][j].doubleValue() < min.doubleValue()) {
                    min = matrix2[i][j];
                }
            }
        }

        return min;
    }
}
