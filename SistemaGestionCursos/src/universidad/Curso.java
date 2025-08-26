package universidad;

public class Curso {
    private String nombreCurso;
    private String categoria;
    private Profesor profesor;
    private Estudiante[] estudiantes;
    private int contadorEstudiantes;

    private static int totalCursos = 0;

    public Curso(String nombreCurso, String categoria, Profesor profesor, int capacidad) {
        this.nombreCurso = nombreCurso;
        this.categoria = categoria;
        this.profesor = profesor;
        this.estudiantes = new Estudiante[capacidad];
        this.contadorEstudiantes = 0;
        totalCursos++;
    }

    public void inscribirEstudiante(Estudiante e) {
        if (contadorEstudiantes < estudiantes.length) {
            estudiantes[contadorEstudiantes] = e;
            contadorEstudiantes++;
            System.out.println(e.nombre + " se inscribió en " + nombreCurso);
        } else {
            System.out.println("El curso está lleno.");
        }
    }

    public void mostrarCurso() {
        System.out.println("\nCurso: " + nombreCurso + " | Categoría: " + categoria);
        profesor.mostrarDatos();
        System.out.println("Estudiantes matriculados:");
        for (int i = 0; i < contadorEstudiantes; i++) {
            estudiantes[i].mostrarDatos();
        }
    }

    public static int getTotalCursos() {
        return totalCursos;
    }
}
