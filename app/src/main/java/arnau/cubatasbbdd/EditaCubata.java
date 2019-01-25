package arnau.cubatasbbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditaCubata extends AppCompatActivity {

    private DataSourceCubata dsc = new DataSourceCubata(this);
    private Cubata cubata = new Cubata();
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
//        this.id =Long.parseLong(getIntent().getStringExtra("ID"));
//        cubata = dsc.getCubata(id);
        this.nomCubata=findViewById(R.id.nomCubata);
        this.graduacio=findViewById(R.id.graduacio);
        this.tipus=findViewById(R.id.tipus);
        this.data=findViewById(R.id.data);
        this.comentari=findViewById(R.id.comentari);
        this.nomBar=findViewById(R.id.nomBar);
        this.valOlfativa=findViewById(R.id.valOlfativa);
        this.valGustativa=findViewById(R.id.valGustativa);
        this.preu=findViewById(R.id.preu);
        this.valVisual=findViewById(R.id.valVisual);
        this.nota=findViewById(R.id.nota);
        this.foto=findViewById(R.id.foto);
//        valOlfativa.setText(cubata.getValOlfativa());
//        nomCubata.setText(cubata.getnomCubata());
//        graduacio.setText(cubata.getGraduacio());
//        tipus.setText(cubata.getTipus());
//        data.setText(cubata.getData());
//        comentari.setText(cubata.getComentari());
//        nomBar.setText(Long.toString(cubata.getIdBar()));
//        valGustativa.setText(cubata.getValGustativa());
//        preu.setText(Double.toString(cubata.getPreu()));
//        valVisual.setText(cubata.getValVisual());
//        nota.setText(cubata.getNota());
//        foto.setText(cubata.getFoto());
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
        dsc.open();
        dsc.createCubata(cubata);
        dsc.close();
    }

}
