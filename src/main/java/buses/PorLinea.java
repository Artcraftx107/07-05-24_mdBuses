package buses;

public class PorLinea implements Criterio{
    private int codLinea;
    public PorLinea (int cod){
        this.codLinea=cod;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        boolean seleccionable = false;
        if(bus.getCodLinea()==this.codLinea){
            seleccionable=true;
        }
        return seleccionable;
    }
}
