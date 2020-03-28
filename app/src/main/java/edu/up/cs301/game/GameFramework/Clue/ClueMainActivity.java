package edu.up.cs301.game.GameFramework.Clue;

import java.util.ArrayList;

import edu.up.cs301.game.GameFramework.GameMainActivity;
import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.gameConfiguration.GameConfig;
import edu.up.cs301.game.GameFramework.gameConfiguration.GamePlayerType;

public class ClueMainActivity extends GameMainActivity
{
    public LocalGame localGame;
    public GameConfig gameConfig;

    private static final int PORT_NUMBER = 6598;

    @Override
    public GameConfig createDefaultConfig()
    {
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        //human player type
        playerTypes.add(new GamePlayerType() {
            @Override
            public GamePlayer createPlayer(String name) {
                return new ClueHumanPlayer(name);
            }
        });

        //create configuration
        GameConfig defaultConfig = new GameConfig(playerTypes, 2, 6, "Clue Game", PORT_NUMBER);

        //add players to config
        //update with different AI as game is developed
        defaultConfig.addPlayer("Human", 0);

        return defaultConfig;

    }

    public ClueMainActivity()
    {

    }

    public LocalGame createLocalGame()
    {
        return new ClueLocalGame();
    }
}
