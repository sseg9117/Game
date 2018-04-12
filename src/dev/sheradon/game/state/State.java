package dev.sheradon.game.state;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.sheradon.game.Handler;
import dev.sheradon.game.ui.UIManager;

public abstract class State
{
	private boolean leftPressed, rightPressed;
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


	public boolean isLeftPressed()
	{
		return leftPressed;
	}
	public boolean isRightPressed()
	{
		return rightPressed;
	}

	public void setLeftPressed(boolean leftPressed)
	{
		this.leftPressed = leftPressed;
	}

	public void setRightPressed(boolean rightPressed)
	{
		this.rightPressed = rightPressed;
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
