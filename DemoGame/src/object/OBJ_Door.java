package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject{

	public OBJ_Door() {
		
		name = "Door";
		
		// REMEMBER THIS IMAGE STUFF TRY/CATCH
		try {
			image = ImageIO.read(getClass().getResource("/objects/door.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
