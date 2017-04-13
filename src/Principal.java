import br.ifmg.util.Verificacoes;

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
            String opcaoStr;
            do
            {
                opcaoStr = JOptionPane.showInputDialog(null, "Menu de opcoes\n" +
                        "1. Cadastrar Companhia Aerea\n" +
                        "2. Entrar no módulo de Companhias Aéreas\n" +
                        "3. Importação do arquivo Json\n" +
                        "4. Painel de Voos\n" +
                        "5. Consulta do Passageiro\n" +
                        "6. Módulos Gerenciais\n" +
                        "7. Sair", "Menu de Opcoes - Geral", JOptionPane.PLAIN_MESSAGE);
            }while(opcaoStr == null || opcaoStr.equals("") || !Verificacoes.somenteNumeroInt(opcaoStr));
            opcao = Integer.parseInt(opcaoStr);

            switch(opcao)
            {
                case 1:
                    String nomeCompanhia;
                    do
                    {
                        nomeCompanhia = JOptionPane.showInputDialog(null, "Digite o nome da companhia : ");
                    }while(nomeCompanhia == null || nomeCompanhia.equals(""));
                    String resposta = aeroporto.cadastraCompanhia(nomeCompanhia);
                    JOptionPane.showConfirmDialog(null, resposta, "Cadastro de Companhia", JOptionPane.OK_CANCEL_OPTION);
                    break;

                case 2:
                    //Usuario seleciona uma companhia
                    String companhia;
                    do
                    {
                        companhia = String.valueOf(JOptionPane.showInputDialog(null, "Escolha a companhia : ",
                                "Modulo Companhia", JOptionPane.PLAIN_MESSAGE, null, aeroporto.getCompanhiasAereas(), null));
                    }while(companhia == null || companhia.equals("") || companhia.equals("null"));
                    CompanhiaAerea companhiaEscolhida = aeroporto.getCompanhia(companhia);

                    //menu do modulo da companhia
                    int opcaoModuloCompanhia;
                    do
                    {
                        String opcaoModuloCompanhiaStr;
                        do
                        {
                            opcaoModuloCompanhiaStr = JOptionPane.showInputDialog(null, "Menu de opcoes\n" +
                                "1. Cadastrar Aviao\n" +
                                "2. Cadastrar Voo\n" +
                                "3. Cadastrar Passageiro\n" +
                                "4. Gera Json\n" +
                                "5. Alterações\n" +
                                "7. Sair", "Menu de Opcoes - Companhia "+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                        }while(opcaoModuloCompanhiaStr == null || opcaoModuloCompanhiaStr.equals("") || !Verificacoes.somenteNumeroInt(opcaoModuloCompanhiaStr));
                        opcaoModuloCompanhia = Integer.parseInt(opcaoModuloCompanhiaStr);

                        switch(opcaoModuloCompanhia)
                        {
                            case 1://cadastro dos avioes
                                //leitura dos dados do aviao
                                String prefixo;
                                do
                                {
                                    prefixo = JOptionPane.showInputDialog(null, "Digite o prefixo do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(prefixo == null || prefixo.equals(""));

                                String autonomiaStr;
                                do
                                {
                                    autonomiaStr = JOptionPane.showInputDialog(null, "Digite a autonomia do aviao",
                                            "Cadastro de avioes - Companhia" + companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(autonomiaStr == null || autonomiaStr.equals("") || !Verificacoes.somenteNumeroFloat(autonomiaStr));
                                double autonomia = Float.parseFloat(autonomiaStr);

                                String alturaStr;
                                do
                                {
                                    alturaStr =  JOptionPane.showInputDialog(null, "Digite a altura do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(alturaStr == null || alturaStr.equals("") || !Verificacoes.somenteNumeroFloat(alturaStr));
                                double altura = Float.parseFloat(alturaStr);

                                String envergaduraStr;
                                do
                                {
                                    envergaduraStr =  JOptionPane.showInputDialog(null, "Digite a envergadura do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(envergaduraStr == null || envergaduraStr.equals("") || !Verificacoes.somenteNumeroFloat(envergaduraStr));
                                double envergadura = Float.parseFloat(envergaduraStr);

                                String comprimentoStr;
                                do
                                {
                                    comprimentoStr = JOptionPane.showInputDialog(null, "Digite o comprimento do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(comprimentoStr == null || comprimentoStr.equals("") || !Verificacoes.somenteNumeroFloat(comprimentoStr));
                                double comprimento = Float.parseFloat(comprimentoStr);

                                String capacidadeStr;
                                do
                                {
                                    capacidadeStr =  JOptionPane.showInputDialog(null, "Digite a capacidade do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(capacidadeStr == null || capacidadeStr.equals("") || !Verificacoes.somenteNumeroFloat(capacidadeStr));
                                double capacidade = Float.parseFloat(capacidadeStr);

                                String quantAssentosStr;
                                do
                                {
                                    quantAssentosStr = JOptionPane.showInputDialog(null, "Digite a quantidade de assentos do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(quantAssentosStr == null || capacidadeStr.equals("") || !Verificacoes.somenteNumeroInt(quantAssentosStr));
                                int quantAssentos = Integer.parseInt(quantAssentosStr);

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
                                String numeroVooStr;
                                do
                                {
                                    numeroVooStr = JOptionPane.showInputDialog(null, "Digite o numero do voo",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(numeroVooStr == null || numeroVooStr.equals("") || !Verificacoes.somenteNumeroInt(numeroVooStr));
                                int numeroVoo = Integer.parseInt(numeroVooStr);

                                Object aviaoObjectVoo;
                                do
                                {
                                    aviaoObjectVoo = JOptionPane.showInputDialog(null, "Escolha o aviao",
                                            "Cadastro de Voos - Companhia" + companhiaEscolhida, JOptionPane.PLAIN_MESSAGE, null, companhiaEscolhida.getAvioes(), null);
                                }while(aviaoObjectVoo == null);
                                //faz o cast do tipo Object para Aviao
                                Aviao aviaoVoo = ((Aviao) aviaoObjectVoo);

                                String diaVoo;
                                do
                                {
                                    diaVoo = JOptionPane.showInputDialog(null, "Digite o dia do voo",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(diaVoo == null || diaVoo.equals("") || !Verificacoes.diaValido(diaVoo));

                                String horaVoo;
                                do
                                {
                                    horaVoo = JOptionPane.showInputDialog(null, "Digite a hora do voo",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(horaVoo == null || horaVoo.equals("") || !Verificacoes.horaValida(horaVoo));

                                String origemVoo;
                                do
                                {
                                    origemVoo = JOptionPane.showInputDialog(null, "Digite a origem do voo",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(origemVoo == null || origemVoo.equals(""));

                                String destinoVoo;
                                do
                                {
                                    destinoVoo = JOptionPane.showInputDialog(null, "Digite o destino do voo",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(destinoVoo == null || destinoVoo.equals(""));

                                if(moduloCompanhia.cadastraVoo(numeroVoo, companhiaEscolhida, aviaoVoo, diaVoo, horaVoo, origemVoo, destinoVoo))
                                {
                                    companhiaEscolhida.setLucro(companhiaEscolhida.getLucro()+10000);
                                    JOptionPane.showConfirmDialog(null, "Voo Cadastrado com Sucesso",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.OK_CANCEL_OPTION);
                                }
                                else
                                    JOptionPane.showConfirmDialog(null, "ERRO - Voo Nao Cadastrado",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.OK_CANCEL_OPTION);
                                break;//break cadastro de voo

                            case 3://cadastro de passageiro em voo
                                Object vooObjectPassageiro;
                                do
                                {
                                    vooObjectPassageiro = JOptionPane.showInputDialog(null, "Escolha um voo",
                                        "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE,
                                        null, moduloCompanhia.getVoosCompanhia(companhiaEscolhida), null);
                                }while(vooObjectPassageiro == null);
                                Voo vooPassageiro = ((Voo) vooObjectPassageiro);


                                String nomePassageiro;
                                do
                                {
                                    nomePassageiro = JOptionPane.showInputDialog(null, "Digite o nome do Passageiro",
                                            "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(nomePassageiro == null || nomePassageiro.equals(""));

                                String telefonePassageiro;
                                do
                                {
                                    telefonePassageiro = JOptionPane.showInputDialog(null, "Digite o telefone do Passageiro",
                                            "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(telefonePassageiro == null || telefonePassageiro.equals("") || !Verificacoes.telefoneValido(telefonePassageiro));

                                String emailPassageiro;
                                do
                                {
                                    emailPassageiro = JOptionPane.showInputDialog(null, "Digite o email do Passageiro",
                                            "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(emailPassageiro == null || emailPassageiro.equals("") || !Verificacoes.emailValido(emailPassageiro));

                                String cpfPassageiro;
                                do
                                {
                                    cpfPassageiro = JOptionPane.showInputDialog(null, "Digite o CPF do Passageiro",
                                            "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(cpfPassageiro == null || cpfPassageiro.equals("") || !Verificacoes.cpfValido(cpfPassageiro));

                                String nascimentoPassageiro;
                                do
                                {
                                    nascimentoPassageiro = JOptionPane.showInputDialog(null, "Digite a data de nascimento do Passageiro",
                                            "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(nascimentoPassageiro == null || nascimentoPassageiro.equals("") || !Verificacoes.diaValido(nascimentoPassageiro));

                                String pesoPassageiroStr;
                                do
                                {
                                    pesoPassageiroStr = JOptionPane.showInputDialog(null, "Digite o peso da bagagem",
                                            "Cadastro de Passageiro - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                }while(pesoPassageiroStr == null || pesoPassageiroStr.equals("") || !Verificacoes.somenteNumeroFloat(pesoPassageiroStr));
                                float pesoPassageiro = Float.parseFloat(pesoPassageiroStr);

                                if(moduloCompanhia.cadastraPassageiro(vooPassageiro, nomePassageiro, telefonePassageiro, emailPassageiro,
                                        cpfPassageiro, nascimentoPassageiro))
                                {
                                    vooPassageiro.setPesoTotal(pesoPassageiro+vooPassageiro.getPesoTotal());
                                    if(vooPassageiro.getPesoTotal() > 30000)
                                    {
                                        vooPassageiro.setPesoAcumulado(vooPassageiro.getPesoAcumulado()+pesoPassageiro);
                                        if(vooPassageiro.getPesoAcumulado() >= 1000)
                                        {
                                            if(vooPassageiro.getPesoAcumulado() % 1000 != 0)
                                            {
                                                int peso = (int)vooPassageiro.getPesoAcumulado()/1000;
                                                companhiaEscolhida.setLucro(companhiaEscolhida.getLucro()+1000*peso);
                                                vooPassageiro.setPesoAcumulado(vooPassageiro.getPesoAcumulado()-peso);
                                            }
                                            else
                                            {
                                                companhiaEscolhida.setLucro(companhiaEscolhida.getLucro()+1000*vooPassageiro.getPesoAcumulado());
                                                vooPassageiro.setPesoAcumulado(0);
                                            }
                                        }
                                    }
                                    JOptionPane.showConfirmDialog(null, "Passageiro Cadastrado com Sucesso",
                                            "Cadastro de Voos - Companhia" + companhiaEscolhida, JOptionPane.OK_CANCEL_OPTION);
                                }
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
                                    String opcaoAlteracaoStr;
                                    do
                                    {
                                        opcaoAlteracaoStr = JOptionPane.showInputDialog(null, "Menu de opcoes\n" +
                                                "1. Alterar Aviao\n" +
                                                "2. Alterar Voo\n" +
                                                "3. Excluir Aviao\n" +
                                                "4. Excluir Voo\n" +
                                                "7. Sair", "Menu de Opcoes - Companhia "+companhiaEscolhida+" - Alteração", JOptionPane.PLAIN_MESSAGE);
                                    }while(opcaoAlteracaoStr == null || opcaoAlteracaoStr.equals("") || !Verificacoes.somenteNumeroInt(opcaoAlteracaoStr));
                                    opcaoAlteracao = Integer.parseInt(opcaoAlteracaoStr);

                                    switch(opcaoAlteracao)
                                    {
                                        case 1://alterar o aviao
                                            String prefixoAlterar;
                                            do
                                            {
                                                prefixoAlterar = JOptionPane.showInputDialog(null, "Digite o prefixo do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(prefixoAlterar == null || prefixoAlterar.equals(""));

                                            String autonomiaAlterarStr;
                                            do
                                            {
                                                autonomiaAlterarStr = JOptionPane.showInputDialog(null, "Digite a autonomia do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(autonomiaAlterarStr == null || autonomiaAlterarStr.equals("") || !Verificacoes.somenteNumeroFloat(autonomiaAlterarStr));
                                            double autonomiaAlterar = Float.parseFloat(autonomiaAlterarStr);

                                            String alturaAlterarStr;
                                            do
                                            {
                                                alturaAlterarStr = JOptionPane.showInputDialog(null, "Digite a altura do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(alturaAlterarStr == null || alturaAlterarStr.equals("") || !Verificacoes.somenteNumeroFloat(alturaAlterarStr));
                                            double alturaAlterar = Float.parseFloat(alturaAlterarStr);

                                            String envergaduraAlterarStr;
                                            do
                                            {
                                                envergaduraAlterarStr = JOptionPane.showInputDialog(null, "Digite a envergadura do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(envergaduraAlterarStr == null || envergaduraAlterarStr.equals("") || !Verificacoes.somenteNumeroFloat(envergaduraAlterarStr));
                                            double envergaduraAlterar = Float.parseFloat(envergaduraAlterarStr);

                                            String comprimentoAlterarStr;
                                            do
                                            {
                                                comprimentoAlterarStr = JOptionPane.showInputDialog(null, "Digite o comprimento do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(comprimentoAlterarStr == null || comprimentoAlterarStr.equals("") || !Verificacoes.somenteNumeroFloat(comprimentoAlterarStr));
                                            double comprimentoAlterar = Float.parseFloat(comprimentoAlterarStr);

                                            String capacidadeAlterarStr;
                                            do
                                            {
                                                capacidadeAlterarStr = JOptionPane.showInputDialog(null, "Digite a capacidade do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(capacidadeAlterarStr == null || capacidadeAlterarStr.equals("") || !Verificacoes.somenteNumeroFloat(capacidadeAlterarStr));
                                            double capacidadeAlterar = Float.parseFloat(capacidadeAlterarStr);

                                            String quantAssentosAlterarStr;
                                            do
                                            {
                                                quantAssentosAlterarStr = JOptionPane.showInputDialog(null, "Digite a quantidade de assentos do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(quantAssentosAlterarStr == null || quantAssentosAlterarStr.equals("") || !Verificacoes.somenteNumeroInt(quantAssentosAlterarStr));
                                            int quantAssentosAlterar = Integer.parseInt(quantAssentosAlterarStr);

                                            if(moduloCompanhia.alteraAviao(companhiaEscolhida, prefixoAlterar, autonomiaAlterar, alturaAlterar,
                                                    envergaduraAlterar, comprimentoAlterar, capacidadeAlterar, quantAssentosAlterar))
                                                JOptionPane.showConfirmDialog(null, "Atualização do aviao realizada com sucesso");
                                            else
                                                JOptionPane.showConfirmDialog(null, "Falha na atualização de avião");
                                            break;

                                        case 2://alteracao de voo
                                            String numeroVooAlteracaoStr;
                                            do
                                            {
                                                numeroVooAlteracaoStr = JOptionPane.showInputDialog(null, "Digite o numero do voo",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(numeroVooAlteracaoStr == null || numeroVooAlteracaoStr.equals("") || !Verificacoes.somenteNumeroInt(numeroVooAlteracaoStr));
                                            int numeroVooAlteracao = Integer.parseInt(numeroVooAlteracaoStr);

                                            Object aviaoObjectVooAlteracao;
                                            do
                                            {
                                                aviaoObjectVooAlteracao = JOptionPane.showInputDialog(null, "Escolha o aviao",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE, null, companhiaEscolhida.getAvioes(), null);
                                            }while(aviaoObjectVooAlteracao == null);
                                            //faz o cast do tipo Object para Aviao
                                            Aviao aviaoVooAlteracao = ((Aviao) aviaoObjectVooAlteracao);

                                            String diaVooAlteracao;
                                            do
                                            {
                                                diaVooAlteracao = JOptionPane.showInputDialog(null, "Digite o dia do voo",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(diaVooAlteracao == null || diaVooAlteracao.equals("") || !Verificacoes.diaValido(diaVooAlteracao));

                                            String horaVooAlteracao;
                                            do
                                            {
                                                horaVooAlteracao = JOptionPane.showInputDialog(null, "Digite a hora do voo",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(horaVooAlteracao == null || horaVooAlteracao.equals("") || !Verificacoes.horaValida(horaVooAlteracao));

                                            String origemVooAlteracao;
                                            do
                                            {
                                                origemVooAlteracao = JOptionPane.showInputDialog(null, "Digite a origem do voo",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(origemVooAlteracao == null || origemVooAlteracao.equals(""));

                                            String destinoVooAlteracao;
                                            do
                                            {
                                                destinoVooAlteracao = JOptionPane.showInputDialog(null, "Digite o destino do voo",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);
                                            }while(destinoVooAlteracao == null || destinoVooAlteracao.equals(""));

                                            if(moduloCompanhia.alterarVoo(numeroVooAlteracao, companhiaEscolhida, aviaoVooAlteracao, diaVooAlteracao,
                                                    horaVooAlteracao, origemVooAlteracao, destinoVooAlteracao))
                                                JOptionPane.showConfirmDialog(null, "Atualização do aviao realizada com sucesso");
                                            else
                                                JOptionPane.showConfirmDialog(null, "Falha na atualização de avião");
                                            break;

                                        case 3://excluir o aviao
                                            String prefixoExcluir;
                                            do
                                            {
                                                prefixoExcluir = String.valueOf(JOptionPane.showInputDialog(null, "Escolha o aviao",
                                                        "Exclusao de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE, null, companhiaEscolhida.getAvioes(), null));
                                            }while(prefixoExcluir == null || prefixoExcluir.equals(""));

                                            if(moduloCompanhia.excluirAviao(companhiaEscolhida, prefixoExcluir))
                                                JOptionPane.showConfirmDialog(null, "Exclusão do aviao realizada com sucesso");
                                            else
                                                JOptionPane.showConfirmDialog(null, "Exclusão do aviao nao realizada");
                                            break;

                                        case 4://excluir o voo
                                            String numeroVooExcluirStr;
                                            do
                                            {
                                                numeroVooExcluirStr = String.valueOf(JOptionPane.showInputDialog(null, "Escolha o voo",
                                                        "Exclusao de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE, null, moduloCompanhia.getVoosCompanhia(companhiaEscolhida), null));
                                            }while(numeroVooExcluirStr == null || numeroVooExcluirStr.equals(""));
                                            int numeroVooExcluir = Integer.parseInt(numeroVooExcluirStr);

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
                    String dia;
                    do
                    {
                        dia = JOptionPane.showInputDialog(null, "Digite o dia: ");
                    }while(dia == null || dia.equals("") || !Verificacoes.diaValido(dia));

                    String dadosPainel = moduloPainel.mostraVoos(dia);
                    JOptionPane.showMessageDialog(null, dadosPainel);
                    break;

                case 5://modulo do passageiro
                    String cpf;
                    do
                    {
                        cpf = JOptionPane.showInputDialog(null, "Digite o seu CPF:", "Consulta do Passageiro", JOptionPane.PLAIN_MESSAGE);
                    }while(cpf == null || cpf.equals("") || !Verificacoes.cpfValido(cpf));

                    Voo[] voosDoPasageiro = moduloCelular.getVoosPassageiro(cpf);
                    if(voosDoPasageiro != null)
                    {
                        String mensagem = moduloCelular.getStringVoos(voosDoPasageiro, cpf);
                        JOptionPane.showConfirmDialog(null, mensagem, "Busca de Voos", JOptionPane.DEFAULT_OPTION);
                    }
                    else
                        JOptionPane.showConfirmDialog(null, "Passageiro Nao Cadastado", "Busca de Voos",JOptionPane.DEFAULT_OPTION);
                    break;

                case 6://modulos gerenciais
                    break;

            }

        }while(opcao != 7);

    }
}
