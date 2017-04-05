/**
 * Created by arthur and saulo on 27/03/17 teste.
 * Classe
 */
public class Aviao
{
    private String prefixo;
    private double autonomia;
    private double altura;
    private double envergadura;
    private double comprimento;
    private double capacidade;
    private int quantidadeAssentos;

    public Aviao()
    {
        this.prefixo = "";
        this.autonomia = 0;
        this.altura = 0;
        this.envergadura = 0;
        this.comprimento = 0;
        this.capacidade = 0;
        this.quantidadeAssentos = 0;
    }

    public Aviao(String prefixo, double autonomia, double altura, double envergadura, double comprimento, double capacidade, int quantidadeAssentos)
    {
        this.prefixo = prefixo;
        this.autonomia = autonomia;
        this.altura = altura;
        this.envergadura = envergadura;
        this.comprimento = comprimento;
        this.capacidade = capacidade;
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public void setPrefixo(String prefixo)
    {
        this.prefixo = prefixo;
    }

    public String getPrefixo()
    {
        return this.prefixo;
    }

    public void setAutonomia(double autonomia)
    {
        this.autonomia = autonomia;
    }

    public double getAutonomia()
    {
        return this.autonomia;
    }

    public void setAltura(double altura)
    {
        this.altura = altura;
    }

    public double getAltura()
    {
        return this.altura;
    }

    public void setEnvergadura(double envergadura)
    {
        this.envergadura = envergadura;
    }

    public double getEnvergadura()
    {
        return this.envergadura;
    }

    public void setComprimento(double comprimento)
    {
        this.comprimento = comprimento;
    }

    public double getComprimento()
    {
        return this.comprimento;
    }

    public void setCapacidade(double capacidade)
    {
        this.capacidade = capacidade;
    }

    public double getCapacidade()
    {
        return this.capacidade;
    }

    public void setQuantidadeAssentos(int quantidade)
    {
        this.quantidadeAssentos = quantidade;
    }

    public int getQuantidadeAssentos()
    {
        return this.quantidadeAssentos;
    }

    @Override
    public String toString()
    {
        return this.getPrefixo();
    }

}
