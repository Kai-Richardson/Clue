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

    private static final int PORT_NUMBER = 4253;

    @Override
    public GameConfig createDefaultConfig()
    {
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        //human player type
        playerTypes.add(new GamePlayerType("Human Player") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new ClueHumanPlayer(name);
            }
        });

        playerTypes.add(new GamePlayerType("Bad AI Player") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new ClueBadAI(name);
            }
        });

        //create configuration
        GameConfig defaultConfig = new GameConfig(playerTypes, 2, 6, "Clue Game", PORT_NUMBER);

        //add players to config
        //update with different AI as game is developed
        defaultConfig.addPlayer("Human", 0);
        defaultConfig.addPlayer("Bad AI", 1);

        defaultConfig.setRemoteData("Remote Player", "", 0);

        return defaultConfig;

    }


    public LocalGame createLocalGame()
    {
        return new ClueLocalGame();
    }
}
