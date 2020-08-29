package db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.servicsofts.miscontactos.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDaatos.DATA_NAME, null, ConstantesBaseDaatos.DATA_BASE_VERSION);
        this.context = context;
    }

    @Override //se crea la estructura de la base de datos
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     String queryCreatTableMascota ="CREATE TABLE " + ConstantesBaseDaatos.TABLE_MASCOTA + "("+
             ConstantesBaseDaatos.TABLE_ID + " INTEGER PRIMARY  KEY AUTOINCREMENT, " +
             ConstantesBaseDaatos.TABLE_NOMBRE + "TEXT, " +
             ConstantesBaseDaatos.TABLE_EMAIL + "TEXT, " +
             ConstantesBaseDaatos.TABLE_FOTO + "TEXT " +
             ")";
        String queryCreateTableMascotaLike ="CREATE TABLE " + ConstantesBaseDaatos.TABLE_MASCOTA_LIKE + "("+
                ConstantesBaseDaatos.TABLE_MASCOTA_LITE_ID + " INTEGER PRIMARY  KEY AUTOINCREMENT, " +
                ConstantesBaseDaatos.TABLE_MASCOTA_LITE_ID_MASCOTA + "INTEGER, " +
                ConstantesBaseDaatos.TABLE_MASCOTA_LIKE_NUM_LIKE + "INTEGER, " +
                 "FOREIGN KEY ("+ ConstantesBaseDaatos.TABLE_MASCOTA_LITE_ID_MASCOTA + ") "+
                 " REFERENCES " + ConstantesBaseDaatos.TABLE_MASCOTA +" (" +ConstantesBaseDaatos.TABLE_MASCOTA_LITE_ID_MASCOTA+ ")"+
                ")";

        sqLiteDatabase.execSQL(queryCreatTableMascota);
        sqLiteDatabase.execSQL(queryCreateTableMascotaLike);
    }

    @Override  //
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDaatos.TABLE_MASCOTA_LIKE  );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDaatos.TABLE_MASCOTA  );
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> consultarMarscotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT  * FROM " + ConstantesBaseDaatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext()){
          Mascota  mascotasActual = new Mascota();
            mascotasActual.setId(registros.getInt(0));
            mascotasActual.setNombre(registros.getString(1));
            mascotasActual.setEmail(registros.getString(2));
            mascotasActual.setFoto(registros.getInt(3));
            mascotas.add(mascotasActual);
            //consultamos los like de esa moscota
        }
        db.close();
        return  mascotas;
    }


    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDaatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarMascotaLke(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDaatos.TABLE_MASCOTA_LIKE, null, contentValues);
        db.close();
    }
}
