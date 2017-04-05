import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by arthur and saulo on 28/03/17.
 * Classe para o controle e validacao do CPF
 */
public class CPF
{

    private String cpf;

    public CPF()
    {
        this.cpf = "";
    }

    public CPF(String cpf)
    {
        this.cpf = cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getCpf()
    {
        return this.cpf;
    }

    public boolean eValido()
    {
        String regex = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.cpf);

        return (matcher.find() && matcher.group().equals(this.cpf));
    }
}
