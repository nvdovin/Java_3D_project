public class Matrix {

    public static double[][] multiple_matrixes(double[][] matrix1, double[][] matrix2){
        int matrix1_cols = matrix1.length, matrix1_rows = matrix1[0].length;
        int matrix2_cols = matrix2.length, matrix2_rows = matrix2[0].length;

        if (matrix1_cols == matrix2_rows){
            double[][] summed_matrix = new double[matrix2_rows][matrix1_cols];
            for (int n = 0; n < matrix1_cols; n++){
                double current_volume = 0;
                for (int m = 0; m < matrix2_rows; m++){
                    current_volume += matrix1[n][m] * matrix2[m][n];
                    summed_matrix[n][m] = current_volume;
                }
            }
            return summed_matrix;
        }
        else {
            double[][] summed_matrix = new double[matrix2_rows][matrix1_cols];
            for (int n = 0; n < matrix1_cols; n++){
                double current_volume = 0;
                for (int m = 0; m < matrix2_rows; m++){
                    current_volume += matrix1[n][m] * matrix2[m][n];
                    summed_matrix[n][m] = current_volume;
                }
            }
            return summed_matrix;
        }
    }

    public static double[] rotate(String arg, double angle, double[][] point ){
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
        double[][] rotate_xy = multiple_matrixes(rotate_x, rotate_y);
        double[][] rotate_xz = multiple_matrixes(rotate_x, rotate_z);
        double[][] rotate_yz = multiple_matrixes(rotate_y, rotate_z);
        double[][] rotate_xyz = multiple_matrixes(rotate_xy, rotate_yz);

        double[][] matrix;

        switch (arg){
            case "x": matrix = multiple_matrixes(point, rotate_x); break;
            case "y": matrix = multiple_matrixes(point, rotate_y); break;
            case "z": matrix = multiple_matrixes(point, rotate_z); break;
            case "xy": matrix = multiple_matrixes(point, rotate_xy); break;
            case "xz": matrix = multiple_matrixes(point, rotate_xz); break;
            case "yz": matrix = multiple_matrixes(point, rotate_yz); break;
            case "xyz": matrix = multiple_matrixes(point, rotate_xyz); break;
            default: matrix = {
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1}
            }; break;
        }
        return  matrix;

    }

}
