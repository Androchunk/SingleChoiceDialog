package com.androchunk.choicedialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SingleChoiceDialogFragment.SingleChoiceListener {

    private TextView tvDisplayChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplayChoice = findViewById(R.id.tvDisplayChoice);

        Button btnSelectChoice = findViewById(R.id.btnSelectChoice);
        btnSelectChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment singleChoiceDialog = new SingleChoiceDialogFragment();
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(), "Single Choice Dialog");
            }
        });

    }


    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        tvDisplayChoice.setText("Selected Item = " + list[position]);
    }

    @Override
    public void onNegativeButtonClicked() {
        tvDisplayChoice.setText("Dialog cancel");
    }
}
