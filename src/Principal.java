import br.ifmg.util.Verificacoes;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

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

                if (opcaoStr == null)
                    break;
            }while(opcaoStr.equals("") || !Verificacoes.somenteNumeroInt(opcaoStr));

            if (opcaoStr == null)
                break;
            opcao = Integer.parseInt(opcaoStr);

            switch(opcao)
            {
                case 1:
                    String nomeCompanhia;
                    do
                    {
                        nomeCompanhia = JOptionPane.showInputDialog(null, "Digite o nome da companhia : ");
                        if (nomeCompanhia == null)
                            break;
                    }while(nomeCompanhia.equals(""));
                    if (nomeCompanhia == null)
                        break;
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
                        if (companhia.equals("null"))
                            break;
                    }while(companhia.equals(""));
                    if (companhia.equals("null"))
                        break;
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

                            if (opcaoModuloCompanhiaStr == null)
                                break;
                        }while(opcaoModuloCompanhiaStr.equals("") || !Verificacoes.somenteNumeroInt(opcaoModuloCompanhiaStr));

                        if (opcaoModuloCompanhiaStr == null)
                            break;

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

                                    if (prefixo == null)
                                        break;
                                }while(prefixo.equals(""));

                                if (prefixo == null)
                                    break;

                                String autonomiaStr;
                                do
                                {
                                    autonomiaStr = JOptionPane.showInputDialog(null, "Digite a autonomia do aviao",
                                            "Cadastro de avioes - Companhia" + companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                    if (autonomiaStr == null)
                                        break;
                                }while(autonomiaStr.equals("") || !Verificacoes.somenteNumeroFloat(autonomiaStr));

                                if (autonomiaStr == null)
                                    break;
                                double autonomia = Float.parseFloat(autonomiaStr);

                                String alturaStr;
                                do
                                {
                                    alturaStr =  JOptionPane.showInputDialog(null, "Digite a altura do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                    if (alturaStr == null)
                                        break;
                                }while(alturaStr.equals("") || !Verificacoes.somenteNumeroFloat(alturaStr));

                                if (alturaStr == null)
                                    break;
                                double altura = Float.parseFloat(alturaStr);

                                String envergaduraStr;
                                do
                                {
                                    envergaduraStr =  JOptionPane.showInputDialog(null, "Digite a envergadura do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                    if (envergaduraStr == null)
                                        break;
                                }while(envergaduraStr.equals("") || !Verificacoes.somenteNumeroFloat(envergaduraStr));

                                if (envergaduraStr == null)
                                    break;
                                double envergadura = Float.parseFloat(envergaduraStr);

                                String comprimentoStr;
                                do
                                {
                                    comprimentoStr = JOptionPane.showInputDialog(null, "Digite o comprimento do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                    if (comprimentoStr == null)
                                        break;
                                }while(comprimentoStr.equals("") || !Verificacoes.somenteNumeroFloat(comprimentoStr));

                                if (comprimentoStr == null)
                                    break;
                                double comprimento = Float.parseFloat(comprimentoStr);

                                String capacidadeStr;
                                do
                                {
                                    capacidadeStr =  JOptionPane.showInputDialog(null, "Digite a capacidade do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                    if (capacidadeStr == null)
                                        break;
                                }while(capacidadeStr.equals("") || !Verificacoes.somenteNumeroFloat(capacidadeStr));

                                if (capacidadeStr == null)
                                    break;
                                double capacidade = Float.parseFloat(capacidadeStr);

                                String quantAssentosStr;
                                do
                                {
                                    quantAssentosStr = JOptionPane.showInputDialog(null, "Digite a quantidade de assentos do aviao",
                                            "Cadastro de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                    if (quantAssentosStr == null)
                                        break;
                                }while(quantAssentosStr.equals("") || !Verificacoes.somenteNumeroInt(quantAssentosStr));

                                if (quantAssentosStr == null)
                                    break;
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

                                    if (numeroVooStr == null)
                                        break;
                                }while(numeroVooStr.equals("") || !Verificacoes.somenteNumeroInt(numeroVooStr));

                                if (numeroVooStr == null)
                                    break;
                                int numeroVoo = Integer.parseInt(numeroVooStr);

                                Object aviaoObjectVoo;
                                do
                                {
                                    aviaoObjectVoo = JOptionPane.showInputDialog(null, "Escolha o aviao",
                                            "Cadastro de Voos - Companhia" + companhiaEscolhida, JOptionPane.PLAIN_MESSAGE, null, companhiaEscolhida.getAvioes(), null);

                                    if (aviaoObjectVoo == null)
                                        break;
                                }while(aviaoObjectVoo == null);

                                if (aviaoObjectVoo == null)
                                    break;
                                //faz o cast do tipo Object para Aviao
                                Aviao aviaoVoo = ((Aviao) aviaoObjectVoo);

                                String diaVoo;
                                do
                                {
                                    diaVoo = JOptionPane.showInputDialog(null, "Digite o dia do voo",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                    if (diaVoo == null)
                                        break;
                                }while(diaVoo.equals("") || !Verificacoes.diaValido(diaVoo));

                                if (diaVoo == null)
                                    break;

                                String horaVoo;
                                do
                                {
                                    horaVoo = JOptionPane.showInputDialog(null, "Digite a hora do voo",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                    if (horaVoo == null)
                                        break;
                                }while(horaVoo.equals("") || !Verificacoes.horaValida(horaVoo));

                                if (horaVoo == null)
                                    break;
                                String origemVoo;
                                do
                                {
                                    origemVoo = JOptionPane.showInputDialog(null, "Digite a origem do voo",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                    if (origemVoo == null)
                                        break;
                                }while(origemVoo.equals(""));

                                if (origemVoo == null)
                                    break;

                                String destinoVoo;
                                do
                                {
                                    destinoVoo = JOptionPane.showInputDialog(null, "Digite o destino do voo",
                                            "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                    if (destinoVoo == null)
                                        break;
                                }while(destinoVoo.equals(""));

                                if (destinoVoo == null)
                                    break;

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

                                        if (opcaoAlteracaoStr == null)
                                            break;
                                    }while(opcaoAlteracaoStr.equals("") || !Verificacoes.somenteNumeroInt(opcaoAlteracaoStr));

                                    if (opcaoAlteracaoStr == null)
                                        break;
                                    opcaoAlteracao = Integer.parseInt(opcaoAlteracaoStr);

                                    switch(opcaoAlteracao)
                                    {
                                        case 1://alterar o aviao
                                            String prefixoAlterar;
                                            do
                                            {
                                                prefixoAlterar = JOptionPane.showInputDialog(null, "Digite o prefixo do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (prefixoAlterar == null)
                                                    break;
                                            }while(prefixoAlterar.equals(""));

                                            if (prefixoAlterar == null)
                                                break;

                                            String autonomiaAlterarStr;
                                            do
                                            {
                                                autonomiaAlterarStr = JOptionPane.showInputDialog(null, "Digite a autonomia do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (autonomiaAlterarStr == null)
                                                    break;
                                            }while(autonomiaAlterarStr.equals("") || !Verificacoes.somenteNumeroFloat(autonomiaAlterarStr));

                                            if (autonomiaAlterarStr == null)
                                                break;
                                            double autonomiaAlterar = Float.parseFloat(autonomiaAlterarStr);

                                            String alturaAlterarStr;
                                            do
                                            {
                                                alturaAlterarStr = JOptionPane.showInputDialog(null, "Digite a altura do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (alturaAlterarStr == null)
                                                    break;
                                            }while(alturaAlterarStr.equals("") || !Verificacoes.somenteNumeroFloat(alturaAlterarStr));

                                            if (alturaAlterarStr == null)
                                                break;
                                            double alturaAlterar = Float.parseFloat(alturaAlterarStr);

                                            String envergaduraAlterarStr;
                                            do
                                            {
                                                envergaduraAlterarStr = JOptionPane.showInputDialog(null, "Digite a envergadura do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (envergaduraAlterarStr == null)
                                                    break;
                                            }while(envergaduraAlterarStr.equals("") || !Verificacoes.somenteNumeroFloat(envergaduraAlterarStr));

                                            if (envergaduraAlterarStr == null)
                                                break;
                                            double envergaduraAlterar = Float.parseFloat(envergaduraAlterarStr);

                                            String comprimentoAlterarStr;
                                            do
                                            {
                                                comprimentoAlterarStr = JOptionPane.showInputDialog(null, "Digite o comprimento do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (comprimentoAlterarStr == null)
                                                    break;
                                            }while(comprimentoAlterarStr.equals("") || !Verificacoes.somenteNumeroFloat(comprimentoAlterarStr));

                                            if (comprimentoAlterarStr == null)
                                                break;
                                            double comprimentoAlterar = Float.parseFloat(comprimentoAlterarStr);

                                            String capacidadeAlterarStr;
                                            do
                                            {
                                                capacidadeAlterarStr = JOptionPane.showInputDialog(null, "Digite a capacidade do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (capacidadeAlterarStr == null)
                                                    break;
                                            }while(capacidadeAlterarStr.equals("") || !Verificacoes.somenteNumeroFloat(capacidadeAlterarStr));

                                            if (capacidadeAlterarStr == null)
                                                break;
                                            double capacidadeAlterar = Float.parseFloat(capacidadeAlterarStr);

                                            String quantAssentosAlterarStr;
                                            do
                                            {
                                                quantAssentosAlterarStr = JOptionPane.showInputDialog(null, "Digite a quantidade de assentos do aviao",
                                                        "Alteração de avioes - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (quantAssentosAlterarStr == null)
                                                    break;
                                            }while(quantAssentosAlterarStr.equals("") || !Verificacoes.somenteNumeroInt(quantAssentosAlterarStr));

                                            if (quantAssentosAlterarStr == null)
                                                break;
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

                                                if (numeroVooAlteracaoStr == null)
                                                    break;
                                            }while(numeroVooAlteracaoStr.equals("") || !Verificacoes.somenteNumeroInt(numeroVooAlteracaoStr));

                                            if (numeroVooAlteracaoStr == null)
                                                break;
                                            int numeroVooAlteracao = Integer.parseInt(numeroVooAlteracaoStr);

                                            Object aviaoObjectVooAlteracao;
                                            do
                                            {
                                                aviaoObjectVooAlteracao = JOptionPane.showInputDialog(null, "Escolha o aviao",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE, null, companhiaEscolhida.getAvioes(), null);

                                                if (aviaoObjectVooAlteracao == null)
                                                    break;
                                            }while(aviaoObjectVooAlteracao == null);

                                            if (aviaoObjectVooAlteracao == null)
                                                break;
                                            //faz o cast do tipo Object para Aviao
                                            Aviao aviaoVooAlteracao = ((Aviao) aviaoObjectVooAlteracao);

                                            String diaVooAlteracao;
                                            do
                                            {
                                                diaVooAlteracao = JOptionPane.showInputDialog(null, "Digite o dia do voo",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (diaVooAlteracao == null)
                                                    break;
                                            }while(diaVooAlteracao.equals("") || !Verificacoes.diaValido(diaVooAlteracao));

                                            if (diaVooAlteracao == null)
                                                break;

                                            String horaVooAlteracao;
                                            do
                                            {
                                                horaVooAlteracao = JOptionPane.showInputDialog(null, "Digite a hora do voo",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (horaVooAlteracao == null)
                                                    break;
                                            }while(horaVooAlteracao.equals("") || !Verificacoes.horaValida(horaVooAlteracao));

                                            if (horaVooAlteracao == null)
                                                break;

                                            String origemVooAlteracao;
                                            do
                                            {
                                                origemVooAlteracao = JOptionPane.showInputDialog(null, "Digite a origem do voo",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (origemVooAlteracao == null)
                                                    break;
                                            }while(origemVooAlteracao.equals(""));

                                            if (origemVooAlteracao == null)
                                                break;

                                            String destinoVooAlteracao;
                                            do
                                            {
                                                destinoVooAlteracao = JOptionPane.showInputDialog(null, "Digite o destino do voo",
                                                        "Cadastro de Voos - Companhia"+companhiaEscolhida, JOptionPane.PLAIN_MESSAGE);

                                                if (destinoVooAlteracao == null)
                                                    break;
                                            }while(destinoVooAlteracao.equals(""));

                                            if (destinoVooAlteracao == null)
                                                break;

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

                                                if (prefixoExcluir == null)
                                                    break;
                                            }while(prefixoExcluir.equals(""));

                                            if (prefixoExcluir == null)
                                                break;

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

                                                if (numeroVooExcluirStr == null)
                                                    break;
                                            }while(numeroVooExcluirStr.equals(""));

                                            if (numeroVooExcluirStr == null)
                                                break;
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
                        if (dia == null)
                            break;
                    }while(dia.equals("") || !Verificacoes.diaValido(dia));

                    if (dia == null)
                        break;

                    String dadosPainel = moduloPainel.mostraVoos(dia);
                    JOptionPane.showMessageDialog(null, dadosPainel);
                    break;

                case 5://modulo do passageiro
                    String cpf;
                    do
                    {
                        cpf = JOptionPane.showInputDialog(null, "Digite o seu CPF:", "Consulta do Passageiro", JOptionPane.PLAIN_MESSAGE);
                        if (cpf == null)
                            break;
                    }while(cpf.equals("") || !Verificacoes.cpfValido(cpf));

                    if (cpf == null)
                        break;

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
                    int opcaoModuloGerencial;
                    do
                    {

                        String opcaoModuloGerencialStr;
                        do
                        {
                            opcaoModuloGerencialStr = JOptionPane.showInputDialog(null,
                                    "1. Consultar Lucro da Companhia\n"+
                                            "2. Listagem dos Passageiros\n"+
                                            "3. Quantidade de voos por companhia\n"+
                                            "7. Sair");
                            if(opcaoModuloGerencialStr == null)
                                break;
                        }while(opcaoModuloGerencialStr.equals(""));

                        if(opcaoModuloGerencialStr == null)
                            break;

                        opcaoModuloGerencial = Integer.parseInt(opcaoModuloGerencialStr);

                        switch(opcaoModuloGerencial)
                        {
                            case 1://pegar o lucro da companhia
                                Object companhiaObject;
                                companhiaObject = JOptionPane.showInputDialog(null, "Escolha a Companhia",
                                            "Modulo Gerencial", JOptionPane.PLAIN_MESSAGE, null, aeroporto.getCompanhiasAereas(), null);
                                if(companhiaObject == null)
                                    break;
                                CompanhiaAerea companhiaGerencial  = ((CompanhiaAerea) companhiaObject);

                                JOptionPane.showConfirmDialog(null, "O lucro da Companhia" +
                                companhiaGerencial.getNome()+ " eh "+ companhiaGerencial.getLucro(), "Modulo Gerencial", JOptionPane.DEFAULT_OPTION);
                                break;

                            case 2://listagem de passageiros
                                Object vooGerencialObject;
                                vooGerencialObject = JOptionPane.showInputDialog(null, "Selecione o Voo", "Modulo Gerencial",
                                            JOptionPane.PLAIN_MESSAGE, null, aeroporto.getVoos(), null);
                                if(vooGerencialObject == null)
                                    break;

                                Voo vooSelecionado = ((Voo) vooGerencialObject);

                                JOptionPane.showConfirmDialog(null, "Os passageiros deste voos sao:\n"+
                                        Arrays.toString(aeroporto.listaPassageiroVoo(vooSelecionado.getNumeroVoo())), "Modulo Gerencial", JOptionPane.DEFAULT_OPTION);
                                break;

                            case 3://quantidade de voos
                                Object companhiaQuantidadeObject;
                                companhiaQuantidadeObject = JOptionPane.showInputDialog(null, "Escolha a Companhia",
                                            "Modulo Gerencial", JOptionPane.PLAIN_MESSAGE, null, aeroporto.getCompanhiasAereas(), null);
                                if(companhiaQuantidadeObject == null)
                                    break;
                                CompanhiaAerea companhiaQuantidadeGerencial  = ((CompanhiaAerea) companhiaQuantidadeObject);

                                JOptionPane.showConfirmDialog(null, "A quantidade de voos da Companhia" +
                                        companhiaQuantidadeGerencial.getNome()+ " eh "+ aeroporto.quantidadeVoosCompanhia(companhiaQuantidadeGerencial), "Modulo Gerencial", JOptionPane.DEFAULT_OPTION);
                                break;
                        }

                    }while(opcaoModuloGerencial != 7);
                    break;
            }

        }while(opcao != 7);

    }
}
