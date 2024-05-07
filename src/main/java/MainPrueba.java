import buses.*;

import java.io.IOException;

public class MainPrueba {
    public static void main(String[] args){
        Servicio servicio = new Servicio("Malaga");
        try {
            servicio.leeBuses("mdBuses/recursos/buses.txt");
        } catch (IOException e) {
            throw new RuntimeException("El fichero especificado no existe");
        }
        for(int i = 0; i<servicio.getBuses().size(); i++){
            System.out.println(servicio.getBuses().get(i));
        }
    }


}
