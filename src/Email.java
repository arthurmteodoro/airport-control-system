import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by arthur and saulo on 27/03/17.
 * Classe que controla o email e sua devida validacao
 */
public class Email
{
    private String email;

    public Email()
    {
        this.email = "";
    }

    public Email(String email)
    {
        this.email = email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return this.email;
    }

    public boolean eValido()
    {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.email);

        return (matcher.find() && matcher.group().equals(this.email));
    }
}
