/*#################################################################################
#            Projeto com Responsabilidades - APS                                   #
#            Nome: Eike Stalei Vieira Neves                                        #
#            Nome: Gealisson Jorge da Silva Oliveira                               #
#            Nome: Marcus Felipe Magalhães Mendes                                  #
###################################################################################*/
package com.mycompany.bookaroom;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InterfaceUsuario {
    private int escolha;
    Scanner ler = new Scanner(System.in);
    Campus campus = new Campus("montes claros");
    SalaGeral salag = new  SalaGeral();
    ArrayList<SalaReuniao> salaslivres = new ArrayList<SalaReuniao>();
    ArrayList<SalaReuniao> salas= new ArrayList<SalaReuniao>();
    ArrayList<SalaReuniao> salasMes= new ArrayList<SalaReuniao>();
    ArrayList<Equipamentos> listaEquipamentos= new ArrayList<Equipamentos>();
    Equipamentos equi1 = new Equipamentos("SmartTV", "desc patrimonio 1");
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 


    public void fazInterface(int escolha) throws ParseException
    {

        if(escolha==1){
            int a=1,numFuncionario,numSala,horaInicio,horaFim,numEquipamento,desejaEquipamento;
            String assunto;
            String dataReserva;
            Date dataReservaDate;
            ArrayList<Equipamentos> equipamentoReservado = new ArrayList<Equipamentos>();

            System.out.println("digite o numero do funcionario: ");
            numFuncionario = ler.nextInt();
            System.out.println("digite numero da sala: ");
            numSala = ler.nextInt();
            System.out.println("digite data no formato: dd/mm/aaaa");
            dataReserva = ler.next();
            dataReservaDate = formato.parse(dataReserva);
            System.out.println("digite hora inicio da reserva: ");
            horaInicio = ler.nextInt();
            System.out.println("digite hora final da reserva: ");
            horaFim = ler.nextInt();
            System.out.println("digite assunto da reserva:");
            assunto = ler.next();
            if(campus.funcionarios.get(0).checaDisponibilidade(dataReservaDate,horaInicio,horaFim,salag,assunto,numSala))
            {
                System.out.println("Horario disponivel");
                System.out.println("Deseja adicionar equipamento?\n 1 para sim 0 para nao:");
                desejaEquipamento = ler.nextInt();

                if(desejaEquipamento==1)
                {
                    System.out.println("equipamentos:");
                    for(int i=0;i<listaEquipamentos.size();i++){
                    System.out.println(a++ +") "+listaEquipamentos.get(i));
                    }
                do{
                    System.out.println("digite o numero do equipamento que deseja adicionar:");
                        numEquipamento = ler.nextInt();
                        equipamentoReservado.add(listaEquipamentos.get(numEquipamento-1));
                        System.out.println("Deseja adicionar mais um equipamento? \nSe sim digite 1 se nao digite 0: ");
                        desejaEquipamento = ler.nextInt(); 
                }while(desejaEquipamento!=0);
                }
                    campus.funcionarios.get(numFuncionario-1).FazReserva(salaslivres.get(numSala-1), salag, dataReservaDate, 
                    horaInicio, horaFim, assunto, equipamentoReservado,campus.funcionarios.get(numFuncionario-1).getNome());
                    System.out.println("Reserva concluida");
                    
            }
            else{
                System.out.println("horario indisponivel");
            }
        }
        if(escolha==2||escolha==3){
                int periodo;
                Date dataEscolha;
                String checarPeriodo;
                System.out.println("Exibir sala ocupada por dia(1) ou mes(2)");
                periodo = ler.nextInt();    
                if(periodo==1)
                {
                    System.out.println("digite o dia no formato: dd/mm/aaaa");
                    checarPeriodo = ler.next();
                    
                    dataEscolha = formato.parse(checarPeriodo);
                        
                        for (Funcionario f : campus.funcionarios) {
                            salas =f.Ocupacao(dataEscolha,salag);  //seleciona a data por dia
                        }
                        System.out.println(salas);
                }
             /*    else if(periodo==2)
                {
                System.out.println("digite a semana: ");
                checarPeriodo = ler.next();
                }*/
                else if(periodo==2)
                {
                System.out.println("digite o mes no formato: dd/mm/aaaa");
                checarPeriodo = ler.next();
                dataEscolha = formato.parse(checarPeriodo);
            
                for (Funcionario f : campus.funcionarios) {
                    salasMes =f.OcupacaoMes(dataEscolha,salag);
                }
                System.out.println(salasMes);//ocupacao com base no mes  
            }
                else
                System.out.println("opcao invalida.");
        }
        
        if(escolha==4){
            String nomeEquipamento,patrimonioEquipamento;
            System.out.println("digite nome do equipamento:");
            nomeEquipamento = ler.next();
            System.out.println("digite patrimonio:");
            patrimonioEquipamento = ler.next();
            Equipamentos novoequi = new Equipamentos(nomeEquipamento,patrimonioEquipamento);
            listaEquipamentos.add(novoequi);
            System.out.println("equipamento add");

        }
        if(escolha==5){

            System.out.println("----------------------------------Funcionarios----------------------------------");
                System.out.println(campus.funcionarios);
        }
        if(escolha==6){
            String nomeFuncionario,cargoFuncionario,cidadeFuncionario;
            int ramalFuncionario;
            System.out.println("digite nome do funcionario:");
            nomeFuncionario = ler.next();
            System.out.println("digite cargo do funcionario:");
            cargoFuncionario = ler.next();
            System.out.println("digite ramal do funcionario:");
            ramalFuncionario = ler.nextInt();
            System.out.println("digite cidade do funcionario:");
            cidadeFuncionario = ler.next();
            campus.criaFuncionario(nomeFuncionario, cargoFuncionario, cidadeFuncionario, ramalFuncionario);
            System.out.println("Funcionario adicionado");
        }
        if(escolha==7){
            System.out.println("----------------------------------Reservas----------------------------------");
            for (SalaReuniao s : salag.salas) {
                System.out.println(s);
                for (Reserva rv : s.reservas) {
                    System.out.println(rv.equipamentos);
                }
            }

        }
        if(escolha==8){
            int numeroSala,capacidadeSala,numPredio;
            System.out.println("digite numero da sala:");
            numeroSala = ler.nextInt();
            System.out.println("digite capacidade da sala:");
            capacidadeSala = ler.nextInt();
            System.out.println("digite numero do predio:");
            System.out.println(campus.predios);
            numPredio = ler.nextInt();
            SalaReuniao sala6 = new SalaReuniao(numeroSala,capacidadeSala);
            salag=campus.predios.get(numPredio-1).CriarSala(salag, sala6);
            System.out.println("sala adicionada");
        }
        if(escolha==9){
            int a=1;
            System.out.println("----------------------------------Equipamentos----------------------------------");
            for(int i=0;i<listaEquipamentos.size();i++){
                System.out.println(a++ +") "+listaEquipamentos.get(i));
            }
 
 
        }
        if(escolha==10){
            System.out.println("----------------------------------Predios----------------------------------");
            System.out.println(campus.predios);
        }
        if(escolha==11){
            System.out.println("----------------------------------Salas----------------------------------");
            for (SalaReuniao s : salag.salas) 
                System.out.println(s.exibeSala());
        }
        if(escolha==12){
            String nome;
            System.out.println("digite nome do predio:");
            nome=ler.next();
            campus.criaPredio(nome);
            System.out.println("predio adicionado");
        }
    }

    public void carregaDados() throws ParseException{ //essa função apenas inicializa os dados para facilitar os testes
        campus.criaEndereco("rua 1", 1, "montes claros", "mg", "39402000");
        //instancia predios
        campus.criaPredio("1");
        campus.criaPredio("2");
        //instancia salas
        SalaReuniao sala1 = new SalaReuniao(1,40);
        SalaReuniao sala2 = new SalaReuniao(2,30);
        SalaReuniao sala3 = new SalaReuniao(3,40);
        SalaReuniao sala4 = new SalaReuniao(4,30);
        SalaReuniao sala5 = new SalaReuniao(5,40);
        Equipamentos equi1 = new Equipamentos("SmartTV", "desc patrimonio 1");
        Equipamentos equi2 = new Equipamentos("Notebook", "desc patrimonio 2");
        listaEquipamentos.add(equi1);
        listaEquipamentos.add(equi2);
        //determina predios com salas
        salag=campus.predios.get(0).CriarSala(salag, sala1);
        salag=campus.predios.get(0).CriarSala(salag, sala2);
        salag=campus.predios.get(1).CriarSala(salag, sala3);
        salag=campus.predios.get(1).CriarSala(salag, sala4);
        salag=campus.predios.get(1).CriarSala(salag, sala5);
        //adicao de funcianarios
        campus.criaFuncionario("Fulano", "professor", "Montes Claros", 1);
        campus.criaFuncionario("Siclano", "professor", "Montes Claros", 2);
        campus.criaFuncionario("Fulano 2", "professor", "Montes Claros", 3);
        campus.criaFuncionario("Siclano 2", "professor", "Montes Claros", 4);
        //definicao de datas base
        Date data = formato.parse("13/11/2023");
        Date data1 = formato.parse("25/01/2023");
        Date data2 = formato.parse("23/05/2023");
        Date data3 = formato.parse("23/02/2023");
        Date data4 = formato.parse("14/12/2023");
        Date data5 = formato.parse("02/01/2021");
        for(Funcionario f: campus.funcionarios){ 
            salaslivres=f.SelecionaSalas(data, 10,11, salag);
        }
        //adicao das reservas em salas especificas (index)
        campus.funcionarios.get(1).FazReserva(salaslivres.get(0), salag, data, 13, 14, "aula", listaEquipamentos,campus.funcionarios.get(1).getNome());
        campus.funcionarios.get(2).FazReserva(salaslivres.get(1), salag, data2, 15, 16, "reuniao",listaEquipamentos,campus.funcionarios.get(2).getNome());
        campus.funcionarios.get(3).FazReserva(salaslivres.get(2), salag, data3, 10, 11, "reuniao",listaEquipamentos,campus.funcionarios.get(3).getNome());
        campus.funcionarios.get(0).FazReserva(salaslivres.get(3), salag, data4, 9, 10, "aula",listaEquipamentos,campus.funcionarios.get(0).getNome());
        campus.funcionarios.get(1).FazReserva(salaslivres.get(4), salag, data5, 8, 9, "reuniao", listaEquipamentos,campus.funcionarios.get(1).getNome());
        campus.funcionarios.get(2).FazReserva(salaslivres.get(0), salag, data1, 11, 13, "aula",listaEquipamentos,campus.funcionarios.get(2).getNome());
        campus.funcionarios.get(3).FazReserva(salaslivres.get(1), salag, data1, 11, 13, "aula",listaEquipamentos,campus.funcionarios.get(3).getNome());
    }
    
    public int getEscolha() {
        return escolha;
    }

    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }

    @Override
    public String toString() {
        return "Escolha:"+escolha;
    }
    
}
