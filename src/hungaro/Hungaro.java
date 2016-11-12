/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungaro;

/**
 *
 * @author Guilherme
 */
public class Hungaro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matriz[][] = {{15, 10, 9}, {9, 15, 10}, {10, 12, 8}};
        int mat[][] = matriz;
        // mostra matriz original
        Matriz m = new Matriz();
        System.out.println("--Matriz-original--");
        m.listar(mat);
        m.calcular(mat);
        m.listar(mat);
        m.cobrirZeros(mat);

    }
}
