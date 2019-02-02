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
    private String[] allColumnsBar
            = {HelperCubata.COLUMN__IDBAR,
           HelperCubata.COLUMN_NOMBAR,
            HelperCubata.COLUMN_IDLOCALITZACIO
    };

    private String[] allColumnsTipus
            = {HelperCubata.COLUMN__TIPUS,
    };

    private String[] allColumnsLocalitzacio
            = {HelperCubata.COLUMN__IDLOCALITZACIO,
            HelperCubata.COLUMN_NOMLOCALITZACIO,
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

    public Bar createBar(Bar bar) {
        // insert d'un nou bar
        ContentValues values
                = new ContentValues();
        values.put(HelperCubata.COLUMN_NOMBAR,
                bar.getnomBar());
        values.put(HelperCubata.COLUMN_IDLOCALITZACIO,
                 bar.getIdLocalitzacio());

        long insertId= database.insert(HelperCubata.TABLE_BAR,null,values);
        bar.setId(insertId);
        return bar;
    }

    public Localitzacio createLocalitzacio(Localitzacio localitzacio) {
        // insert d'un nou localitzacio
        ContentValues values
                = new ContentValues();
        values.put(HelperCubata.COLUMN_NOMLOCALITZACIO,
                localitzacio.getLloc());

        long insertId= database.insert(HelperCubata.TABLE_LOCALITZACIO,null,values);
        localitzacio.setId(insertId);
        return localitzacio;
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

    public boolean updateBar(Bar bar) {
        ContentValues values
                = new ContentValues();
        long id = bar.getId();
        values.put(HelperCubata.COLUMN_NOMBAR,
                bar.getnomBar());
        return database.update(HelperCubata.TABLE_BAR,values, HelperCubata.COLUMN_ID+ "="+ id,null)> 0;
    }

    public boolean updateLocalitzacio(Localitzacio localitzacio) {
        ContentValues values
                = new ContentValues();
        long id = localitzacio.getId();
        values.put(HelperCubata.COLUMN_NOMLOCALITZACIO,
                localitzacio.getLloc());
        return database.update(HelperCubata.TABLE_LOCALITZACIO,values, HelperCubata.COLUMN_ID+ "="+ id,null)> 0;
    }

    public void deleteCubata(Cubata cubata) {
        long id = cubata.getId();
        database.delete(HelperCubata.TABLE_CUBATA,
                        HelperCubata.COLUMN_ID+ " = "+ id,null);
    }

    public void deleteBar(Bar bar) {
        long id = bar.getId();
        database.delete(HelperCubata.TABLE_BAR,
                HelperCubata.COLUMN_ID+ " = "+ id,null);
    }

    public void deleteLocalitzacio(Localitzacio localitzacio) {
        long id = localitzacio.getId();
        database.delete(HelperCubata.TABLE_LOCALITZACIO,
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

    public List<String> getAllTipus(){
        List<String> tipus = new ArrayList<String>();
        Cursor cursor= database.query(HelperCubata.TABLE_TIPUS,
                allColumnsTipus,
                null,
                null,
                null,
                null,
                HelperCubata.COLUMN_DATA+ " DESC"
        );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String s = cursorToTipus(cursor);
            tipus.add(s);
            cursor.moveToNext();
        }
        cursor.close();
        return tipus;
    }

    private String cursorToTipus(Cursor cursor) {
        String s = cursor.getString(0);
        return s;
    }

    private Cubata cursorToCubata(Cursor cursor) {
        Cubata v= new Cubata();
        v.setId(cursor.getLong(0));
        v.setnomCubata(cursor.getString(
                1
        ));
        v.setGraduacio(cursor.getString(
                2
        ));
        v.setData(cursor.getString(
                3
        ));
        v.setComentari(cursor.getString(
                4
        ));
        v.setIdBar(cursor.getLong(
                5
        ));
        v.setIdBar(cursor.getLong(
                6
        ));
        v.setPreu(cursor.getFloat(
                7
        ));
        v.setValOlfativa(cursor.getString(
                8
        ));
        v.setValGustativa(cursor.getString(
                9
        ));
        v.setValVisual(cursor.getString(
                10
        ));
        v.setNota(cursor.getInt(
                11
        ));
        v.setFoto(cursor.getString(
                12
        ));
        return v;
    }
}

