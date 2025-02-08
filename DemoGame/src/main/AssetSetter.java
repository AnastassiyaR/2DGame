package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldXX = 23 * gp.tileSize; // a location of key x
		gp.obj[0].worldYY = 7 * gp.tileSize; // y
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldXX = 23 * gp.tileSize;
		gp.obj[1].worldYY = 40 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key();
		gp.obj[2].worldXX = 37 * gp.tileSize;
		gp.obj[2].worldYY = 7 * gp.tileSize;
		
		
		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldXX = 10 * gp.tileSize;
		gp.obj[3].worldYY = 11 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldXX = 8 * gp.tileSize;
		gp.obj[4].worldYY = 28 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Door();
		gp.obj[5].worldXX = 12 * gp.tileSize;
		gp.obj[5].worldYY = 22 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Chest();
		gp.obj[6].worldXX = 10 * gp.tileSize;
		gp.obj[6].worldYY = 7 * gp.tileSize;
	}
}
