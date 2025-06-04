package ud.calchistory;

public class Calculadora {
    private double resultadoActual;
    private Caretaker caretaker;

    public Calculadora() {
        this.caretaker = new Caretaker();
        this.resultadoActual = 0;
    }

    public void sumar(double valor) {
        guardarEstado();
        resultadoActual += valor;
    }

    public void restar(double valor) {
        guardarEstado();
        resultadoActual -= valor;
    }

    public void multiplicar(double valor) {
        guardarEstado();
        resultadoActual *= valor;
    }

    public void dividir(double valor) {
        if (valor != 0) {
            guardarEstado();
            resultadoActual /= valor;
        } else {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
    }

    public double getResultadoActual() {
        return resultadoActual;
    }
    
    public Memento guardarEstado() {
        return new Memento(resultadoActual, "Estado guardado");
    }


    public void deshacer() {
        Memento memento = caretaker.deshacer();
        if (memento != null) {
            resultadoActual = memento.getEstado();
        }
    }

    public void rehacer() {
        Memento memento = caretaker.rehacer();
        if (memento != null) {
            resultadoActual = memento.getEstado();
        }
    }

    public boolean puedeDeshacer() {
        return caretaker.puedeDeshacer();
    }

    public boolean puedeRehacer() {
        return caretaker.puedeRehacer();
    }

    public double getEstado() {
        return resultadoActual;
    }

    public void restaurarEstado(Memento memento) {
        this.resultadoActual = memento.getEstado();
    }
}