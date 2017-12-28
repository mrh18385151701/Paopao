package com.zdk.paopao.bean;

import com.zdk.paopao.gson.Image;

/**
 * Created by Administrator on 2017/12/26.
 */

public class ImageInfo {
    private String avatar;
    private String usernameererre;
    private String content;

    public void parseImage(Image imageData, int position){
        avatar=imageData.data.get(position).avatar;
        username=imageData.data.get(position).nickname;
        content=imageData.data.get(position).txt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
