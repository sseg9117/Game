package dev.sheradon.game.state;

import java.awt.Graphics;

import dev.sheradon.game.Handler;
import dev.sheradon.game.ui.UIManager;

public abstract class State
{
	private UIManager uiManager;

	public void setUIManager(UIManager uiManager)
	{
		this.setUiManager(uiManager);
	}

	private static State currentState = null;

	public static void setState(State state)
	{
		currentState = state;
	}

	public static State getState()
	{
		return currentState;
	}

	// CLASS

	protected Handler handler;

	public State(Handler handler)
	{
		this.handler = handler;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public UIManager getUiManager()
	{
		return uiManager;
	}

	public void setUiManager(UIManager uiManager)
	{
		this.uiManager = uiManager;
	}

}
