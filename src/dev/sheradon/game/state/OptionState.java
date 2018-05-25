package dev.sheradon.game.state;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.sheradon.game.Handler;
import dev.sheradon.game.gfx.Assets;
import dev.sheradon.game.input.MouseManager;
import dev.sheradon.game.ui.ClickListener;
import dev.sheradon.game.ui.UIImageButton;
import dev.sheradon.game.ui.UIManager;

public class OptionState extends State
{
	private BufferedImage option;
	private UIManager optionManager;
	private boolean running = false;
	private Thread thread;

	public OptionState(Handler handler)
	{
		super(handler);
		optionManager = new UIManager(handler);		
		handler.getMouseManager().setUIManager(getUiManager());;

		optionManager.addObject(new UIImageButton(820, 600, 110, 45, Assets.btn_menu, new ClickListener()
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
			option = ImageIO.read(new File("res/textures/Options.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void tick()
	{
			optionManager.tick();
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(option, 0, 0, null);
		optionManager.render(g);
	}

	public BufferedImage getTest()
	{
		return option;
	}

	public void setTest(BufferedImage test)
	{
		this.option = test;
	}

	public UIManager getUiManager()
	{
		return optionManager;
	}

	public void setUiManager(UIManager uiManager)
	{
		this.optionManager = uiManager;
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
