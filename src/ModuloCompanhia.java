import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by arthur on 28/03/17.
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

    public String geraJson() throws IOException
    {
        Gson gson = new Gson();
        String json = gson.toJson(this.voos);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("voo.json"));
        bufferedWriter.append(json);
        bufferedWriter.close();
        return "voo.json";
    }
}
