/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungaro;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class Matriz {

    int linha;
    int coluna;
    int countLinhas;
    int countColunas;

    public int getCountLinhas() {
        return countLinhas;
    }

    public void setCountLinhas(int countLinhas) {
        this.countLinhas = countLinhas;
    }

    public int getCountColunas() {
        return countColunas;
    }

    public void setCountColunas(int countColunas) {
        this.countColunas = countColunas;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int[][] listar(int matriz[][]) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t ");
            }
            System.out.println();
        }
        return matriz;
    }

    public int[][] calcular(int matriz[][]) {
        System.out.println("-------linha-------");
        boolean aux = false;
        int menorValor = 0;
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz.length; j++) {
                //pega o primeiro elemento da linha e seta como menor valor
                if (aux == false) {
                    menorValor = matriz[i][j];
                    aux = true;
                } else if (matriz[i][j] < menorValor) {
                    menorValor = matriz[i][j];
                }
            }
            // for para subtrair linha
            for (int y = 0; y < matriz.length; y++) {
                matriz[i][y] -= menorValor;
                System.out.print(matriz[i][y] + "\t ");
                aux = false;
            }
            System.out.println();
        }
        System.out.println("------coluna-------");

        boolean aux2 = false;
        int menorValor2 = 0;
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz.length; j++) {
                //pega o primeiro elemento da linha e seta como menor valor
                if (aux2 == false) {
                    menorValor2 = matriz[j][i];
                    aux2 = true;
                } else if (matriz[j][i] < menorValor2) {
                    menorValor2 = matriz[j][i];
                }
            }
            // for para subtrair linha
            for (int y = 0; y < matriz.length; y++) {
                matriz[y][i] -= menorValor2;
                aux2 = false;
            }
        }

        return matriz;
    }

    public int[][] cobrirZeros(int matriz[][]) {
        ArrayList<Matriz> linhas = new ArrayList<Matriz>();
        ArrayList<Matriz> colunas = new ArrayList<Matriz>();
        ArrayList<Matriz> xyZero = new ArrayList<Matriz>();
        for (int i = 0; i < matriz.length; i++) {
            linhas = countLinha(matriz, i);
            for (int j = 0; j < matriz.length; j++) {

            }
        }
        return matriz;
    }

    public ArrayList<Matriz> countLinha(int matriz[][], int index) {
        ArrayList<Matriz> mat = new ArrayList<Matriz>();
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[index][i] == 0) {
                Matriz m = new Matriz();
                m.setLinha(i);
                m.setColuna(index);
                mat.add(m);
            }
        }
        return mat;
    }

    public ArrayList<Matriz> countColuna(int matriz[][], int index) {
        ArrayList<Matriz> mat = new ArrayList<Matriz>();
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][index] == 0) {
                Matriz m = new Matriz();
                m.setLinha(i);
                m.setColuna(index);
                mat.add(m);
            }
        }
        return mat;
    }

}
