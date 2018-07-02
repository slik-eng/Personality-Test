package com.slikengsoft.personalitytest.misc;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class Helper {
    private static Context context;

    public Helper(Context context) {
        this.context = context;
    }

    public static InputStream getInputStreamFromAsset() {
        InputStream fileLocation = null;
        try {
            fileLocation = context.getAssets().open("personality_test.json");
            //fileLocation.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLocation;
    }
}
