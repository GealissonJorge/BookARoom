/*#################################################################################
#            Projeto com Responsabilidades - APS                                   #
#            Nome: Eike Stalei Vieira Neves                                        #
#            Nome: Gealisson Jorge da Silva Oliveira                               #
#            Nome: Marcus Felipe Magalhães Mendes                                  #
###################################################################################*/
package com.mycompany.bookaroom;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


public class Funcionario {
    private String nome;
    private String cargo;
    private String cidade;
    private int ramal;


    public Funcionario(String nome, String cargo, String cidade, int ramal) {
        this.nome = nome;
        this.cargo = cargo;
        this.cidade = cidade;
        this.ramal = ramal;
    }
    
    public ArrayList<SalaReuniao> SelecionaSalas(Date data,int inicio,int fim,SalaGeral salasgeral)
    {
        ArrayList<SalaReuniao> salaslivres = new ArrayList<SalaReuniao>();
        
        salaslivres = salasgeral.SelecionaSalas(data,inicio,fim);
        
        return salaslivres;
    }

    public SalaGeral FazReserva(SalaReuniao sala,SalaGeral salageral,Date data,int inicio,int fim,String assunto, ArrayList<Equipamentos> equipamentos
    ,String nomeF)
    {
        Reserva reserva = new Reserva(data,inicio,fim,assunto,true,nomeF); //cria uma reserva ativa
        reserva.AddEquipamento(equipamentos);
        sala.addReserva(reserva);
        
        for(SalaReuniao s : salageral.salas)
        {
            if(sala.getNumero() == s.getNumero())
            {
                s = sala;
            }
        }
        return salageral;
    }
    public ArrayList<SalaReuniao> Ocupacao(Date dia,SalaGeral salageral)
    {
        ArrayList<SalaReuniao> salas = new ArrayList<SalaReuniao>();
        
        //pega o dia
        LocalDate localdate = dia.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int day   = localdate.getDayOfMonth();
        
        
        for(SalaReuniao sala : salageral.salas)
        {
            for(Reserva reserva : sala.reservas)
            {
                LocalDate ld = reserva.getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int d = ld.getDayOfMonth();
                if(day == d)
                {
                    salas.add(sala);
                    break;
                }
            } 
        }
        
        return salas;
    }

    public boolean checaDisponibilidade(Date dia,int inicio,int fim,SalaGeral salageral,String assunto,int numSala)//retorna true se horario disponivel
    {
        int i=0;
        boolean estaDisponivel=true;
                        
        for(i=0; i < salageral.salas.get(numSala-1).reservas.size(); i++)
        {

            if(dia.equals(salageral.salas.get(numSala-1).reservas.get(i).getData()) && 
            (inicio<salageral.salas.get(numSala-1).reservas.get(i).getHorainicio()&& // intervalos possiveis de horario nao concorrente com o que se deseja adicionar
            fim<=salageral.salas.get(numSala-1).reservas.get(i).getHorainicio()) || 
            (inicio>=salageral.salas.get(numSala-1).reservas.get(i).getHoraFim() &&
            fim>salageral.salas.get(numSala-1).reservas.get(i).getHoraFim())            
            || assunto.equals("aula") && dia.equals(salageral.salas.get(numSala-1).reservas.get(i).getData()))
            {
                
                if(!salageral.salas.get(numSala-1).reservas.get(i).getAssunto().equals("aula")&&
                !salageral.salas.get(numSala-1).reservas.get(i).getAssunto().equals("") && 
                (inicio<salageral.salas.get(numSala-1).reservas.get(i).getHorainicio()&& // horarios que estejam no mesmo intervalo de uma aula que vai ser adicionada em cima de uma reuniao
                fim>salageral.salas.get(numSala-1).reservas.get(i).getHorainicio()) || 
                (inicio<salageral.salas.get(numSala-1).reservas.get(i).getHoraFim() &&
                fim>salageral.salas.get(numSala-1).reservas.get(i).getHoraFim()) ||
                (inicio==salageral.salas.get(numSala-1).reservas.get(i).getHorainicio() &&
                fim==salageral.salas.get(numSala-1).reservas.get(i).getHoraFim()
                ))
                {
                    System.out.println("Choque de horario mas aula tem prioridade.");
                    salageral.salas.get(numSala-1).reservas.get(i).setSituacao(false);
                    
                    estaDisponivel= true;
                    return estaDisponivel;
                }else if(salageral.salas.get(numSala-1).reservas.get(i).getAssunto().equals( "aula")){
                    System.out.println("Horario indisponivel, uma aula ja agendada para esse horario!");
                    estaDisponivel=false;// tentar adicionar aula em aula não pode
                    return estaDisponivel;
                }
                estaDisponivel = true;
            }
            else if(dia.equals(salageral.salas.get(numSala-1).reservas.get(i).getData())){
            estaDisponivel=false;
            return estaDisponivel;
            }
        } 
        return estaDisponivel;
    }

    public ArrayList<SalaReuniao> OcupacaoMes(Date mes,SalaGeral salageral)
    {
        ArrayList<SalaReuniao> salas = new ArrayList<SalaReuniao>();
        
        //pega o dia
        LocalDate localdate = mes.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month   = localdate.getMonthValue();
        
        
        for(SalaReuniao sala : salageral.salas)
        {
            for(Reserva reserva : sala.reservas)
            {
                LocalDate ld = reserva.getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int m = ld.getMonthValue();
                
                if(month == m)
                {
                    salas.add(sala);
                    break;
                }
              
            } 
        }
        return salas;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    @Override
    public String toString() {
        return "Funcionario: "+nome+" , cargo:"+cargo+" , cidade:"+cidade+" , ramal:"+ramal+"\n";
    }
    
}
