package br.ifmg.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by arthur on 13/04/17.
 * Classe com métodos estáticos para verificacao
 */
public class Verificacoes
{

    public static boolean somenteNumeroInt(String entrada)
    {
        String regex = "[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entrada);

        return (matcher.find() && matcher.group().equals(entrada));
    }

    public static boolean somenteNumeroFloat(String entrada)
    {
        String regex = "[0-9]*\\.?[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entrada);

        return (matcher.find() && matcher.group().equals(entrada));
    }

    public static boolean diaValido(String entrada)
    {
        String regex = "^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entrada);

        return (matcher.find() && matcher.group().equals(entrada));
    }

    public static boolean horaValida(String entrada)
    {
        String regex = "([01][0-9]|2[0-3]):[0,3]0";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entrada);

        return (matcher.find() && matcher.group().equals(entrada));
    }

    public static boolean telefoneValido(String entrada)
    {
        String regex = "(\\([0-9]{2}\\))?[0-9]{4}\\-?[0-9]{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entrada);

        return (matcher.find() && matcher.group().equals(entrada));
    }

    public static boolean emailValido(String entrada)
    {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entrada);

        return (matcher.find() && matcher.group().equals(entrada));
    }

    public static boolean cpfValido(String entrada)
    {
        String regex = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entrada);

        return (matcher.find() && matcher.group().equals(entrada));
    }

}
