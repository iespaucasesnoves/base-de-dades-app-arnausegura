package arnau.cubatasbbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditaBar extends AppCompatActivity {

    private DataSourceCubata dsc = new DataSourceCubata(this);
    private Bar bar = new Bar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_bar);
    }

    public void crearBar(View v){
        EditText tv = findViewById(R.id.nomBar);
        bar.setnomBar(tv.getText().toString());
        tv = findViewById(R.id.nomBar2);
        bar.setIdLocalitzacio(Integer.parseInt(tv.getText().toString()));
        dsc.open();
        dsc.createBar(bar);
        dsc.close();
        finish();
    }
}
