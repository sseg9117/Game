package dev.sheradon.game.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
	private static final int width = 512, height = 512;

	public static BufferedImage dirt, sky, grass, stone, tree, wood, lava, leaves, chest, cloud;
	public static BufferedImage[] player_right, player_left, player_up,
			player_down, player_still, player_jump;
	
	public static BufferedImage[] player2_right, player2_left, player2_up,
			player2_down, player2_still, player2_jump;
	
	public static BufferedImage[] btn_back, btn_menu;


	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/sheet.png"));
		
		btn_menu = new BufferedImage[1];
		btn_menu[0] = sheet.crop(width *4, height *5, width, height);
		
		btn_back = new BufferedImage[1];
		btn_back[0] = sheet.crop(width *3, height *5, width, height);
		
		cloud = sheet.crop(width * 0,height * 0, width, height);
		grass = sheet.crop(width * 0, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		dirt = sheet.crop(width * 2, 0, width, height);
		sky = sheet.crop(width * 0, height * 0, width, height);
		leaves = sheet.crop(width * 1, height * 2, width, height);
		wood = sheet.crop(width * 1, height * 1, width, height);
		lava = sheet.crop(width * 2, height * 2, width, height);
		
		tree = sheet.crop(width * 0, height * 1, width, height * 2);
		chest = sheet.crop(width * 0, height * 5, width, height);
		
		
		player2_jump = new BufferedImage[1];
		player2_jump[0] = sheet.crop(width * 5, height *0, width, height);
		
		player_jump = new BufferedImage[1];
		player_jump[0] = sheet.crop(width * 4, height * 3, width, height);
		
		player2_still = new BufferedImage[1];
		player2_still[0] = sheet.crop(width * 5, height *0, width, height);
		
		player_still = new BufferedImage[1];
		player_still[0] = sheet.crop(width * 4, height * 3, width, height);
		
		player2_up = new BufferedImage[1];
		player2_up[0] = sheet.crop(width * 5, height *0, width, height);
		
		player_up = new BufferedImage[1];
		player_up[0] = sheet.crop(width * 4, height *3, width, height);
		
		player2_down = new BufferedImage[1];
		player2_down[0] = sheet.crop(width * 5, height *0, width, height);
		
		player_down = new BufferedImage[1];
		player_down[0] = sheet.crop(width * 4, height *3, width, height);
		
		player2_right = new BufferedImage[3];
		player2_right[0] = sheet.crop(width * 5, height *1, width, height);
		player2_right[1] = sheet.crop(width * 6, height *1, width, height);
		player2_right[2] = sheet.crop(width * 7, height *1, width, height);

		player_right = new BufferedImage[8];
		player_right[0] = sheet.crop(width * 3, 0, width, height);
		player_right[1] = sheet.crop(width * 4, 0, width, height);
		player_right[2] = sheet.crop(width * 5, 0, width, height);
		player_right[3] = sheet.crop(width * 6, 0, width, height);
		player_right[4] = sheet.crop(width * 7, 0, width, height);
		player_right[5] = sheet.crop(width * 3, height * 1, width, height);
		player_right[6] = sheet.crop(width * 4, height * 1, width, height);
		player_right[7] = sheet.crop(width * 5, height * 1, width, height);
		
		player2_left = new BufferedImage[3];
		player2_left[0] = sheet.crop(width * 5, height *0, width, height);
		player2_left[1] = sheet.crop(width * 6, height *0, width, height);
		player2_left[2] = sheet.crop(width * 7, height *0, width, height);

		player_left = new BufferedImage[8];
		player_left[7] = sheet.crop(width * 6, height * 1, width, height);
		player_left[6] = sheet.crop(width * 7, height * 1, width, height);
		player_left[5] = sheet.crop(width * 3, height * 2, width, height);
		player_left[4] = sheet.crop(width * 4, height * 2, width, height);
		player_left[3] = sheet.crop(width * 5, height * 2, width, height);
		player_left[2] = sheet.crop(width * 6, height * 2, width, height);
		player_left[1] = sheet.crop(width * 7, height * 2, width, height);
		player_left[0] = sheet.crop(width * 3, height * 3, width, height);

	}
}
