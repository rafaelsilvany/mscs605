package org.MSCS605;

import java.net.URLEncoder;

public class Face2Anime {

    public static String face2Anime(String token, String img_path) {

        String url = "https://aip.baidubce.com/rest/2.0/image-process/v1/selfie_anime";
        try {
            String filePath = img_path; // Local file.
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // No caching for now.
            String accessToken = token;

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}