package com.example.zapateria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup GrupoSex, GrupoSlippers,GrupoBrands ;
    private RadioButton Sex, Slipper,Brand;
    private EditText Quantity;
    private TextView Totals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GrupoSex = findViewById(R.id.Grupo_Sex);
        GrupoSlippers = findViewById(R.id.Grupo_Type_Footwear);
        GrupoBrands = findViewById(R.id.Grupo_Brand);
        Quantity = findViewById(R.id.txt_Quantity);
        Totals = findViewById(R.id.lbl_Totals);
    }

    public void Calculate(View v){
        int  total = 0;
        Sex = findViewById(GrupoSex.getCheckedRadioButtonId());
        Slipper = findViewById(GrupoSlippers.getCheckedRadioButtonId());
        Brand = findViewById(GrupoBrands.getCheckedRadioButtonId());
        if(checkfields()){
            if(Sex.getText().equals( getString(R.string.rb_man) )){
                if(Slipper.getText().equals( getString(R.string.rb_slipper) )){
                    if(Brand.getText().equals( getString(R.string.rb_nike) )){
                        total = 120000  * Integer.parseInt( Quantity.getText().toString() );
                    } if(Brand.getText().equals( getString(R.string.rb_adidas) )){
                        total= 140000  * Integer.parseInt( Quantity.getText().toString() );
                    } if(Brand.getText().equals( getString(R.string.rb_puma) )){
                        total = 130000  * Integer.parseInt( Quantity.getText().toString() );
                    }
                }
                if(Slipper.getText().equals( getString(R.string.rb_classic) )){
                    if(Brand.getText().equals( getString(R.string.rb_nike)) ){
                        total = 50000  * Integer.parseInt( Quantity.getText().toString() );
                    }
                    if(Brand.getText().equals( getString(R.string.rb_adidas) )){
                        total = 80000  * Integer.parseInt( Quantity.getText().toString() );
                    }
                    if(Brand.getText().equals( getString(R.string.rb_puma) )){
                        total = 100000  * Integer.parseInt( Quantity.getText().toString() );
                    }
                }
            }
            if(Sex.getText() == getString(R.string.rb_woman)){
                if(Slipper.getText().equals(getString(R.string.rb_slipper) )){
                    if(Brand.getText().equals( getString(R.string.rb_nike) )){
                        total = 100000  * Integer.parseInt( Quantity.getText().toString() );
                    }
                    if(Brand.getText().equals( getString(R.string.rb_adidas) )){
                        total = 130000  * Integer.parseInt( Quantity.getText().toString() );
                    }
                    if(Brand.getText().equals( getString(R.string.rb_puma) )){
                        total = 110000  * Integer.parseInt( Quantity.getText().toString() );
                    }
                }
                if(Slipper.getText().equals( getString(R.string.rb_classic) )){
                    if(Brand.getText().equals( getString(R.string.rb_nike) )){
                        total = 60000  * Integer.parseInt( Quantity.getText().toString() );
                    }
                    if(Brand.getText().equals( getString(R.string.rb_adidas) )){
                        total = 70000  * Integer.parseInt( Quantity.getText().toString() );
                    }
                    if(Brand.getText().equals( getString(R.string.rb_puma) )){
                        total = 120000  * Integer.parseInt( Quantity.getText().toString() );
                    }
                }
            }
            Totals.setText(""+total);
        }

    }

    public boolean checkfields(){
        if (GrupoSex.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            Totals.setText("");
            return  false;
        }
        if (GrupoSlippers.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            Totals.setText("");
            return  false;
        }
        if (GrupoBrands.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            Totals.setText("");
            return  false;
        }
        if(Quantity.getText().toString().isEmpty()){
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            Totals.setText("");
            return  false;
        }
        return true;
    }



}