package ics.softwares.lab5_customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private int value = 0;
    private Button increment, startActivity;  // start

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        increment = (Button)findViewById(R.id.button);
        increment.setOnClickListener(new OnClickListener());
        updateButtonLabel();
        startActivity = (Button)findViewById(R.id.startActivity);
        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent mainIntent = new Intent(MainActivity.this, ActivityWithoutSavedState.class);
                MainActivity.this.startActivity(mainIntent);
            }
        });
    }
    public void updateButtonLabel() {
        increment.setText(" " + value);
    }

    private class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            value++;
            updateButtonLabel();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        value = savedInstanceState.getInt(" keyValue");
        updateButtonLabel();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(" keyValue", value);
    }
}
