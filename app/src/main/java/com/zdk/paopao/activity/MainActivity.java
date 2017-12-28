package com.zdk.paopao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.zdk.paopao.R;
import com.zdk.paopao.adapter.ImageAdapter;
import com.zdk.paopao.bean.ImageInfo;
import com.zdk.paopao.util.HttpCallbackListener;
import com.zdk.paopao.util.HttpHelper;
import com.zdk.paopao.util.HttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ImageInfo> imageInfos;
    ImageInfo imageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.lv);
        imageInfo = new ImageInfo();
        Log.d("MainActivity", "运行到这了");

        HttpUtil.sendHttpRequest("http://paopao.myncic.com/plugin_1?c=api&a=quanTopicList&clientapp=android&tid=0&area=%E9%81%B5%E4%B9%89%E5%B8%82", new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Log.d("MainActivity", response);

                for (int i = 0; i < 10; i++) {
                    try {
                        JSONObject jsonObject=new JSONObject(response);
                        String temData=jsonObject.getString("data");
                        Log.d("MainActivity", temData);
                        jsonObject=new JSONObject(temData);
                        imageInfo.setAvatar(jsonObject.getString("avatar"));
                        Log.d("MainActivity", imageInfo.getAvatar());
                        imageInfo.setUsername(jsonObject.getString("nickname"));
                        imageInfo.setContent(jsonObject.getString("txt"));
                        imageInfos.add(imageInfo);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
        ImageAdapter adapter = new ImageAdapter(imageInfos, this);
        lv.setAdapter(adapter);
    }

    public static String http_quanTopicList(String tid) {
        Log.e("tag", "http_quanTopicList");
        String write_data = "clientapp=android"
                + "&tid=" + tid + "&area=遵义市";
        return HttpHelper.get_Http_Post("http://paopao.myncic.com/plugin_1?c=api&a=quanTopicList", write_data);
    }


}
