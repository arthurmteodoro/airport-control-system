/**
 * Created by arthur and saulo on 27/03/17.
 * Classe responsável pela companhia
 */
public class CompanhiaAerea
{
    private String nome;
    private int quantidadeVoo;
    private double lucro;
    private Aviao[] avioes;

    public CompanhiaAerea()
    {
        this.nome = "";
        this.quantidadeVoo = 0;
        this.lucro = 0;
        this.avioes = new Aviao[100];
    }

    public CompanhiaAerea(String nome, int quantidadeVoo, double lucro)
    {
        this.nome = nome;
        this.quantidadeVoo = quantidadeVoo;
        this.lucro = lucro;
        this.avioes = new Aviao[100];
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

    public void setAvioes(Aviao[] avioes)
    {
        this.avioes = avioes;
    }

    public Aviao[] getAvioes()
    {
        return this.avioes;
    }

    public Aviao getAviaoPrefixo(String prefixoAviao)
    {
        for(int i = 0; i < this.avioes.length && this.avioes[i] != null; i++)
        {
            if(this.avioes[i].getPrefixo().equals(prefixoAviao))
                return this.avioes[i];
        }
        return null;
    }

    public void insereAviao(Aviao aviao)
    {
        if(this.avioes[this.avioes.length-1] != null)
            return;

        int i;
        for(i = 0; this.avioes[i] != null; i++);
        this.avioes[i] = aviao;
    }

    @Override
    public String toString()
    {
        return this.nome;
    }
}
