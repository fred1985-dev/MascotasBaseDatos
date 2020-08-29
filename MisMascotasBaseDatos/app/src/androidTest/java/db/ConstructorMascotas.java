package db;

import android.content.ContentValues;
import android.content.Context;

import com.servicsofts.miscontactos.Mascota;
import com.servicsofts.miscontactos.R;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final Integer LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context=context;
    }

    public ArrayList<Mascota> obtenerDatos(){

       /* ArrayList<Mascota>  mascotas= new ArrayList<Mascota>();
        mascotas.add(new Mascota( R.mipmap.mascota1,"Catyy","catty@hotmail.com", 5));
        mascotas.add(new Mascota(R.mipmap.mascota2,"Ronny","ronny@hotmail.com", 3));
        return mascotas;

        */
       BaseDatos db = new BaseDatos(context);
       insertarMascotas(db);
       return db.consultarMarscotas();
    }

    public  void insertarMascotas(BaseDatos db){
        ContentValues contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDaatos.TABLE_NOMBRE, "Catyy");
        contentValues.put(ConstantesBaseDaatos.TABLE_EMAIL, "Catyy@hotmail.con");
        contentValues.put(ConstantesBaseDaatos.TABLE_FOTO, R.mipmap.mascota1);

        db.insertarMascotas(contentValues);

        ContentValues contentValuesDos =  new ContentValues();
        contentValuesDos.put(ConstantesBaseDaatos.TABLE_NOMBRE, "Ronny");
        contentValuesDos.put(ConstantesBaseDaatos.TABLE_EMAIL, "Ronny@hotmail.con");
        contentValuesDos.put(ConstantesBaseDaatos.TABLE_FOTO, R.mipmap.mascota2);

        db.insertarMascotas(contentValuesDos);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDaatos.TABLE_MASCOTA_LITE_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDaatos.TABLE_MASCOTA_LIKE_NUM_LIKE, LIKE);
        db.insertarMascotaLke(contentValues);
    }

}
