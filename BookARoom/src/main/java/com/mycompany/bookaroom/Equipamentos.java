/*#################################################################################
#            Projeto com Responsabilidades - APS                                   #
#            Nome: Eike Stalei Vieira Neves                                        #
#            Nome: Gealisson Jorge da Silva Oliveira                               #
#            Nome: Marcus Felipe Magalhães Mendes                                  #
###################################################################################*/
package com.mycompany.bookaroom;

public class Equipamentos {
    private String nome;
    private String patrimonio;

    public Equipamentos(String nome, String patrimonio) {
        this.nome = nome;
        this.patrimonio = patrimonio;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    @Override
    public String toString() {
        
        return "Equipamento: " +" "+nome+" "+patrimonio +" \n";
    }
    
}
