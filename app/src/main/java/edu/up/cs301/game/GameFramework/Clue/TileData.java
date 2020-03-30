package edu.up.cs301.game.GameFramework.Clue;

public class TileData
{

    private boolean playerOnTile;
    private Room roomData;
    private boolean wall;

    public TileData(String roomName, boolean w)
    {
        this.playerOnTile = false;
        this.roomData = new Room(roomName);
        this.wall = w;
    }


    public Room getRoom()
    {
        return roomData;
    }

    public void addPlayer()
    {
        playerOnTile = true;
    }

    public void removePlayer()
    {
        playerOnTile = false;
    }

    public boolean hasPlayer()
    {
        return playerOnTile;
    }

    public boolean isWall()
    {
        return wall;
    }
}
