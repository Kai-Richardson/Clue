package edu.up.cs301.game.GameFramework.Clue;

import android.service.quicksettings.Tile;
import android.widget.ProgressBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class ClueGameState extends GameState implements Serializable
{

    private int gameStage;
    private TileData[][] board = new TileData[25][25];
    private Card[] suggestedCards;
    private int moves;
    private int whoseMove;
    private int[] playerX;
    private int[] playerY;
    private ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList<Card> winningCards = new ArrayList<Card>();

    private int handSize;
    private Card[][] playerHands;

    //maybe have a variable for all cards dealt, and it is accessed using player ID int
    //if any variables are added here, make sure to assign them in the two constructors


    //some stuff for interface
    private static final long serialVersionUID = 7737393762469851826L;

    public ClueGameState(int numPlayers, String[] playerName, int turnID)
    {

        //make deck
        deck.add(new Card("wrench", 2));
        deck.add(new Card("candlestick", 2));
        deck.add(new Card("pipe", 2));
        deck.add(new Card("rope", 2));
        deck.add(new Card("gun", 2));
        deck.add(new Card("knife", 2));
        deck.add(new Card("yard", 0));
        deck.add(new Card("conservatory", 0));
        deck.add(new Card("lounge", 0));
        deck.add(new Card("kitchen", 0));
        deck.add(new Card("courtyard", 0));
        deck.add(new Card("pool", 0));
        deck.add(new Card("ballroom", 0));
        deck.add(new Card("dining", 0));
        deck.add(new Card("library", 0));
        deck.add(new Card("scarlet", 1));
        deck.add(new Card("plum", 1));
        deck.add(new Card("mustard", 1));
        deck.add(new Card("green", 1));
        deck.add(new Card("white", 1));
        deck.add(new Card("peacock", 1));

        Collections.shuffle(deck);
        for(Card card: deck)
        {
            if(card.getCardType() == 0)
            {
                winningCards.add(card);
                deck.remove(card);
                break;
            }
        }

        for(Card card: deck)
        {
            if(card.getCardType() == 1)
            {
                winningCards.add(card);
                deck.remove(card);
                break;
            }
        }

        for(Card card: deck)
        {
            if(card.getCardType() == 2)
            {
                winningCards.add(card);
                deck.remove(card);
                break;
            }
        }
        playerHands = new Card[deck.size()/2][2];
        handSize = deck.size()/numPlayers;
        for(int i = 0; i < handSize; i++) {
            for (int j = 0; j < numPlayers; j++) {
                playerHands[i][j] = deck.get(0);
                deck.remove(0);
            }
        }


        //walls with no rooms
        board[7][0] = new TileData("wall", true);
        board[9][0] = new TileData("wall", true);
        board[0][4] = new TileData("wall", true);
        board[0][6] = new TileData("wall", true);
        board[24][7] = new TileData("wall", true);
        board[24][9] = new TileData("wall", true);
        board[24][17] = new TileData("wall", true);
        board[24][19] = new TileData("wall", true);
        board[6][24] = new TileData("wall", true);
        board[18][24] = new TileData("wall", true);

        //board center TileData
        board[9][9]= new TileData("wall", true);
        board[10][9] = new TileData("wall", true);
        board[11][9] = new TileData("wall", true);
        board[12][9] = new TileData("wall", true);
        board[13][9] = new TileData("wall", true);
        board[14][9] = new TileData("wall", true);
        board[9][10]= new TileData("wall", true);
        board[9][11]= new TileData("wall", true);
        board[9][12]= new TileData("wall", true);
        board[9][13]= new TileData("wall", true);
        board[9][14]= new TileData("wall", true);
        board[9][15]= new TileData("wall", true);
        board[14][10] = new TileData("wall", true);
        board[14][11] = new TileData("wall", true);
        board[14][12] = new TileData("wall", true);
        board[14][13] = new TileData("wall", true);
        board[14][14] = new TileData("wall", true);
        board[14][15] = new TileData("wall", true);
        board[13][15] = new TileData("wall", true);
        board[12][15] = new TileData("wall", true);
        board[11][15] = new TileData("wall", true);
        board[10][15] = new TileData("wall", true);

        //study TileData
        board[1][1] = new TileData("study", true);
        board[2][1] = new TileData("study", true);
        board[3][1] = new TileData("study", true);
        board[4][1] = new TileData("study", true);
        board[5][1] = new TileData("study", true);
        board[6][1] = new TileData("study", true);
        board[7][1] = new TileData("study", true);
        board[1][2] = new TileData("study", true);
        board[2][2] = new TileData("study", false);
        board[3][2] = new TileData("study", false);
        board[4][2] = new TileData("study", false);
        board[5][2] = new TileData("study", false);
        board[6][2] = new TileData("study", false);
        board[7][2] = new TileData("study", true);
        board[1][3] = new TileData("study", true);
        board[2][3] = new TileData("study", false);
        board[3][3] = new TileData("study", false);
        board[4][3] = new TileData("study", false);
        board[5][3] = new TileData("study", false);
        board[6][3] = new TileData("study", false);
        board[7][3] = new TileData("study", true);
        board[1][4] = new TileData("study", true);
        board[2][4] = new TileData("study", true);
        board[3][4] = new TileData("study", true);
        board[4][4] = new TileData("study", true); //door tile
        board[5][4] = new TileData("study", false);
        board[6][4] = new TileData("study", true);
        board[7][4] = new TileData("study", true);

        //hall TileData
        board[10][1] = new TileData("hall", true);
        board[11][1] = new TileData("hall", true);
        board[12][1] = new TileData("hall", true);
        board[13][1] = new TileData("hall", true);
        board[14][1] = new TileData("hall", true);
        board[15][1] = new TileData("hall", true);
        board[16][1] = new TileData("hall", true);
        board[10][2] = new TileData("hall", true);
        board[10][3] = new TileData("hall", false); //door tile
        board[10][4] = new TileData("hall", true);
        board[10][5] = new TileData("hall", true);
        board[10][6] = new TileData("hall", true);
        board[11][6] = new TileData("hall", true);
        board[12][6] = new TileData("hall", true);
        board[13][6] = new TileData("hall", false); //door tile
        board[14][6] = new TileData("hall", false); //door tile
        board[15][6] = new TileData("hall", true);
        board[16][6] = new TileData("hall", true);
        board[16][5] = new TileData("hall", true);
        board[16][4] = new TileData("hall", true);
        board[16][3] = new TileData("hall", true);
        board[16][2] = new TileData("hall", true);
        board[11][2] = new TileData("hall", false);
        board[12][2] = new TileData("hall", false);
        board[13][2] = new TileData("hall", false);
        board[14][2] = new TileData("hall", false);
        board[15][2] = new TileData("hall", false);
        board[11][3] = new TileData("hall", false);
        board[12][3] = new TileData("hall", false);
        board[13][3] = new TileData("hall", false);
        board[14][3] = new TileData("hall", false);
        board[15][3] = new TileData("hall", false);
        board[11][4] = new TileData("hall", false);
        board[12][4] = new TileData("hall", false);
        board[13][4] = new TileData("hall", false);
        board[14][4] = new TileData("hall", false);
        board[15][4] = new TileData("hall", false);
        board[11][5] = new TileData("hall", false);
        board[12][5] = new TileData("hall", false);
        board[13][5] = new TileData("hall", false);
        board[14][5] = new TileData("hall", false);
        board[15][5] = new TileData("hall", false);

        //lounge TitleData
        board[19][1] = new TileData("lounge", true);
        board[20][1] = new TileData("lounge", true);
        board[21][1] = new TileData("lounge", true);
        board[22][1] = new TileData("lounge", true);
        board[23][1] = new TileData("lounge", true);
        board[19][2] = new TileData("lounge", true);
        board[19][3] = new TileData("lounge", true);
        board[19][4] = new TileData("lounge", true);
        board[19][5] = new TileData("lounge", true);
        board[19][6] = new TileData("lounge", true);
        board[20][6] = new TileData("lounge", true); //door tile
        board[21][6] = new TileData("lounge", true);
        board[22][6] = new TileData("lounge", true);
        board[23][6] = new TileData("lounge", true);
        board[23][5] = new TileData("lounge", true);
        board[23][4] = new TileData("lounge", true);
        board[23][3] = new TileData("lounge", true);
        board[23][2] = new TileData("lounge", true);
        board[20][2] = new TileData("lounge", false);
        board[21][2] = new TileData("lounge", false);
        board[22][2] = new TileData("lounge", false);
        board[20][3] = new TileData("lounge", false);
        board[21][3] = new TileData("lounge", false);
        board[22][3] = new TileData("lounge", false);
        board[20][4] = new TileData("lounge", false);
        board[21][4] = new TileData("lounge", false);
        board[22][4] = new TileData("lounge", false);
        board[20][5] = new TileData("lounge", false);
        board[21][5] = new TileData("lounge", false);
        board[22][5] = new TileData("lounge", false);

        //dining room TileData
        board[17][10] = new TileData("dining", true);
        board[17][11] = new TileData("dining", true);
        board[17][12] = new TileData("dining", true);
        board[17][13] = new TileData("dining", true);
        board[17][14] = new TileData("dining", false); //door tile
        board[17][15] = new TileData("dining", true);
        board[17][16] = new TileData("dining", true);
        board[18][10] = new TileData("dining", true);
        board[19][10] = new TileData("dining", false); //door tile
        board[20][10] = new TileData("dining", true);
        board[21][10] = new TileData("dining", true);
        board[22][10] = new TileData("dining", true);
        board[23][10] = new TileData("dining", true);
        board[24][10] = new TileData("dining", true);
        board[24][11] = new TileData("dining", true);
        board[24][12] = new TileData("dining", true);
        board[24][13] = new TileData("dining", true);
        board[24][14] = new TileData("dining", true);
        board[24][15] = new TileData("dining", true);
        board[24][16] = new TileData("dining", true);
        board[18][16] = new TileData("dining", true);
        board[19][16] = new TileData("dining", true);
        board[20][16] = new TileData("dining", true);
        board[21][16] = new TileData("dining", true);
        board[22][16] = new TileData("dining", true);
        board[23][16] = new TileData("dining", true);
        board[18][11] = new TileData("dining", false);
        board[19][11] = new TileData("dining", false);
        board[20][11] = new TileData("dining", false);
        board[21][11] = new TileData("dining", false);
        board[22][11] = new TileData("dining", false);
        board[23][11] = new TileData("dining", false);
        board[18][12] = new TileData("dining", false);
        board[19][12] = new TileData("dining", false);
        board[20][12] = new TileData("dining", false);
        board[21][12] = new TileData("dining", false);
        board[22][12] = new TileData("dining", false);
        board[23][12] = new TileData("dining", false);
        board[18][13] = new TileData("dining", false);
        board[19][13] = new TileData("dining", false);
        board[20][13] = new TileData("dining", false);
        board[21][13] = new TileData("dining", false);
        board[22][13] = new TileData("dining", false);
        board[23][13] = new TileData("dining", false);
        board[18][14] = new TileData("dining", false);
        board[19][14] = new TileData("dining", false);
        board[20][14] = new TileData("dining", false);
        board[21][14] = new TileData("dining", false);
        board[22][14] = new TileData("dining", false);
        board[23][14] = new TileData("dining", false);
        board[18][15] = new TileData("dining", false);
        board[19][15] = new TileData("dining", false);
        board[20][15] = new TileData("dining", false);
        board[21][15] = new TileData("dining", false);
        board[22][15] = new TileData("dining", false);
        board[23][15] = new TileData("dining", false);

        //kitchen TileData
        board[19][20] = new TileData("kitchen", true);
        board[20][20] = new TileData("kitchen", false); //door tile
        board[21][20] = new TileData("kitchen", true);
        board[22][20] = new TileData("kitchen", true);
        board[23][20] = new TileData("kitchen", true);
        board[24][20] = new TileData("kitchen", true);
        board[19][21] = new TileData("kitchen", true);
        board[19][22] = new TileData("kitchen", true);
        board[19][23] = new TileData("kitchen", true);
        board[19][24] = new TileData("kitchen", true);
        board[20][24] = new TileData("kitchen", true);
        board[21][24] = new TileData("kitchen", true);
        board[22][24] = new TileData("kitchen", true);
        board[23][24] = new TileData("kitchen", true);
        board[24][24] = new TileData("kitchen", true);
        board[24][23] = new TileData("kitchen", true);
        board[24][22] = new TileData("kitchen", true);
        board[24][21] = new TileData("kitchen", true);
        board[20][21] = new TileData("kitchen", false);
        board[21][21] = new TileData("kitchen", false);
        board[22][21] = new TileData("kitchen", false);
        board[23][21] = new TileData("kitchen", false);
        board[20][22] = new TileData("kitchen", false);
        board[21][22] = new TileData("kitchen", false);
        board[22][22] = new TileData("kitchen", false);
        board[23][22] = new TileData("kitchen", false);
        board[20][23] = new TileData("kitchen", false);
        board[21][23] = new TileData("kitchen", false);
        board[22][23] = new TileData("kitchen", false);
        board[23][23] = new TileData("kitchen", false);

        //ballroom TitleData
        board[8][19] = new TileData("ballroom", true);
        board[8][20] = new TileData("ballroom", false); //door tile
        board[8][21] = new TileData("ballroom", true);
        board[8][22] = new TileData("ballroom", true);
        board[8][23] = new TileData("ballroom", true);
        board[8][24] = new TileData("ballroom", true);
        board[9][19] = new TileData("ballroom", true);
        board[10][19] = new TileData("ballroom", false); //door tile
        board[11][19] = new TileData("ballroom", true);
        board[12][19] = new TileData("ballroom", true);
        board[13][19] = new TileData("ballroom", true);
        board[14][19] = new TileData("ballroom", false); //door tile
        board[15][19] = new TileData("ballroom", true);
        board[16][19] = new TileData("ballroom", true);
        board[9][24] = new TileData("ballroom", true);
        board[10][24] = new TileData("ballroom", true);
        board[11][24] = new TileData("ballroom", true);
        board[12][24] = new TileData("ballroom", true);
        board[13][24] = new TileData("ballroom", true);
        board[14][24] = new TileData("ballroom", true);
        board[15][24] = new TileData("ballroom", true);
        board[16][24] = new TileData("ballroom", true);
        board[16][20] = new TileData("ballroom", false); //door tile
        board[16][21] = new TileData("ballroom", true);
        board[16][22] = new TileData("ballroom", true);
        board[16][23] = new TileData("ballroom", true);
        board[9][20] = new TileData("ballroom", false);
        board[10][20] = new TileData("ballroom", false);
        board[11][20] = new TileData("ballroom", false);
        board[12][20] = new TileData("ballroom", false);
        board[13][20] = new TileData("ballroom", false);
        board[14][20] = new TileData("ballroom", false);
        board[15][20] = new TileData("ballroom", false);
        board[9][21] = new TileData("ballroom", false);
        board[10][21] = new TileData("ballroom", false);
        board[11][21] = new TileData("ballroom", false);
        board[12][21] = new TileData("ballroom", false);
        board[13][21] = new TileData("ballroom", false);
        board[14][21] = new TileData("ballroom", false);
        board[15][21] = new TileData("ballroom", false);
        board[9][22] = new TileData("ballroom", false);
        board[10][22] = new TileData("ballroom", false);
        board[11][22] = new TileData("ballroom", false);
        board[12][22] = new TileData("ballroom", false);
        board[13][22] = new TileData("ballroom", false);
        board[14][22] = new TileData("ballroom", false);
        board[15][22] = new TileData("ballroom", false);
        board[9][23] = new TileData("ballroom", false);
        board[10][23] = new TileData("ballroom", false);
        board[11][23] = new TileData("ballroom", false);
        board[12][23] = new TileData("ballroom", false);
        board[13][23] = new TileData("ballroom", false);
        board[14][23] = new TileData("ballroom", false);
        board[15][23] = new TileData("ballroom", false);

        //garden TileData
        board[0][20] = new TileData("garden", true);
        board[0][21] = new TileData("garden", true);
        board[0][22] = new TileData("garden", true);
        board[0][23] = new TileData("garden", true);
        board[0][24] = new TileData("garden", true);
        board[1][20] = new TileData("garden", true);
        board[2][20] = new TileData("garden", true);
        board[3][20] = new TileData("garden", true);
        board[4][20] = new TileData("garden", true);
        board[5][20] = new TileData("garden", true);
        board[5][21] = new TileData("garden", false); //door tile
        board[5][22] = new TileData("garden", true);
        board[5][23] = new TileData("garden", true);
        board[5][24] = new TileData("garden", true);
        board[1][24] = new TileData("garden", true);
        board[2][24] = new TileData("garden", true);
        board[3][24] = new TileData("garden", true);
        board[4][24] = new TileData("garden", true);
        board[1][21] = new TileData("garden", false);
        board[2][21] = new TileData("garden", false);
        board[3][21] = new TileData("garden", false);
        board[4][21] = new TileData("garden", false);
        board[1][22] = new TileData("garden", false);
        board[2][22] = new TileData("garden", false);
        board[3][22] = new TileData("garden", false);
        board[4][22] = new TileData("garden", false);
        board[1][23] = new TileData("garden", false);
        board[2][23] = new TileData("garden", false);
        board[3][23] = new TileData("garden", false);
        board[4][23] = new TileData("garden", false);

        //billard TileData
        board[0][13] = new TileData("game", true);
        board[0][14] = new TileData("game", true);
        board[0][15] = new TileData("game", true);
        board[0][16] = new TileData("game", true);
        board[0][17] = new TileData("game", true);
        board[1][13] = new TileData("game", true);
        board[2][13] = new TileData("game", false); //door tile
        board[3][13] = new TileData("game", true);
        board[4][13] = new TileData("game", true);
        board[5][13] = new TileData("game", true);
        board[5][14] = new TileData("game", true);
        board[5][15] = new TileData("game", true);
        board[5][16] = new TileData("game", false); //door tile
        board[5][17] = new TileData("game", true);
        board[4][17] = new TileData("game", true);
        board[3][17] = new TileData("game", true);
        board[2][17] = new TileData("game", true);
        board[1][17] = new TileData("game", true);
        board[1][14] = new TileData("game", false);
        board[2][14] = new TileData("game", false);
        board[3][14] = new TileData("game", false);
        board[4][14] = new TileData("game", false);
        board[1][15] = new TileData("game", false);
        board[2][15] = new TileData("game", false);
        board[3][15] = new TileData("game", false);
        board[4][15] = new TileData("game", false);
        board[1][16] = new TileData("game", false);
        board[2][16] = new TileData("game", false);
        board[3][16] = new TileData("game", false);
        board[4][16] = new TileData("game", false);

        //library TileData
        board[0][7] = new TileData("library", true);
        board[0][8] = new TileData("library", true);
        board[0][9] = new TileData("library", true);
        board[0][10] = new TileData("library", true);
        board[0][11] = new TileData("library", true);
        board[1][7] = new TileData("library", true);
        board[2][7] = new TileData("library", true);
        board[3][7] = new TileData("library", true);
        board[4][7] = new TileData("library", true);
        board[5][7] = new TileData("library", true);
        board[6][7] = new TileData("library", true);
        board[6][8] = new TileData("library", true);
        board[6][9] = new TileData("library", false); //door tile
        board[6][10] = new TileData("library", true);
        board[6][11] = new TileData("library", true);
        board[5][11] = new TileData("library", true);
        board[4][11] = new TileData("library", true);
        board[3][11] = new TileData("library", false); //door tile
        board[2][11] = new TileData("library", true);
        board[1][11] = new TileData("library", true);
        board[1][8] = new TileData("library", false);
        board[2][8] = new TileData("library", false);
        board[3][8] = new TileData("library", false);
        board[4][8] = new TileData("library", false);
        board[5][8] = new TileData("library", false);
        board[1][9] = new TileData("library", false);
        board[2][9] = new TileData("library", false);
        board[3][9] = new TileData("library", false);
        board[4][9] = new TileData("library", false);
        board[5][9] = new TileData("library", false);
        board[1][10] = new TileData("library", false);
        board[2][10] = new TileData("library", false);
        board[3][10] = new TileData("library", false);
        board[4][10] = new TileData("library", false);
        board[5][10] = new TileData("library", false);

        //tiles not in a room that are not walls
        board[8][1] = new TileData(null, false);
        board[9][1] = new TileData(null, false);
        board[8][2] = new TileData(null, false);
        board[9][2] = new TileData(null, false);
        board[8][3] = new TileData(null, false);
        board[9][3] = new TileData(null, false);
        board[17][3] = new TileData(null, false);
        board[18][3] = new TileData(null, false);
        board[8][4] = new TileData(null, false);
        board[9][4] = new TileData(null, false);
        board[17][4] = new TileData(null, false);
        board[18][4] = new TileData(null, false);
        board[1][5] = new TileData(null, false);
        board[2][5] = new TileData(null, false);
        board[3][5] = new TileData(null, false);
        board[4][5] = new TileData(null, false);
        board[5][5] = new TileData(null, false);
        board[6][5] = new TileData(null, false);
        board[7][5] = new TileData(null, false);
        board[8][5] = new TileData(null, false);
        board[9][5] = new TileData(null, false);
        board[17][5] = new TileData(null, false);
        board[18][5] = new TileData(null, false);
        board[1][6] = new TileData(null, false);
        board[2][6] = new TileData(null, false);
        board[3][6] = new TileData(null, false);
        board[4][6] = new TileData(null, false);
        board[5][6] = new TileData(null, false);
        board[6][6] = new TileData(null, false);
        board[7][6] = new TileData(null, false);
        board[8][6] = new TileData(null, false);
        board[9][6] = new TileData(null, false);
        board[17][6] = new TileData(null, false);
        board[18][6] = new TileData(null, false);
        board[7][7] = new TileData(null, false);
        board[8][7] = new TileData(null, false);
        board[9][7] = new TileData(null, false);
        board[10][7] = new TileData(null, false);
        board[11][7] = new TileData(null, false);
        board[12][7] = new TileData(null, false);
        board[13][7] = new TileData(null, false);
        board[14][7] = new TileData(null, false);
        board[15][7] = new TileData(null, false);
        board[16][7] = new TileData(null, false);
        board[17][7] = new TileData(null, false);
        board[18][7] = new TileData(null, false);
        board[19][7] = new TileData(null, false);
        board[20][7] = new TileData(null, false);
        board[21][7] = new TileData(null, false);
        board[22][7] = new TileData(null, false);
        board[23][7] = new TileData(null, false);
        board[7][8] = new TileData(null, false);
        board[8][8] = new TileData(null, false);
        board[9][8] = new TileData(null, false);
        board[10][8] = new TileData(null, false);
        board[11][8] = new TileData(null, false);
        board[12][8] = new TileData(null, false);
        board[13][8] = new TileData(null, false);
        board[14][8] = new TileData(null, false);
        board[15][8] = new TileData(null, false);
        board[16][8] = new TileData(null, false);
        board[17][8] = new TileData(null, false);
        board[18][8] = new TileData(null, false);
        board[19][8] = new TileData(null, false);
        board[20][8] = new TileData(null, false);
        board[21][8] = new TileData(null, false);
        board[22][8] = new TileData(null, false);
        board[23][8] = new TileData(null, false);
        board[7][9] = new TileData(null, false);
        board[8][9] = new TileData(null, false);
        board[15][9] = new TileData(null, false);
        board[16][9] = new TileData(null, false);
        board[17][9] = new TileData(null, false);
        board[18][9] = new TileData(null, false);
        board[19][9] = new TileData(null, false);
        board[20][9] = new TileData(null, false);
        board[21][9] = new TileData(null, false);
        board[22][9] = new TileData(null, false);
        board[23][9] = new TileData(null, false);
        board[7][10] = new TileData(null, false);
        board[8][10] = new TileData(null, false);
        board[15][10] = new TileData(null, false);
        board[16][10] = new TileData(null, false);
        board[7][11] = new TileData(null, false);
        board[8][11] = new TileData(null, false);
        board[15][11] = new TileData(null, false);
        board[16][11] = new TileData(null, false);
        board[1][12] = new TileData(null, false);
        board[2][12] = new TileData(null, false);
        board[3][12] = new TileData(null, false);
        board[4][12] = new TileData(null, false);
        board[5][12] = new TileData(null, false);
        board[6][12] = new TileData(null, false);
        board[7][12] = new TileData(null, false);
        board[8][12] = new TileData(null, false);
        board[15][12] = new TileData(null, false);
        board[16][12] = new TileData(null, false);
        board[6][13] = new TileData(null, false);
        board[7][13] = new TileData(null, false);
        board[8][13] = new TileData(null, false);
        board[15][13] = new TileData(null, false);
        board[16][13] = new TileData(null, false);
        board[6][14] = new TileData(null, false);
        board[7][14] = new TileData(null, false);
        board[8][14] = new TileData(null, false);
        board[15][14] = new TileData(null, false);
        board[16][14] = new TileData(null, false);
        board[6][15] = new TileData(null, false);
        board[7][15] = new TileData(null, false);
        board[8][15] = new TileData(null, false);
        board[15][15] = new TileData(null, false);
        board[16][15] = new TileData(null, false);
        board[6][16] = new TileData(null, false);
        board[7][16] = new TileData(null, false);
        board[8][16] = new TileData(null, false);
        board[9][16] = new TileData(null, false);
        board[10][16] = new TileData(null, false);
        board[11][16] = new TileData(null, false);
        board[12][16] = new TileData(null, false);
        board[13][16] = new TileData(null, false);
        board[14][16] = new TileData(null, false);
        board[15][16] = new TileData(null, false);
        board[16][16] = new TileData(null, false);
        board[6][17] = new TileData(null, false);
        board[7][17] = new TileData(null, false);
        board[8][17] = new TileData(null, false);
        board[9][17] = new TileData(null, false);
        board[10][17] = new TileData(null, false);
        board[11][17] = new TileData(null, false);
        board[12][17] = new TileData(null, false);
        board[13][17] = new TileData(null, false);
        board[14][17] = new TileData(null, false);
        board[15][17] = new TileData(null, false);
        board[16][17] = new TileData(null, false);
        board[17][17] = new TileData(null, false);
        board[18][17] = new TileData(null, false);
        board[19][17] = new TileData(null, false);
        board[20][17] = new TileData(null, false);
        board[21][17] = new TileData(null, false);
        board[22][17] = new TileData(null, false);
        board[23][17] = new TileData(null, false);
        board[3][18] = new TileData(null, false);
        board[4][18] = new TileData(null, false);
        board[5][18] = new TileData(null, false);
        board[6][18] = new TileData(null, false);
        board[7][18] = new TileData(null, false);
        board[8][18] = new TileData(null, false);
        board[9][18] = new TileData(null, false);
        board[10][18] = new TileData(null, false);
        board[11][18] = new TileData(null, false);
        board[12][18] = new TileData(null, false);
        board[13][18] = new TileData(null, false);
        board[14][18] = new TileData(null, false);
        board[15][18] = new TileData(null, false);
        board[16][18] = new TileData(null, false);
        board[17][18] = new TileData(null, false);
        board[18][18] = new TileData(null, false);
        board[19][18] = new TileData(null, false);
        board[20][18] = new TileData(null, false);
        board[21][18] = new TileData(null, false);
        board[22][18] = new TileData(null, false);
        board[23][18] = new TileData(null, false);
        board[3][19] = new TileData(null, false);
        board[4][19] = new TileData(null, false);
        board[5][19] = new TileData(null, false);
        board[6][19] = new TileData(null, false);
        board[7][19] = new TileData(null, false);
        board[17][19] = new TileData(null, false);
        board[18][19] = new TileData(null, false);
        board[19][19] = new TileData(null, false);
        board[20][19] = new TileData(null, false);
        board[21][19] = new TileData(null, false);
        board[22][19] = new TileData(null, false);
        board[23][19] = new TileData(null, false);
        board[6][20] = new TileData(null, false);
        board[7][20] = new TileData(null, false);
        board[17][20] = new TileData(null, false);
        board[18][20] = new TileData(null, false);
        board[6][21] = new TileData(null, false);
        board[7][21] = new TileData(null, false);
        board[17][21] = new TileData(null, false);
        board[18][21] = new TileData(null, false);
        board[6][22] = new TileData(null, false);
        board[7][22] = new TileData(null, false);
        board[17][22] = new TileData(null, false);
        board[18][22] = new TileData(null, false);
        board[6][23] = new TileData(null, false);
        board[7][23] = new TileData(null, false);
        board[17][23] = new TileData(null, false);
        board[18][23] = new TileData(null, false);
        board[8][0] = new TileData(null, false); //plum start
        board[0][5] = new TileData(null, false); //peacock start
        board[7][24] = new TileData(null, false); //mustang start
        board[17][24] = new TileData(null, false); //green start
        board[24][18] = new TileData(null, false); //scarlet start
        board[24][8] = new TileData(null, false); //white start


        //this will assign the board and choose cards for players

        whoseMove = 0;
        //predefine starting positions for two players
        playerX = new int[2];
        playerY = new int[2];
        playerX[0] = 0;
        playerY[0] = 8;
        playerX[1] = 24;
        playerY[1] = 17;

    }

    public ClueGameState(ClueGameState or) {
        suggestedCards = or.suggestedCards;
        //if other variables are added, they need to be added here too
        gameStage = or.gameStage;
        board = or.board;
        moves = or.moves;
        whoseMove = or.whoseMove;
        playerX = or.playerX;
        playerY = or.playerY;
        deck = or.deck;
        winningCards = or.winningCards;

        handSize = or.handSize;
        playerHands = or.playerHands;

    }


    public int getWhoseTurn()
    {
        return whoseMove;
    }

    public int getMovesLeft()
    {
        return moves;
    }

    public void decreaseMoves() { moves--; }

    public void setRollResult(int roll)
    {
        moves = roll;
    }

    public int getGameStage() { return gameStage; }

    public void setGameStage(int gs)
    {
        this.gameStage = gs;
    }

    public TileData getTileDataAtCoord(int x, int y)
    {
        return board[x][y];
    }

    public int getPlayerX(int i)
    {
        return playerX[i];
    }

    public void setPlayerX(int i, int j)
    {
        playerX[i] = j;
    }

    public int getPlayerY(int i)
    {
        return playerY[i];
    }

    public void setPlayerY(int i, int j)
    {
        playerY[i] = j;
    }
}
