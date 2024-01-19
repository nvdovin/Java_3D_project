import java.util.ArrayList;


class Main {
    public static void main(String[] args) {
        System.out.println("I'll try to print here the table!");

        int WIGHT = 230, HEIGHT = WIGHT / 4;
        int COLS_MID = WIGHT / 2, ROWS_MID = HEIGHT / 2;
        double K = WIGHT / HEIGHT;

        int max_volume = WIGHT + HEIGHT;
        System.out.println(max_volume);
        char[] gradient = new char[]{' ', '.', ',', ':', 'c', 't', 'V', 'W', '@'};

        int[][] points_array = {
                {1, 1, 1},
                {1, -1, 1},
                {-1, -1, 1},
                {-1, 1, 1},
                {1, 1, -1},
                {1, -1, -1},
                {-1, -1, -1},
                {-1, 1, -1}

        };
        double scale = 8;
        String rotate = "xyz";

//  Тело программы
        for (double angle = 0; angle < 100; angle += 0.01) {
//            GradientCircle.clearConsole();

            char[][] screen = ProjectUtils.get_empty_screen(WIGHT, HEIGHT);
            for (int[] point : points_array) {
                double[][] new_point = Matrix.rotate_point(rotate, angle, point);
                int x = (int) (new_point[0][0] * scale * K + COLS_MID);
                int y = (int) (new_point[1][0] * scale + ROWS_MID);

                screen[x][y] = '@';
            }
            ProjectUtils.show_screen(WIGHT, HEIGHT, screen);

        }
    }
}
