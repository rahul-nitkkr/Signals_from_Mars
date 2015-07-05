package com.rahul.signalsfrommars.model;

import android.widget.ImageView;

/**
 * Created by Apple on 26/04/15.
 */
public class Page
{
    private String mText;
    private int mImageId;
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean mIsFinal = false;

    public boolean isFinal(){
        return mIsFinal;
    }

    public Page(int imageId, String text,Choice choice1, Choice choice2){
        mImageId = imageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;
        mIsFinal = false;
    }

    public Page(int imageId,String text){
        mImageId = imageId;
        mText = text;
        mChoice2 = null;
        mChoice1 = null;
        mIsFinal = true;
    }
    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }
}
