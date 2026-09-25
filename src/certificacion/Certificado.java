package certificacion;

import modelo.Estudiante;

public class Certificado {
    private String entidadEmisora;
    private Estudiante estudiante;

    public Certificado(String entidadEmisora, Estudiante estudiante){
        this.entidadEmisora = entidadEmisora;
        this.estudiante = estudiante;
    }

    public void mostrarCertificado(){
        System.out.println("CERTIFICADO DE ASISTENCIA");
        System.out.println("Entidad: " + entidadEmisora);
        System.out.println("Alumno: " + estudiante.getNombre());
    }
}
