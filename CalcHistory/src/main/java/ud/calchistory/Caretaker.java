package ud.calchistory;

import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> pilaUndo = new Stack<>();
    private final Stack<Memento> pilaRedo = new Stack<>();

    public void guardarEstado(Memento memento) {
        pilaUndo.push(memento);
        pilaRedo.clear(); // Al guardar un nuevo estado, se borra el historial de rehacer
    }

    public Memento deshacer() {
        if (!pilaUndo.isEmpty()) {
            Memento ultimo = pilaUndo.pop();
            pilaRedo.push(ultimo);
            return ultimo;
        }
        return null;
    }

    public Memento rehacer() {
        if (!pilaRedo.isEmpty()) {
            Memento memento = pilaRedo.pop();
            pilaUndo.push(memento);
            return memento;
        }
        return null;
    }

    public boolean puedeDeshacer() {
        return !pilaUndo.isEmpty();
    }

    public boolean puedeRehacer() {
        return !pilaRedo.isEmpty();
    }
}
