public class Articulo {
    long codigo;
    String Descripcion;
    double precioCompra;
    double precioVenta;
    int stock;

    public Articulo(String Descripcion, long codigo, double precioCompra, double precioVenta, int stock) {
        this.Descripcion = Descripcion;
        this.codigo = codigo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {return  "\n╔══════════════════════════════════════════╗" +
            "\n║            DETALLE DEL ARTÍCULO          ║" +
            "\n╠══════════════════════════════════════════╣" +
            "\n  > Código:      " + codigo +
            "\n  > Descripción: " + Descripcion +
            "\n  > P. Compra:   " + precioCompra + " euros" +
            "\n  > P. Venta:    " + precioVenta + " euros" +
            "\n  > Stock:       " + stock + " unidades" +
            "\n╚══════════════════════════════════════════╝";
    }


}
