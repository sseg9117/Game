package dev.sheradon.game.state;

import java.awt.Graphics;

import dev.sheradon.game.Game;
import dev.sheradon.game.entities.creatures.Player;
import dev.sheradon.game.tile.Tile;
import dev.sheradon.game.worlds.World;

public class GameState extends State
{
	private Player player;
	private World world;
	
	public GameState(Game game)
	{
		super(game);
		player = new Player(game, 100, 100);
		world = new World("res/worlds/world1.txt");
	}

	@Override
	public void tick()
	{
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g)
	{
		world.render(g);
		player.render(g);
		Tile.tiles[2].render(g, 0, 0);
	}
	
}
