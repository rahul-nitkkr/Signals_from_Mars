package com.rahul.signalsfrommars.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.rahul.signalsfrommars.R;
import com.rahul.signalsfrommars.model.Page;
import com.rahul.signalsfrommars.model.Story;


public class storyActivity extends ActionBarActivity {

    private Story mStory = new Story();
    private ImageView mImageView;
    private EditText mEditText;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mName = name;

        Toast.makeText(this,name,Toast.LENGTH_LONG).show();

        mImageView = (ImageView)findViewById(R.id.storyImageView);
        mEditText = (EditText)findViewById(R.id.storyEditText);
        mChoice1 = (Button)findViewById(R.id.choiceButton1);
        mChoice2 = (Button)findViewById(R.id.choiceButton2);

        loadPage(0);
    }

    private void loadPage(int Index){
        mPage = mStory.getPage(Index);

        Drawable drawable = getResources().getDrawable(mPage.getImageId());
        mImageView.setImageDrawable(drawable);

        String pageText = mPage.getText();
        pageText = String.format(pageText,mName);

        mEditText.setText(pageText);

        if(mPage.isFinal()){
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("PLAY AGAIN!!");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else{
        mChoice1.setText(mPage.getChoice1().getText());
        mChoice2.setText(mPage.getChoice2().getText());

        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = mPage.getChoice1().getNextPage();
                loadPage(nextPage);
            }
        });

        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = mPage.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
    }
    }
}
