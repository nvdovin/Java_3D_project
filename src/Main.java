import java.util.Scanner;


class Main{
    public static void main(String[] args){
        System.out.println("I'll try to print here the table!");

        int x_row = 30, y_row = 80;
        int x_mid = x_row / 2, y_mid = y_row / 2;
        char[][] array = new char[x_row][y_row];

        int max_volume = x_row + y_row;
        System.out.println(max_volume);
        char[] gradient = new char[]{' ', '.', ',', ':', 'c', 't', 'V', 'W', '@'};
        int[] grades = new int[gradient.length];

        for (int i = 0; i < gradient.length; i++){
            grades[i] = (i / max_volume) * 100;
            System.out.println((i / max_volume) * 100);
        }

    }
}