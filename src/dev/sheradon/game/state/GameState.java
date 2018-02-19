package dev.sheradon.game.state;

import java.awt.Graphics;

import dev.sheradon.game.Handler;
import dev.sheradon.game.entities.creatures.Player;
import dev.sheradon.game.tile.Tile;
import dev.sheradon.game.worlds.World;

public class GameState extends State
{
	private Player player;
	private World world;
	
	public GameState(Handler handler)
	{
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);

		
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
