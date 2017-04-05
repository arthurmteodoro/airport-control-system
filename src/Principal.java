import javax.swing.*;
import java.io.IOException;

/**
 * Created by arthur and saulo on 28/03/17.
 * Classe principal do sistema
 */
public class Principal
{
    public static void main(String[] args)
    {
        Aeroporto aeroporto = new Aeroporto();
        ModuloCompanhia moduloCompanhia = new ModuloCompanhia();
        ModuloPainel moduloPainel = new ModuloPainel(aeroporto.getVoos());
        ModuloCelular moduloCelular = new ModuloCelular(aeroporto.getVoos());

        int opcao;
        do
        {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu de opcoes\n" +
                    "1. Cadastrar Companhia Aerea\n" +
                    "2. Entrar no módulo de Companhias Aéreas\n" +
                    "3. Importação do arquivo Json\n" +
                    "4. Painel de Voos\n" +
                    "5. Consulta do Passageiro\n" +
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
                                "5. Alterações\n" +
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
                                break;

                            case 5://menu de alterações
                                int opcaoAlteracao;
                                do
                                {
                                    opcaoAlteracao = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu de opcoes\n" +
                                            "1. Alterar Aviao\n" +
                                            "2. Alterar Voo\n" +
                                            "3. Excluir Aviao\n" +
                                            "4. Excluir Voo\n" +
                                            "7. Sair", "Menu de Opcoes - Companhia "+companhiaEscolhida+" - Alteração", JOptionPane.PLAIN_MESSAGE));

                                    switch(opcaoAlteracao)
                                    {
                                        case 1://alterar o aviao
                                            String prefixoAlterar = JOptionPane.showInputDialog(null, "Digite o prefixo do aviao",
                                                    "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            double autonomiaAlterar =  Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a autonomia do aviao",
                                                    "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                            double alturaAlterar =  Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a altura do aviao",
                                                    "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                            double envergaduraAlterar =  Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a envergadura do aviao",
                                                    "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                            double comprimentoAlterar =  Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o comprimento do aviao",
                                                    "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                            double capacidadeAlterar =  Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a capacidade do aviao",
                                                    "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                            int quantAssentosAlterar =  Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de assentos do aviao",
                                                    "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));

                                            if(moduloCompanhia.alteraAviao(companhiaEscolhida, prefixoAlterar, autonomiaAlterar, alturaAlterar,
                                                    envergaduraAlterar, comprimentoAlterar, capacidadeAlterar, quantAssentosAlterar))
                                                JOptionPane.showConfirmDialog(null, "Atualização do aviao realizada com sucesso");
                                            else
                                                JOptionPane.showConfirmDialog(null, "Falha na atualização de avião");
                                            break;

                                        case 2://alteracao de voo
                                            int numeroVooAlteracao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do voo",
                                                    "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE));
                                            Object aviaoObjectVooAlteracao = JOptionPane.showInputDialog(null, "Escolha o aviao",
                                                    "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE, null, companhiaEscolhida.getAvioes(), null);
                                            //faz o cast do tipo Object para Aviao
                                            Aviao aviaoVooAlteracao = ((Aviao) aviaoObjectVooAlteracao);
                                            String diaVooAlteracao = JOptionPane.showInputDialog(null, "Digite o dia do voo",
                                                    "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            String horaVooAlteracao = JOptionPane.showInputDialog(null, "Digite a hora do voo",
                                                    "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            String origemVooAlteracao = JOptionPane.showInputDialog(null, "Digite a origem do voo",
                                                    "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            String destinoVooAlteracao = JOptionPane.showInputDialog(null, "Digite o destino do voo",
                                                    "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            if(moduloCompanhia.alterarVoo(numeroVooAlteracao, companhiaEscolhida, aviaoVooAlteracao, diaVooAlteracao,
                                                    horaVooAlteracao, origemVooAlteracao, destinoVooAlteracao))
                                                JOptionPane.showConfirmDialog(null, "Atualização do aviao realizada com sucesso");
                                            else
                                                JOptionPane.showConfirmDialog(null, "Falha na atualização de avião");
                                            break;

                                        case 3://excluir o aviao
                                            String prefixoExcluir = String.valueOf(JOptionPane.showInputDialog(null, "Escolha o aviao",
                                                    "Exclusao de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE, null, companhiaEscolhida.getAvioes(), null));
                                            if(moduloCompanhia.excluirAviao(companhiaEscolhida, prefixoExcluir))
                                                JOptionPane.showConfirmDialog(null, "Exclusão do aviao realizada com sucesso");
                                            else
                                                JOptionPane.showConfirmDialog(null, "Exclusão do aviao nao realizada");
                                            break;

                                        case 4://excluir o voo
                                            int numeroVooExcluir = Integer.parseInt(String.valueOf(JOptionPane.showInputDialog(null, "Escolha o voo",
                                                    "Exclusao de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE, null, moduloCompanhia.getVoosCompanhia(companhiaEscolhida), null)));
                                            if(moduloCompanhia.excluirVoo(numeroVooExcluir))
                                                JOptionPane.showConfirmDialog(null, "Exclusão do voo realizada com sucesso");
                                            else
                                                JOptionPane.showConfirmDialog(null, "Exclusão do voo nao realizada");

                                    }
                                }while(opcaoAlteracao != 7);
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
                            moduloCelular.setVoos(aeroporto.getVoos());
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

                case 5://modulo do passageiro
                    String cpf = JOptionPane.showInputDialog(null, "Digite o seu CPF:", "Consulta do Passageiro", JOptionPane.PLAIN_MESSAGE);
                    Voo[] voosDoPasageiro = moduloCelular.getVoosPassageiro(cpf);
                    if(voosDoPasageiro != null)
                    {
                        String mensagem = moduloCelular.getStringVoos(voosDoPasageiro, cpf);
                        JOptionPane.showConfirmDialog(null, mensagem, "Busca de Voos", JOptionPane.DEFAULT_OPTION);
                    }
                    else
                        JOptionPane.showConfirmDialog(null, "Passageiro Nao Cadastado", "Busca de Voos",JOptionPane.DEFAULT_OPTION);
                    break;

            }

        }while(opcao != 7);

    }
}
