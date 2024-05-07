package buses;

public class EnMatricula implements Criterio{
    private String data;
    public EnMatricula(String n){
        this.data=n;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        boolean seleccionable = false;
        if(bus.getMatricula().contains(data)){
            seleccionable=true;
        }
        return seleccionable;
    }
}
