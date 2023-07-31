package com.abdelhadi.java_revesion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calculer,rest;
    Spinner pro,categ;
    RadioButton dom ,relaise,magasin ;
    CheckBox lembamage ,rapide;
    EditText edit_prix;
    EditText edit_Quati;
    EditText prixHT;
    EditText tVA;
    EditText remise;
    EditText prixeTTC;
    double tva,prix,livrais,embalage,rap,prixHTTT,roumise,PrixTTC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculer=findViewById(R.id.button_calculer);
        rest=findViewById(R.id.button2_reset);
        pro=findViewById(R.id.spinner2_ordinateur);
        categ=findViewById(R.id.spinner_catego);
        dom=findViewById(R.id.radioButton_domicel);
        relaise=findViewById(R.id.radio_role);
        magasin=findViewById(R.id.radio_magasin);
        lembamage=findViewById(R.id.checkBox_lembalage);
        rapide=findViewById(R.id.checkBox2_laivraison);
        edit_prix=findViewById(R.id.editT_prix);
        edit_Quati=findViewById(R.id.edit_Qentite);
        prixHT=findViewById(R.id.edit_prixTH);
        tVA=findViewById(R.id.edit_TVA);
        remise=findViewById(R.id.edit_Remise);
       prixeTTC=findViewById(R.id.edit_PRIXTTC);

categ.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (position == 0){
            tva = 0.2;
        }
        else if  (position == 1){
            tva = 0.3;

        } else if (position ==2){
            tva = 0.35;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});
       pro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if (position == 0){
                   prix=5000;
                   edit_prix.setText(prix+" DH" );

               }else if(position == 1){
                   prix=4000;
                   edit_prix.setText(prix+" DH" );

               }
               else if(position == 2){
                   prix=75000;
                   edit_prix.setText(prix+" DH" );

               }
               else if(position == 3){
                   prix=15000;
                   edit_prix.setText(prix+" DH" );
               }
           }
           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });



        calculer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            int QNT=Integer.parseInt(edit_Quati.getText().toString());

            prixHTTT = prix*QNT ;
            if(QNT <= 3){
                roumise = 0.05;
            }

            else if (QNT >3){
                roumise =0.1;
            }



            if (magasin.isChecked()){
                livrais = 0;
            }
            else if  (relaise.isChecked()){
                livrais = 0.05 *prixHTTT ;
            }
            else if  (dom.isChecked()){
                livrais = 0.1 *prixHTTT;
            }


            if(lembamage.isChecked()){
                embalage=300 ;
            } else{
                embalage =0;}

            if (rapide.isChecked()){
                rap=400;
            } else{
                rap=0;}


            PrixTTC=prixHTTT+tva-roumise+embalage+rap+livrais;



            prixHT.setText(String.valueOf(prixHTTT));
            tVA.setText(String.valueOf(tva));
            remise.setText(String.valueOf(roumise));
            prixeTTC.setText(String.valueOf(PrixTTC));
        }


    });





    }
}