import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomesString = lerNomesDoUsuario();
        List<Pessoa> listaPessoas = criarListPessoas(nomesString);
        filtrarMulheres(listaPessoas);
    }

    private static void filtrarMulheres(List<Pessoa> listaPessoas) {
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("Estas são as mulheres presentes na lista fornecida:");
        listaPessoas.stream().filter(pessoa -> pessoa.getSexo().equals("F"))
                .forEach(pessoa -> System.out.println(pessoa.nome));
    }

    private static List<Pessoa> criarListPessoas(String nomesString) {
        String[] nomesArray = nomesString.split(",");
        List<Pessoa> listaPessoas = new ArrayList<>();

        for (String nome : nomesArray) {
            String[] parte = nome.split("-");

            String nomeAtual = parte[0].trim();
            String sexo = (parte.length > 1) ? parte[1] : "";

            listaPessoas.add(new Pessoa(nomeAtual, sexo));
        }

        return listaPessoas;
    }


    private static String lerNomesDoUsuario() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite nomes e sexos separados por hífen e vírgula, usando \"M\" para masculino e \"F\" para feminino. \nexemplo: \"João-M,Maria-F,Ana-F\".");

        return s.nextLine();
    }

}

