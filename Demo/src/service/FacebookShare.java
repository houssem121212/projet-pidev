package service;

import com.codename1.facebook.FaceBookAccess;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
/**
 *
 * @author Fenina Malek
 */
public class FacebookShare {
    private static String token = "EAACEdEose0cBAOZCb9imV6DyG42IcxwFVuyu7Mp09ouWMwjW5qeLKbGtryKbkoyP826HHUHHt0LR97V6B9RD7pBgZAU6wEZAjZCzs2IvpVNZBITbLYE7ra1Qjae8FazhPYMm5RTqsPfOW4wVcL2jAOkhFaqZB2gi8x2DFTZCAIll5m4eYZC5YKzboaonzduZAB6Wuf7xMsr5mWcidSeDm6QzT";

    public FacebookShare(String token) {
        FaceBookAccess.setToken(token);
    }


    
    public void share(String text) throws IOException {
	FaceBookAccess.getInstance().addResponseCodeListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent evt) {
		NetworkEvent ne = (NetworkEvent) evt;
		int code = ne.getResponseCode();
		FaceBookAccess.getInstance().removeResponseCodeListener(this);
	    }
	});
	FaceBookAccess.getInstance().postOnWall("me", text);
    }
    
}
