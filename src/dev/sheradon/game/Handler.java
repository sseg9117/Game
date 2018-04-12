package dev.sheradon.game;

import dev.sheradon.game.gfx.GameCamera;
import dev.sheradon.game.input.KeyManager;
import dev.sheradon.game.input.MouseManager;
import dev.sheradon.game.ui.UIManager;
import dev.sheradon.game.worlds.World;

public class Handler
{
	private Game game;
	private World world;
	private UIManager uiManager;

	public Handler(Game game)
	{
		this.game = game;
	}

	
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}
	public MouseManager getMouseManager()
	{
		return game.getMouseManager();
	}
	
	public int getHeight()
	{
		return game.getHeight();
	}
	public int getWidth()
	{
		return game.getWidth();
	}
	public Game getGame()
	{
		return game;
	}

	public void setGame(Game game)
	{
		this.game = game;
	}

	
	public void setWorld(World world)
	{
		this.world = world;
	}
	public World getWorld()
	{
		return world;
	}


	public void setUIManager(UIManager uiManager)
	{
		this.setUiManager(uiManager);
	}


	public UIManager getUiManager()
	{
		return uiManager;
	}


	public void setUiManager(UIManager uiManager)
	{
		this.uiManager = uiManager;
	}

}
