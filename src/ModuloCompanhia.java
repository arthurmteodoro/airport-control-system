import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by arthur and saulo on 28/03/17.
 * Esta classe e a responsavel pelas operacoes que o modulo companhia implementa
 */
public class ModuloCompanhia
{
    private Voo[] voos;

    public ModuloCompanhia()
    {
        this.voos = new Voo[100];
    }

    public boolean cadastraAviao(CompanhiaAerea companhia, String prefixo, double autonomia, double altura,
                                 double envergadura, double comprimento, double capacidade, int quantidadeAssentos)
    {
        if(companhia == null)
            return false;

        for(Aviao aviao : companhia.getAvioes())
        {
            if(aviao != null)
            {
                if(aviao.getPrefixo().equals(prefixo))
                    return false;
            }
        }

        Aviao inserirAviao = new Aviao(prefixo, autonomia, altura, envergadura, comprimento, capacidade, quantidadeAssentos);
        companhia.insereAviao(inserirAviao);
        return true;
    }

    public boolean cadastraVoo(int numeroVoo, CompanhiaAerea companhia, Aviao aviao, String dia, String hora,
                               String destino, String origem)
    {

        for(Voo voo : this.voos)
        {
            if(voo != null)
            {
                if(voo.getNumeroVoo() == numeroVoo)
                    return false;
            }
        }

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
        if(!novoPassageiro.getCpf().eValido() || !novoPassageiro.getEmail().eValido())
            return false;

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

    public String geraJson() throws IOException
    {
        Gson gson = new Gson();
        String json = gson.toJson(this.voos);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("voo.json"));
        bufferedWriter.append(json);
        bufferedWriter.close();
        return "voo.json";
    }

    public boolean alteraAviao(CompanhiaAerea companhia, String prefixo, double autonomia, double altura,
                               double envergadura, double comprimento, double capacidade, int quantidadeAssentos)
    {
        Aviao[] avioes = companhia.getAvioes();
        for(int i = 0; i < avioes.length && avioes[i] != null; i++)
        {
            if(avioes[i].getPrefixo().equals(prefixo))
            {
                Aviao aviaoEscolhido = avioes[i];
                aviaoEscolhido.setAutonomia(autonomia);
                aviaoEscolhido.setAltura(altura);
                aviaoEscolhido.setEnvergadura(envergadura);
                aviaoEscolhido.setComprimento(comprimento);
                aviaoEscolhido.setCapacidade(capacidade);
                aviaoEscolhido.setQuantidadeAssentos(quantidadeAssentos);
                return true;
            }
        }
        return false;
    }


    public boolean alterarVoo(int numeroVoo, CompanhiaAerea companhia, Aviao aviao, String dia, String hora,
                              String destino, String origem)
    {
        Voo[] voos = this.voos;
        for(int i = 0; i < voos.length && voos[i] != null; i++)
        {
            if(voos[i].getNumeroVoo() == numeroVoo)
            {
                Voo vooEscolhido = voos[i];
                if(!vooEscolhido.setAviao(aviao))
                    return false;
                vooEscolhido.setDia(dia);
                vooEscolhido.setHora(hora);
                vooEscolhido.setDestino(destino);
                vooEscolhido.setOrigem(origem);
                return true;
            }
        }
        return false;
    }

    public boolean excluirAviao(CompanhiaAerea companhiaAerea, String prefixo)
    {
        //faz a busca pelo vetor de avioes
        Aviao aviaoExcluir = null;
        Aviao[] avioes = companhiaAerea.getAvioes();
        int posicaoAviao = 0;
        for(int i = 0; i < avioes.length && avioes[i] != null; i++)
        {
            if(avioes[i].getPrefixo().equals(prefixo))
            {
                aviaoExcluir = avioes[i];
                posicaoAviao = i;
            }
        }
        if(aviaoExcluir == null)
            return false;

        //verifica se o aviao eh usada em algum voo
        for(int i = 0; i < this.voos.length && this.voos[i] != null; i++)
        {
            if(this.voos[i].getAviao() == aviaoExcluir)
                return false;
        }

        //caso o avaio nao esta sendo usado pode deletar ele e jogar os elementos pra frente
        int i;
        for(i = posicaoAviao; i < avioes.length && avioes[i] != null; i++)
        {
            avioes[i] = avioes[i+1];
        }
        avioes[i-1] = null;
        return true;
    }

    public boolean excluirVoo(int numeroVoo)
    {
        Voo vooExcluir = null;
        int posicaoVoo = 0;
        for(int i = 0; i < this.voos.length && this.voos[i] != null; i++)
        {
            if(this.voos[i].getNumeroVoo() == numeroVoo)
                vooExcluir = this.voos[i];
                posicaoVoo = i;
        }
        if(vooExcluir == null)
            return false;

        int i;
        for(i = posicaoVoo; i < this.voos.length && this.voos[i] != null; i++)
        {
            this.voos[i] = this.voos[i+1];
        }
        this.voos[i-1] = null;
        return true;
    }

}
