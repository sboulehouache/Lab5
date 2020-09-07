package ics.softwares.lab5_customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
public class MainActivity extends AppCompatActivity {
    private int value = 0;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this) ;
        button = new Button(this) ;

        button.setOnClickListener(new OnClickListener() ) ;
        updateButtonLabel() ;
        layout.addView(button) ;
        setContentView(layout) ;
        button.setHeight(((View) button.getParent()).getHeight());
        button.setWidth(((View) button.getParent()).getWidth());

    }
    public void updateButtonLabel() {
        button. setText(" " +value) ;
    }
    private class OnClickListener implements View. OnClickListener {
        @Override
        public void onClick(View v) {
            value++;
            updateButtonLabel() ;
        }
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState) ;
        value = savedInstanceState.getInt(" keyValue" ) ;
        updateButtonLabel() ;
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState) ;
        outState.putInt(" keyValue" , value) ;
    }
}
