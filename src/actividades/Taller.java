package actividades;

import certificacion.Certificable;
import certificacion.Certificado;
import modelo.Estudiante;

public class Taller extends Actividad implements Certificable, Cloneable{
    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    public double calcularCostoMateriales() {
        if (requiereNotebook) {
            return 5000;
        }
        return 2000;
    }
    public String getTipo(){
        return "Taller";
    }

    @Override
    public Certificado generarCertificado(Estudiante estudiante){
        return new Certificado("UTN", estudiante);
    }
    @Override
    public Taller clone(){
        try {
            return (Taller) super.clone();
        } catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }
}