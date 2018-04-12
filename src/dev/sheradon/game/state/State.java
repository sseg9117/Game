package dev.sheradon.game.state;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.sheradon.game.Handler;

public abstract class State implements MouseListener, MouseMotionListener
{
	private boolean isLeftPressed = false;
	private boolean isRightPressed = false;
	
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
	
	public void mousePressed(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON1)
			isLeftPressed = true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			isRightPressed = true;
	}
	public abstract void tick();

	public abstract void render(Graphics g);

	public boolean isLeftPressed()
	{
		return isLeftPressed;
	}

	public void setLeftPressed(boolean isLeftPressed)
	{
		this.isLeftPressed = isLeftPressed;
	}

	public boolean isRightPressed()
	{
		return isRightPressed;
	}

	public void setRightPressed(boolean isRightPressed)
	{
		this.isRightPressed = isRightPressed;
	}
}
