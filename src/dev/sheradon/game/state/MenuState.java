package dev.sheradon.game.state;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.sheradon.game.Handler;
import dev.sheradon.game.ui.UIManager;

public class MenuState extends State
{
	private BufferedImage menu;
	private UIManager uiManager;
	private boolean running = false;
	private Thread thread;
	public MenuState(Handler handler)
	{
		super(handler);
		try
		{
			menu = ImageIO.read(new File("res/textures/Menu.png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		//Buttons
		//when mouse clicked in certain area of screen where it says start it switches to
		//State.setState(handler.getGame().gameState);
	}
		
	@Override
	public void tick()
	{
		uiManager.tick();
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(menu, 0, 0, null);
		uiManager.render(g);
	}

	public boolean isRunning()
	{
		return running;
	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}

	public Thread getThread()
	{
		return thread;
	}

	public void setThread(Thread thread)
	{
		this.thread = thread;
	}
}
