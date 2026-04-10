public class Coche {
    private String matricula;
    private boolean estaReparado;

    // Constructor: Inicializa la matrícula y el estado en false
    public Coche(String matricula) {
        this.matricula = matricula;
        this.estaReparado = false;
    }

    // Método para cambiar el estado de reparación
    public void reparar() {
        this.estaReparado = true;
    }

    @Override
    public String toString() {
        String estado = estaReparado ? "SÍ" : "NO";
        return "Coche [" + matricula + "] - Reparado: " + estado;
    }
}