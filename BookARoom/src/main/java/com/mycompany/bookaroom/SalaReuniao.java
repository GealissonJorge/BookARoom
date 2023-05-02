/*#################################################################################
#            Projeto com Responsabilidades - APS                                   #
#            Nome: Eike Stalei Vieira Neves                                        #
#            Nome: Gealisson Jorge da Silva Oliveira                               #
#            Nome: Marcus Felipe Magalhães Mendes                                  #
###################################################################################*/
package com.mycompany.bookaroom;

import java.util.ArrayList;


public class SalaReuniao {
    private int numero;
    private int capacidade;
    ArrayList<Reserva> reservas;
    public SalaReuniao(int numero,int capacidade)
    {
        reservas = new ArrayList<Reserva>();
        this.numero = numero;
        this.capacidade = capacidade;
    }
    
    public void addReserva(Reserva r)
    {
        reservas.add(r);
    }
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Sala: "+numero+", "+"capacidade: "+capacidade+"\n "+reservas+" ";
    }
    public String exibeSala() {
        return "Sala: "+numero+", "+"capacidade: "+capacidade+"\n ";
    }


}
