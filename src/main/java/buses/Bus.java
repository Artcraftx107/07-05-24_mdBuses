package buses;

public class Bus {
    private int codBus;
    private int codLinea;
    private String matricula;
    public Bus (int cod, String mat){
        this.codBus=cod;
        this.matricula=mat;
    }
    public void setCodLinea(int cod){
        this.codLinea=cod;
    }

    public int getCodBus() {
        return codBus;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.equals(obj)) return true;
        if(obj==null||getClass()!=obj.getClass())return false;
        Bus bus = (Bus) obj;
        return bus.getMatricula().equalsIgnoreCase(((Bus) obj).matricula)&&bus.getCodBus()==((Bus) obj).codBus;
    }

    @Override
    public String toString() {
        return "Bus("+getCodBus()+","+getMatricula()+","+getCodLinea()+")";
    }
}
