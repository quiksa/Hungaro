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
        System.out.println("--------------------------");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t ");
            }
            System.out.println();
        }
        return matriz;
    }

    public int[][] subtrairLinhaColuna(int matriz[][]) {
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

    public boolean verificaSolucao(int matriz[][]) {
        int valorMatriz = matriz.length * matriz.length;
        int contador = 0;
        boolean teste = true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == -1) {
                    contador++;
                }
            }
        }

        if (contador < 13) {
            teste = false;
        }
        return teste;
    }

    public void calcula(ArrayList<Matriz> list, int matriz[][]) {
        ArrayList<Matriz> zeros = new ArrayList<Matriz>();
        int matrizAux[][] = null;
        matrizAux = matriz;
        boolean aux = true;
        while (aux) {

            int linha0 = 0, linha1 = 0, linha2 = 0, linha3 = 0;
            int coluna0 = 0, coluna1 = 0, coluna2 = 0, coluna3 = 0;

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

            int maiorlinha = 0;
            String stMaiorLinha = null;
            if (linha0 >= linha1 && linha0 >= linha2 && linha0 >= linha3) {
                maiorlinha = linha0;
                stMaiorLinha = "Linha 0";
            } else if (linha1 >= linha0 && linha1 >= linha2 && linha1 >= linha3) {
                maiorlinha = linha1;
                stMaiorLinha = "Linha 1";
            } else if (linha2 >= linha0 && linha2 >= linha1 && linha2 >= linha3) {
                maiorlinha = linha2;
                stMaiorLinha = "Linha 2";
            } else if (linha3 >= linha0 && linha3 >= linha2) {
                maiorlinha = linha3;
                stMaiorLinha = "Linha 3";
            }

            int maiorColuna = 0;
            String stMaiorColuna = null;
            if (coluna0 >= coluna1 && coluna0 >= coluna2 && coluna0 >= coluna3) {
                maiorColuna = coluna0;
                stMaiorColuna = "Coluna 0";
            } else if (coluna1 >= coluna0 && coluna1 >= coluna2 && coluna1 >= coluna3) {
                maiorColuna = coluna1;
                stMaiorColuna = "Coluna 1";
            } else if (coluna2 >= coluna0 && coluna2 >= coluna1 && coluna2 >= coluna3) {
                maiorColuna = coluna2;
                stMaiorColuna = "Coluna 2";
            } else if (coluna3 >= coluna0 && coluna3 >= coluna1 && coluna3 >= coluna2) {
                maiorColuna = coluna3;
                stMaiorColuna = "Coluna 3";
            }

//            System.out.println(maiorlinha);
//            System.out.println(maiorColuna);
            for (int i = 0; i < matrizAux.length; i++) {
                if (maiorlinha >= maiorColuna) {

                    if (stMaiorLinha.equalsIgnoreCase("Linha 0")) {
                        matrizAux[0][i] = -1;
                    } else if (stMaiorLinha.equalsIgnoreCase("Linha 1")) {
                        matrizAux[1][i] = -1;
                    } else if (stMaiorLinha.equalsIgnoreCase("Linha 2")) {
                        matrizAux[2][i] = -1;
                    } else if (stMaiorLinha.equalsIgnoreCase("Linha 3")) {
                        matrizAux[3][i] = -1;
                    }
                } else if (stMaiorColuna.equalsIgnoreCase("Coluna 0")) {
                    matrizAux[i][0] = -1;
                } else if (stMaiorColuna.equalsIgnoreCase("Coluna 1")) {
                    matrizAux[i][1] = -1;
                } else if (stMaiorColuna.equalsIgnoreCase("Coluna 2")) {
                    matrizAux[i][2] = -1;
                } else if (stMaiorColuna.equalsIgnoreCase("Coluna 3")) {
                    matrizAux[i][3] = -1;
                }
            }
            //verifica se existe zeros na matriz
            list = getZeros(matrizAux);
            if (list.size() == 0) {
                //for p/ listar a matriz coberta
                System.out.println("--------------------------");
                for (int i = 0; i < matrizAux.length; i++) {
                    for (int j = 0; j < matrizAux.length; j++) {
                        System.out.print(matrizAux[i][j] + "\t ");
                    }
                    System.out.println();
                }

                aux = false;
            }
            // for p/ listar a matriz
            if (aux) {
                System.out.println("--------------------------");
                for (int i = 0; i < matrizAux.length; i++) {
                    for (int j = 0; j < matrizAux.length; j++) {
                        System.out.print(matrizAux[i][j] + "\t ");
                    }
                    System.out.println();
                }
            }
        }
        boolean matrizCoberta = verificaSolucao(matrizAux);

        if (matrizCoberta == false) {
            int menorValor = getMenorValorMatriz(matrizAux);

            for (int i = 0; i < matrizAux.length; i++) {
                for (int j = 0; j < matrizAux.length; j++) {
                    if (matrizAux[i][j] != -1) {
                        matrizAux[i][j] = matrizAux[i][j] - menorValor;
                    }
                }
            }
            listar(matrizAux);
        }

    }

    public int getMenorValorMatriz(int matriz[][]) {
        int menorValor = 0;
        boolean aux = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (aux == false && matriz[i][j] != -1) {
                    menorValor = matriz[i][j];
                    aux = true;
                } else if (matriz[i][j] < menorValor && matriz[i][j] != -1) {
                    menorValor = matriz[i][j];
                }
            }
        }
        return menorValor;
    }
}
