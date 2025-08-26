package universidad;

public class SistemaGestion {
    public static void main(String[] args) {
        Profesor prof1 = new Profesor("Dr. García", "12345678", "Matemáticas");
        Profesor prof2 = new Profesor("Ing. López", "87654321", "Programación");

        Curso curso1 = new Curso("Cálculo I", Constantes.CATEGORIA_MATEMATICAS, prof1, 3);
        Curso curso2 = new Curso("Java Básico", Constantes.CATEGORIA_PROGRAMACION, prof2, 2);

        Estudiante est1 = new Estudiante("Ana", "11111111", "E001");
        Estudiante est2 = new Estudiante("Luis", "22222222", "E002");
        Estudiante est3 = new Estudiante("María", "33333333", "E003");

        curso1.inscribirEstudiante(est1);
        curso1.inscribirEstudiante(est2);
        curso2.inscribirEstudiante(est3);

        curso1.mostrarCurso();
        curso2.mostrarCurso();

        System.out.println("\nTotal de cursos creados: " + Curso.getTotalCursos());
    }
}
