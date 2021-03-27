package life;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] input_1 = input.split(" ");
        int N = Integer.parseInt(input_1[0]);
        int S = Integer.parseInt(input_1[1]);
        int M = Integer.parseInt(input_1[2]);

       int[][] universe = set(N, N, S);

       while(M != 0){

           universe = (next(universe,N,N));
           draw(universe);
           M--;
           try {
               if (System.getProperty("os.name").contains("Windows"))
                   new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
               else
                   Runtime.getRuntime().exec("clear");
           }
           catch (IOException | InterruptedException ignored) {}
               }




    }

    public static void draw(int[][] universe) {

        for (int[] ints : universe) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 1) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    public static int[][] set(int cols, int rows, int S) {

        int[][] universe = new int[cols][rows];
        Random random = new Random(S);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (random.nextBoolean()) {
                    universe[i][j] = 1;
                } else {
                    universe[i][j] = 0;
                }
            }
        }

        return universe;
    }

    public static int[][] next(int[][] grid, int cols, int rows) {
        int[][] next = new int[cols][rows];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int state = grid[i][j];
                int neighbors = countNeightbors(grid, i, j, cols, rows);
                if (state == 0 && neighbors == 3) {
                    next[i][j] = 1;
                } else if (state == 1 && (neighbors < 2 || neighbors > 3)) {
                    next[i][j] = 0;
                } else {
                    next[i][j] = state;
                }
            }
        }
        return next;
    }

    public static int countNeightbors(int[][] grid, int x, int y, int cols, int rows) {
        int sum = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int col = (x + i + cols) % cols;
                int row = (y + j + rows) % rows;
                sum += grid[col][row];
            }

        }
        sum -= grid[x][y];
        return sum;
    }


}


