package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numberEditText;

    class Number{
        int number;
        public boolean isNumberShape(){
            boolean isNumberShape = false;

            if(number<0){
                isNumberShape = false;
            }else if(isSquareNumberShape()||isTriangleNumberShape()){
                isNumberShape =  true;
            }

            return isNumberShape;
        }

        public boolean isSquareNumberShape(){
            double sq = Math.sqrt(number);
            return ((sq - Math.floor(sq)) == 0);
        }

        public boolean isTriangleNumberShape(){
            int sum = 0;

            for (int n = 1; sum <= number; n++)
            {
                sum = sum + n;
                if (sum == number)
                    return true;
            }

            return false;
        }
    }

    public void checkIfNumberShape(View view){
        numberEditText = findViewById(R.id.numberEditText);
        Number number = new Number();
        number.number = Integer.parseInt(numberEditText.getText().toString());


        if(number.isNumberShape()){
            Toast.makeText(this, number.number +" is a number shape.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, number.number+" is not a number shape", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}