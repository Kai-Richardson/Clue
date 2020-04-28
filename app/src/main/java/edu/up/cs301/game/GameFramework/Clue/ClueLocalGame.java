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
    private int movesLeft;
    private boolean gameOver;

    private ClueGameState gameState;

    public ClueLocalGame(int numPlayers)
    {
        super();
        String[] str = new String[numPlayers];
        //this.gameState = new ClueGameState();
	    this.gameState = new ClueGameState(numPlayers, str, 0);
	    gameOver = false;
    }

    @Override
    protected String checkIfGameOver()
    {
        if(!gameOver)
        {
            return null;
        }
        else
        {
            return "The game is over";
        }
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

    protected boolean canDisprove(int pl)
    {
        return pl == gameState.getSuggestTurn();
    }

    @Override
    protected boolean makeMove(GameAction action)
    {
        //this method checks which state of the game we are in, and if a certain move can be made then
        //updated the gameState if the move was valid, and returns false, else returns false
        //game stages -
        //0 - roll/passageway
        //1 - move
        //2 - suggest / accuse
        //3 - disprove
        //4  - turn over (need to confirm turn over)
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
                xMove++;
            }
            if(cma.getDirection() == 2)
            {
                yMove++;
            }
            if(cma.getDirection() == 3)
            {
                xMove--;
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
	        if (currentSpot.getRoom().getName() != null && currentSpot.getRoom().getName().equals(projectedMove.getRoom().getName()))
            {
                Log.d("Move", "moving in same room");
                return false;
            }
            boolean inRoom = false;
            if(projectedMove.getRoom().getName() == null)
            {
                projectedMove.addPlayer();
            }
            else
            {
                inRoom = true;
            }
            Log.d("Move", "The movement is valid");
            currentSpot.removePlayer();
            gameState.setPlayerX(playerId, xMove);
            gameState.setPlayerY(playerId, yMove);
            gameState.decreaseMoves();
            if(gameState.getMovesLeft() == 0 || inRoom)
            {
                //move to suggest or accuse
                gameState.setGameStage(2); // FIX THIS LATER
            }
            Log.d("Move", "Action complete");
            return true;
        }

        if(action instanceof ClueAccuseAction) {
            ClueAccuseAction aAction = (ClueAccuseAction)action; //This variable needs to hold the user answer
            boolean correct = true;
            int playerId = getPlayerIdx(aAction.getPlayer());
            if(!(canMove(playerId)))
            {
                Log.d("accuse", "break 1");
                return false;
            }
            if(gameState.getGameStage() != 2)
            {
                Log.d("accuse", "break 2");
                return false;
            }
            ArrayList<Card> wCards = gameState.getWinningCards();
            for (int i = 0; i < wCards.size(); i++) {
                if (wCards.get(i).getCardType() == 1) {
                    if(aAction.getPerson() == null)
                    {
                        return false;
                    }
                    if (!wCards.get(i).getName().equalsIgnoreCase(aAction.getPerson())) {
                        correct = false;
                    }
                }
                if (wCards.get(i).getCardType() == 0) {
                    if(aAction.getPerson() == null)
                    {
                        return false;
                    }
                    if (!wCards.get(i).getName().equalsIgnoreCase(aAction.getRoom())) {
                        correct = false;
                    }
                }
                if (wCards.get(i).getCardType() == 2) {
                    if(aAction.getPerson() == null)
                    {
                        return false;
                    }
                    if (!wCards.get(i).getName().equalsIgnoreCase(aAction.getWeapon())) {
                        correct = false;
                    }
                }
            }
            if(correct){
                //make game over
                Log.d("Accuse", "Accuse successful");
                gameOver = true;
                return true;
            }
            else
            {
                Log.d("Accuse", "Accuse failed");
                gameState.setGameStage(4);
                return true;
            }
        }

        if(action instanceof ClueSuggestAction)
        {
            ClueSuggestAction csa = (ClueSuggestAction)action;
            int playerId = getPlayerIdx(csa.getPlayer());
            if(!canMove(playerId))
            {
                Log.d("endturn", "break 1");
                return false;
            }
            if(gameState.getGameStage() != 3)
            {
                Log.d("disprove", "break 2");
                return false;
            }
            gameState.setSugPerson(csa.getPerson());
            gameState.setSugRoom(csa.getRoom());
            gameState.setSugWeapon(csa.getWeapon());
            gameState.setGameStage(3);
            return true;
        }

        //disprove action checks
        if(action instanceof ClueDisproveAction)
        {
            ClueDisproveAction da = (ClueDisproveAction) action;
            int playerId = getPlayerIdx(da.getPlayer());
            if(!(canDisprove(playerId)))
            {
                Log.d("disprove", "break 1");
                return false;
            }
            if(canMove(playerId))
            {
                Log.d("disprove", "break 2, disprove own suggest");
                gameState.setGameStage(4);
                return true;
            }
            if(da.getName() == null)
            {
                Log.d("disprove", "break 2, no return");
                gameState.setSuggestTurn();
            }
            else
            {
                Log.d("disprove", "updated");
                gameState.setDisproveCard(da.getName());
                gameState.setGameStage(4);
                return true;
            }
        }


        if(action instanceof ClueEndTurnAction)
        {
            ClueEndTurnAction eta = (ClueEndTurnAction)action;
            int playerId = getPlayerIdx(eta.getPlayer());
            if(!(canMove(playerId)))
            {
                Log.i("ILLEGAL", "Player " + playerId + " attempted to end turn when it was not their turrn.");
                return false;
            }
            else
            {
                gameState.setGameStage(0);
                gameState.setWhoseTurn();
                return true;
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
    

}
