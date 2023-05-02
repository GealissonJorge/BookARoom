/*#################################################################################
#            Projeto com Responsabilidades - APS                                   #
#            Nome: Eike Stalei Vieira Neves                                        #
#            Nome: Gealisson Jorge da Silva Oliveira                               #
#            Nome: Marcus Felipe Magalhães Mendes                                  #
###################################################################################*/
package com.mycompany.bookaroom;

public class Predio {
    private String nome;
    
    public Predio(String nome) {
        this.nome = nome;
    }
    public SalaGeral CriarSala(SalaGeral salageral,SalaReuniao sala)
    {
        salageral.AddSala(sala);
        return salageral;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Predio:"+nome;
    }
    
}
