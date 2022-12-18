
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

   public static String[][] game = new String[7][7];
   public static boolean turn = true;
   public static boolean gameover = false;

    public static void main(String[] args){


        for (String[] fill: game) {
            Arrays.fill(fill, "▇");
        }
        int count = 1;
        for (int i = 0; i < 7; i++) {

            game[6][i] = Integer.toString(count);
            count++;

        }
        printGame();

        inputRow();

    }

    private static void inputRow() {

        Scanner sc = new Scanner(System.in);

        while (!gameover) {

            if (turn) System.out.print("[Player 1] Input Row: ");
            else System.out.println("[Player 2] Input Row: ");
            int row = sc.nextInt();

            switch (row) {
                case 1 -> {
                    replaceAtIndex(checkForSpace(0));
                    printGame();
                }
                case 2 -> {
                    replaceAtIndex(checkForSpace(1));
                    printGame();
                }
                case 3 -> {
                    replaceAtIndex(checkForSpace(2));
                    printGame();
                }
                case 4 -> {
                    replaceAtIndex(checkForSpace(3));
                    printGame();
                }
                case 5 -> {
                    replaceAtIndex(checkForSpace(4));
                    printGame();
                }
                case 6 -> {
                    replaceAtIndex(checkForSpace(5));
                    printGame();
                }
                case 7 -> {
                    replaceAtIndex(checkForSpace(6));
                    printGame();
                }
            }
        }


    }

    private static int[] checkForSpace(int row){

        int count = 0;
        int[] x = new int[2];

        for (String[] field : game) {
            if (!Objects.equals(field[row], "▇")) {
                count--;
                break;
            }
            else {
                count++;
            }
        }
        x[0] = count;
        x[1] = row;

        return x;
    }

    private static void replaceAtIndex(int[] index){

        if (turn) {
            game[index[0]][index[1]] = "X";
            turn = !turn;
        } else {
            game[index[0]][index[1]] = "O";
            turn = !turn;
        }

    }

    private static void printGame(){
        for (String[] field: game) {
            System.out.println(Arrays.toString(field));
        }
    }

}