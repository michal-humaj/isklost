package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

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
}
