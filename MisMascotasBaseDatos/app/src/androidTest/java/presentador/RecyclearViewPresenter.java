package presentador;

import android.content.Context;

import com.servicsofts.miscontactos.ContactoAdaptador;
import com.servicsofts.miscontactos.Mascota;

import java.util.ArrayList;

import db.ConstructorMascotas;
import vista.fragment.IrecyclerViewFragmentView;

public class RecyclearViewPresenter implements IrecyclearViewPresentador {

     // este constructor resive una instancia del modelo el contexto es una variavle o
     // objeto que necesitamos para estar pasando mensanjes ect
    private  IrecyclerViewFragmentView irecyclerViewFragmentView;

       private Context context;
       private ConstructorMascotas constructorMascotas;
       private ArrayList<Mascota> mascotas;


      public RecyclearViewPresenter(IrecyclerViewFragmentView irecyclerViewFragmentView, Context context){
       this.irecyclerViewFragmentView=irecyclerViewFragmentView;
       this.context = context;
          obtenerMascotas();
      }


    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas (context);
        mascotas =constructorMascotas.obtenerDatos();
        obtenerMascotasRecyclearView();
    }

    @Override
    public void obtenerMascotasRecyclearView() {
        irecyclerViewFragmentView.inicializarAdaptador(irecyclerViewFragmentView.crearAdaptador(mascotas));
        irecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
