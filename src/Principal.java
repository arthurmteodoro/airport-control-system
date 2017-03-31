import com.google.gson.Gson;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by arthur on 28/03/17.
 * Classe principal do sistema
 */
public class Principal
{
    public static void main(String[] args)
    {
        Aeroporto aeroporto = new Aeroporto();
        ModuloCompanhia moduloCompanhia = new ModuloCompanhia();
        ModuloPainel moduloPainel = new ModuloPainel(aeroporto.getVoos());

        int opcao;
        do
        {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu de opcoes\n" +
                    "1. Cadastrar Companhia Aerea\n" +
                    "2. Entrar no módulo de Companhias Aéreas\n" +
                    "3. Importação do arquivo Json\n" +
                    "4. Painel de Voos\n" +
                    "7. Sair", "Menu de Opcoes - Geral", JOptionPane.PLAIN_MESSAGE));

            switch(opcao)
            {
                case 1:
                    String nomeCompanhia;
                    nomeCompanhia = JOptionPane.showInputDialog(null, "Digite o nome da companhia");
                    String resposta = aeroporto.cadastraCompanhia(nomeCompanhia);
                    JOptionPane.showConfirmDialog(null, resposta, "Cadastro de Companhia", JOptionPane.OK_CANCEL_OPTION);
                    break;

                case 2:
                    //Usuario seleciona uma companhia
                    String companhia = String.valueOf(JOptionPane.showInputDialog(null, "Escolha a companhia",
                            "Modulo Companhia", JOptionPane.PLAIN_MESSAGE, null, aeroporto.getCompanhiasAereas(), null));
                    CompanhiaAerea companhiaEscolhida = aeroporto.getCompanhia(companhia);

                    //menu do modulo da companhia
                    int opcaoModuloCompanhia;
                    do
                    {
                        opcaoModuloCompanhia = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu de opcoes\n" +
                                "1. Cadastrar Aviao\n" +
                                "2. Cadastrar Voo\n" +
                                "3. Cadastrar Passageiro\n" +
                                "4. Gera Json\n" +
                                "7. Sair", "Menu de Opcoes - Companhia "+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));

                        switch(opcaoModuloCompanhia)
                        {
                            case 1://cadastro dos avioes
                                //leitura dos dados do aviao
                                String prefixo = JOptionPane.showInputDialog(null, "Digite o prefixo do aviao",
                                        "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                double autonomia =  Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a autonomia do aviao",
                                        "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                double altura =  Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a altura do aviao",
                                        "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                double envergadura =  Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a envergadura do aviao",
                                        "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                double comprimento =  Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o comprimento do aviao",
                                        "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                double capacidade =  Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a capacidade do aviao",
                                        "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                int quantAssentos =  Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de assentos do aviao",
                                        "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));

                                //criacao do aviao
                                if(moduloCompanhia.cadastraAviao(companhiaEscolhida, prefixo, autonomia, altura,
                                        envergadura, comprimento, capacidade, quantAssentos))
                                    JOptionPane.showConfirmDialog(null, "Aviao Cadastrado com Sucesso",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.OK_CANCEL_OPTION);
                                else
                                    JOptionPane.showConfirmDialog(null, "ERRO - Aviao Nao Cadastrado",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.OK_CANCEL_OPTION);
                                break;//break cadastro de aviao

                            case 2://cadastro dos voos
                                //leitura dos dados do voo
                                int numeroVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do voo",
                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                Object aviaoObjectVoo = JOptionPane.showInputDialog(null, "Escolha o aviao",
                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE, null, companhiaEscolhida.getAvioes(), null);
                                //faz o cast do tipo Object para Aviao
                                Aviao aviaoVoo = ((Aviao) aviaoObjectVoo);
                                String diaVoo = JOptionPane.showInputDialog(null, "Digite o dia do voo",
                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                String horaVoo = JOptionPane.showInputDialog(null, "Digite a hora do voo",
                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                String origemVoo = JOptionPane.showInputDialog(null, "Digite a origem do voo",
                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                String destinoVoo = JOptionPane.showInputDialog(null, "Digite o destino do voo",
                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                if(moduloCompanhia.cadastraVoo(numeroVoo, companhiaEscolhida, aviaoVoo, diaVoo, horaVoo, origemVoo, destinoVoo))
                                {
                                    JOptionPane.showConfirmDialog(null, "Voo Cadastrado com Sucesso",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.OK_CANCEL_OPTION);
                                }
                                else
                                    JOptionPane.showConfirmDialog(null, "ERRO - Voo Nao Cadastrado",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.OK_CANCEL_OPTION);
                                break;//break cadastro de voo

                            case 3://cadastro de passageiro em voo
                                Object vooObjectPassageiro = JOptionPane.showInputDialog(null, "Escolha um voo",
                                        "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE,
                                        null, moduloCompanhia.getVoosCompanhia(companhiaEscolhida), null);
                                Voo vooPassageiro = ((Voo) vooObjectPassageiro);
                                String nomePassageiro = JOptionPane.showInputDialog(null, "Digite o nome do Passageiro",
                                        "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                String telefonePassageiro = JOptionPane.showInputDialog(null, "Digite o telefone do Passageiro",
                                        "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                String emailPassageiro = JOptionPane.showInputDialog(null, "Digite o email do Passageiro",
                                        "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                String cpfPassageiro = JOptionPane.showInputDialog(null, "Digite o CPF do Passageiro",
                                        "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                String nascimentoPassageiro = JOptionPane.showInputDialog(null, "Digite a data de nascimento do Passageiro",
                                        "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                if(moduloCompanhia.cadastraPassageiro(vooPassageiro, nomePassageiro, telefonePassageiro, emailPassageiro,
                                        cpfPassageiro, nascimentoPassageiro))
                                    JOptionPane.showConfirmDialog(null, "Passageiro Cadastrado com Sucesso",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.OK_CANCEL_OPTION);
                                else
                                    JOptionPane.showConfirmDialog(null, "ERRO - Passageiro Nao Cadastrado",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.OK_CANCEL_OPTION);
                                break;

                            case 4://gera o json
                                try
                                {
                                    moduloCompanhia.geraJson();
                                    JOptionPane.showConfirmDialog(null, "Json gerado");
                                } catch(IOException e)
                                {
                                    e.printStackTrace();
                                    JOptionPane.showConfirmDialog(null, "Falha na criacao do Json");
                                }
                        }
                    }while(opcaoModuloCompanhia != 7);
                    break;//break do case 2 - menu geral.

                case 3://importacao do arquivo json
                    int opcaoImportacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja importar ps dados",
                            "Importacao do Json", JOptionPane.YES_NO_CANCEL_OPTION);
                    if(opcaoImportacao == JOptionPane.YES_OPTION)
                    {
                        if(aeroporto.leVoosJson("voo.json"))
                        {
                            moduloPainel.setVoos(aeroporto.getVoos());
                            JOptionPane.showConfirmDialog(null, "Json Lido com Sucesso", "Leitura do Json", JOptionPane.OK_CANCEL_OPTION);
                        }
                        else
                            JOptionPane.showConfirmDialog(null, "Erro na Leitura do Json", "Leitura do Json", JOptionPane.OK_CANCEL_OPTION);

                    }
                    break;

                case 4://painel de voo
                    String dia = JOptionPane.showInputDialog(null, "Digite o dia: ");
                    String dadosPainel = moduloPainel.mostraVoos(dia);
                    JOptionPane.showMessageDialog(null, dadosPainel);
                    break;
            }

        }while(opcao != 7);

    }
}
