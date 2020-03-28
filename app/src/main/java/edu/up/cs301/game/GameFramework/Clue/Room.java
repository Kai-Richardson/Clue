package edu.up.cs301.game.GameFramework.Clue;

public class Room
{

    private String roomName;
    private Room linkedRoom;
    private boolean passageway;

    public Room(String rn)
    {
        this.roomName = rn;
        passageway = false;
    }

    public void setPassageway(Room rm)
    {
        linkedRoom = rm;
        passageway = true;

    }

    public boolean hasPassageway()
    {
        return passageway;
    }

    public String getName()
    {
        return roomName;
    }
}