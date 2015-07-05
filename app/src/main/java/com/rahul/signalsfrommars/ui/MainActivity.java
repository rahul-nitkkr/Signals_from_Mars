package com.rahul.signalsfrommars.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.*;

import com.rahul.signalsfrommars.R;


public class MainActivity extends ActionBarActivity {

    private EditText mEditText;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText)findViewById(R.id.nameEditText);
        mStartButton  = (Button)findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                name = mEditText.getText().toString();
                startStory(name);
            }
        });
    }

    private void startStory(String name){
        Intent intent = new Intent(this,storyActivity.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }
}
