package org.MSCS605;

import org.MSCS605.FileUtil;
import org.MSCS605.GsonUtil;
import org.MSCS605.AuthService;
import org.MSCS605.HttpUtil;
import org.MSCS605.Base64Util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        String img_path = args[0];

        String bidu_ml_token = AuthService.getAuth();
        String anime_img = Face2Anime.face2Anime(bidu_ml_token, img_path);

        Map<String, String> response = GsonUtil.convertJSONToMap(anime_img);

        byte[] decoded = Base64Util.decodeToBytes(response.get("image"));
        try (OutputStream stream = new FileOutputStream("img/processed_anime.jpg")) {
            stream.write(decoded);
        } catch (FileNotFoundException ffe){
            ffe.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
