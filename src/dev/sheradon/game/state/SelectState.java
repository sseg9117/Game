package dev.sheradon.game.state;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.sheradon.game.Handler;
import dev.sheradon.game.ui.UIManager;

public class SelectState extends State
{
	private BufferedImage test;
	private UIManager uiManager;
	private boolean running = false;
	private Thread thread;
	
	public SelectState(Handler handler)
	{
		super(handler);
		try
		{
			test = ImageIO.read(new File("res/textures/SelectPlayer.png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
	}

	@Override
	public void tick()
	{
		uiManager.tick();
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(test, 0, 0, null);
		uiManager.render(g);
	}
	
	public BufferedImage getTest()
	{
		return test;
	}
	public void setTest(BufferedImage test)
	{
		this.test = test;
	}
	public UIManager getUiManager()
	{
		return uiManager;
	}
	public void setUiManager(UIManager uiManager)
	{
		this.uiManager = uiManager;
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