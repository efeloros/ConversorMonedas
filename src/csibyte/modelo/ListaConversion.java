package csibyte.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaConversion {
    private List<Coversion>listaDeConversiones;

    public ListaConversion() {
        this.listaDeConversiones = new ArrayList<>();
    }

    public boolean lanzarRegistro(Coversion coversion){
        this.listaDeConversiones.add(coversion);
        return true;
    }

    public List<Coversion> getListaDeConversiones() {
        return listaDeConversiones;
    }
}
