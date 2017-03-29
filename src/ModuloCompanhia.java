/**
 * Created by arthur on 28/03/17.
 * Esta classe e a responsavel pelas operacoes que o modulo companhia implementa
 */
public class ModuloCompanhia
{
    private CompanhiaAerea[] companhiasAereas;
    private Voo[] voos;

    public ModuloCompanhia(CompanhiaAerea[] companhiasAereas, Voo[] voos)
    {
        this.companhiasAereas = companhiasAereas;
        this.voos = voos;
    }

    public boolean cadastraAviao(String nomeCompanhia, String prefixo, double autonomia, double altura,
                                 double envergadura, double comprimento, double capacidade, int quantidadeAssentos)
    {
        CompanhiaAerea companhia = null;
        for(int i = 0; this.companhiasAereas[i] != null; i++)
        {
            if(this.companhiasAereas[i].getNome().equals(nomeCompanhia))
                companhia = this.companhiasAereas[i];
        }
        if(companhia == null)
            return false;


        Aviao inserirAviao = new Aviao(prefixo, autonomia, altura, envergadura, comprimento, capacidade, quantidadeAssentos);
        companhia.insereAviao(inserirAviao);
        return true;
    }

    public boolean cadastraVoo(int numeroVoo, CompanhiaAerea companhia, Aviao aviao, String dia, String hora,
                               String destino, String origem)
    {
        Voo novoVoo = new Voo(numeroVoo, companhia, aviao, dia, hora, destino, origem);

        int i;
        for(i = 0; this.voos[i] != null; i++);

        //o aeroporto ja chegou ao limite
        if(i >= 100)
            return false;

        voos[i] = novoVoo;
        return true;
    }

    public boolean cadastraPassageiro(Voo voo, String nome, String telefone, String email, String cpf, String nascimento)
    {
        Passageiro novoPassageiro = new Passageiro(nome, telefone, email, cpf, nascimento);
        //if(!novoPassageiro.getCpf().eValido() || !novoPassageiro.getEmail().eValido())
        //    return false;

        if(voo.getAviao().getQuantidadeAssentos() <= voo.getQuantidadePassageiros())
            return false;

        return voo.inserePassageiro(novoPassageiro);
    }

    public Voo[] getVoosCompanhia(CompanhiaAerea companhiaAerea)
    {
        Voo[] voos = new Voo[100];
        int countVooCompanhia = 0;
        for(int i = 0; this.voos[i] != null; i++)
        {
            if(this.voos[i].getCompanhia() == companhiaAerea)
            {
                voos[countVooCompanhia] = this.voos[i];
                countVooCompanhia++;
            }
        }
        return voos;
    }
}
