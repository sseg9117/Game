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

public class MenuState extends State
{
	private BufferedImage menu;
	private UIManager menuManager;
	private boolean running = false;
	private Thread thread;

	public MenuState(Handler handler)
	{
		super(handler);
		menuManager = new UIManager(handler);	

		handler.getMouseManager().setUIManager(menuManager);
		
			

		menuManager.addObject(new UIImageButton(370, 250, 256, 95,
				Assets.btn_menu, new ClickListener()
				{
					@Override
					public void onCick()
					{
						handler.getMouseManager().setUIManager(null);
						State.setState(handler.getGame().gameState);
					}
				}));
		menuManager.addObject(new UIImageButton(350, 355, 286, 95,
				Assets.btn_menu, new ClickListener()
				{
					@Override
					public void onCick()
					{
						handler.getMouseManager().setUIManager(null);
						State.setState(handler.getGame().optionState);
					}
				}));
		menuManager.addObject(new UIImageButton(332, 455, 325, 95,
				Assets.btn_menu, new ClickListener()
				{
					@Override
					public void onCick()
					{
						handler.getMouseManager().setUIManager(null);
						State.setState(handler.getGame().controlState);
					}
				}));
		menuManager.addObject(new UIImageButton(835, 625, 105, 50,
				Assets.btn_menu, new ClickListener()
				{
					@Override
					public void onCick()
					{
						handler.getMouseManager().setUIManager(null);
						State.setState(handler.getGame().menuState);
					}
				}));
		menuManager.addObject(new UIImageButton(332, 555, 325, 90,
				Assets.btn_menu, new ClickListener()
				{
					@Override
					public void onCick()
					{
						handler.getMouseManager().setUIManager(null);
						System.exit(0);
					}
				}));
		try
		{
			menu = ImageIO.read(new File("res/textures/Menu.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void tick()
	{
//		if (uiManager != null)
//		{
			menuManager.tick();
//		}
//		else
//			System.out.println("this isnt working");
	}

	@Override
	public void render(Graphics g)
	{
			menuManager.render(g);

		g.drawImage(menu, 0, 0, null);
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
