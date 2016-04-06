package sharecrew.net.datasentral_public;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HTTPostRequest {

    private String link;

    public HTTPostRequest(String link){
        this.link = link;
    }

    public void update_data(HashMap<String, String> postData){
        URL url;
        final int CONNECTION_TIMEOUT = 15 * 1000;
        try{
            String requestUrl = Utilities.WEBSITE + link;
            url = new URL(requestUrl);

            System.out.println(requestUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setReadTimeout(CONNECTION_TIMEOUT);
            con.setConnectTimeout(CONNECTION_TIMEOUT);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.connect();

            OutputStream os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getData(postData));

            System.out.println("IM HERE!");

            writer.flush();
            writer.close();
            os.close();

            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = con.getInputStream();
                InputStreamReader isReader = new InputStreamReader(is, "UTF-8");
                BufferedReader reader = new BufferedReader(isReader);

                String result = "";
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result += line;
                }

                System.out.println(result);
            }

        }catch (Exception e){
            e.getStackTrace();
        }
    }

    private String getData(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for(Map.Entry<String, String> entry : params.entrySet()){
            if(first){
                first = false;
            }else{
                result.append("&");
            }
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
