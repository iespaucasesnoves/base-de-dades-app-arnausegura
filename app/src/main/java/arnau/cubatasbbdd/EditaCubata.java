package arnau.cubatasbbdd;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class EditaCubata extends AppCompatActivity {

    private DataSourceCubata dsc = new DataSourceCubata(this);
    private Cubata cubata = new Cubata();
    private long id;
    private EditText nomCubata;
    private EditText graduacio;
    private Spinner tipus;
    private EditText data;
    private EditText comentari;
    private EditText nomBar;
    private EditText valOlfativa;
    private EditText valGustativa;
    private EditText preu;
    private EditText valVisual;
    private EditText nota;
    private EditText foto;
    private boolean nou;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_cubata);
        this.nomCubata = findViewById(R.id.nomCubata);
        this.graduacio = findViewById(R.id.graduacio);
        this.tipus = findViewById(R.id.spinner);
        this.data = findViewById(R.id.Data);
        this.comentari = findViewById(R.id.comentari);
        this.nomBar = findViewById(R.id.nomBar);
        this.valOlfativa = findViewById(R.id.valOlfativa);
        this.valGustativa = findViewById(R.id.valGustativa);
        this.preu = findViewById(R.id.Preu);
        this.valVisual = findViewById(R.id.valVisual);
        this.nota = findViewById(R.id.nota);
        this.foto = findViewById(R.id.foto);
        if (getIntent().getStringExtra("ID").equals("")) {
            nou = true;
        }else{
            nou = false;
            dsc.open();
            cubata = dsc.getCubata(Long.parseLong(getIntent().getStringExtra("ID")));
            montaSpinners("");
            dsc.close();
            valOlfativa.setText(cubata.getValOlfativa());
            nomCubata.setText(cubata.getnomCubata());
            graduacio.setText(cubata.getGraduacio());
            data.setText(cubata.getData());
            comentari.setText(cubata.getComentari());
            nomBar.setText(Long.toString(cubata.getIdBar()));
            valGustativa.setText(cubata.getValGustativa());
            preu.setText(Double.toString(cubata.getPreu()));
            valVisual.setText(cubata.getValVisual());
            nota.setText(Integer.toString(cubata.getNota()));
            foto.setText(cubata.getFoto());
        }
    }

    public void Guardar(View v) {
        cubata.setnomCubata(nomCubata.getText().toString());
        cubata.setGraduacio(graduacio.getText().toString());
        cubata.setTipus(tipus.toString());
        cubata.setData(data.getText().toString());
        cubata.setComentari(comentari.getText().toString());
        cubata.setIdBar(Long.parseLong(nomBar.getText().toString()));
        cubata.setValOlfativa(valOlfativa.getText().toString());
        cubata.setValGustativa(valGustativa.getText().toString());
        cubata.setValVisual(valVisual.getText().toString());
        cubata.setPreu(Double.parseDouble(preu.getText().toString()));
        cubata.setNota(Integer.parseInt(nota.getText().toString()));
        cubata.setFoto(foto.getText().toString());
        dsc.open();
        if (nou == false) {
            dsc.updateCubata(cubata);
        } else {
            dsc.createCubata(cubata);
        }
        dsc.close();
        finish();
    }

    private void montaSpinners(String t) {
        List<String> llista;
        llista=dsc.getAllTipus();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Crear adapter
        ArrayAdapter<String> dataAdapter =new ArrayAdapter<String>(
                        this,android.R.layout.simple_spinner_item, llista);
// Drop down estil – llista amb radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// assignar adapter
        spinner.setAdapter(dataAdapter);
        if(t!=null&& !t.equals("")) {
            selectValue(spinner,t);
// Si hi ha un valor assignat posicionar-se
        }
    }

    private void selectValue(Spinner spinner, Object value) {
        for(int i =0; i < spinner.getCount(); i++) {
            if(spinner.getItemAtPosition(i).equals(value)) {
                spinner.setSelection(i);
                break;
            }
        }
    }

}
