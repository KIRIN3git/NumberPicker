package kabukeisan.kirin3.jp.numberpicker;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numPicker0, numPicker1;
    private TextView pickerTextView,pickerTextView2,pickerTextView3;
    private CustomNumberPicker customNumberPicker;

    private String[] figures = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pickerTextView = findViewById(R.id.text_view);
        pickerTextView2 = findViewById(R.id.text_view2);
        pickerTextView3 = findViewById(R.id.text_view3);

        numPicker0 = findViewById(R.id.numPicker0);
        numPicker1 = findViewById(R.id.numPicker1);
        customNumberPicker = (CustomNumberPicker)findViewById(R.id.numPicker2);

        Button pickerButton = findViewById(R.id.button1);

        // 最大値、最小値を設定
        numPicker0.setMaxValue(9);
        numPicker0.setMinValue(0);

        numPicker1.setMaxValue(9);
        numPicker1.setMinValue(0);

        customNumberPicker.setMaxValue(1000);
        customNumberPicker.setMinValue(0);


        pickerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                figures[0] = String.valueOf(numPicker0.getValue());
                figures[1] = String.valueOf(numPicker1.getValue());
                figures[2] = String.valueOf(customNumberPicker.getValue());

                String str = String.format("%s%s%s",
                        figures[0], figures[1], figures[2]);
                Float fig = Float.parseFloat(str);

                pickerTextView.setText(String.valueOf(fig));
            }
        });

        // 変更を受け取るリスナー
        numPicker0.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                pickerTextView2.setText(String.valueOf(newVal));
            }
        });

        // 変更を受け取るリスナー
        customNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                pickerTextView3.setText(String.valueOf(newVal * customNumberPicker.getStep()));
            }
        });
    }


}
