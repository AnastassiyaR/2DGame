package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObject{

	public OBJ_Boots() {
		name = "Boots";
		
		// REMEMBER THIS IMAGE STUFF TRY/CATCH
		try {
			image = ImageIO.read(getClass().getResource("/objects/boots.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
