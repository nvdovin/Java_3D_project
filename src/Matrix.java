public class Matrix {

    public static double[][] multiple_2_matrices(double[][] matrix1, double[][] matrix2){
        double[][] result = new double[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static int[] multiple_matrix_and_vector(double[][] matrix, int[] point){
        if (matrix[0].length != point.length) {
            throw new IllegalArgumentException("Matrix columns must be equal to vector length.");
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[] result = new int[rows];

        for (int i = 0; i < rows; i++) {
            int sum = 0;

            for (int j = 0; j < columns; j++) {
                sum += matrix[i][j] * point[j];
            }

            result[i] = sum;
        }

        return result;
    }

    public static int[] rotate_point(String arg, double angle, int[] point ){
        int[] new_point;
        double[][] rotate_x = {
            {1, 0, 0},
            {0, Math.cos(angle), -Math.sin(angle)},
            {0, Math.sin(angle), Math.cos(angle)}
        };
        double[][] rotate_y = {
                {Math.cos(angle), 0, Math.sin(angle)},
                {0, 1, 0},
                {-Math.sin(angle), 0, Math.cos(angle)}
        };
        double[][] rotate_z = {
                {Math.cos(angle), -Math.sin(angle), 0},
                {Math.sin(angle), Math.cos(angle), 0},
                {0, 0, 1}
        };

        switch (arg){
            case "x": {
                new_point = multiple_matrix_and_vector(rotate_x, point);
                break;
            }
            case "y": {
                new_point = multiple_matrix_and_vector(rotate_y, point);
                break;
            }
            case "z": {
                new_point = multiple_matrix_and_vector(rotate_z, point);
                break;
            }
            case "xy": {
                double[][] temp_matrix = multiple_2_matrices(rotate_x, rotate_y);
                new_point = multiple_matrix_and_vector(temp_matrix, point);
                break;
            }
            case "xz": {
                double[][] temp_matrix = multiple_2_matrices(rotate_x, rotate_z);
                new_point = multiple_matrix_and_vector(temp_matrix, point);
                break;
            }
            case "yz": {
                double[][] temp_matrix = multiple_2_matrices(rotate_y, rotate_z);
                new_point = multiple_matrix_and_vector(temp_matrix, point);
                break;
            }
            case "xyz": {
                double[][] temp_matrix = multiple_2_matrices(rotate_x, rotate_y);
                temp_matrix = multiple_2_matrices(temp_matrix, rotate_z);
                new_point = multiple_matrix_and_vector(temp_matrix, point);
                break;
            }
            default:{
                new_point = point;
            }
        }
        return new_point;
    }

}
