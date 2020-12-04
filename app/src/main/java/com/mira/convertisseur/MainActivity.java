package com.mira.convertisseur;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView txtResult;
    TextView txtUS;
    TextView txtCan;
    Button button;
    Button button2;
    Button btnExit;
    AlertDialog.Builder exitMessage;

    public void convert(View view)
    {
        Double canadianAmount;
        Double americanAmount;

        editText=findViewById(R.id.editText);
        canadianAmount=Double.parseDouble(editText.getText().toString());
        americanAmount=canadianAmount*0.77;

        // hide keyboard
        InputMethodManager mgr=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(view.getWindowToken(),0);

         String americanAmountString;
         americanAmountString=String.valueOf(americanAmount);

        txtResult=findViewById(R.id.txtResult);
        txtResult.setText(americanAmountString+"$");

        // Toast.makeText(MainActivity.this,String.format("%.2f",americanAmount) + " $ US",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = findViewById(R.id.editText);
                editText.setText("");
                txtResult = findViewById(R.id.txtResult);
                txtResult.setText("");
            }
        });

        btnExit.findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitMessage=new AlertDialog.Builder(MainActivity.this);
                exitMessage.setTitle("Quitter");
                exitMessage.setMessage("Voulez-vous quittez l'application?");
                exitMessage.setCancelable(false);
                exitMessage.setPositiveButton("Quittez", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });
                exitMessage.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog=exitMessage.create();
                dialog.show();
            }
        });
    }
}