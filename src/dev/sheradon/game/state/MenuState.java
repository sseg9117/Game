package dev.sheradon.game.state;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.ui.ClickListener;
import dev.sheradon.game.ui.UIImageButton;
import dev.sheradon.game.ui.UIManager;

public class MenuState extends State implements ImageObserver
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
	}
	@Override
	public void tick()
	{
		uiManager.tick();
	}

	@Override
	public void render(Graphics2D g2d)
	{
		g2d.drawImage(menu, 0, 0, null);
		uiManager.render(g2d);
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

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height)
	{
		return false;
	}

}
