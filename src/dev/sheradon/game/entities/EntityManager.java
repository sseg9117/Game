package dev.sheradon.game.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import dev.sheradon.game.Handler;
import dev.sheradon.game.entities.creatures.Player;
import dev.sheradon.game.entities.creatures.Player2;

public class EntityManager
{
	private Handler handler;
	private Player player;
	private Player2 player2;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>()
	{

		@Override
		public int compare(Entity a, Entity b)
		{
			if (a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}

	};

	public EntityManager(Handler handler, Player player, Player2 player2)
	{
		this.player2 = player2;
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}

	public void tick()
	{
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext())
		{
			Entity e = it.next();
			e.tick();
			if(!e.isActive())
				it.remove();
		}
		entities.sort(renderSorter);
	}

	public void render(Graphics g)
	{
		for (Entity e : entities)
		{
			e.render(g);
		}
	}

	public void addEntity(Entity e)
	{
		entities.add(e);
	}
	// GETTERS AND SETTERS
	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public Player2 getPlayer2()
	{
		return player2;
	}

	public void setPlayer2(Player2 player2)
	{
		this.player2 = player2;
	}

	public ArrayList<Entity> getEntities()
	{
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities)
	{
		this.entities = entities;
	}
}
