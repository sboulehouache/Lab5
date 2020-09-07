package ics.softwares.lab5_customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityWithoutSavedState extends AppCompatActivity {
    private int value = 0;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_without_saved_state);
        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value++;
                updateButtonLabel();
            }
        });
        updateButtonLabel();
    }
    public void updateButtonLabel() {
        button.setText(" " + value);
    }
}
