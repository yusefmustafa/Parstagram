package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("D9zSKbAVUya3N4o1flTZDEMURgqg7Mb5C5VH9L3a")
                .clientKey("avCBRk69XrXlYgjbbw86hQIV9dnham7v88sp9Rg0")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
