package com.example.eric.multiitemtest;

import com.freelib.multiitem.item.BaseItemData;

/**
 * 创建图片和文字类
 */

public class ImageTextBean extends BaseItemData {
    private int img;
    private String imgUrl;
    private String text;
    private  String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public ImageTextBean(int img, String text,String content) {
        this.img = img;
        this.text = text;
        this.content=content;
    }
    public ImageTextBean(String imgUrl, String text) {
        this.imgUrl = imgUrl;
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return text;
    }
}
