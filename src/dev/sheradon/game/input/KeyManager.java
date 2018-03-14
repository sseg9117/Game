package dev.sheradon.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
	private boolean[] keys;
	public boolean up, down, left, right, space;
	public boolean Attack;
	
	public KeyManager()
	{
		keys = new boolean[256];
	}

	public void tick()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
		
		Attack = keys[KeyEvent.VK_E];
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

}
