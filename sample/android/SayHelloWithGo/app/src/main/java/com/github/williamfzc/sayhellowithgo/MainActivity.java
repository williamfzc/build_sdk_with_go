package com.github.williamfzc.sayhellowithgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

// import from arr
import static hello.Hello.greetings;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.welcome_text);

        // hello from arr
        String welcomeStr = greetings("williamfzc");
        textView.setText(welcomeStr);
    }
}
