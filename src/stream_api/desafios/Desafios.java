package stream_api.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Desafios{

    // Atributos
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

    // Construtor
    public Desafios() {
    }

    // Métodos

    // Desafio 1 - Mostre a lista na ordem numérica
    public void imprimirListaEmOrdemNumerica() {
        System.out.print("Desafio 1 - Mostre a lista na ordem numérica: ");
        numeros.stream()
                .sorted()
                .forEach(num -> System.out.print(num + " "));
    }

    // Desafio 2 - Imprima a soma dos números pares da lista
    public void imprimirSomaNumerosPares() {
        System.out.print("\nDesafio 2 - Imprima a soma dos números pares da lista: ");
        int soma = numeros.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(soma);
    }

    // Desafio 3 - Verifique se todos os números da lista são positivos
    public void verificarNumerosPositivos() {
        System.out.print("Desafio 3 - Verifique se todos os números da lista são positivos: ");
        boolean todosPositivos = numeros.stream()
                .allMatch(num -> num > 0);
        System.out.println(todosPositivos);
    }

    // Desafio 4 - Remova todos os valores ímpares
    public void removerNumerosImpares() {
        System.out.print("Desafio 4 - Remova todos os valores ímpares: ");
        numeros.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
    
    // Desafio 5 - Calcule a média dos números maiores que 5
    public void calcularMediaNumerosMaioresQueCinco() {
        System.out.print("Desafio 5 - Calcule a média dos números maiores que 5: ");
        double media = numeros.stream()
                .filter(num -> num > 5)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println(media);
    }

    // Desafio 6 - Verificar se a lista contém algum número maior que 10
    public void verificarNumeroMaiorQueDez() {
        System.out.print("Desafio 6 - Verifique se a lista contém algum número maior que 10: ");
        boolean temNumeroMaiorQueDez = numeros.stream()
                .anyMatch(num -> num > 10);
        System.out.println(temNumeroMaiorQueDez);
    }

    // Desafio 7 - Encontrar o segundo número maior da lista
    public void segundoMaiorNumero() {
        System.out.print("Desafio 7 - Encontrar o segundo número maior da lista: ");
        int segundoMaior = numeros.stream()
                .sorted((a, b) -> b - a)
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(-1);
        System.out.println(segundoMaior);
    }

    // Desafio 8 - Somar os dígitos de todos os números da lista
    public void somarDigitosNumeros() {
        System.out.print("Desafio 8 - Somar os dígitos de todos os números da lista: ");
        int somaDigitos = numeros.stream()
                .flatMapToInt(num -> String.valueOf(num).chars())
                .map(Character::getNumericValue)
                .sum();
        System.out.println(somaDigitos);
    }

    // Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem)
    public void verificarNumerosDistintos() {
        System.out.print("Desafio 9 - Verifique se todos os números da lista são distintos (não se repetem): ");
        boolean todosDistintos = numeros.stream()
                .distinct()
                .count() == numeros.size();
        System.out.println(todosDistintos);
    }

    // Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5
    public void agruparImparesMultiplosde3ou5() {
        System.out.print("Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5: ");
        numeros.stream()
                .filter(num -> num % 2 != 0 && (num % 3 == 0 || num % 5 == 0))
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    // Desafio 11 - Encontre a soma dos quadrados de todos os números da lista:
    public void somarQuadradosNumeros() {
        System.out.print("Desafio 11 - Encontre a soma dos quadrados de todos os números da lista: ");
        int somaQuadrados = numeros.stream()
                .map(num -> num * num)
                .reduce(0, Integer::sum);
        System.out.println(somaQuadrados);
    }
    
    // Desafio 12 - Encontre o produto de todos os números da lista
    public void produtoNumeros() {
        System.out.print("Desafio 12 - Encontre o produto de todos os números da lista: ");
        int produto = numeros.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(produto);
    }

    // Desafio 13 - Filtrar os números que estão dentro de um intervalo 5 e 10
    public void filtrarNumerosNoIntervalo() {
        System.out.print("Desafio 13 - Filtrar os números que estão dentro de um intervalo: ");
        numeros.stream()
                .filter(num -> num >= 5 && num <= 10)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    // Desafio 14 - Encontre o maior número primo da lista
    public void maiorNumeroPrimo() {
        System.out.print("Desafio 14 - Encontre o maior número primo da lista: ");
        int maiorPrimo = numeros.stream()
                .filter(this::isPrimo)
                .max(Integer::compare)
                .orElse(-1);
        System.out.println(maiorPrimo);
    }

    // Método para verificar se um número é primo
    private boolean isPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    // Desafio 15 - Verifique se a lista contém pelo menos um número negativo
    public void verificarNumerosNegativos() {
        System.out.print("Desafio 15 - Verifique se a lista contém pelo menos um número negativo: ");
        boolean temNegativo = numeros.stream()
                .anyMatch(num -> num < 0);
        System.out.println(temNegativo);
    }

    // Desafio 16 - Agrupe os números em pares e ímpares
    public void agruparParesImpares() {
        System.out.print("Desafio 16 - Agrupe os números em pares e ímpares: ");
        Map<String, List<Integer>> grupos = numeros.stream()
                .collect(Collectors.groupingBy(num -> (num % 2 == 0) ? "Pares" : "Ímpares"));
        System.out.println(grupos);
    }

    // Desafio 17 - Filtrar os números primos da lista
    public void filtrarNumerosPrimos() {
        System.out.print("Desafio 17 - Filtrar os números primos da lista: ");
        numeros.stream()
                .filter(this::isPrimo)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    // Desafio 18 - Verifique se todos os números da lista são iguais
    public void verificarNumerosIguais() {
        System.out.print("Desafio 18 - Verifique se todos os números da lista são iguais: ");
        boolean todosIguais = numeros.stream()
                .distinct()
                .count() == 1;
        System.out.println(todosIguais);
    }

    // Desafio 19 - Encontre a soma dos números divisíveis por 3 e 5
    public void somarNumerosDivisiveisPorTresECinco() {
        System.out.print("Desafio 19 - Encontre a soma dos números divisíveis por 3 e 5: ");
        int somaDivisiveis = numeros.stream()
                .filter(num -> num % 3 == 0 || num % 5 == 0)
                .reduce(0, Integer::sum);
        System.out.println(somaDivisiveis);
    }

    // Método principal para executar o desafio
    public static void main(String[] args) {
        Desafios lista = new Desafios();
        // Executando os desafios
        System.out.println("------------- Desafios Stream API - DIO -------------\n");
        lista.imprimirListaEmOrdemNumerica();
        lista.imprimirSomaNumerosPares();
        lista.verificarNumerosPositivos();
        lista.removerNumerosImpares();
        lista.calcularMediaNumerosMaioresQueCinco();
        lista.verificarNumeroMaiorQueDez();
        lista.segundoMaiorNumero();
        lista.somarDigitosNumeros();
        lista.verificarNumerosDistintos();
        lista.agruparImparesMultiplosde3ou5();
        lista.somarQuadradosNumeros();
        lista.produtoNumeros();
        lista.filtrarNumerosNoIntervalo();
        lista.maiorNumeroPrimo();
        lista.verificarNumerosNegativos();
        lista.agruparParesImpares();
        lista.filtrarNumerosPrimos();
        lista.verificarNumerosIguais();
        lista.somarNumerosDivisiveisPorTresECinco();
        System.out.println("\n"+
                        "------------- Fim dos Desafios Stream API - DIO -------------\n");
    }
}
