package edu.up.cs301.game.GameFramework.Clue;

import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Collections;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class ClueLocalGame extends LocalGame
{
    //private Player whoseTurn;
    private int movesLeft;


    private ClueGameState gameState;

    public ClueLocalGame()
    {
        this.gameState = new ClueGameState();
    }

    @Override
    protected String checkIfGameOver()
    {
        return null; //put actual content here
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer pl)
    {
        pl.sendInfo(new ClueGameState(gameState));
    }

    @Override
    protected boolean canMove(int pl)
    {
        return false;
    }

    @Override
    protected boolean makeMove(GameAction action)
    {
        //this method checks which state of the game we are in, and if a certain move can be made then
        //updated the gameState if the move was valid, and returns false, else returns false
        return false; //filler
    }


    private GamePlayer disproveTurn()
    {
        return null;
    }

    public boolean canRoll(GamePlayer pl)
    {
        return false;
    }

    public boolean canAccuse(GamePlayer pl)
    {
        return false;
    }

    public boolean canSuggest(GamePlayer pl)
    {
        return false;
    }

    public boolean canDisprove(GamePlayer pl)
    {
        return false;
    }

    public boolean canPassageway(GamePlayer pl)
    {
        return false;
    }

    public boolean checkAccusation(Card[] cd)
    {
        int correct = 0;
        for(Card card: cd){
            if(card == winningCards.get(0) || card == winningCards.get(1) || card == winningCards.get(2)){
                correct++;
            }
            if(correct == 3){
                return true;
            }
        }
        return false;
    }

}
