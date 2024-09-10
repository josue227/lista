import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(" listas de números.");
            return;
        }

        List<Integer> lista1 = convertirCadenaALista(args[0]);
        List<Integer> lista2 = convertirCadenaALista(args[1]);

        List<Integer> resultado = merge(lista1, lista2);

        System.out.println(resultado);
    }

    private static List<Integer> convertirCadenaALista(String cadena) {
        String[] numeros = cadena.split(",\\s*");
        List<Integer> lista = new ArrayList<>();
        for (String num : numeros) {
            lista.add(Integer.parseInt(num));
        }
        return lista;
    }

    public static List<Integer> merge(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                resultado.add(lista1.get(i));
                i++;
            } else {
                resultado.add(lista2.get(j));
                j++;
            }
        }

        //  primera lista
        while (i < lista1.size()) {
            resultado.add(lista1.get(i));
            i++;
        }

        //  segunda lista
        while (j < lista2.size()) {
            resultado.add(lista2.get(j));
            j++;
        }

        return resultado;
    }
}
