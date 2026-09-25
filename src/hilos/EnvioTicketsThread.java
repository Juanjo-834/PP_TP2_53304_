package hilos;

import modelo.Inscripcion;
import java.util.List;

public class EnvioTicketsThread extends Thread {

    private List<Inscripcion> inscripciones;


    public EnvioTicketsThread(List<Inscripcion> inscripciones){
        this.inscripciones = inscripciones;
    }


    @Override
    public void run(){

        for(Inscripcion inscripcion : inscripciones){

            System.out.println(
                    "Hilo de tickets - Enviando ticket a: "
                            + inscripcion.getEstudiante().getNombre()
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("Error en envio de tickets");
            }

        }

    }
}