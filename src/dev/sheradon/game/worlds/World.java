package dev.sheradon.game.worlds;

import java.awt.Graphics;

import dev.sheradon.game.Handler;
import dev.sheradon.game.entities.EntityManager;
import dev.sheradon.game.entities.creatures.Player;
import dev.sheradon.game.entities.statics.Tree;
import dev.sheradon.game.items.ItemManager;
import dev.sheradon.game.tile.Tile;
import dev.sheradon.game.utils.Utils;
//USED  CodeNMore YoutubeChannle as a refernce for the code in here he has a youtube tutorial video and used stackoverflow for a little help with bounds.
public class World
{
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	// ENtities
	private EntityManager entityManager;
	
	private ItemManager itemManager;
	
	public World(Handler handler, String path)
	{
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 500, 700), null);
		itemManager = new ItemManager(handler);
//		entityManager.addEntity(new Tree(handler, 100, 250));
		

		loadWorld(path);

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);

	}

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public void tick()
	{
		itemManager.tick();
		entityManager.tick();
	}

	public void render(Graphics g)
	{
		int xStart = (int) Math.max(0, handler.getGameCamera().getXoffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getXoffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getYoffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getYoffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++)
		{
			for (int x = xStart; x < xEnd; x++)
			{
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getXoffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getYoffset()));
			}
		}
		//items
		itemManager.render(g);
		// ENtities
		entityManager.render(g);
	}

	public Tile getTile(int x, int y)
	{
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.dirtTile;

		return t;
	}

	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}

	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	public ItemManager getItemManager()
	{
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager)
	{
		this.itemManager = itemManager;
	}
	
}
