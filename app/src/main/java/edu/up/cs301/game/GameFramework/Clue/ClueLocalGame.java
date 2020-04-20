package edu.up.cs301.game.GameFramework.Clue;

import android.support.annotation.IdRes;
import android.util.Log;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Collections;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class ClueLocalGame extends LocalGame
{
    //private Player whoseTurn;
    private int movesLeft;

    private ClueGameState gameState;

    public ClueLocalGame(int numPlayers)
    {
        super();
        String[] str = new String[numPlayers];
        //this.gameState = new ClueGameState();
	    gameState = new ClueGameState(numPlayers, str, 0);
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
        return pl == gameState.getWhoseTurn();
    }

    @Override
    protected boolean makeMove(GameAction action)
    {
        //this method checks which state of the game we are in, and if a certain move can be made then
        //updated the gameState if the move was valid, and returns false, else returns false
        if(action instanceof ClueRollAction)
        {
            ClueRollAction cra = (ClueRollAction)action;
            int playerId = getPlayerIdx(cra.getPlayer());
            if(!(canMove(playerId)))
            {
                Log.d("roll action", "break 1");
                return false;
            }
            if(gameState.getGameStage() != 0)
            {
                Log.d("roll action", "break 2");
                return false;
            }
            Log.d("roll action", "roll action passed");
            Log.d("roll result", "the result in state is" + gameState.getMovesLeft());
            gameState.setRollResult(cra.getResult());
            gameState.setGameStage(1);
            return true;

        }
        if(action instanceof ClueMoveAction)
        {
            Log.d("LocalGame", "Move Registered");

            ClueMoveAction cma = (ClueMoveAction)action;
            int playerId = getPlayerIdx(cma.getPlayer());
            Log.d("LocalGame", "Player turn: " + playerId);
            Log.d("LocalGame", "actual turn: " + gameState.getWhoseTurn());
            if(!(canMove(playerId)))
            {
                Log.d("Move", "move error 1");
                return false;
            }
            if(gameState.getMovesLeft() <= 0 || gameState.getGameStage() != 1)
            {
                Log.d("Move", "move error 2");
                Log.d("Move", "moves left " + gameState.getMovesLeft());
                Log.d("Move", "gameStage: " + gameState.getGameStage());
                return false;
            }
            Log.d("LocalGame", "Move part 2");
            int xMove = gameState.getPlayerX(playerId);
            int yMove = gameState.getPlayerY(playerId);
            TileData currentSpot = gameState.getTileDataAtCoord(xMove, yMove);
            if(cma.getDirection() == 0)
            {
                yMove--;
            }
            if(cma.getDirection() == 1)
            {
                xMove--;
            }
            if(cma.getDirection() == 2)
            {
                yMove++;
            }
            if(cma.getDirection() == 3)
            {
                xMove++;
            }

            if(xMove > 24 || xMove < 0 || yMove > 24 || yMove < 0)
            {
                Log.d("Move", "move 3");
                 return false;
            }
            TileData projectedMove = gameState.getTileDataAtCoord(xMove, yMove);
            if(projectedMove.hasPlayer() || projectedMove.isWall())
            {
                Log.d("Move", "move 4");
                return false;
            }
            Log.d("Move", "The movement is valid");
            currentSpot.removePlayer();
            projectedMove.addPlayer();
            gameState.setPlayerX(playerId, xMove);
            gameState.setPlayerY(playerId, yMove);
            gameState.decreaseMoves();
            if(gameState.getMovesLeft() == 0)
            {
                //move to accuse stage
                gameState.setGameStage(4);
            }
            if(projectedMove.getRoom().getName() != null)
            {
                gameState.setGameStage(3);
            }
            Log.d("Move", "Action complete");
        }
        if(action instanceof ClueAccuseAction) {
            ClueAccuseAction aAction; //This variable needs to hold the user answer
            boolean correct = true;
            ArrayList<Card> wCards = gameState.getWinningCards();
            for (int i = 0; i < wCards.size(); i++) {
                if (wCards.get(i).getCardType() == 0) {
                    if (!wCards.get(i).getName().equals(aAction.person)) {
                        correct = false;
                    }
                }
                if (wCards.get(i).getCardType() == 1) {
                    if (!wCards.get(i).getName().equals(aAction.room)) {
                        correct = false;
                    }
                }
                if (wCards.get(i).getCardType() == 2) {
                    if (!wCards.get(i).getName().equals(aAction.weapon)) {
                        correct = false;
                    }
                }
            }
            if(!correct){
                //make game over
            }
        }
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
            //if(card == winningCards.get(0) || card == winningCards.get(1) || card == winningCards.get(2)){
           //     correct++;
            //}
            if(correct == 3){
                return true;
            }
        }
        return false;
    }

}
