package ud.calchistory;

public class Calculadora {
    private double resultadoActual;
    private Caretaker caretaker;

    public Calculadora() {
        this.caretaker = new Caretaker();
        this.resultadoActual = 0;
    }

    public void sumar(double valor1, double valor2) {
        guardarEstado();
        resultadoActual = valor1 + valor2;  
    }

    public void restar(double valor1, double valor2) {
        guardarEstado();
        resultadoActual = valor1 - valor2;
    }

    public void multiplicar(double valor1, double valor2) {
        guardarEstado();
        resultadoActual = valor1 * valor2;
    }

    public void dividir(double valor1, double valor2) {
        if (valor2 != 0) {
            guardarEstado();
            resultadoActual = valor1 / valor2;
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