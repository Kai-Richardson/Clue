package edu.up.cs301.game.GameFramework.Clue;

import android.widget.ProgressBar;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class ClueGameState extends GameState
{

    private int gameStage;
    private int[] rollResult;
    private TileData[][] board;
    private Card[] suggestedCards;
    private Card[] winningCards = new Card[3];
    private int moves;
    private int whoseMove;
    //maybe have a variable for all cards dealt, and it is accessed using player ID int
    //if any variables are added here, make sure to assign them in the two constuctors


    //some stuff for interface
    private static final long serialVersionUID = 7737393762469851826L;

    public ClueGameState()
    {

        //walls with no rooms
        board[0][7] = new TileData("wall", true);
        board[0][9] = new TileData("wall", true);
        board[4][0] = new TileData("wall", true);
        board[6][0] = new TileData("wall", true);
        board[7][24] = new TileData("wall", true);
        board[9][24] = new TileData("wall", true);
        board[17][24] = new TileData("wall", true);
        board[19][24] = new TileData("wall", true);
        board[24][6] = new TileData("wall", true);
        board[24][18] = new TileData("wall", true);

        //board center TileData
        board[9][9] = new TileData("wall", true);
        board[9][10] = new TileData("wall", true);
        board[9][11] = new TileData("wall", true);
        board[9][12] = new TileData("wall", true);
        board[9][13] = new TileData("wall", true);
        board[9][14] = new TileData("wall", true);
        board[10][9] = new TileData("wall", true);
        board[11][9] = new TileData("wall", true);
        board[12][9] = new TileData("wall", true);
        board[13][9] = new TileData("wall", true);
        board[14][9] = new TileData("wall", true);
        board[15][9] = new TileData("wall", true);
        board[10][14] = new TileData("wall", true);
        board[11][14] = new TileData("wall", true);
        board[12][14] = new TileData("wall", true);
        board[13][14] = new TileData("wall", true);
        board[14][14] = new TileData("wall", true);
        board[15][14] = new TileData("wall", true);
        board[15][13] = new TileData("wall", true);
        board[15][12] = new TileData("wall", true);
        board[15][11] = new TileData("wall", true);
        board[15][10] = new TileData("wall", true);

        //study TileData
        board[1][1] = new TileData("study", true);
        board[1][2] = new TileData("study", true);
        board[1][3] = new TileData("study", true);
        board[1][4] = new TileData("study", true);
        board[1][5] = new TileData("study", true);
        board[1][6] = new TileData("study", true);
        board[1][7] = new TileData("study", true);
        board[2][1] = new TileData("study", true);
        board[2][2] = new TileData("study", false);
        board[2][3] = new TileData("study", false);
        board[2][4] = new TileData("study", false);
        board[2][5] = new TileData("study", false);
        board[2][6] = new TileData("study", false);
        board[2][7] = new TileData("study", true);
        board[3][1] = new TileData("study", true);
        board[3][2] = new TileData("study", false);
        board[3][3] = new TileData("study", false);
        board[3][4] = new TileData("study", false);
        board[3][5] = new TileData("study", false);
        board[3][6] = new TileData("study", false);
        board[3][7] = new TileData("study", true);
        board[4][1] = new TileData("study", true);
        board[4][2] = new TileData("study", true);
        board[4][3] = new TileData("study", true);
        board[4][4] = new TileData("study", true); //door tile
        board[4][5] = new TileData("study", false);
        board[4][6] = new TileData("study", true);
        board[4][7] = new TileData("study", true);

        //hall TileData
        board[1][10] = new TileData("hall", true);
        board[1][11] = new TileData("hall", true);
        board[1][12] = new TileData("hall", true);
        board[1][13] = new TileData("hall", true);
        board[1][14] = new TileData("hall", true);
        board[1][15] = new TileData("hall", true);
        board[1][16] = new TileData("hall", true);
        board[2][10] = new TileData("hall", true);
        board[3][10] = new TileData("hall", false); //door tile
        board[4][10] = new TileData("hall", true);
        board[5][10] = new TileData("hall", true);
        board[6][10] = new TileData("hall", true);
        board[6][11] = new TileData("hall", true);
        board[6][12] = new TileData("hall", true);
        board[6][13] = new TileData("hall", false); //door tile
        board[6][14] = new TileData("hall", false); //door tile
        board[6][15] = new TileData("hall", true);
        board[6][16] = new TileData("hall", true);
        board[5][16] = new TileData("hall", true);
        board[4][16] = new TileData("hall", true);
        board[3][16] = new TileData("hall", true);
        board[2][16] = new TileData("hall", true);
        board[2][11] = new TileData("hall", false);
        board[2][12] = new TileData("hall", false);
        board[2][13] = new TileData("hall", false);
        board[2][14] = new TileData("hall", false);
        board[2][15] = new TileData("hall", false);
        board[3][11] = new TileData("hall", false);
        board[3][12] = new TileData("hall", false);
        board[3][13] = new TileData("hall", false);
        board[3][14] = new TileData("hall", false);
        board[3][15] = new TileData("hall", false);
        board[4][11] = new TileData("hall", false);
        board[4][12] = new TileData("hall", false);
        board[4][13] = new TileData("hall", false);
        board[4][14] = new TileData("hall", false);
        board[4][15] = new TileData("hall", false);
        board[5][11] = new TileData("hall", false);
        board[5][12] = new TileData("hall", false);
        board[5][13] = new TileData("hall", false);
        board[5][14] = new TileData("hall", false);
        board[5][15] = new TileData("hall", false);

        //lounge TitleData
        board[1][19] = new TileData("lounge", true);
        board[1][20] = new TileData("lounge", true);
        board[1][21] = new TileData("lounge", true);
        board[1][22] = new TileData("lounge", true);
        board[1][23] = new TileData("lounge", true);
        board[2][19] = new TileData("lounge", true);
        board[3][19] = new TileData("lounge", true);
        board[4][19] = new TileData("lounge", true);
        board[5][19] = new TileData("lounge", true);
        board[6][19] = new TileData("lounge", true);
        board[6][20] = new TileData("lounge", true); //door tile
        board[6][21] = new TileData("lounge", true);
        board[6][22] = new TileData("lounge", true);
        board[6][23] = new TileData("lounge", true);
        board[5][23] = new TileData("lounge", true);
        board[4][23] = new TileData("lounge", true);
        board[3][23] = new TileData("lounge", true);
        board[2][23] = new TileData("lounge", true);
        board[2][20] = new TileData("lounge", false);
        board[2][21] = new TileData("lounge", false);
        board[2][22] = new TileData("lounge", false);
        board[3][20] = new TileData("lounge", false);
        board[3][21] = new TileData("lounge", false);
        board[3][22] = new TileData("lounge", false);
        board[4][20] = new TileData("lounge", false);
        board[4][21] = new TileData("lounge", false);
        board[4][22] = new TileData("lounge", false);
        board[5][20] = new TileData("lounge", false);
        board[5][21] = new TileData("lounge", false);
        board[5][22] = new TileData("lounge", false);

        //dining room TileData
        board[10][17] = new TileData("dining", true);
        board[11][17] = new TileData("dining", true);
        board[12][17] = new TileData("dining", true);
        board[13][17] = new TileData("dining", true);
        board[14][17] = new TileData("dining", false); //door tile
        board[15][17] = new TileData("dining", true);
        board[16][17] = new TileData("dining", true);
        board[10][18] = new TileData("dining", true);
        board[10][19] = new TileData("dining", false); //door tile
        board[10][20] = new TileData("dining", true);
        board[10][21] = new TileData("dining", true);
        board[10][22] = new TileData("dining", true);
        board[10][23] = new TileData("dining", true);
        board[10][24] = new TileData("dining", true);
        board[11][24] = new TileData("dining", true);
        board[12][24] = new TileData("dining", true);
        board[13][24] = new TileData("dining", true);
        board[14][24] = new TileData("dining", true);
        board[15][24] = new TileData("dining", true);
        board[16][24] = new TileData("dining", true);
        board[16][18] = new TileData("dining", true);
        board[16][19] = new TileData("dining", true);
        board[16][20] = new TileData("dining", true);
        board[16][21] = new TileData("dining", true);
        board[16][22] = new TileData("dining", true);
        board[16][23] = new TileData("dining", true);
        board[11][18] = new TileData("dining", false);
        board[11][19] = new TileData("dining", false);
        board[11][20] = new TileData("dining", false);
        board[11][21] = new TileData("dining", false);
        board[11][22] = new TileData("dining", false);
        board[11][23] = new TileData("dining", false);
        board[12][18] = new TileData("dining", false);
        board[12][19] = new TileData("dining", false);
        board[12][20] = new TileData("dining", false);
        board[12][21] = new TileData("dining", false);
        board[12][22] = new TileData("dining", false);
        board[12][23] = new TileData("dining", false);
        board[13][18] = new TileData("dining", false);
        board[13][19] = new TileData("dining", false);
        board[13][20] = new TileData("dining", false);
        board[13][21] = new TileData("dining", false);
        board[13][22] = new TileData("dining", false);
        board[13][23] = new TileData("dining", false);
        board[14][18] = new TileData("dining", false);
        board[14][19] = new TileData("dining", false);
        board[14][20] = new TileData("dining", false);
        board[14][21] = new TileData("dining", false);
        board[14][22] = new TileData("dining", false);
        board[14][23] = new TileData("dining", false);
        board[15][18] = new TileData("dining", false);
        board[15][19] = new TileData("dining", false);
        board[15][20] = new TileData("dining", false);
        board[15][21] = new TileData("dining", false);
        board[15][22] = new TileData("dining", false);
        board[15][23] = new TileData("dining", false);

        //kitchen TileData
        board[20][19] = new TileData("kitchen", true);
        board[20][20] = new TileData("kitchen", false); //door tile
        board[20][21] = new TileData("kitchen", true);
        board[20][22] = new TileData("kitchen", true);
        board[20][23] = new TileData("kitchen", true);
        board[20][24] = new TileData("kitchen", true);
        board[21][19] = new TileData("kitchen", true);
        board[22][19] = new TileData("kitchen", true);
        board[23][19] = new TileData("kitchen", true);
        board[24][19] = new TileData("kitchen", true);
        board[24][20] = new TileData("kitchen", true);
        board[24][21] = new TileData("kitchen", true);
        board[24][22] = new TileData("kitchen", true);
        board[24][23] = new TileData("kitchen", true);
        board[24][24] = new TileData("kitchen", true);
        board[23][24] = new TileData("kitchen", true);
        board[22][24] = new TileData("kitchen", true);
        board[21][24] = new TileData("kitchen", true);
        board[21][20] = new TileData("kitchen", false);
        board[21][21] = new TileData("kitchen", false);
        board[21][22] = new TileData("kitchen", false);
        board[21][23] = new TileData("kitchen", false);
        board[22][20] = new TileData("kitchen", false);
        board[22][21] = new TileData("kitchen", false);
        board[22][22] = new TileData("kitchen", false);
        board[22][23] = new TileData("kitchen", false);
        board[23][20] = new TileData("kitchen", false);
        board[23][21] = new TileData("kitchen", false);
        board[23][22] = new TileData("kitchen", false);
        board[23][23] = new TileData("kitchen", false);

        //ballroom TitleData
        board[19][8] = new TileData("ballroom", true);
        board[20][8] = new TileData("ballroom", false); //door tile
        board[21][8] = new TileData("ballroom", true);
        board[22][8] = new TileData("ballroom", true);
        board[23][8] = new TileData("ballroom", true);
        board[24][8] = new TileData("ballroom", true);
        board[19][9] = new TileData("ballroom", true);
        board[19][10] = new TileData("ballroom", false); //door tile
        board[19][11] = new TileData("ballroom", true);
        board[19][12] = new TileData("ballroom", true);
        board[19][13] = new TileData("ballroom", true);
        board[19][14] = new TileData("ballroom", false); //door tile
        board[19][15] = new TileData("ballroom", true);
        board[19][16] = new TileData("ballroom", true);
        board[24][9] = new TileData("ballroom", true);
        board[24][10] = new TileData("ballroom", true);
        board[24][11] = new TileData("ballroom", true);
        board[24][12] = new TileData("ballroom", true);
        board[24][13] = new TileData("ballroom", true);
        board[24][14] = new TileData("ballroom", true);
        board[24][15] = new TileData("ballroom", true);
        board[24][16] = new TileData("ballroom", true);
        board[20][16] = new TileData("ballroom", false); //door tile
        board[21][16] = new TileData("ballroom", true);
        board[22][16] = new TileData("ballroom", true);
        board[23][16] = new TileData("ballroom", true);
        board[20][9] = new TileData("ballroom", false);
        board[20][10] = new TileData("ballroom", false);
        board[20][11] = new TileData("ballroom", false);
        board[20][12] = new TileData("ballroom", false);
        board[20][13] = new TileData("ballroom", false);
        board[20][14] = new TileData("ballroom", false);
        board[20][15] = new TileData("ballroom", false);
        board[21][9] = new TileData("ballroom", false);
        board[21][10] = new TileData("ballroom", false);
        board[21][11] = new TileData("ballroom", false);
        board[21][12] = new TileData("ballroom", false);
        board[21][13] = new TileData("ballroom", false);
        board[21][14] = new TileData("ballroom", false);
        board[21][15] = new TileData("ballroom", false);
        board[22][9] = new TileData("ballroom", false);
        board[22][10] = new TileData("ballroom", false);
        board[22][11] = new TileData("ballroom", false);
        board[22][12] = new TileData("ballroom", false);
        board[22][13] = new TileData("ballroom", false);
        board[22][14] = new TileData("ballroom", false);
        board[22][15] = new TileData("ballroom", false);
        board[23][9] = new TileData("ballroom", false);
        board[23][10] = new TileData("ballroom", false);
        board[23][11] = new TileData("ballroom", false);
        board[23][12] = new TileData("ballroom", false);
        board[23][13] = new TileData("ballroom", false);
        board[23][14] = new TileData("ballroom", false);
        board[23][15] = new TileData("ballroom", false);

        //garden TileData
        board[20][0] = new TileData("garden", true);
        board[21][0] = new TileData("garden", true);
        board[22][0] = new TileData("garden", true);
        board[23][0] = new TileData("garden", true);
        board[24][0] = new TileData("garden", true);
        board[20][1] = new TileData("garden", true);
        board[20][2] = new TileData("garden", true);
        board[20][3] = new TileData("garden", true);
        board[20][4] = new TileData("garden", true);
        board[20][5] = new TileData("garden", true);
        board[21][5] = new TileData("garden", false); //door tile
        board[22][5] = new TileData("garden", true);
        board[23][5] = new TileData("garden", true);
        board[24][5] = new TileData("garden", true);
        board[24][1] = new TileData("garden", true);
        board[24][2] = new TileData("garden", true);
        board[24][3] = new TileData("garden", true);
        board[24][4] = new TileData("garden", true);
        board[21][1] = new TileData("garden", false);
        board[21][2] = new TileData("garden", false);
        board[21][3] = new TileData("garden", false);
        board[21][4] = new TileData("garden", false);
        board[22][1] = new TileData("garden", false);
        board[22][2] = new TileData("garden", false);
        board[22][3] = new TileData("garden", false);
        board[22][4] = new TileData("garden", false);
        board[23][1] = new TileData("garden", false);
        board[23][2] = new TileData("garden", false);
        board[23][3] = new TileData("garden", false);
        board[23][4] = new TileData("garden", false);

        //billard TileData
        board[13][0] = new TileData("game", true);
        board[14][0] = new TileData("game", true);
        board[15][0] = new TileData("game", true);
        board[16][0] = new TileData("game", true);
        board[17][0] = new TileData("game", true);
        board[13][1] = new TileData("game", true);
        board[13][2] = new TileData("game", false); //door tile
        board[13][3] = new TileData("game", true);
        board[13][4] = new TileData("game", true);
        board[13][5] = new TileData("game", true);
        board[14][5] = new TileData("game", true);
        board[15][5] = new TileData("game", true);
        board[16][5] = new TileData("game", false); //door tile
        board[17][5] = new TileData("game", true);
        board[17][4] = new TileData("game", true);
        board[17][3] = new TileData("game", true);
        board[17][2] = new TileData("game", true);
        board[17][1] = new TileData("game", true);
        board[14][1] = new TileData("game", false);
        board[14][2] = new TileData("game", false);
        board[14][3] = new TileData("game", false);
        board[14][4] = new TileData("game", false);
        board[15][1] = new TileData("game", false);
        board[15][2] = new TileData("game", false);
        board[15][3] = new TileData("game", false);
        board[15][4] = new TileData("game", false);
        board[16][1] = new TileData("game", false);
        board[16][2] = new TileData("game", false);
        board[16][3] = new TileData("game", false);
        board[16][4] = new TileData("game", false);

        //library TileData
        board[7][0] = new TileData("library", true);
        board[8][0] = new TileData("library", true);
        board[9][0] = new TileData("library", true);
        board[10][0] = new TileData("library", true);
        board[11][0] = new TileData("library", true);
        board[7][1] = new TileData("library", true);
        board[7][2] = new TileData("library", true);
        board[7][3] = new TileData("library", true);
        board[7][4] = new TileData("library", true);
        board[7][5] = new TileData("library", true);
        board[7][6] = new TileData("library", true);
        board[8][6] = new TileData("library", true);
        board[9][6] = new TileData("library", false); //door tile
        board[10][6] = new TileData("library", true);
        board[11][6] = new TileData("library", true);
        board[11][5] = new TileData("library", true);
        board[11][4] = new TileData("library", true);
        board[11][3] = new TileData("library", false); //door tile
        board[11][2] = new TileData("library", true);
        board[11][1] = new TileData("library", true);
        board[8][1] = new TileData("library", false);
        board[8][2] = new TileData("library", false);
        board[8][3] = new TileData("library", false);
        board[8][4] = new TileData("library", false);
        board[8][5] = new TileData("library", false);
        board[9][1] = new TileData("library", false);
        board[9][2] = new TileData("library", false);
        board[9][3] = new TileData("library", false);
        board[9][4] = new TileData("library", false);
        board[9][5] = new TileData("library", false);
        board[10][1] = new TileData("library", false);
        board[10][2] = new TileData("library", false);
        board[10][3] = new TileData("library", false);
        board[10][4] = new TileData("library", false);
        board[10][5] = new TileData("library", false);

        //this will assign the board and choose cards for players


    }

    public ClueGameState(ClueGameState or) {
        rollResult = or.rollResult;
        suggestedCards = or.suggestedCards;
        board = or.board;
        //if other variables are added, they need to be added here too
    }


    public int getWhoseTurn()
    {
        return whoseMove;
    }

    public int getMovesLeft()
    {
        return moves;
    }

    public void setRollResult(int[] roll)
    {
        this.rollResult = roll;
        moves = rollResult[0] + rollResult[1];
    }

    public int getGameStage() { return gameStage; }
}
