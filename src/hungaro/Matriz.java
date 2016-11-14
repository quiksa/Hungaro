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

    public ArrayList<Matriz> getZeros(int matriz[][]) {
        ArrayList<Matriz> zeros = new ArrayList<Matriz>();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 0) {
                    Matriz m = new Matriz();
                    m.setLinha(i);
                    m.setColuna(j);
                    zeros.add(m);
                }
            }
        }
        return zeros;
    }

    public void calcula(ArrayList<Matriz> list) {
        int linha0 = 0;
        int linha1 = 0;
        int linha2 = 0;
        int linha3 = 0;
        int coluna0 = 0;
        int coluna1 = 0;
        int coluna2 = 0;
        int coluna3 = 0;
        for (Matriz pontos : list) {
            if (pontos.getLinha() == 0) {
                linha0++;
            } else if (pontos.getLinha() == 1) {
                linha1++;
            } else if (pontos.getLinha() == 2) {
                linha2++;
            } else if (pontos.getLinha() == 3) {
                linha3++;
            }

            if (pontos.getColuna() == 0) {
                coluna0++;
            } else if (pontos.getColuna() == 1) {
                coluna1++;
            } else if (pontos.getColuna() == 2) {
                coluna2++;
            } else if (pontos.getColuna() == 3) {
                coluna3++;
            }
        }
    }
}
