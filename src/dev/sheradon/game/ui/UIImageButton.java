package dev.sheradon.game.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject
{
	private BufferedImage [] images;
 	private ClickListener clicker;

	public UIImageButton(float x, float y, int width, int height, BufferedImage [] images, ClickListener clicker)
	{
		super(x, y, width, height);
		this.setImages(images);
		this.clicker = clicker;
	}

	@Override
	public void tick()
	{	
	}

	@Override
	public void render(Graphics g)
	{

	}

	@Override
	public void onClick()
	{
		clicker.onCick();
	}

	public BufferedImage [] getImages()
	{
		return images;
	}

	public void setImages(BufferedImage [] images)
	{
		this.images = images;
	}
	
}