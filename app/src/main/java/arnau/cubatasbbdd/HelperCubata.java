package arnau.cubatasbbdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HelperCubata extends SQLiteOpenHelper {
    public static final String TABLE_CUBATA
            = "cubata";
    public static final String COLUMN_ID
            = "_id";
    public static final String COLUMN_NOMCUBATA
            = "nomcubata";
    public static final String COLUMN_TIPUS
            = "tipus";
    public static final String COLUMN_GRADUACIO
            = "graduacio";
    public static final String COLUMN_DATA
            = "data";
    public static final String COLUMN_COMENTARI
            = "comentari";
    public static final String COLUMN_IDBAR
            = "idbar";
    public static final String COLUMN_PREU
            = "preu";
    public static final String COLUMN_VALOLFATIVA
            = "valolfativa";
    public static final String COLUMN_VALGUSTATIVA
            = "valgustativa";
    public static final String COLUMN_VALVISUAL
            = "valcubatasual";
    public static final String COLUMN_NOTA
            = "nota";
    public static final String COLUMN_FOTO
            = "foto";
    public static final String TABLE_BAR
            = "bodega";
    public static final String COLUMN__IDBAR
            = "_idbar";
    public static final String COLUMN_IDLOCALITZACIO
            = "idlocalitzacio";
    public static final String COLUMN_NOMBAR
            = "nombar";
    public static final String TABLE_LOCALITZACIO
            = "localitzacio";
    public static final String COLUMN__IDLOCALITZACIO
            = "_idlocalitzacio";
    public static final String COLUMN_NOMLOCALITZACIO
            = "nomlocalitzacio";
    public static final String TABLE_TIPUS
            = "tipus";
    public static final String COLUMN__TIPUS
            = "_tipus";
    private static final String DATABASE_NAME
            = "alcoholicapp";
    private static final int DATABASE_VERSION= 7;

    private static final String DATABASE_CREATE_CUBATA
            = "create table "
            + TABLE_CUBATA
            + "("
            + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_NOMCUBATA
            + " text not null,"
            + COLUMN_TIPUS
            + " text,"
            + COLUMN_GRADUACIO
            + " text,"
            + COLUMN_DATA
            + " text,"
            + COLUMN_COMENTARI
            + " text,"
            + COLUMN_IDBAR
            + " integer,"
            + COLUMN_PREU
            + " float,"
            + COLUMN_VALOLFATIVA
            + " text,"
            + COLUMN_VALGUSTATIVA
            + " text,"
            + COLUMN_VALVISUAL
            + " text,"
            + COLUMN_NOTA
            + " integer,"
            + COLUMN_FOTO
            + " text);";
    private static final String DATABASE_CREATE_BAR
            = "create table "
            + TABLE_BAR
            + "("
            + COLUMN__IDBAR
            + " integer primary key autoincrement, "
            + COLUMN_IDLOCALITZACIO
            + " integer,"
            +COLUMN_NOMBAR
            + " text not null);"
            ;
    private static final String DATABASE_CREATE_TIPUS
            = "create table "
            + TABLE_TIPUS
            + "("
            + COLUMN__TIPUS
            + " text not null primary key);";

    private static final String DATABASE_CREATE_LOCALITZACIO
            = "create table "
            + TABLE_LOCALITZACIO
            + "("
            + COLUMN_NOMLOCALITZACIO
            + " text,"
            + COLUMN__IDLOCALITZACIO
            + " integer primary key autoincrement);";

    public HelperCubata(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_CUBATA);
        database.execSQL(DATABASE_CREATE_BAR);
        database.execSQL(DATABASE_CREATE_TIPUS);
        database.execSQL(DATABASE_CREATE_LOCALITZACIO);
        database.execSQL(" insert into "+ TABLE_TIPUS+ "(_tipus) values(('Combinat'))");
        database.execSQL(" insert into "+ TABLE_TIPUS+ "(_tipus) values(('Cocktail'))");
        database.execSQL(" insert into "+ TABLE_TIPUS+ "(_tipus) values(('Chupito'))");
        database.execSQL(" insert into "+ TABLE_TIPUS+ "(_tipus) values(('Licor'))");
        database.execSQL("insert into " + TABLE_CUBATA + "(nomcubata,graduacio,data,comentari,idbar,preu,valolfativa,valgustativa,valcubatasual," +
                "nota,foto,tipus) values('RonCola','23º','23/10/19','','1','5','5','','','10','foto','Combinat')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {
        Log.w(HelperCubata.class.getName(),"Modificant desde la versió "+ oldVersion+ " a "+ newVersion);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BAR);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_TIPUS);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_LOCALITZACIO);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_CUBATA);
        onCreate(db);
    }
}
