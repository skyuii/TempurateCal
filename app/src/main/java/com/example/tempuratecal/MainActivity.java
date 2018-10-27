package com.example.tempuratecal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static DecimalFormat df2 = new DecimalFormat(".##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button transCtoF = findViewById(R.id.tran_c2f);
        Button transFtoC = findViewById(R.id.tran_f2c);
        final EditText tempInput = findViewById(R.id.input_temp);
        final TextView tempResult = findViewById(R.id.ans_temp);

        transCtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String raw_in = tempInput.getText().toString();

                if(raw_in.isEmpty()) {
                    alert_input_valid();
                }
                else {
                    Double input = Double.valueOf(raw_in);
                    tempResult.setText(cal_c_to_f(input));
                }
            }
        });

        transFtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String raw_in = tempInput.getText().toString();

                if(raw_in.isEmpty()) {
                    alert_input_valid();
                }
                else {
                    Double input = Double.valueOf(raw_in);
                    tempResult.setText(cal_f_to_c(input));
                }
            }
        });

    }
    public String cal_c_to_f(Double input){
        return df2.format(input*1.8+32.0);
    }

    public String cal_f_to_c(Double input){
        return df2.format((input-32.0)/1.8);
    }
    public void alert_input_valid(){
        Toast t = Toast.makeText(getApplicationContext(), R.string.app_name,Toast.LENGTH_LONG);
        t.show();
    }
}
