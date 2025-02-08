package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject{

	public OBJ_Key() {
		name = "key";
		
		// REMEMBER THIS IMAGE STUFF TRY/CATCH
		try {
			image = ImageIO.read(getClass().getResource("/objects/key.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
