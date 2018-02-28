package dev.sheradon.game.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, sky, grass, stone;
	public static BufferedImage[] player_right, player_left;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		player_right = new BufferedImage[8];
		player_left = new BufferedImage[8];
		
		player_right[0] = sheet.crop(width, height, width, height);
		player_right[1] = sheet.crop(width * 1, height, width, height);
		player_left[0] = sheet.crop(width, height * 2, width, height);
		player_left[1] = sheet.crop(width * 1, height * 2, width, height);
		
		grass = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width * 1, 0, width, height);
		dirt = sheet.crop(width * 2, 0, width, height);
	}
}
