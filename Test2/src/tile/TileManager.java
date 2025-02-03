package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/worldmap.txt");
	}
	public void getTileImage() {
		
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision = true;
					
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap(String filePath) {
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			// Read each char in the text and save in the buffer
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldRow) {
					col = 0;
					row++;
				}
				
			}
			br.close();
		} catch (Exception e) {
		}
	}
	public void draw(Graphics2D g2) {
		
		int worldcol = 0;
		int worldrow = 0;
		
		// the thing is that world map and screen has different coordinates like coordinate for world and screen
		// The screen is a limited area!!!
		//so here are formulas
		
		while(worldcol < gp.maxWorldCol && worldrow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldcol][worldrow];
			
			int worldx = worldcol * gp.tileSize;
			int worldy = worldrow * gp.tileSize;
			
			// gp.player.worldx shows where is character on the map; relates to the map
			// gp.player.screenx is needed so player displace at the center; relates to the screen
			int screenx = worldx - gp.player.worldX + gp.player.screenX; 
			int screeny = worldy - gp.player.worldY + gp.player.screenY;
			
			// boundary so it draws only tiles which is visible on the screen
			if(worldx + gp.tileSize > gp.player.worldX - gp.player.screenX && 
					worldx - gp.tileSize < gp.player.worldX + gp.player.screenX &&
					worldy + gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldy - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenx, screeny, gp.tileSize, gp.tileSize, null);
			}
			
			worldcol++;
			
			if(worldcol == gp.maxWorldCol) {
				worldcol = 0;
				worldrow++;
			}
		}
	}
}
