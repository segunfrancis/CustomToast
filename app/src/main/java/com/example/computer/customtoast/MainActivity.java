package com.example.computer.customtoast;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView container;
    private Context context;
    private int duration = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.custom_toast_container);
        context = getApplicationContext();
    }

    public void displayCustomToast(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, container);

        TextView text = layout.findViewById(R.id.text);
        text.setText(R.string.custom_toast_message);

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM, 0, 40);
        toast.setDuration(duration);
        toast.setView(layout);
        toast.show();
    }

    public void displayDefaultToast(View view) {
        Toast toast = Toast.makeText(context, R.string.default_toast_message, duration);
        toast.setGravity(Gravity.CENTER | Gravity.START, 20, 0);
        toast.show();
    }
}
