package dev.sheradon.game.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display
{
	private JFrame menu;
	private JFrame frame;
	private Canvas menuScreen;
	private Canvas canvas;

	private String title;
	private int width, height;

	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}

	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);		
		
		frame.add(canvas);
		frame.pack();		
	
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	public Canvas getCanvas()
	{
		return canvas;
	}

	public JFrame getMenu()
	{
		return menu;
	}

	public void setMenu(JFrame menu)
	{
		this.menu = menu;
	}

	public Canvas getMenuScreen()
	{
		return menuScreen;
	}

	public void setMenuScreen(Canvas menuScreen)
	{
		this.menuScreen = menuScreen;
	}

}
