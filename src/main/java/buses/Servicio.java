package buses;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Servicio {
    private String ciudad;
    private List<Bus> buses;
    public Servicio(String cui){
        this.ciudad=cui;
        this.buses=new ArrayList<>();
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void leeBuses(String file)throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.out.println("Error: Datos de autobús incorrectos o faltantes en la línea: " + line);
                    continue;
                }
                try {
                    int codBus = Integer.parseInt(parts[0]);
                    String matri = parts[1];
                    int codLinea = Integer.parseInt(parts[2]);
                    Bus bus = new Bus(codBus, matri);
                    bus.setCodLinea(codLinea);
                    buses.add(bus);
                } catch (Exception e) {
                    System.out.println("Error al procesar la línea: " + line);
                }
            }
        }
    }
    public List<Bus> filtra(Criterio crit){
        List<Bus> criterioGood= new ArrayList<>();
        for(int i = 0; i< buses.size(); i++){
            if(crit.esSeleccionable(buses.get(i))){
                criterioGood.add(buses.get(i));
            }
        }
        return criterioGood;
    }
    public void guarda(String fileName, Criterio criterio)throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(new File(fileName))){
            guarda(pw, criterio);
        }catch (FileNotFoundException e){
            throw new FileNotFoundException("El fichero especificado no existe/no se ha encontrado");
        }
    }
    public void guarda(PrintWriter pw, Criterio criterio){
        List<Bus> busFiltrados = filtra(criterio);
        for(Bus bus : busFiltrados){
            pw.println(bus.toString());
        }
    }
}

