package modelo;


import actividades.Actividad;
import actividades.Charla;
import actividades.Taller;
import actividades.Curso;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;

    private Sala sala;

    private List<Actividad> actividades;

    private static int cantidadEventos = 0;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito){
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();

        cantidadEventos++;
    }
     public void asignarSala(Sala sala){
        this.sala = sala;
     }

    public void crearActividad(int id, String titulo, int cupoMaximo, String tipo) {
        if (tipo.equals("Charla")){
            Charla charla = new Charla(id, titulo, cupoMaximo, "Sin especificar");
            actividades.add(charla);
            
        } else if (tipo.equals("Taller")) {
            Taller taller = new Taller(id, titulo, cupoMaximo, false);
            actividades.add(taller);
        }
        else if(tipo.equals("Curso")){

            Curso curso = new Curso(id, titulo, cupoMaximo, 1);
            actividades.add(curso);

        }
    }
     public double calcularCostoEstimado(){
        if(gratuito){
            return 0;
        }
        double costoActividades = 0;
        for (Actividad actividad : actividades){
            costoActividades += actividad.calcularCostoMateriales();

        }
         return (costoBase + costoActividades) * 1.21;
     }
     public EventoUniversitario(EventoUniversitario otro){
         this.id = otro.id;
         this.titulo = otro.titulo;
         this.costoBase = otro.costoBase;
         this.gratuito = otro.gratuito;
         this.sala = otro.sala;
         this.actividades = new ArrayList<>();

         cantidadEventos++;
     }
     public static int getCantidadEventos(){
        return cantidadEventos;
     }
     public void mostrarDatos(){
            System.out.println("ID: " + id);
            System.out.println("Titulo: " + titulo);
            System.out.println("Costo Base: $" + costoBase);
            System.out.println("Gratuito: " + gratuito);
            if(sala != null){
                System.out.println("Sala: "+ sala.getNombre());
            }
            System.out.println("Costo Estimado: $" + calcularCostoEstimado() );
         for (Actividad actividad : actividades) {
             actividad.mostrarIdentificacion();
             actividad.mostrarInscripciones();
         }
        }
        public List<Actividad> getActividades(){
        return actividades;
        }

    public <T extends Actividad> List<T> filtrarActividadesPorTipo(Class<T> tipo){

        List<T> resultado = new ArrayList<>();

        for(Actividad actividad : actividades){

            if(tipo.isInstance(actividad)){
                resultado.add(tipo.cast(actividad));
            }
        }

        return resultado;
    }
    public double calcularCostoMateriales(List<? extends Actividad> actividades){

        double total = 0;

        for(Actividad actividad : actividades){

            total += actividad.calcularCostoMateriales();

        }

        return total;
    }
    }
