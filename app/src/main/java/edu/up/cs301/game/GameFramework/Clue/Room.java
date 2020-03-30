package edu.up.cs301.game.GameFramework.Clue;

public class Room {

	private String roomName;
	private Room linkedRoom;
	private boolean passageway;
	private TileData toSpawnOn; //Spawns the player on this tile when they go through passageway

    public Room(String rn) {
		this.roomName = rn;
		passageway = false;
	}

	public void setPassageway(Room rm) {
		linkedRoom = rm;
		passageway = true;
	}

	public boolean hasPassageway() {
		return passageway;
	}

	public Room getLinkedRoom() {
		return linkedRoom;
	}

	public TileData getToSpawnOn() {
		return toSpawnOn;
	}

	public void setToSpawnOn(TileData toSpawnOn) {
		this.toSpawnOn = toSpawnOn;
	}

	public String getName() {
		return roomName;
	}
}