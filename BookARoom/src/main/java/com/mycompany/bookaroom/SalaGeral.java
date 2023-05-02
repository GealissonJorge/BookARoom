/*#################################################################################
#            Projeto com Responsabilidades - APS                                   #
#            Nome: Eike Stalei Vieira Neves                                        #
#            Nome: Gealisson Jorge da Silva Oliveira                               #
#            Nome: Marcus Felipe Magalhães Mendes                                  #
###################################################################################*/
package com.mycompany.bookaroom;

import java.util.ArrayList;
import java.util.Date;

public class SalaGeral {
    
    ArrayList<SalaReuniao> salas;
    
    public SalaGeral(){
        salas = new ArrayList<SalaReuniao>();
    }
    
    public void AddSala(SalaReuniao sala)
    {
        salas.add(sala);
    }

    ArrayList<SalaReuniao> SelecionaSalas(Date data, int inicio, int fim) {//seleciona salas com base na disponibilidade
         
        ArrayList<SalaReuniao> salaslivres = new ArrayList<SalaReuniao>();
       for(SalaReuniao sala : salas)
       {
           boolean livre = true;
           for(Reserva r : sala.reservas)
           {
               
               if(r.getData() == data && ((fim < r.getHorainicio() || inicio > r.getHoraFim())))
               {
                   livre = false;
                   break;
               }
           }
           if(livre)salaslivres.add(sala);
       }
        
        return salaslivres;
    }

    @Override
    public String toString() {
        return salas.toString();
    }
    
}
