package com.slikengsoft.personalitytest.data.api;

import android.os.Handler;

import com.google.gson.Gson;
import com.slikengsoft.personalitytest.misc.Helper;
import com.slikengsoft.personalitytest.data.model.Callback;
import com.slikengsoft.personalitytest.data.model.QuestionsResponse;

import java.io.IOException;
import java.io.InputStream;

public class Questions {
    public void getQuestions(final Callback callback, Boolean isOnline) {
        final int DELAY_MILLIS = 1000;
        new Handler().postDelayed(() -> {
            if (!isOnline)
                callback.onLoadCategories(getOfflineResponse());
            // else get from online api
        }, DELAY_MILLIS);
    }

    private String getFromLocal() {
        String json = null;
        try {
            InputStream inputStream = Helper.getInputStreamFromAsset();
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }
        return json;
    }

    public QuestionsResponse getOfflineResponse() {
        return new Gson().fromJson(getFromLocal(), QuestionsResponse.class);
    }
}
