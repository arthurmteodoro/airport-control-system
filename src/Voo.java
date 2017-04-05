import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by arthur and saulo on 27/03/17.
 * Classe do voo
 */
public class Voo
{
    private int numeroVoo;
    private CompanhiaAerea companhia;
    private Aviao aviao;
    private Date data;
    private String destino;
    private String origem;
    private String status;
    private int quantidadePassageiros;
    private Passageiro[] passageiros;

    public Voo()
    {
        this.numeroVoo = 0;
        this.companhia = new CompanhiaAerea();
        this.aviao = null;
        this.data = new Date();
        this.destino = "";
        this.origem = "";
        this.status = "";
        this.quantidadePassageiros = 0;
        this.passageiros = null;
    }

    public Voo(int numeroVoo, CompanhiaAerea companhia, Aviao aviao, String dia, String hora, String destino, String origem)
    {
        this.numeroVoo = numeroVoo;
        this.companhia = companhia;
        this.aviao = aviao;

        //Criação da data
        this.data = new Date();
        Calendar calendar = Calendar.getInstance();

        //faz o split das string de entradas
        String[] diaSplit = dia.split("/");
        String[] horaSplit = hora.split(":");

        //insere os dados no calendario seguindo as stings convertidas
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(diaSplit[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(diaSplit[1])-1);
        calendar.set(Calendar.YEAR, Integer.parseInt(diaSplit[2]));

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(horaSplit[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(horaSplit[1]));

        this.data = calendar.getTime();

        this.destino = destino;
        this.origem = origem;

        this.quantidadePassageiros = 0;
        this.status = "Confirmado";

        //como ja possui o numero de assento o aviao possui e possivel
        //determinar quantos passageiros o voo pode ter
        this.passageiros = new Passageiro[this.aviao.getQuantidadeAssentos()];
    }

    public void setNumeroVoo(int numero)
    {
        this.numeroVoo = numero;
    }

    public int getNumeroVoo()
    {
        return this.numeroVoo;
    }

    public void setCompanhia(CompanhiaAerea companhia)
    {
        this.companhia = companhia;
    }

    public CompanhiaAerea getCompanhia()
    {
        return this.companhia;
    }

    public boolean setAviao(Aviao aviao)
    {
        //verifica se o aviao comporta os passageiros
        if(aviao.getQuantidadeAssentos() < this.quantidadePassageiros)
            return false;

        Passageiro[] passageirosAntigos = this.passageiros;

        this.aviao = aviao;

        //como ja possui o numero de assento o aviao possui e possivel
        //determinar quantos passageiros o voo pode ter
        this.passageiros = new Passageiro[this.aviao.getQuantidadeAssentos()];
        for(int i = 0; i < passageirosAntigos.length && passageirosAntigos[i] != null; i++)
        {
            this.passageiros[i] = passageirosAntigos[i];
        }
        return true;
    }

    public Aviao getAviao()
    {
        return this.aviao;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public Date getData()
    {
        return this.data;
    }

    public void setDia(String dia)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.data);

        //faz o split das string de entradas
        String[] diaSplit = dia.split("/");

        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(diaSplit[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(diaSplit[1])-1);
        calendar.set(Calendar.YEAR, Integer.parseInt(diaSplit[2]));

        this.data = calendar.getTime();
    }

    public String getDia()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.data);
    }

    public void setHora(String hora)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.data);

        String[] horaSplit = hora.split(":");

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(horaSplit[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(horaSplit[1]));

        this.data = calendar.getTime();
    }

    public String getHora()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(this.data);
    }

    public void setDestino(String destino)
    {
        this.destino = destino;
    }

    public String getDestino()
    {
        return this.destino;
    }

    public void setOrigem(String origem)
    {
        this.origem = origem;
    }

    public String getOrigem()
    {
        return this.origem;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setQuantidadePassageiros(int quantidadePassageiros)
    {
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public int getQuantidadePassageiros()
    {
        return this.quantidadePassageiros;
    }

    public void setPassageiros(Passageiro[] passageiros)
    {
        this.passageiros = passageiros;
    }

    public Passageiro[] getPassageiros()
    {
        return this.passageiros;
    }

    public boolean inserePassageiro(Passageiro novoPassageiro)
    {
        if(this.passageiros == null || this.quantidadePassageiros + 1 > this.aviao.getQuantidadeAssentos())
            return false;

        this.passageiros[this.quantidadePassageiros] = novoPassageiro;
        this.quantidadePassageiros++;
        return true;
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.numeroVoo);
    }
}
