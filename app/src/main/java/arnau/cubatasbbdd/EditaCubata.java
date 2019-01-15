package arnau.cubatasbbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditaCubata extends AppCompatActivity {

    private DataSourceCubata dsc;
    private long id;
    private Cubata cubata;
    private EditText nomCubata;
    private EditText graduacio;
    private EditText tipus;
    private EditText data;
    private EditText comentari;
    private EditText nomBar;
    private EditText valOlfativa;
    private EditText valGustativa;
    private EditText preu;
    private EditText valVisual;
    private EditText nota;
    private EditText foto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_cubata);
        this.id =Long.parseLong(getIntent().getStringExtra("ID"));
        cubata = dsc.getCubata(id);
        this.nomCubata=findViewById(R.id.nomCubata);
        nomCubata.setText(cubata.getnomCubata());
        this.graduacio=findViewById(R.id.graduacio);
        graduacio.setText(cubata.getGraduacio());
        this.tipus=findViewById(R.id.tipus);
        tipus.setText(cubata.getTipus());
        this.data=findViewById(R.id.data);
        data.setText(cubata.getData());
        this.comentari=findViewById(R.id.comentari);
        comentari.setText(cubata.getComentari());
        this.nomBar=findViewById(R.id.nomBar);
        nomBar.setText(Long.toString(cubata.getIdBar()));
        this.valOlfativa=findViewById(R.id.valOlfativa);
        valOlfativa.setText(cubata.getValOlfativa());
        this.valGustativa=findViewById(R.id.valGustativa);
        valGustativa.setText(cubata.getValGustativa());
        this.preu=findViewById(R.id.preu);
        preu.setText(Double.toString(cubata.getPreu()));
        this.valVisual=findViewById(R.id.valVisual);
        valVisual.setText(cubata.getValVisual());
        this.nota=findViewById(R.id.nota);
        nota.setText(cubata.getNota());
        this.foto=findViewById(R.id.foto);
        foto.setText(cubata.getFoto());
    }

    public void Guardar(View v){
        cubata.setnomCubata(nomCubata.getText().toString());
        cubata.setGraduacio(graduacio.getText().toString());
        cubata.setTipus(tipus.getText().toString());
        cubata.setData(data.getText().toString());
        cubata.setComentari(comentari.getText().toString());
        cubata.setIdBar(Long.parseLong(nomBar.getText().toString()));
        cubata.setValOlfativa(valOlfativa.getText().toString());
        cubata.setValGustativa(valGustativa.getText().toString());
        cubata.setValVisual(valVisual.getText().toString());
        cubata.setPreu(Double.parseDouble(preu.getText().toString()));
        cubata.setNota(Integer.parseInt(nota.getText().toString()));
        cubata.setFoto(foto.getText().toString());
        dsc.updateCubata(cubata);
    }

}
