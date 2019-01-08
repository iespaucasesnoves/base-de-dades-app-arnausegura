package arnau.cubatasbbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DataSourceCubata {
    private SQLiteDatabase database;
    private HelperCubata dbAjuda;
    private String[] allColumnsCubata
            = {HelperCubata.COLUMN_ID,
            HelperCubata.COLUMN_NOMCUBATA,
            HelperCubata.COLUMN_GRADUACIO,
            HelperCubata.COLUMN_DATA,
            HelperCubata.COLUMN_COMENTARI,
            HelperCubata.COLUMN_IDBAR,
            HelperCubata.COLUMN_PREU,
            HelperCubata.COLUMN_VALOLFATIVA,
            HelperCubata.COLUMN_VALGUSTATIVA,
            HelperCubata.COLUMN_VALVISUAL,
            HelperCubata.COLUMN_NOTA,
            HelperCubata.COLUMN_FOTO,
            HelperCubata.COLUMN_TIPUS
    };

    public DataSourceCubata(Context context) {
        dbAjuda= new HelperCubata(context);
    }

    public void open()throws SQLException {
        database= dbAjuda.getWritableDatabase();
    }

    public void close() {
        dbAjuda.close();
    }
    
    public Cubata createCubata(Cubata cubata) {
        // insert d'un nou cubata
        ContentValues values
                = new ContentValues();
        values.put(HelperCubata.COLUMN_NOMCUBATA,
                cubata.getnomCubata());
        values.put(HelperCubata.COLUMN_TIPUS,
                cubata.getTipus());
        values.put(HelperCubata.COLUMN_GRADUACIO,
                cubata.getGraduacio());
        values.put(HelperCubata.COLUMN_DATA,
                String.valueOf(cubata.getData()));
        values.put(HelperCubata.COLUMN_COMENTARI,
                cubata.getComentari());
        values.put(HelperCubata.COLUMN_IDBAR,
                cubata.getIdBar());
        values.put(HelperCubata.COLUMN_PREU,
                cubata.getPreu());
        values.put(HelperCubata.COLUMN_VALOLFATIVA,
                cubata.getValOlfativa());
        values.put(HelperCubata.COLUMN_VALGUSTATIVA,
                cubata.getValGustativa());
        values.put(HelperCubata.COLUMN_VALVISUAL,
                cubata.getValVisual());
        values.put(HelperCubata.COLUMN_NOTA,
                cubata.getNota());
        values.put(HelperCubata.COLUMN_FOTO,
                cubata.getFoto());
        long insertId= database.insert(HelperCubata.TABLE_CUBATA,null,values);
        cubata.setId(insertId);
        return cubata;
    }

    public boolean updateCubata(Cubata cubata) {
        ContentValues values
                = new ContentValues();
        long id = cubata.getId();
        values.put(HelperCubata.COLUMN_NOMCUBATA,
                cubata.getnomCubata());
        values.put(HelperCubata.COLUMN_TIPUS,
                cubata.getTipus());
        values.put(HelperCubata.COLUMN_GRADUACIO,
                cubata.getGraduacio());
        values.put(HelperCubata.COLUMN_DATA,
                String.valueOf(cubata.getData()));
        values.put(HelperCubata.COLUMN_COMENTARI,
                cubata.getComentari());
        values.put(HelperCubata.COLUMN_IDBAR,
                cubata.getIdBar());
        values.put(HelperCubata.COLUMN_PREU,
                cubata.getPreu());
        values.put(HelperCubata.COLUMN_VALOLFATIVA,
                cubata.getValOlfativa());
        values.put(HelperCubata.COLUMN_VALGUSTATIVA,
                cubata.getValGustativa());
        values.put(HelperCubata.COLUMN_VALVISUAL,
                cubata.getValVisual());
        values.put(HelperCubata.COLUMN_NOTA,
                cubata.getNota());
        values.put(HelperCubata.COLUMN_FOTO,
                cubata.getFoto());
        return database.update(HelperCubata.TABLE_CUBATA,values, HelperCubata.COLUMN_ID+ "="+ id,null)> 0;
    }

    public void deleteCubata(Cubata cubata) {
        long id = cubata.getId();
        database.delete(HelperCubata.TABLE_CUBATA,
                        HelperCubata.COLUMN_ID+ " = "+ id,null);
    }

    public Cubata getCubata(long id) {
        Cubata cubata;
        Cursor cursor= database.query(HelperCubata.TABLE_CUBATA,allColumnsCubata,HelperCubata.COLUMN_ID+ " = "+ id,
                    null,
                        null,
                        null,
                        null
                );
        if (cursor.getCount()> 0) {
            cursor.moveToFirst();
            cubata = cursorToCubata(cursor);
        } else {
            cubata= new Cubata();
        }
        cursor.close();
        return cubata;
    }

    public List<Cubata> getAllCubata() {
        List<Cubata> cubatas = new ArrayList<Cubata>();
        Cursor cursor= database.query(HelperCubata.TABLE_CUBATA,
                        allColumnsCubata,
                        null,
                        null,
                        null,
                        null,
                        HelperCubata.COLUMN_DATA+ " DESC"
                );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Cubata cubata = cursorToCubata(cursor);
            cubatas.add(cubata);
            cursor.moveToNext();
        }
        cursor.close();
        return cubatas;
    }

    private Cubata cursorToCubata(Cursor cursor) {
        Cubata v= new Cubata();
        v.setId(cursor.getLong(0));
        v.setnomCubata(cursor.getString(
                1
        ));
        v.setGraduacio(cursor.getString(
                4
        ));
        v.setData(cursor.getString(
                5
        ));
        v.setComentari(cursor.getString(
                6
        ));
        v.setIdBar(cursor.getLong(
                7
        ));
        v.setIdBar(cursor.getLong(
                8
        ));
        v.setPreu(cursor.getFloat(
                9
        ));
        v.setValOlfativa(cursor.getString(
                10
        ));
        v.setValGustativa(cursor.getString(
                11
        ));
        v.setValVisual(cursor.getString(
                12
        ));
        v.setNota(cursor.getInt(
                13
        ));
        v.setFoto(cursor.getString(
                14
        ));
        return v;
    }
}

