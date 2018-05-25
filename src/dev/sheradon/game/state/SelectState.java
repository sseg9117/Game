package dev.sheradon.game.state;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.ui.ClickListener;
import dev.sheradon.game.ui.UIImageButton;
import dev.sheradon.game.ui.UIManager;

public class SelectState extends State
{
	private BufferedImage test;
	private UIManager selectManager;
	private boolean running = false;
	private Thread thread;

	public SelectState(Handler handler)
	{
		super(handler);
		selectManager = new UIManager(handler);
	    handler.getMouseManager().setUIManager(selectManager);
	    
		selectManager.addObject(new UIImageButton(835, 625, 105, 50, Assets.btn_menu, new ClickListener()
		{
			@Override
			public void onCick()
			{
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().menuState);
			}
		}));
		selectManager.addObject(new UIImageButton(490, 205, 365, 390, Assets.btn_menu, new ClickListener()
		{
			@Override
			public void onCick()
			{
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
		selectManager.addObject(new UIImageButton(140, 205, 360, 390, Assets.btn_menu, new ClickListener()
		{
			@Override
			public void onCick()
			{
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
		try
		{
			test = ImageIO.read(new File("res/textures/SelectPlayer.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void tick()
	{
		selectManager.tick();
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(test, 0, 0, null);
		selectManager.render(g);
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
		return selectManager;
	}

	public void setUiManager(UIManager uiManager)
	{
		this.selectManager = uiManager;
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
