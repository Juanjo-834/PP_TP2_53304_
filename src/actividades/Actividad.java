package actividades;

import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.Inscripcion;

import java.util.ArrayList;
import java.util.List;


public abstract class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;

    public static final int CUPO_MINIMO = 1;

    private List<Inscripcion> inscripciones;
    public Actividad(int id, String titulo, int cupoMaximo){
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }
    public Inscripcion inscribir(Estudiante estudiante)throws CupoExcedidoException {
            if (inscripciones.size() >= cupoMaximo) {
                throw new CupoExcedidoException("No Hay Cupo Disponible. ");
            }

            Inscripcion inscripcion = new Inscripcion(this, estudiante);
            inscripciones.add(inscripcion);
            return inscripcion;
        }
    public void mostrarInscripciones(){
        for(Inscripcion inscripcion : inscripciones) {
            System.out.println(inscripcion.getEstudiante().getNombre());

        }
    }
    public List<Inscripcion> getInscripciones(){
        return inscripciones;
    }
    public String getTitulo(){
        return titulo;
    }
    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

    public final void mostrarIdentificacion(){
        System.out.println(getTipo()+ ":"+ titulo);
    }

}