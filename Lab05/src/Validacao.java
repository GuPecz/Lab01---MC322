import java.util.List;

public class Validacao 
{
    public static int digitoVerificadorCPF(int[] cpf, int ini, int fim)
    {
        int multiplicador = 10;
        int verificador = 0;
        int resto;

        for (int i = ini; i < fim; i++, multiplicador--)
            verificador += cpf[i] * multiplicador;

        resto = verificador % 11;
        if (resto == 1 || resto == 0)
            return 0;
        else
            return (11 - resto);
    }

    public static int digitoVerificadorCNPJ(int[] cnpj, int ini, int fim)
    {
        int[] mults = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int verificador = 0;
        int resto;
        int j;

        if (fim == 12) 
            j = 1;
        else
            j = 0;

        for (int i = ini; i < fim; i++, j++)
            verificador += cnpj[i] * mults[j];

        resto = verificador % 11;
        if (resto < 2)
            return 0;
        else
            return (11 - resto);
    }

    public static boolean validarCPF(String cpf)
    {
        int[] cpfInt = new int[11];
        boolean todosIguais = true;
        int verificadorUm;
        int verificadorDois;
        

        String cpfNumeros = cpf.replaceAll("\\D", "");

        if (cpfNumeros.length() != 11)
            return false;

        for (int i = 0; i < 11; i++)
            cpfInt[i] = cpfNumeros.charAt(i) - '0';

        for (int i = 1; i < 11; i++)
            if (cpfInt[i] != cpfInt[i - 1])
            {
                todosIguais = false;
                break;
            }

        if (todosIguais == true)
            return false;

        verificadorUm = digitoVerificadorCPF(cpfInt, 0, 9);
        verificadorDois = digitoVerificadorCPF(cpfInt, 1, 10);

        if (cpfInt[9] == verificadorUm && cpfInt[10] == verificadorDois)
            return true;
        else
            return false;
    }


    public static boolean validarCNPJ(String cnpj)
    {
        int[] cnpjInt = new int[14];
        boolean todosIguais = true;
        int verificadorUm;
        int verificadorDois;
        

        String cnpjNumeros = cnpj.replaceAll("\\D", "");

        if (cnpjNumeros.length() != 14)
            return false;

        for (int i = 0; i < 14; i++)
            cnpjInt[i] = cnpjNumeros.charAt(i) - '0';


        for (int i = 1; i < 14; i++)
            if (cnpjInt[i] != cnpjInt[i - 1])
            {
                todosIguais = false;
                break;
            }

        if (todosIguais == true)
            return false;

        verificadorUm = digitoVerificadorCNPJ(cnpjInt, 0, 12);
        verificadorDois = digitoVerificadorCNPJ(cnpjInt, 0, 13);

        if (cnpjInt[12] == verificadorUm && cnpjInt[13] == verificadorDois)
            return true;
        else
            return false;
    }

    public static boolean validarInt(String inteiro)
    {
        try
        {
            Integer.parseInt(inteiro);
            return true;
        } 
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean validarNome(String nome)
    {
        for (char c: nome.toCharArray())
            if (!Character.isLetter(c) && c != ' ')
                    return false;

        return true;
    }

    private static boolean buscaLinear(int valor, int[] array)
    {
        for (int i = 0; i < array.length; i++)
            if (array[i] == valor)
                return true;
        return false;
    }

    private static boolean ehBissexto(int ano)
    {
        if (ano % 4 == 0)
            return true;
        else
            return false;
    }

    public static boolean validarData(int dia, int mes, int ano)
    {
        int[] mes31dias = {1, 3, 5, 7, 8, 10, 11};
        int[] mes30dias = {4, 6, 9, 12};

        if (ano < 1945 || ano > 2023)
        {
            System.out.println("ERRO: Ano inválido");
            return false;
        }
        
        if (mes < 1 || mes > 12)
        {
            System.out.println("ERRO: Mês inválido");
            return false;
        }
        
        if (dia < 1)
        {
            System.out.println("ERRO: Dia inválido");
            return false;
        }

        if (buscaLinear(mes, mes30dias))
            if (dia > 30)
            {
                System.out.println("ERRO: Dia inválido");
                return false;
            }
        
        if (buscaLinear(mes, mes31dias))
            if (dia > 31)
            {
                System.out.println("ERRO: Dia inválido");
                return false;
            }
        
        if (mes == 2)
            if ((ehBissexto(ano) && dia > 29) || (!ehBissexto(ano) && dia > 28))
            {
                    System.out.println("ERRO: Dia inválido");
                    return false;
            }
            
        return true;
    }

    public static boolean validarIndice(int indice, List<?> lista)
    {
        if (indice < 0)
        {
            System.out.println("ERRO: Opção inválida");
            return false;
        }
        else if (indice > lista.size() - 1)
        {
            System.out.println("ERRO: Opção inválida");
            return false;
        }

        return true;
    }
}