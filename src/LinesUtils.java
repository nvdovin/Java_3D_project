import java.lang.reflect.Array;
import java.util.ArrayList;


public class LinesUtils {
    public static void main(String[] args) {
        int[] A = {32, 2}, B = {30, 30};
        ArrayList<int[]> line = get_lines_coordinates(A, B);
        int i = 0;
        for (int[] l : line){
            System.out.printf("%d. [%d; %d] \n", i, l[0], l[1]);
            i++;
        }
    }
    public static ArrayList<int[]> get_lines_coordinates(int[] A, int[] B){
    /*   Как найти все точки на отрезке, который соединяет две точки
         Конечно же с помощью формулы:

            y = ((By - Ay) / (Bx - Ax)) * (x - Ax) - Ay;
            x ++;
    */

        ArrayList<int[]> points_coordinates = new ArrayList<>();
        double distance = B[0] - A[0];

        // Проходимся циклом по каждой Х точке и ищет У точку
        if (distance > 2){
            for (int x = A[0] + 1; x < B[0]; x++){
                double y = ((double) (B[1] - A[1]) / (B[0] - A[0])) * (x - A[0]) - A[1];
                points_coordinates.add(new int[]{x, (int)y});
            }
        } else if (distance < -2) {
            for (int x = A[0] - 1; x > B[0]; x--){
                double y = ((double) (B[1] - A[1]) / (B[0] - A[0])) * (x - A[0]) - A[1];
                points_coordinates.add(new int[]{x, (int)y});
            }
        }
        else {
            int min_point = Math.min(A[1], B[1]), max_point = Math.max(A[1], B[1]);
            while (min_point < max_point){
                points_coordinates.add(new int[]{A[0], min_point});
                min_point++;
            }
        }
        return points_coordinates;
    }
}
