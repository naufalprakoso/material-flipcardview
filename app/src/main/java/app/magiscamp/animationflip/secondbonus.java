package app.magiscamp.animationflip;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secondbonus extends AppCompatActivity {

    String score, scoreSend;
    Double scoreDouble, scoreResult;
    SharedPreferences prefs;
    SharedPreferences.Editor mEditor;
    TextView scoreBonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondbonus);

        prefs = getSharedPreferences("quizData", Context.MODE_PRIVATE);
        scoreBonus = (TextView) findViewById(R.id.scoreBonus);
        mEditor = prefs.edit();
        score = prefs.getString("scoreBonus", null);
        scoreDouble = Double.parseDouble(score);

        scoreBonus.setText(score);
    }
}