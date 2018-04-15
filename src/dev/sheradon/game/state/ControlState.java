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

public class ControlState extends State
{
	private BufferedImage test;
	private UIManager uiManager;
	private boolean running = false;
	private Thread thread;

	public ControlState(Handler handler)
	{
		super(handler);
		uiManager = new UIManager(handler);
		// handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(788, 610, 105, 45, Assets.btn_menu, new ClickListener()
		{
			@Override
			public void onCick()
			{
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().menuState);
			}
		}));

		try
		{
			test = ImageIO.read(new File("res/textures/Controls.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
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