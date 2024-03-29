import com.google.gson.Gson;

import java.io.*;

/**
 * Created by arthur and saulo on 28/03/17.
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

    public void setVoos(Voo[] voos)
    {
        this.voos = voos;
    }

    public int contaVoos()
    {
        int i;
        for(i = 0; this.voos[i] != null; i++);
        return i;
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

        for(CompanhiaAerea companhia : this.companhiasAereas)
        {
            if(companhia != null)
            {
                if(companhia.getNome().equals(nomeCompanhia))
                    return "ERRO - Companhia Aerea Já Cadastrada";
            }
        }

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

    public boolean leVoosJson(String arquivo)
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo));
            String json = "";
            String linha = bufferedReader.readLine();
            while(linha != null)
            {
                json = json + linha;
                linha = bufferedReader.readLine();
            }
            Gson gson = new Gson();
            this.voos = gson.fromJson(json, Voo[].class);

            bufferedReader.close();
            return true;

        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
            return false;
        } catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public int quantidadeVoosCompanhia(CompanhiaAerea companhiaAerea)
    {
        int quantidade = 0;

        for(int i = 0; i < this.voos.length && this.voos[i] != null; i++)
        {
            if(this.voos[i].getCompanhia().getNome().equals(companhiaAerea.getNome()))
            {
                quantidade++;
            }
        }
        return quantidade;
    }

    public Passageiro[] listaPassageiroVoo(int numeroVoo)
    {
        for(Voo voo : this.voos)
        {
            if(voo != null)
            {
                if(voo.getNumeroVoo() == numeroVoo)
                {
                    //conta quantos elementos tem
                    int quantidade = 0;
                    for(Passageiro passageiro : voo.getPassageiros())
                    {
                        if(passageiro != null)
                            quantidade++;
                    }
                    //cria um vetor com a quantidade
                    Passageiro[] passageiros = new Passageiro[quantidade];
                    int cont = 0;
                    for(Passageiro passageiro : voo.getPassageiros())
                    {
                        if(passageiro != null)
                        {
                            passageiros[cont] = passageiro;
                            cont++;
                        }
                    }
                    return passageiros;
                }
            }
        }
        return null;
    }

    public Voo[] choqueVoo(String dia, String hora)
    {
        if(!verificaQuatroVoos(dia, hora))
        {
            Voo[] choque = new Voo[3];
            int cont = 0;

            for(Voo voo:this.voos)
            {
                if(voo.getDia().equals(dia) && voo.getHora().equals(hora))
                {
                    choque[cont] = voo;
                    cont++;
                }
            }

            return choque;
        }
        return null;
    }
    private boolean verificaQuatroVoos(String dia, String hora)
    {

        int cont = 0;
        for(Voo voo:this.voos)
        {
            if(voo != null)
            {
                if(voo.getDia().equals(dia) && voo.getHora().equals(hora))
                {
                    cont++;
                }
            }
            if(cont == 3)
            {
                return false;
            }
        }
        return true;
    }

    private boolean cadastraVoo(int numeroVoo, CompanhiaAerea companhia, Aviao aviao, String dia, String hora,
                               String destino, String origem)
    {

        if(!verificaQuatroVoos(dia, hora))
        {
            return false;
        }

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
}
