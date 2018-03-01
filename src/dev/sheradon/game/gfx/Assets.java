package dev.sheradon.game.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, sky, grass, stone;
	public static BufferedImage[] player_right, player_left, player_still;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		player_right = new BufferedImage[8];
		player_left = new BufferedImage[8];
		player_still = new BufferedImage[1];
		
		player_still[0] = sheet.crop(width * 3, 0, width, height);

		
		player_right[0] = sheet.crop(width * 3, 0, width, height);
		player_right[1] = sheet.crop(width * 4, 0, width, height);
		player_right[2] = sheet.crop(width * 5, 0, width, height);
		player_right[3] = sheet.crop(width * 6, 0, width, height);
		player_right[4] = sheet.crop(width * 7, 0, width, height);
		player_right[5] = sheet.crop(width * 3, height, width, height);
		player_right[6] = sheet.crop(width * 4, height, width, height);
		player_right[7] = sheet.crop(width * 5, height, width, height);
		
		player_left[0] = sheet.crop(width * 6, height, width, height);
		player_left[1] = sheet.crop(width * 7, height, width, height);
		player_left[2] = sheet.crop(width * 3, height * 2, width, height);
		player_left[3] = sheet.crop(width * 4, height * 2, width, height);
		player_left[4] = sheet.crop(width * 6, height * 2, width, height);
		player_left[5] = sheet.crop(width * 6, height * 2, width, height);
		player_left[6] = sheet.crop(width * 7, height * 2, width, height);
		player_left[7] = sheet.crop(width * 3, height * 3, width, height);
		
		
		grass = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width * 1, 0, width, height);
		dirt = sheet.crop(width * 2, 0, width, height);
	}
}
