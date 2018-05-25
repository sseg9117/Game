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
	private UIManager menuManager;
	private UIManager selectManager;
	private UIManager optionManager;
	private UIManager controlsManager;

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


	/**
	 * @return the menuManager
	 */
	public UIManager getMenuManager()
	{
		return menuManager;
	}


	/**
	 * @param menuManager the menuManager to set
	 */
	public void setMenuManager(UIManager menuManager)
	{
		this.menuManager = menuManager;
	}


	/**
	 * @return the selectManager
	 */
	public UIManager getSelectManager()
	{
		return selectManager;
	}


	/**
	 * @param selectManager the selectManager to set
	 */
	public void setSelectManager(UIManager selectManager)
	{
		this.selectManager = selectManager;
	}


	/**
	 * @return the optionManager
	 */
	public UIManager getOptionManager()
	{
		return optionManager;
	}


	/**
	 * @param optionManager the optionManager to set
	 */
	public void setOptionManager(UIManager optionManager)
	{
		this.optionManager = optionManager;
	}


	/**
	 * @return the controlsManager
	 */
	public UIManager getControlsManager()
	{
		return controlsManager;
	}


	/**
	 * @param controlsManager the controlsManager to set
	 */
	public void setControlsManager(UIManager controlsManager)
	{
		this.controlsManager = controlsManager;
	}

}
