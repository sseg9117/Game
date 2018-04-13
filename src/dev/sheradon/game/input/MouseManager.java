package dev.sheradon.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.sheradon.game.Handler;
import dev.sheradon.game.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener
{
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	public boolean menu, options, back, start, select, controls;
	public boolean quit, restart;
	private UIManager uiManager;

	public MouseManager()
	{

	}

	public void setUIManager(Handler handler, UIManager uiManager)
	{
		this.uiManager = uiManager;
	}

	// Getters
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
//		int x = e.getX();
//		int y = e.getY();
//		System.out.println(x);
//		if (e.getButton() == MouseEvent.BUTTON1)
//			leftPressed = true;
//		else if (e.getButton() == MouseEvent.BUTTON3)
//			rightPressed = true;
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
