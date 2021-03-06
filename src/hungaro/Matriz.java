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

    public static int[][] listar(int matriz[][]) {
        System.out.println("--------------------------");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t ");
            }
            System.out.println();
        }
        return matriz;
    }

    public static int[][] subtrairLinhaColuna(int matriz[][]) {
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

    public static ArrayList<Matriz> getZeros(int matriz[][]) {
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

    public static boolean verificaSolucao(int matriz[][]) {
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

    public static ArrayList<Matriz> calcula(ArrayList<Matriz> list, int matriz[][]) {
        ArrayList<Matriz> zeros = new ArrayList<Matriz>();
        zeros.addAll(list);
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
            //adiciona todos zeros na lista

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

                list = getZeros(matrizCoberta(matrizAux));
                zeros.addAll(list);
                if (list.size() == 0) {
                    aux = false;

                }
            }
            // for p/ listar a matriz
            if (aux) {
                System.out.println("-------------------------");
                for (int i = 0; i < matrizAux.length; i++) {
                    for (int j = 0; j < matrizAux.length; j++) {
                        System.out.print(matrizAux[i][j] + "\t ");
                    }
                    System.out.println();
                }
            }
        }

        return zeros;
    }

    public static int getMenorValorMatriz(int matriz[][]) {
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

    public static int[][] matrizCoberta(int matriz[][]) {
        //verifica se o numero de cobrimentos é igual a ordem da matriz Ex: matriz 4x4(ordem 4) 
        boolean matrizCoberta = true;
        matrizCoberta = verificaSolucao(matriz);

        if (matrizCoberta == false) {
            int menorValor = getMenorValorMatriz(matriz);

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[i][j] != -1) {
                        matriz[i][j] = matriz[i][j] - menorValor;
                    }
                }
            }
            //listar(matriz);
        }
        return matriz;
    }

    public static void getSolucao(ArrayList<Matriz> zeros, int[][] matriz) {
        int coluna0 = 0, coluna1 = 0, coluna2 = 0, coluna3 = 0;
        boolean aux0 = false;
        boolean aux1 = false;
        boolean aux2 = false;
        boolean aux3 = false;
        for (Matriz zero : zeros) {
            if (zero.getColuna() == 0) {
                if (aux0 == false) {
                    coluna0 = matriz[zero.getLinha()][zero.getColuna()];
                    aux0 = true;
                } else if (matriz[zero.getLinha()][zero.getColuna()] < coluna0) {
                    coluna0 = matriz[zero.getLinha()][zero.getColuna()];
                }
            } else if (zero.getColuna() == 1) {
                if (aux1 == false) {
                    coluna1 = matriz[zero.getLinha()][zero.getColuna()];
                    aux1 = true;
                } else if (matriz[zero.getLinha()][zero.getColuna()] < coluna1) {
                    coluna1 = matriz[zero.getLinha()][zero.getColuna()];
                }
            } else if (zero.getColuna() == 2) {
                if (aux2 == false) {
                    coluna2 = matriz[zero.getLinha()][zero.getColuna()];
                    aux2 = true;
                } else if (matriz[zero.getLinha()][zero.getColuna()] < coluna2) {
                    coluna2 = matriz[zero.getLinha()][zero.getColuna()];
                }
            } else if (zero.getColuna() == 3) {
                if (aux3 == false) {
                    coluna3 = matriz[zero.getLinha()][zero.getColuna()];
                    aux3 = true;
                } else if (matriz[zero.getLinha()][zero.getColuna()] < coluna3) {
                    coluna3 = matriz[zero.getLinha()][zero.getColuna()];
                }
            }
        }
        int solucao = coluna0 + coluna1 + coluna2 + coluna3;
        System.out.println("Solução: "+coluna0+" + "+coluna1+" + "+coluna2+" + "+coluna3+" = "+solucao);
    }

}
