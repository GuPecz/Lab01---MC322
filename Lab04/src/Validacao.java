public class Validacao 
{
    public static int digitoVerificadorCPF(int[] cpf, int ini, int fim)
    {
        int multiplicador = 10;
        int verificador = 0;
        int resto;

        for (int i = ini; i < fim; i++, multiplicador--)
        {
            verificador += cpf[i] * multiplicador;
        }

        resto = verificador % 11;
        if (resto == 1 || resto == 0)
        {
            return 0;
        }
        else
        {
            return (11 - resto);
        }
    }

    public static int digitoVerificadorCNPJ(int[] cnpj, int ini, int fim)
    {
        int[] mults = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int verificador = 0;
        int resto;
        int j;

        if (fim == 12) 
        {
            j = 1;
        }
        else
        {
            j = 0;
        }

        for (int i = ini; i < fim; i++, j++)
        {
            verificador += cnpj[i] * mults[j];
        }

        resto = verificador % 11;
        if (resto < 2)
        {
            return 0;
        }
        else
        {
            return (11 - resto);
        }
    }

    public static boolean validarCPF(String cpf)
    {
        int[] cpfInt = new int[11];
        boolean todosIguais = true;
        int verificadorUm;
        int verificadorDois;
        

        String cpfNumeros = cpf.replaceAll("\\D", "");

        if (cpfNumeros.length() != 11)
        {            
            return false;
        }

        for (int i = 0; i < 11; i++)
        {
            cpfInt[i] = cpfNumeros.charAt(i) - '0';
        }

        for (int i = 1; i < 11; i++)
        {
            if (cpfInt[i] != cpfInt[i - 1])
            {
                todosIguais = false;
                break;
            }
        }

        if (todosIguais == true)
        {
            return false;
        }

        verificadorUm = digitoVerificadorCPF(cpfInt, 0, 9);
        verificadorDois = digitoVerificadorCPF(cpfInt, 1, 10);

        if (cpfInt[9] == verificadorUm && cpfInt[10] == verificadorDois)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public static boolean validarCNPJ(String cnpj)
    {
        int[] cnpjInt = new int[14];
        boolean todosIguais = true;
        int verificadorUm;
        int verificadorDois;
        

        String cnpjNumeros = cnpj.replaceAll("\\D", "");

        if (cnpjNumeros.length() != 14)
        {            
            return false;
        }

        for (int i = 0; i < 14; i++)
        {
            cnpjInt[i] = cnpjNumeros.charAt(i) - '0';
        }

        for (int i = 1; i < 14; i++)
        {
            if (cnpjInt[i] != cnpjInt[i - 1])
            {
                todosIguais = false;
                break;
            }
        }

        if (todosIguais == true)
        {
            return false;
        }

        verificadorUm = digitoVerificadorCNPJ(cnpjInt, 0, 12);
        verificadorDois = digitoVerificadorCNPJ(cnpjInt, 0, 13);

        if (cnpjInt[12] == verificadorUm && cnpjInt[13] == verificadorDois)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean validarNome(String nome)
    {
        for (char c: nome.toCharArray())
        {
            if (!Character.isLetter(c))
                if (c != ' ')
                    return false;
        }

        return true;
    }
}