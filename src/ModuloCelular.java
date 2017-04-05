/**
 * Created by arthur and saulo on 01/04/17.
 */
public class ModuloCelular
{
    private Voo[] voos;

    public ModuloCelular(Voo[] voosAeroporto)
    {
        this.voos = voosAeroporto;
    }

    public void setVoos(Voo[] voos)
    {
        this.voos = voos;
    }

    public Voo[] getVoos()
    {
        return this.voos;
    }

    public int getQuantidadeVoosPassageiro(String cpfPassageiro)
    {
        //faz a contagem de quantos voos ele esta
        int quantidadeVoosPassageiro = 0;

        for(int i = 0; this.voos[i] != null; i++)
        {
            Passageiro[] passageirosVoo = this.voos[i].getPassageiros();
            for(int j = 0; j != passageirosVoo.length && passageirosVoo[i] != null; j++)
            {
                if(passageirosVoo[j].getCpf().getCpf().equals(cpfPassageiro))
                {
                    quantidadeVoosPassageiro++;
                }
            }
        }
        return quantidadeVoosPassageiro;
    }

    public Voo[] getVoosPassageiro(String cpfPassageiro)
    {
        int quantidadeVoosPassageiro = this.getQuantidadeVoosPassageiro(cpfPassageiro);
        int indexVetor = 0;
        if(quantidadeVoosPassageiro > 0)
        {
            Voo[] voosPassageiroEsta = new Voo[quantidadeVoosPassageiro];
            for(int i = 0; this.voos[i] != null; i++)
            {
                Passageiro[] passageiros = this.voos[i].getPassageiros();
                for(int j = 0; j != passageiros.length && passageiros[i] != null; j++)
                {
                    if(passageiros[j].getCpf().getCpf().equals(cpfPassageiro))
                    {
                        voosPassageiroEsta[indexVetor] = this.voos[i];
                        indexVetor++;
                    }
                }
            }
            return voosPassageiroEsta;
        }
        return null;
    }

    public String getStringVoos(Voo[] voos, String cpf)
    {
        String dadosVoo = "";
        for(int i = 0; i != this.getQuantidadeVoosPassageiro(cpf); i++)
        {
            dadosVoo = dadosVoo + "Numero Voo: " + voos[i].getNumeroVoo() + "    Companhia: " + voos[i].getCompanhia().getNome() + "    Hora: " + voos[i].getHora()
                    + "    Destino: " + voos[i].getDestino() + "    Origem: " + voos[i].getOrigem() + "    Status : " + voos[i].getStatus() + "\n";
        }
        return dadosVoo;
    }
}
