//package service;
//
//import com.codename1.facebook.FaceBookAccess;
//import com.codename1.io.NetworkEvent;
//import com.codename1.ui.events.ActionEvent;
//import com.codename1.ui.events.ActionListener;
//import java.io.IOException;
//
//public class FacebookShare {
//    private static String token = "EAAF91IQMzb4BAEghVt2ZBzkaSNLB9pTGM0ZApc926nJb4aww6DMDo3sNYcfK3q08tdaMgOOZCyuOWkEKEJP8JomA6uW6jK6iKdLqeLvkzZCZCBTHZA3w2ZBB6ELbZA4uAF8QFxREYDgK9sqqYNd5G4a8sx181TXV0lKznicnRmDQt1C9lYtlexKCcj2UwEeTvn9IlKN0gi7ZAEQZDZD";
//
//    public FacebookShare(String token) {
//        FaceBookAccess.setToken(token);
//    }
//
//
//    
//    public void share(String text) throws IOException {
//	FaceBookAccess.getInstance().addResponseCodeListener(new ActionListener() {
//
//	    @Override
//	    public void actionPerformed(ActionEvent evt) {
//		NetworkEvent ne = (NetworkEvent) evt;
//		int code = ne.getResponseCode();
//		FaceBookAccess.getInstance().removeResponseCodeListener(this);
//	    }
//	});
//	FaceBookAccess.getInstance().postOnWall("me", text);
//    }
//    
//}
