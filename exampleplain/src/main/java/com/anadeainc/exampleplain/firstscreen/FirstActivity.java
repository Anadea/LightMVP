package com.anadeainc.exampleplain.firstscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.anadeainc.exampleplain.R;
import com.anadeainc.exampleplain.base.SimpleActivity;
import com.anadeainc.exampleplain.secondscreen.SecondActivity;

public class FirstActivity extends SimpleActivity<FirstMvp.View, FirstPresenter>
        implements FirstMvp.View {

    private Button button;
    private TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        button = (Button) findViewById(R.id.first_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter().onButtonClick();
            }
        });
        counter = (TextView) findViewById(R.id.first_counterText);
    }

    @Override
    protected FirstPresenter createRetainedComponent() {
        return new FirstPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        button.setOnClickListener(null);
    }

    @Override
    public void setScreenTitle() {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(getString(R.string.title_activity_first));
    }

    @Override
    public void setCounter(int count) {
        counter.setText(getString(R.string.activity_attached));
        counter.append(String.valueOf(count));
    }

    @Override
    public void toSecondActivity() {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
