/**
 * Created by arthur on 28/03/17.
 * Classe que contem os dados e operações do aeroporto
 */
public class Aeroporto
{
    private CompanhiaAerea[] companhiasAereas;
    private int quantidadeCompanhias;
    private Voo[] voos;
    private int quantidadeVoos;

    public Aeroporto()
    {
        this.companhiasAereas = new CompanhiaAerea[100];
        this.quantidadeCompanhias = 0;
        this.voos = new Voo[100];
        this.quantidadeVoos = 0;
    }

    public CompanhiaAerea[] getCompanhiasAereas()
    {
        return this.companhiasAereas;
    }

    public int getQuantidadeCompanhias()
    {
        return  this.quantidadeCompanhias;
    }

    public void setQuantidadeCompanhias(int quantidade)
    {
        this.quantidadeVoos = quantidade;
    }

    public int getQuantidadeVoos()
    {
        return this.quantidadeVoos;
    }

    public void setQuantidadeVoos(int quantidadeVoos)
    {
        this.quantidadeVoos = quantidadeVoos;
    }

    public Voo[] getVoos()
    {
        return this.voos;
    }

    public String cadastraCompanhia(String nomeCompanhia)
    {
        if(this.quantidadeCompanhias >= 100)
            return "ERRO - Quantidade de Companhias Esgotadas.";

        CompanhiaAerea novaCompanhia = new CompanhiaAerea(nomeCompanhia, 0, 0);
        this.companhiasAereas[this.quantidadeCompanhias] = novaCompanhia;
        this.quantidadeCompanhias++;
        return "Companhia Aerea Criada com Sucesso";
    }

    public CompanhiaAerea getCompanhia(String nomeCompanhia)
    {
        for(int i = 0; i < this.quantidadeCompanhias; i++)
        {
            if(this.companhiasAereas[i].getNome().equals(nomeCompanhia))
                return this.companhiasAereas[i];
        }
        return null;
    }
}
