package dev.sheradon.game;

public class Launcher
{
	public static void main(String[] args)
	{
		Game game = new Game("Title of Game", 700, 400);
		game.start();
	}
}
