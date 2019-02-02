package arnau.cubatasbbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EditaLocalitzacio extends AppCompatActivity {

    private DataSourceCubata dsc = new DataSourceCubata(this);
    private Localitzacio localitzacio = new Localitzacio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_localitzacio);
    }

    public void crearLocalitzacio(View v){
        EditText tv = findViewById(R.id.nomLocalitzacio);
        localitzacio.setLloc(tv.getText().toString());
        dsc.open();
        dsc.createLocalitzacio(localitzacio);
        dsc.close();
        finish();
    }
}
