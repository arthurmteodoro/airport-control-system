import java.util.Calendar;
import java.util.Date;

/**
 * Created by arthur and saulo on 31/03/17.
 * Modulo que controla o painel do aeroporto
 */
public class ModuloPainel
{
    private Voo[] voos;

    public ModuloPainel(Voo[] voosAeroporto)
    {
        this.voos = voosAeroporto;
    }

    public void setVoos(Voo[] voos)
    {
        this.voos = voos;
    }

    public String mostraVoos(String dia)
    {
        String painel = "";
        for(Voo voo:this.voos)
        {
            if(voo != null && voo.getDia().equals(dia))
            {
                painel = painel + "Numero Voo: " + voo.getNumeroVoo() + "    Companhia: " + voo.getCompanhia().getNome() + "    Hora: " + voo.getHora()
                        + "    Destino: " + voo.getDestino() + "    Origem: " + voo.getOrigem() + "    Status : " + voo.getStatus() + "\n";
            }
        }
        return painel;
    }
}
