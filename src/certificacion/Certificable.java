package certificacion;

import modelo.Estudiante;

public interface Certificable {
    Certificado generarCertificado(Estudiante estudiante);
}
