/*#################################################################################
#            Projeto com Responsabilidades - APS         #
#            Nome: Eike Stalei Vieira Neves                                        #
#            Nome: Gealisson Jorge da Silva Oliveira                               #
#            Nome: Marcus Felipe Magalhães Mendes                                            #
###################################################################################*/
package com.mycompany.bookaroom;
import java.util.ArrayList;
public class Campus {
    private String nome;
    ArrayList<Endereco> enderecos=new ArrayList<Endereco>();;
    ArrayList<Funcionario> funcionarios= new ArrayList<Funcionario>();;
    ArrayList<Predio> predios = new ArrayList<Predio>();;
    public Campus(String nome)
    {
        this.nome = nome;
    }
    public void criaPredio(String nome){
        Predio predio = new Predio(nome);
        predios.add(predio);
    }
    public void criaFuncionario(String nome, String cargo, String cidade, int ramal){
        Funcionario funcionario= new Funcionario(nome,cargo,cidade,ramal);
        funcionarios.add(funcionario);
    }

    @Override
    public String toString() {
        return "Campus:"+nome+"\n"; 
    }
    public void criaEndereco(String rua, int numero, String cidade, String estado, String cep){
        Endereco endereco = new Endereco(rua,numero,cidade, estado,cep);
        enderecos.add(endereco);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    
}
