import java.time.LocalDate;
import java.util.Scanner;

public class Leitura 
{
    public static Scanner input = new Scanner(System.in);
    
    public static LocalDate leData()
    {
        String data;
        int dia = 0, mes = 0, ano = 0;
        boolean dataValida;
    
        do
        {
            data = input.nextLine();
            data = data.replaceAll("\\D", "");
    
            if (data.length() != 8)
            {
                System.out.println("ERRO: Data inválida");
                dataValida = false;
            }
            else
            {
                dia = Integer.parseInt(data.substring(0, 2));
                mes = Integer.parseInt(data.substring(2, 4));
                ano = Integer.parseInt(data.substring(4, 8));
    
                dataValida = Validacao.validarData(dia, mes, ano);
            }
        } while (!dataValida);
    
        return LocalDate.of(ano, mes, dia);
    }

    public static String lePalavra()
    {
        String nome;
        boolean nomeValido;

        do
        {
            nome = input.nextLine();

            nomeValido = Validacao.validarNome(nome);
            if (!nomeValido)
                System.out.println("ERRO: Palavra inválida");
        } while (!nomeValido);

        return nome;
    }

    public static int leInt()
    {
        String inteiro;
        boolean intValido = false;

        do
        {
            inteiro = input.nextLine();

            intValido = Validacao.validarInt(inteiro);
            if (!intValido)
                System.out.println("ERRO: Número inválido");
        } while (!intValido);

        return Integer.parseInt(inteiro);
    }

    public static int leAno()
    {
        int ano;

        do
        {
            ano = leInt();
        } while (!Validacao.ValidarAno(ano));

        return ano;
    }

    public static String leString()
    {
        return input.nextLine();
    }
}