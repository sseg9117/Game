package dev.sheradon.game.state;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.sheradon.game.Handler;
import dev.sheradon.game.ui.ClickListener;
import dev.sheradon.game.ui.UIManager;

public class MenuState extends State implements MouseListener, MouseMotionListener
{
	private BufferedImage menu;
	private UIManager uiManager;
	Rectangle start = new Rectangle(300, 500, 100, 64);

	public MenuState(Handler handler, ClickListener clicker)
	{
		super(handler);
		try
		{
			menu = ImageIO.read(new File("res/textures/Menu.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(handler, uiManager);
		// Buttons
//		 if ((e.getButton() == MouseEvent.BUTTON1) && start.contains(e.getX(), e.getY()) )
//		 {
//		 State.setState(handler.getGame().gameState);
//		 }
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
	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		System.out.println(x);
		 if ((e.getButton() == MouseEvent.BUTTON1) && start.contains(e.getX(), e.getY()) )
		 {
		 State.setState(handler.getGame().gameState);
		 }
	}
	
}
