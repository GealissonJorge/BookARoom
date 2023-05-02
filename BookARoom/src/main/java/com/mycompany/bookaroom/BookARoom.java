/*#################################################################################
#            Projeto com Responsabilidades - APS                                   #
#            Nome: Eike Stalei Vieira Neves                                        #
#            Nome: Gealisson Jorge da Silva Oliveira                               #
#            Nome: Marcus Felipe Magalhães Mendes                                  #
###################################################################################*/
package com.mycompany.bookaroom;
import java.util.Scanner;
import java.text.ParseException;

public class BookARoom {
    public static void main(String[] args) throws ParseException {
        
        InterfaceUsuario console = new InterfaceUsuario();
        int escolha=0;
        Scanner ler = new Scanner(System.in);
        console.carregaDados();//inicializa dados para teste

        do{
            System.out.println("Digite opcao: ");
            System.out.println("1 - fazer reserva");
            System.out.println("2 - exibir salas livres");
            System.out.println("3 - exibir salas ocupadas");
            System.out.println("4 - cadastrar equipamento");
            System.out.println("5 - informações sobre funcionarios");
            System.out.println("6 - adicionar novo funcionario");
            System.out.println("7 - listar todas as reservas");
            System.out.println("8 - adicionar sala");
            System.out.println("9 - listar todos os equipamentos");
            System.out.println("10 - listar predios");
            System.out.println("11 - listar salas");
            System.out.println("12 - adicionar predio");
            System.out.println("0 - encerrar");
            
            escolha = ler.nextInt();

            if(escolha!=0)
            console.fazInterface(escolha);

        }while(escolha!=0);
        ler.close();
    }
}
