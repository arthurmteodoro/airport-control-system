/**
 * Created by arthur and saulo on 27/03/17.
 * Classe que contem dados sobre os passageiros
 */
public class Passageiro
{
    private String nome;
    private String telefone;
    private Email email;
    private CPF cpf;
    private String nascimento;

    public Passageiro()
    {
        this.nome = "";
        this.telefone = "";
        this.email = new Email();
        this.cpf = new CPF();
        this.nascimento = "";
    }

    public Passageiro(String nome, String telefone, String email, String cpf, String nascimento)
    {
        this.nome = nome;
        this.telefone = telefone;
        this.email = new Email(email);
        this.cpf = new CPF(cpf);
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

    public void setEmail(Email email)
    {
        this.email = email;
    }

    public Email getEmail()
    {
        return this.email;
    }

    public void setCpf(CPF cpf)
    {
        this.cpf = cpf;
    }

    public CPF getCpf()
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

    @Override
    public String toString()
    {
       return "Nome: "+this.nome+" CPF: "+this.cpf.getCpf()+"\n";
    }
}
