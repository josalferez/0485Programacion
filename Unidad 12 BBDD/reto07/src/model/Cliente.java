package src.model;

public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String emailCliente;
    private int telefonoCliente;
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getEmailCliente() {
        return emailCliente;
    }
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    public int getTelefonoCliente() {
        return telefonoCliente;
    }
    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", emailCliente=" + emailCliente
                + ", telefonoCliente=" + telefonoCliente + "]";
    }
    public Cliente(int idCliente, String nombreCliente, String emailCliente, int telefonoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.emailCliente = emailCliente;
        this.telefonoCliente = telefonoCliente;
    }

    // constructor vacío para los updates
    public Cliente(){}

}
