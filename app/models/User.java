package models;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MiHu on 18.8.2014.
 */
@Entity
public class User extends Model {

    @Id
    public String userId;
    public String accessToken;
    public String refreshToken;
    public Long lastUpdate;

    public static Finder<String, User> find = new Finder<>(String.class, User.class);

    public User(String userId, String accessToken, String refreshToken, Long lastUpdate) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.lastUpdate = lastUpdate;
    }

    /**
     * makes post request for this user to google server
     * retrieves access token
     * update access token in DB as well as time point of this update
     */
    public void updateAccessToken() throws IOException, JSONException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("https://accounts.google.com/o/oauth2/token");
        List<NameValuePair> params = new ArrayList<NameValuePair>(4);
        params.add(new BasicNameValuePair("refresh_token", refreshToken));
        params.add(new BasicNameValuePair("client_id", "348319642197-otjpf6153v1mitqtbe11d08r39oc5skq.apps.googleusercontent.com")); //TODO dat do app variables
        params.add(new BasicNameValuePair("client_secret", "xmwcMxJ547EMUm3G_MyzQzsr"));  //TODO dat do app variables
        params.add(new BasicNameValuePair("grant_type", "refresh_token"));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse response = httpclient.execute(httppost);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        for (String line = null; (line = reader.readLine()) != null;) {
            builder.append(line).append("\n");
        }
        JSONTokener tokener = new JSONTokener(builder.toString());
        JSONObject obj = new JSONObject(tokener);
        accessToken = obj.get("access_token").toString();
        lastUpdate = new Date().getTime();
        update();
    }
}
