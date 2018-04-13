package dev.sheradon.game.state;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.sheradon.game.Handler;
import dev.sheradon.game.ui.UIManager;

public abstract class State implements MouseListener, MouseMotionListener
{
	protected boolean leftPressed;
	protected boolean rightPressed;
	private int mouseX, mouseY;

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
	
	public boolean isLeftPressed()
	{
		return leftPressed;
	}

	public boolean isRightPressed()
	{
		return rightPressed;
	}
	
	public int getMouseX()
	{
		return mouseX;
	}
	public int getMouseY()
	{
		return mouseY;
	}
	// IMplemmented methods

	@Override
	public void mouseDragged(MouseEvent e)
	{

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();

		if (uiManager != null)
			uiManager.onMouseMove(e);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}
	@Override
	public void mousePressed(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		System.out.println(x);
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;

		if (uiManager != null)
			uiManager.onMouseRelease(e);
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}
}
