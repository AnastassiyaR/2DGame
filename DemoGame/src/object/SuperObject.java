package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	
	public void draw(Graphics2D g2, GamePanel gp) {
	// gp.player.screenx is needed so player displace at the center; relates to the screen
	int screenx = worldX - gp.player.worldX + gp.player.screenX; 
	int screeny = worldY - gp.player.worldY + gp.player.screenY;
	
	// boundary so it draws only tiles which is visible on the screen
	if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
		g2.drawImage(image, screenx, screeny, gp.tileSize, gp.tileSize, null);
	
		}
	}

}
