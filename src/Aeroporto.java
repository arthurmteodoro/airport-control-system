import javax.swing.*;

/**
 * Created by arthur on 28/03/17.
 */
public class Aeroporto
{
    public static void main(String[] args)
    {
        Voo[] voos = new Voo[100];

        String nome = JOptionPane.showInputDialog(null, "Digite o nome da companhia");

        CompanhiaAerea companhia = new CompanhiaAerea(nome, 0, 0);

        String aviaoNome = JOptionPane.showInputDialog(null, "Digite o prefixo do aviao");
        String aviaoQuant = JOptionPane.showInputDialog(null, "Digite a quantidade de assentos do aviao");

        Aviao aviao = new Aviao(aviaoNome, 0, 0, 0, 0, 0, Integer.parseInt(aviaoQuant));

        Voo voo = new Voo(1, companhia, aviao, "28/03/2017", "08:57", "formiga", "asd");

        Passageiro passageiro = new Passageiro("asd", "123123", "asd@gmail.com", "123.456.789", "10/10/1999");
        CPF cpfPassageiro = passageiro.getCpf();
        if(cpfPassageiro.eValido())
            System.out.println("eh valido");
        else
            System.out.println("nao eh valido");

        voo.inserePassageiro(passageiro);

    }
}
