/**
 * Created by arthur on 27/03/17.
 * Classe responsável pela companhia
 */
public class CompanhiaAerea
{
    private String nome;
    private int quantidadeVoo;
    private double lucro;

    public CompanhiaAerea()
    {
        this.nome = "";
        this.quantidadeVoo = 0;
        this.lucro = 0;
    }

    public CompanhiaAerea(String nome, int quantidadeVoo, double lucro)
    {
        this.nome = nome;
        this.quantidadeVoo = quantidadeVoo;
        this.lucro = lucro;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setQuantidadeVoo(int quantidade)
    {
        this.quantidadeVoo = quantidade;
    }

    public int getQuantidadeVoo()
    {
        return this.quantidadeVoo;
    }

    public void setLucro(double lucro)
    {
        this.lucro = lucro;
    }

    public double getLucro()
    {
        return this.lucro;
    }

}
