package ud.calchistory;

public class Memento {
    private final double estado;
    private final String descripcionOperacion;

    public Memento(double estado, String descripcionOperacion) {
        this.estado = estado;
        this.descripcionOperacion = descripcionOperacion;
    }

    public double getEstado() {
        return estado;
    }

    public String getDescripcionOperacion() {
        return descripcionOperacion;
    }

    //public Memento guardarEstado() {
    //return new Memento(resultadoActual, "Descripción o tipo de operación");
    // }

    //public void restaurarEstado(Memento memento) {
    //this.resultadoActual = memento.getEstado();

    //La clase calculadora debe tener estos metodos, si es necesario cambiarlos quien soy yo?
    //}
    
}
