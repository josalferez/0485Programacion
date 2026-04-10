public class Vehiculo {
    String matricula;
    String marca;

    public Vehiculo(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + "]";
    }

    public void arrancar() {
        System.out.println("El vehiculo matrícula: " + getMatricula() + " y marca: " + getMarca() + " arranca");
    }

    public void parar() {
        System.out.println("El vehiculo se para");
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void mostrarDatos() {
        System.out.println("Vehiculo matrícula: " + getMatricula() + " y marca: " + getMarca());
    }
}
