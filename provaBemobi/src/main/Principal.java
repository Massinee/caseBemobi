package main;

import java.io.*;

public class Principal {

    //onde a primeira posição equivale quantos usuarios usaram o serviço e
    //a segunda posição equivale a usuarios ativos
    static int[] bra = new int[2]; //brasil
    static int[] ch = new int[2]; //chile
    static int[] mx = new int[2]; //méxico

    public static void main(String[] args) throws Exception {

        //escrever um arquivo
        FileOutputStream saidaResposta = new FileOutputStream("saidaResposta.txt");
        PrintWriter pr = new PrintWriter(saidaResposta);
        //ler um arquivo
        FileInputStream log = new FileInputStream("src/logBemobi.txt");
        InputStreamReader input = new InputStreamReader(log);
        BufferedReader br = new BufferedReader(input);

        String linha;

        do{
            linha = br.readLine(); //ler linha a linha do arquivo log

            if(linha != null){

                String[] codStatus = linha.split(" "); //separo para analisar as informações separadamente
                verificaCodigo(codStatus);
            }
        }while (linha != null);

        //imprimo os resultados num arquivo txt criado lá em cima
        pr.println("Brasil, " + bra[0] + ", " + bra[1]);
        pr.println("Chile, " + ch[0] + ", " + ch[1]);
        pr.println("México, " + mx[0] + ", " + mx[1]);

        pr.close();
        saidaResposta.close();
    }

    public static void verificaCodigo(String[] codStatus){

        String pais = "";
        String codigo = codStatus[0];
        //Como são os 2 primeiros digitos que indicam o país, separo eles dois
        String cod = Character.toString(codigo.charAt(0));
        cod+= Character.toString(codigo.charAt(1));

        switch(cod){
            case "55":

                bra[0]++;
                if(codStatus[1].equals("assinado")){
                    bra[1]++;
                }
                break;

            case "56":

                ch[0]++;
                if(codStatus[1].equals("assinado")){
                    ch[1]++;
                }
                break;

            case "52":

                mx[0]++;
                if(codStatus[1].equals("assinado")){
                    mx[1]++;
                }
                break;
        }
    }
}
