import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       // 2D array to make the actual board of TicTacToe.
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}
                         };
        Scanner sc = new Scanner(System.in);

        while(true) {
            // printing board after each Turn.
            printBoard(board);
            // calling player Turn.
            playerTurn(board, sc);
            // checks if the player won after its turn.
            if(isGameFinished(board))
            {
                break;
            }
            // calling computer Turn.
            computerTurn(board);
            // checks if the computer won after its turn.
            if(isGameFinished(board))
            {
                break;
            }
        }
    }
    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true)
        {
            computerMove = rand.nextInt(9) + 1; // we added one because the range here is 0-8, (we want 1-9).
            if (isValidMove(board, String.valueOf(computerMove)))
            {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, String.valueOf(computerMove), 'O');
    }
    // Cases of what a user can input on the grid.
    private static void playerTurn(char[][] board, Scanner sc) {
        String userInput;
        while (true)
        {
            System.out.println("Where would you like to play? (1-9)");
            userInput = sc.nextLine();
            if (isValidMove(board, userInput))
            {
                break;
            } else {
                System.out.println("Input " + userInput + " was invalid, choose an empty spot. ");
                printBoard(board);
            }
        }
            // We are calling placeMove method to place the symbol (after validating that there is the spot is empty).
            placeMove(board, userInput, 'X');
        }
    //method to check if the spot is empty. Boolean, True/False.
    private static boolean isValidMove (char[][] board, String position)
    {
        switch(position){
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return(board[0][2] == ' ');
            case "4":
               return(board[1][0] == ' ');
            case "5":
                return(board[1][1] == ' ');
            case "6":
                return(board[1][2] == ' ');
            case "7":
               return(board[2][0] == ' ');
            case "8":
                return(board[2][1] == ' ');
            case "9":
                return(board[2][2] == ' ');
            default:
            return false;
        }
    }
    // This method takes the board, position which is the userInput and symbol = 'X' as parameters
    // and checks in a switch case to know where to place the symbol.
    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position){
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;

            default:
                System.out.println(":(");
        }
    }
    // This method is checking 2 cases:
    // 1) if the game ended in a tie -> no other blank places are left to choose
    // (we check this by looping every indice of the grid and see if its equal to == ' ', if yes gameNotFinished.
    // 2) if 1 of the participants won.
    private static boolean isGameFinished(char[][] board) {
        // if there is a winner.
        if (ParticipantWin(board, 'X') == true)
        {
            printBoard(board);
            System.out.println("Player wins!!");
            return true;
        }
        if (ParticipantWin(board, 'O') == true)
        {
            printBoard(board);
            System.out.println("Computer wins!!");
            return true;
        }
        // if no other places are left -> tie.
       for(int i=0; i < board.length; i++)
       {
           for (int j=0; j < board[i].length; j++)
           {
            if(board[i][j] == ' ')
            {
                return false;
            }
           }
       }
       System.out.println("The game ended in a tie!");
        return true;
    }
        // All possible combinations of wins.
    private static boolean ParticipantWin(char[][] board, char symbol) {
        if ( //row checks
            (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
           (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
           (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
             //column checks
            (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
            (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
            (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
             // diagonal checks
            (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) )
        {
            return true;
        }
        return false;
    }
    //method that has the board structure.
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" + board[2][2]);
    }
}