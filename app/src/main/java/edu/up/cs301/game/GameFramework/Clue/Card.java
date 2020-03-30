package edu.up.cs301.game.GameFramework.Clue;

public class Card
{
    private String name;
    private int cardType; //card types 0, 1, 2 to represent player, room, and weapon respectively

    public Card(String n, int type)
    {
        this.name = n;
        this.cardType = type;
    }

    public int getCardType()
    {
        return cardType;
    }

    public String getName()
    {
        return name;
    }
}
