import java.util.Scanner;

public class Criptografia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.!? ".toCharArray();
        char[] aleatorio = "BkfHl9KYyfVua6qtdbZ8sRmeA4,.xjX21ECNhGgO7?SzILpWJ3TDiQUcvnorM5P!0FwUeQ ".toCharArray();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criptografar");
            System.out.println("2. Descriptografar");
            System.out.println("3. Encerrar");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Digite o texto: ");
                    String textoCriptografado = criptografar(scanner.nextLine(), alfabeto, aleatorio);
                    System.out.println("Texto criptografado: " + textoCriptografado);
                    break;
                case 2:
                    System.out.print("Digite o texto criptografado: ");
                    String textoDescriptografado = descriptografar(scanner.nextLine(), alfabeto, aleatorio);
                    System.out.println("Texto descriptografado: " + textoDescriptografado);
                    break;
                case 3:
                    continuar = false;
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    public static String criptografar(String texto, char[] alfabeto, char[] aleatorio) {
        char[] resultado = new char[texto.length()];
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            int indice = indexOf(alfabeto, caracter);
            resultado[i] = (indice >= 0) ? aleatorio[indice] : caracter;
        }
        return new String(resultado);
    }

    public static String descriptografar(String texto, char[] alfabeto, char[] aleatorio) {
        char[] resultado = new char[texto.length()];
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            int indice = indexOf(aleatorio, caracter);
            resultado[i] = (indice >= 0) ? alfabeto[indice] : caracter;
        }
        return new String(resultado);
    }

    public static int indexOf(char[] array, char target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
