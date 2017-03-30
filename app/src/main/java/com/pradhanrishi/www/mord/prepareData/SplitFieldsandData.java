package com.pradhanrishi.www.mord.prepareData;

import android.util.Log;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by yash on 27/3/17.
 */

public class SplitFieldsandData implements FormatJSONString {

    public static Object mFields, mData;
    public String resFields, resData;

    public void splitString() {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(GetJSONString.parsedJSONString);
            Log.e("PieChartActivity", json.toString());
            mFields = json.get("fields");
            resFields = mFields.toString();
            Log.e("SplitFieldsandData", resFields);
            mData = json.get("data");
            resData = mData.toString();
            Log.e("SplitFieldsandData2", resData);

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < resFields.length(); i++) {
            int j = resFields.indexOf("data");
        }

    }
}
