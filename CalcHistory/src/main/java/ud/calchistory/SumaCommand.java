/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud.calchistory;

/**
 *
 * @author USUARIO
 */
public class SumaCommand implements Command {
    
    private Calculadora calculadora;
    private double valor;

    public SumaCommand(Calculadora calculadora, double valor) {
        this.calculadora = calculadora;
        this.valor = valor;
    }

    @Override
    public void execute() {
        calculadora.sumar(valor);
    }
    
}
