package Q2 ;

public class Board {
    private int [][] board = new int[3][3];
    /* elements of board is either 0, 1 or 2 
     * 0 means empty
     * 1 means player 1's token  (say X) 
     * 2 means player 2's token  (say O)
     */

    public Board(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j] = 0;
            }
        }
    }






    public void printBoard(){
        /*
         * Don't change this function
         */
        System.out.println("Board:");
        System.out.println("-------------");
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                if(board[i][j]==0){
                    System.out.print(" ");
                }
                else if(board[i][j]==1){
                    System.out.print("X");
                }
                else if(board[i][j]==2){
                    System.out.print("O");
                }
                System.out.print(" | ");
            }
            System.out.println("\n-------------");   
        }
    }











    public Boolean available(Integer x, Integer y){
        /*
         * TODO: Check if the position (x,y) is available
         * return true if available. 
         * Also return false if (x,y) is not a valid position
         */

        if( x < 0 || x > 2 || y < 0 || y > 2){
            return false;
        }
        else if(board[x][y] == 0){
            return true;
        }
        else{
            return false;
        }

    }











    public void updateBoard(Integer[] pos, Integer id){
        /*
         * TODO: Update the board 
         */

        board[pos[0]][pos[1]] = id;


    }

    // create any helper functions you need

    











    public int checkBoard() {

        printBoard();
        /*
         * Don't remove the above line
         */

        // EDIT BELOW THIS LINE
        /*
         * TODO: Check the board and return the status of the game
         * -1 if Game has Not yet Ended
         * 0 if Game has Ended in a Draw
         * 1 if Player 1 has Won
         * 2 if Player 2 has Won
         */

        // This part is the soul of this game! ::::::::::::::::::::::::::



        // Checking rows for lines:

        for(int rowNo = 0; rowNo < 3; rowNo++){

            // if all three equal
            if( board[rowNo][0] == board[rowNo][1] && board[rowNo][1] == board[rowNo][2] ){
                if( board[rowNo][0] == 1 )
                {
                    return 1;
                }
                else if( board[rowNo][0] == 2 )
                {
                    return 2;
                }
                else{

                }
            }

        }

        // Checking columns for lines:

        for(int colNo = 0; colNo < 3; colNo++){

            // if all three equal
            if( board[0][colNo] == board[1][colNo] && board[1][colNo] == board[2][colNo] ){
                if( board[0][colNo] == 1 )
                {
                    return 1;
                }
                else if( board[0][colNo] == 2 )
                {
                    return 2;
                }
                else{

                }
            }

        }


        // Checking diagonals for lines:

        // Main diagonal
        if( board[0][0] == board[1][1] && board[1][1] == board[2][2] ){
            if( board[0][0] == 1 ){
                return 1;
            }
            else if( board[0][0] == 2) {
                return 2;
            }
            else{}
        }

        // Opposite diagonal
        if( board[0][2] == board[1][1] && board[1][1] == board[2][0] ){
            if( board[0][2] == 1 ){
                return 1;
            }
            else if( board[0][2] == 2) {
                return 2;
            }
            else{}
        }



        // All possible lines have been checked
        // Now it is either draw or remaining

        // Checking for remaining
        // If any place is empty, game is remaining

        boolean isRemaining = false;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == 0){
                    isRemaining = true;
                }
            }
        }
        if(isRemaining){
            return -1;
        }
        else{
            return 0;
        }

    }
}
