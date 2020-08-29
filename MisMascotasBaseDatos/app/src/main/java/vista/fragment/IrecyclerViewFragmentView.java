package vista.fragment;

import com.servicsofts.miscontactos.ContactoAdaptador;
import com.servicsofts.miscontactos.Mascota;

import java.util.ArrayList;

public interface IrecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(ContactoAdaptador adaptador);

}

