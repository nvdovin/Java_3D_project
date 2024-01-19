import java.io.IOException;



public class ProjectUtils {
    public static void main(String[] args) throws IOException {
        int WIGHT = 240, HEIGHT = 40;
        int cols_mid = WIGHT / 2, rows_mid = HEIGHT / 2, cor_HEIGHT = WIGHT / HEIGHT, cor_WIGHT = 2;
        char[] gradient = {' ', '.', ',', ':', 't', 'S', 'Q', '@'};
        int gradients_len = gradient.length - 1;
        int MAX_LEN = (int)Math.sqrt(Math.pow(rows_mid, 2) + Math.pow(cols_mid, 2));

        double alpha = 0;
        while (true) {
            alpha += 0.005;
                double beta = Math.cos(alpha * 10) * 100;

                char[][] screen = get_empty_screen(WIGHT, HEIGHT);
                for (int y = 0; y < HEIGHT; y++) {
                    for (int x = 0; x < WIGHT; x++) {
                        int current_len = (int) Math.sqrt(Math.pow(x - cols_mid + (int) beta, 2) + Math.pow(y - rows_mid, 2) * cor_HEIGHT);
                        int current_color = (current_len * gradients_len) / MAX_LEN;

                        if (current_color > gradients_len) current_color = gradients_len;
                        screen[x][y] = gradient[gradients_len - current_color];
                    }
                }
//                clearConsole();
                show_screen(WIGHT, HEIGHT, screen);
            }

    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }

    public static char[][] get_empty_screen(int WIGHT, int HEIGHT){
        char[][] screen = new char[WIGHT][HEIGHT];
        for (int rows = 0; rows < HEIGHT; rows++){
            for (int cols = 0; cols < WIGHT; cols++){
                screen[cols][rows] = ' ';
            }
        }
        return screen;
    }

    public static void show_screen(int WIGHT, int HEIGHT, char[][] screen){
        //Here I want to create the method where I will can to show my screen

        String buffer = "";
        for (int y = 0; y < HEIGHT; y++){
            for (int x = 0; x < WIGHT; x++){
                buffer += screen[x][y];
            }
            buffer += "\r\n";
        }
        System.out.print(buffer);
    }

    public static int[][] get_lines(int[] point1, int[] point2){
        // y = ((y1 - y0) / (x1 - x0) * (x - x0) + y0
        // x += 1

        double check_len = point2[0] - point1[0];
        int[][] lines_coordinates = new int[(int)check_len][2];
        if (point1 != point2){
            int x = point1[0];
            int i = 0;
            if (check_len > 1){
                while (x != point2[0]){
                    int y = ((point2[1] - point1[1]) / (point2[0] - point1[0])) * (x  - point1[0]) + point2[0];
                    x++;
                    lines_coordinates[i][0] = x;
                    lines_coordinates[i][1] = y;
                }
            } else if (check_len >= -1 || check_len <= 1) {
                int vertical_len = Math.abs(point1[1] - point2[1]);
                int highter_point = Math.max(point1[1], point2[1]);
                for (int lower_point = Math.min(point1[1], point2[1]); lower_point <= highter_point; lower_point++){
                    lines_coordinates[i][0] = x;
                    lines_coordinates[i][1] = lower_point;
                }
            } else if (check_len < -1) {
                while (x != point2[0]){
                    int y = ((point2[1] - point1[1]) / (point2[0] - point1[0])) * (x  - point1[0]) + point2[0];
                    x--;
                    lines_coordinates[i][0] = x;
                    lines_coordinates[i][1] = y;
                }
            }
        }
        return lines_coordinates;
    }

}
