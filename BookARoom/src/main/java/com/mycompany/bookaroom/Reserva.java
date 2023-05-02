/*#################################################################################
#            Projeto com Responsabilidades - APS                                   #
#            Nome: Eike Stalei Vieira Neves                                        #
#            Nome: Gealisson Jorge da Silva Oliveira                               #
#            Nome: Marcus Felipe Magalhães Mendes                                  #
###################################################################################*/
package com.mycompany.bookaroom;
import java.util.ArrayList;
import java.util.Date;
public class Reserva {
    private Date data;
    private int horainicio;
    private int horaFim;
    private String assunto;
    private boolean situacao;
    private String nomeFuncionario;
    public 
    ArrayList<ArrayList<Equipamentos>> equipamentos =new ArrayList<ArrayList<Equipamentos>>();
    
    public Reserva(Date data,int inicio,int fim,String assunto, boolean situacao, String nome)
    {
        this.data = data;
        this.horainicio = inicio;
        this.horaFim = fim;
        this.assunto = assunto;
        this.situacao= situacao;
        this.nomeFuncionario=nome;
    }
    
    public void exibir_Equipamentos(){
        System.out.println(equipamentos);
    }

    public void AddEquipamento(ArrayList<Equipamentos> equip)
    {
        equipamentos.add(equip);
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(int horainicio) {
        this.horainicio = horainicio;
    }

    public int getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(int horaFim) {
        this.horaFim = horaFim;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public boolean getSituacao(){
        return situacao;
    }
    public void setSituacao(boolean situacao){
        this.situacao= situacao;
    }
    public String getnomeFuncionario(){
        return nomeFuncionario;
    }
    public void setnomeFuncionario(String nome){
        this.nomeFuncionario= nome;
    }

    @Override
    public String toString() {
        return "Reserva feita por: "+nomeFuncionario +" para a data: "+ data +", no horario: "+horainicio+":00"+" - "+horaFim+":00"+", com o assunto: "+assunto+", ativa: " + situacao + "\n"; 
    }
    
    
}
