package ejercicio1;


import actividades.Actividad;
import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Sala;
import excepciones.CupoExcedidoException;
import certificacion.Certificable;
import certificacion.Certificado;
import actividades.Taller;
import actividades.Charla;
import actividades.Curso;
import modelo.Inscripcion;
import hilos.EnvioTicketsThread;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args){
        Estudiante juan = new Estudiante("53304","juan");
        Estudiante maria = new Estudiante("50124", "maria");
        Estudiante pedro = new Estudiante("50125", "pedro");

        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(juan);
        estudiantes.add(maria);
        estudiantes.add(pedro);

        EventoUniversitario evento1 = new EventoUniversitario("EV01", "Jornada de programacion", 10000, false) ;
        Sala sala1 = new Sala(1, "Aula 10");

        evento1.asignarSala(sala1);

        evento1.crearActividad(1, "Introduccion a java", 2, "Charla");
        evento1.crearActividad(2, "Git y Github", 3, "Taller");

        Actividad actividadJava = evento1.getActividades().get(0);
        Actividad actividadGit = evento1.getActividades().get(1);

        try {


            actividadJava.inscribir(juan);
            actividadJava.inscribir(maria);
            actividadJava.inscribir(pedro);

            actividadGit.inscribir(maria);
            actividadGit.inscribir(pedro);

        } catch (CupoExcedidoException e) {
            System.out.println("Error de inscripcion: " + e.getMessage());
        }
        evento1.mostrarDatos();

        EventoUniversitario evento2 =new EventoUniversitario("EV02", "Encuentro de Tecnología", 8000, true);

        Sala sala2 = new Sala(2, "Aula 20");

        evento2.asignarSala(sala2);

        evento2.crearActividad(3, "Inteligencia Artificial", 2, "Charla");
        evento2.crearActividad(4, "Taller de Java", 3, "Taller");
        evento2.crearActividad(5, "Curso de Programacion", 3, "Curso");

        Actividad actividadBD = evento2.getActividades().get(0);
        Actividad actividadWeb = evento2.getActividades().get(1);

        Taller tallerOriginal = (Taller) actividadWeb;

        Taller tallerCopia = tallerOriginal.clone();

        System.out.println("Tipo del original: " + tallerOriginal.getTipo());
        System.out.println("Tipo de la copia: " + tallerCopia.getTipo());

        Actividad actividadCurso = evento2.getActividades().get(2);

        try {
            actividadBD.inscribir(juan);
            actividadBD.inscribir(pedro);

            actividadWeb.inscribir(maria);
            actividadWeb.inscribir(pedro);

            Inscripcion inscripcionJuan = actividadCurso.inscribir(juan);
            Inscripcion inscripcionPedro = actividadCurso.inscribir(pedro);

            inscripcionJuan.confirmar();
            inscripcionPedro.confirmar();

            EnvioTicketsThread hiloTickets =
                    new EnvioTicketsThread(actividadCurso.getInscripciones());

            hiloTickets.start();

            if (actividadCurso instanceof Certificable) {

                Certificable certificable = (Certificable) actividadCurso;

                Certificado certificado1 = certificable.generarCertificado(juan);
                Certificado certificado2 = certificable.generarCertificado(pedro);

                certificado1.mostrarCertificado();
                certificado2.mostrarCertificado();

            }

        }catch(CupoExcedidoException e){
            System.out.println("Error de Inscripcion:" + e.getMessage());
        }

        evento2.mostrarDatos();

        List<Charla> listaCharlas = evento2.filtrarActividadesPorTipo(Charla.class);

        List<Taller> listaTalleres = evento2.filtrarActividadesPorTipo(Taller.class);

        List<Curso> listaCursos = evento2.filtrarActividadesPorTipo(Curso.class);


        System.out.println("Cantidad de charlas: " + listaCharlas.size());

        System.out.println("Cantidad de talleres: " + listaTalleres.size());

        System.out.println("Cantidad de cursos: " + listaCursos.size());

        System.out.println(
                "Costo materiales talleres: "
                        + evento2.calcularCostoMateriales(listaTalleres)
        );

        System.out.println("Total de eventos creados: " + EventoUniversitario.getCantidadEventos());




    }


}
