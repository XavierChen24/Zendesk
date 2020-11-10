package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    public static List createBoard(int dimension) {
        List<Character> board = new ArrayList<Character>(dimension*dimension);
        System.out.println("Your size of board is:" + (dimension*dimension));
        for(int i = 0; i<(dimension*dimension); i++){
            board.add('e');
        }
        return board;
    }
    
    public static void printBoard(int dimension, List board) {
        int count=0;
        for(int rowCount=1;  rowCount<= dimension; rowCount++) {                                                        //each row

            for (int columnCount = 1; columnCount <= dimension; columnCount++) {                                        //each column in each row.
                if(board.get(count).equals('e')) {                                                                      //checks if they are empty
                    System.out.print("\t" + (count+1) + "\t");                                                          //print empty space
                }
                else {
                    System.out.print("\t" + board.get(count) + "\t");                                                   //prints selections
                }
                if(columnCount<dimension){
                    System.out.print("|");
                }

                count++;
            }
            System.out.print("\n");
            for (int columnCount = 1; columnCount <= dimension; columnCount++) {
                if(rowCount==dimension){
                    break;
                }
                System.out.print("-----------------");
            }
            System.out.print("\n");
        }
    }

    public static List newMove(Character turn, List board, int selection) {
        if(board.get(selection-1).equals('e')) {
            board.set(selection-1,turn);
        }
        else {
            System.out.println("Selection is already played. Please select a valid move!");
        }
        return board;
    }

    public static boolean winCheck(int dimension, List board, int choice, Character turn){

        List<Boolean> tempBoard = new ArrayList<Boolean>(25);                                                      // created a new 5x5 board for checker
                                                                                                                        //refer to documentation to understand methodology
        for(int row=-2; row<=2; row++){
            for(int column=-2; column<=2;column++) {
                try {
                    tempBoard.add(board.get(choice + row * dimension + column-1).equals(turn));
                }catch(Exception ignore){
                    tempBoard.add(false);
                }
            }
        }

        choice = 12;
        dimension = 5;

        if ((tempBoard.get(choice - dimension - 1) && (tempBoard.get(choice + dimension + 1)))) {                       //check 1,5
            return true;
        } else if ((tempBoard.get(choice - dimension - 1)) && (tempBoard.get(choice - 2 * dimension - 2))) {            //check 1,9
            return true;
        } else if ((tempBoard.get(choice + dimension + 1)) && (tempBoard.get(choice + 2 * dimension + 2))) {            //check 5,13
            return true;
        }


        if ((tempBoard.get(choice - dimension + 1)) && (tempBoard.get(choice + dimension - 1))) {                       //check 3,7
            return true;
        } else if ((tempBoard.get(choice - dimension + 1)) && (tempBoard.get(choice - 2 * dimension + 2))) {            //check 3,11
            return true;
        } else if ((tempBoard.get(choice + dimension - 1)) && (tempBoard.get(choice + 2 * dimension - 2))) {            //check 7,15
            return true;
        }


        if ((tempBoard.get(choice - dimension)) && (tempBoard.get(choice + dimension))) {                               //check 2,6
            return true;
        } else if ((tempBoard.get(choice - dimension)) && (tempBoard.get(choice - 2 * dimension))) {                    //check 2,10
            return true;
        } else if ((tempBoard.get(choice + dimension)) && (tempBoard.get(choice + 2 * dimension))) {                    //check 6,14
            return true;
        }


        if ((tempBoard.get(choice + 1)) && (tempBoard.get(choice - 1))) {                                               //check 4,8
            return true;
        } else if ((tempBoard.get(choice + 1)) && (tempBoard.get(choice + 2))) {                                        //check 4,12
            return true;
        } else if ((tempBoard.get(choice - 1)) && (tempBoard.get(choice - 2))) {                                        //check 8,16
            return true;
        }

        return false;
    }

}
