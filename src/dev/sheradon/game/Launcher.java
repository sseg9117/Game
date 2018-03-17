package dev.sheradon.game;

public class Launcher
{
	public static void main(String[] args)
	{
		Game game = new Game("MY GAME", 1000, 700);
		game.start();
	}
}
