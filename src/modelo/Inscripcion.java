package modelo;



import actividades.Actividad;

import java.time.LocalDate;

public class Inscripcion {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private Actividad actividad;
    private TicketDeAcceso ticket;

    public Inscripcion(Actividad actividad, Estudiante estudiante) {
        this.fecha = LocalDate.now();
        this.estado = "Activa";
        this.actividad = actividad;
        this.estudiante = estudiante;
    }
    public Estudiante getEstudiante(){
        return estudiante;
    }

    public void confirmar(){
        this.estado = "Confirmada";
        this.ticket = new TicketDeAcceso("TK-" + estudiante.getNombre());
    }
    public class TicketDeAcceso {

        private String codigo;

        public TicketDeAcceso(String codigo){
            this.codigo = codigo;
        }

        public void mostrarTicket(){
            System.out.println("TICKET DE ACCESO");
            System.out.println("Codigo: " + codigo);
            System.out.println("Alumno: " + estudiante.getNombre());
        }

    }



}
