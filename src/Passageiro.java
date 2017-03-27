/**
 * Created by arthur on 27/03/17.
 * Classe que contem dados sobre os passageiros
 */
public class Passageiro
{
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String nascimento;

    public Passageiro()
    {
        this.nome = "";
        this.telefone = "";
        this.email = "";
        this.cpf = "";
        this.nascimento = "";
    }

    public Passageiro(String nome, String telefone, String email, String cpf, String nascimento)
    {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getTelefone()
    {
        return this.telefone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getCpf()
    {
        return this.cpf;
    }

    public void setNascimento(String nascimento)
    {
        this.nascimento = nascimento;
    }

    public String getNascimento()
    {
        return this.nascimento;
    }
}
