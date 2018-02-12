package dev.sheradon.game.state;

import java.awt.Graphics;

import dev.sheradon.game.Game;
import dev.sheradon.game.entities.creatures.Player;

public class GameState extends State
{
	private Player player;
	
	public GameState(Game game)
	{
		super(game);
		player = new Player(game, 100, 100);
	}

	@Override
	public void tick()
	{
		player.tick();
	}

	@Override
	public void render(Graphics g)
	{
		player.render(g);
	}
	
}
