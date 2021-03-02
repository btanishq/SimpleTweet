package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Tweet {
    public String body;
    public String createdAt;
    public long id;
    public User user;
    public String timestamp;

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {

        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.id = jsonObject.getLong("id");
        tweet.timestamp = TimeFormatter.getTimeDifference(jsonObject.getString("created_at"));

        return tweet;

    }

    public static List<Tweet> fromJsonArray (JSONArray jsonArray) throws JSONException {
            List<Tweet> tweets = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                tweets.add(fromJson(jsonArray.getJSONObject(i)));
            }
        return tweets;
        }

    }

