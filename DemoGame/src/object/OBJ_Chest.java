package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject{

	public OBJ_Chest() {
		
		name = "Chest";
		
		// REMEMBER THIS IMAGE STUFF TRY/CATCH
		try {
			image = ImageIO.read(getClass().getResource("/objects/chest.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

