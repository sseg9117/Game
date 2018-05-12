 package dev.sheradon.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.sheradon.game.Handler;
import dev.sheradon.game.state.State;
import dev.sheradon.game.ui.UIManager;

public class KeyManager implements KeyListener
{
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right, space;
	public boolean attackLeft, attackRight;
	
	public KeyManager()
	{
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}

	public void tick()
	{
		for(int i= 0;i < keys.length;i++)
		{
			if(cantPress[i] && !keys[i])
			{
				cantPress[i] = false;
			}
			else if(justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i])
			{
				justPressed[i] = true;
			}
			
		}
		if(keyJustPressed(KeyEvent.VK_TAB))
		{
			System.out.println("Just pressed");
		}
		if(keyJustPressed(KeyEvent.VK_ESCAPE))
		{
//			State.setState(State.getState().getGame().menuState);
		}
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
		
		attackLeft = keys[KeyEvent.VK_E];
		attackRight = keys[KeyEvent.VK_E];
	}
	public boolean keyJustPressed(int keyCode)
	{
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

}
