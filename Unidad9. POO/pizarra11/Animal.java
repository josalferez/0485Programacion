public class Animal{
    // Animal
    private Sexo sexo;

    // Métodos
    // Constructor 1
    public Animal(){
        this.sexo = Sexo.MACHO;
    }

    // Constructor 2
    public Animal(Sexo s){
        this.sexo = s;
    }

    public Sexo getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Animal [sexo=" + sexo + "]";
    }
  
    public void duerme(){
        System.out.println("Zzzzz");
    }
}