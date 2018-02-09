package dev.sheradon.game.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
	private static final int width = 64, height = 64;
	
	public static BufferedImage dirt, grass, stone;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		dirt = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width * 2, 0, width, height);
	}
}
