package dev.sheradon.game;

import dev.sheradon.game.display.Display;

public class Launcher
{
	public static void main (String [] args)
	{
		Game game = new Game("Title of Game",400,400);
		game.start();
	}
}
