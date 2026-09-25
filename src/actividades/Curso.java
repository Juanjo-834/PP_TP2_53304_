package actividades;

import certificacion.Certificable;
import certificacion.Certificado;
import modelo.Estudiante;


    public class Curso extends Actividad implements Certificable {

        private int nivel;


        public Curso(int id, String titulo, int cupoMaximo, int nivel) {

            super(id, titulo, cupoMaximo);
            this.nivel = nivel;

        }


        @Override
        public double calcularCostoMateriales() {

            return 3000;

        }


        @Override
        public String getTipo() {

            return "Curso";

        }


        @Override
        public Certificado generarCertificado(Estudiante estudiante) {

            return new Certificado("UTN", estudiante);

        }

    }

