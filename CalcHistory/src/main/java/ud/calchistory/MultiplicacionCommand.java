/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud.calchistory;

/**
 *
 * @author USUARIO
 */
public class MultiplicacionCommand implements Command{
    private Calculadora calculadora;
    private double valor1;
    private double valor2;

    public MultiplicacionCommand(Calculadora calculadora, double valor1, double valor2) {
        this.calculadora = calculadora;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    @Override
    public void execute() {
        calculadora.multiplicar(valor1, valor2);
    }
}
