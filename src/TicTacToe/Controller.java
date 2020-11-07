package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args){

        boolean check;
        int dimension = 0;
        TicTacToe ticTacToe = new TicTacToe();
        final Scanner scan = new Scanner(System.in);
        String playerX;
        String playerO;


        System.out.println("Enter name for Player 1:");
        System.out.print(">>");
        playerX = scan.next();

        System.out.println("Enter name for Player 2:");
        System.out.print(">>");
        playerO = scan.next();

        do {
            try {
                System.out.println("Enter the dimension of the game:");
                System.out.print(">>");
                dimension = scan.nextInt();
                if(dimension<3){
                    System.out.println("Enter a number larger than 2");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a whole number!");
                scan.next();
                continue;
            }
        }while(true);

        List<Character> board = new ArrayList<Character>(dimension*dimension);
        board = TicTacToe.createBoard(dimension);
        int selection=0;
        boolean validMove;
        String winner = null;
        do {
            do {
                TicTacToe.printBoard(dimension, board);
                validMove = false;
                System.out.println(playerX + ", choose a box to place an 'x' into:");
                System.out.print(">>");
                try {
                    selection = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a whole number!");
                    scan.next();
                    continue;
                }
                if (selection > 0 && selection <= dimension * dimension) {
                    board = ticTacToe.newMove('x', board, selection);
                    validMove = true;
                }
                else{
                    System.out.println("Invalid input. Please enter a number between 1 and "+dimension*dimension);
                }

            } while (!validMove);
            if(ticTacToe.winCheck(dimension,board,selection,'x')){
                winner=playerX;
                break;
            }

            do {
                TicTacToe.printBoard(dimension, board);
                validMove = false;
                System.out.println(playerO + ", choose a box to place an 'O' into:");
                System.out.print(">>");
                try {
                    selection = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a whole number!");
                    scan.next();
                    continue;
                }
                if (selection > 0 && selection <= dimension * dimension) {
                    board = ticTacToe.newMove('o', board, selection);
                    validMove = true;
                }
                else{
                    System.out.println("Invalid input. Please enter a number between 1 and"+dimension*dimension);
                }

            } while (!validMove);
            if(ticTacToe.winCheck(dimension,board,selection,'o')){
                winner=playerO;
                break;
            }

        }while(true);

        TicTacToe.printBoard(dimension, board);
        System.out.println("Congratulations "+winner+"! You have won.");
    }
}
