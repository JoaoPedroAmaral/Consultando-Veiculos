package alura.spring.principal;

import java.util.Comparator;
import java.util.Scanner;

import alura.spring.model.Dados;
import alura.spring.model.Dadosveiculo;
import alura.spring.model.DadosModelos;
import alura.spring.service.ConsumoApi;
import alura.spring.service.ConverteDados;

public class Principal {

    private Scanner entrada = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){        
        String opcao, json, novoEndereco;
        do{
                System.out.println("""
                Escolha a marca de veiculo que deseja buscar:
                Carros
                Motos
                Caminhões
                Sair
                """);
            opcao = entrada.next().toLowerCase();
            
            if(opcao.contains("carr")){
                json = consumo.obterDados(ENDERECO + "carros/marcas");
                novoEndereco = ENDERECO + "carros/marcas";
            }else if(opcao.contains("mot")){
                json = consumo.obterDados(ENDERECO + "motos/marcas");
                novoEndereco = ENDERECO + "motos/marcas";
            }else{
                json = consumo.obterDados(ENDERECO + "caminhoes/marcas");
                novoEndereco = ENDERECO + "caminhoes/marcas";
            }

            var marcasList = conversor.obterLista(json, Dados.class);
            marcasList.stream().sorted(Comparator.comparing(Dados::codigo).reversed()).forEach(System.out::println);



            System.out.println("\nDigite a marca do produto desejado");

            var escolhaMarca = entrada.next().toLowerCase();

            var marcaCodigo = marcasList.stream().filter(m -> m.getNome().toLowerCase().contains(escolhaMarca)).findFirst();

            json = consumo.obterDados(novoEndereco + "/" + marcaCodigo.get().getCodigo() + "/modelos");

            novoEndereco = novoEndereco + "/" + marcaCodigo.get().getCodigo() + "/modelos";

            var modeloList = conversor.obterDados(json, DadosModelos.class);
            System.out.println(modeloList);
            



            System.out.println("\nDigite o modelo desejado");
            var escolhaModelo = entrada.next().toLowerCase();

            var modeloCodigo = modeloList.modelos().stream()
            .filter(mo -> mo.getNome().toLowerCase().contains(escolhaModelo)).findFirst();

            json = consumo.obterDados(novoEndereco + "/" + modeloCodigo.get().getCodigo() + "/anos");
            novoEndereco = novoEndereco + "/" + modeloCodigo.get().getCodigo() + "/anos";

            var anoList = conversor.obterLista(json, Dados.class);
            anoList.stream().sorted(Comparator.comparing(Dados::codigo).reversed()).forEach(System.out::println);



            System.out.println("Escolha o ano da " + escolhaModelo.toUpperCase());
            var escolhaAno = entrada.next().toLowerCase();

            var anoCodigo = anoList.stream().filter(a -> a.getNome().toLowerCase().contains(escolhaAno)).findFirst();

            json = consumo.obterDados(novoEndereco + "/" + anoCodigo.get().getCodigo());

            var carroStatus = conversor.obterDados(json, Dadosveiculo.class);
            
            System.out.println(carroStatus);

            

        }while(opcao.contains("sai"));
        



        // List<DadosTemporada> temporada = new ArrayList<>();

		// for(int i = 1; i <= dados.totaltemp(); i++){
		// 	json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season="+ i + APIKEY); // o novo endereço das season

		// 	DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);

		// 	temporada.add(dadosTemporada);
		// }
        // temporada.forEach(System.out::println);// = temporada.forEach(t -> System.out.println(t));

        // System.out.println("\n");
        // temporada.forEach(t -> t.episodios().forEach(e -> System.out.println(e.Titulo())));

        // {
        // //o lambida (->) é uma função capaz de definir funções que sao usadas de forma (argumentos) -> { corpo-da-função } Por exemplo, podemos definir uma função lambda que adicione dois números da seguinte maneira: (a, b) -> { return a + b; }

        // //outro exemplo: 
        // //List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // // for(Integer i: lista) {
        // //   if(i % 2 == 0) {
        // //     System.out.println(i);
        // //   }
        // // }
        // // com o uso de funções lambda, podemos simplificar esse código:

        // // List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // // lista.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
        // //isso equivale a:
        // // for(int i = 0; i <= dados.totaltemp(); i++){
        // //     List<DadosEposidio> eposidios = temporada.get(i).episodios();
        // //     for(int j = 0; j < eposidios.size(); j++){
        // //         System.out.println(eposidios.get(j).Titulo());
        // //     }
        // // }

        // //STREAMS

        // // List<String> nomes = Arrays.asList("Joao", "Pedro", "Rodrigo", "Matheus", "Deivid");

        // // nomes.stream()
        // //      .sorted()
        // //      .limit(3)
        // //      .filter(j->j.startsWith(("J")))
        // //      .map(j->j.toUpperCase())
        // //      .forEach(System.out::println);
        
        // //ele vai pegar o fluxo de dados e organiza em ordem alfabetica
        // //o metodo Stream, é capaz de fazer muitas operações cadeadas. Exemplo o stream().sorted().limited(3).foreach, ele vai fazendo varias funções, junto com o lambida (->) se torna uma arma poderosa
        // }
        
        // List<DadosEposidio> dadosEposidios = temporada.stream().flatMap(t->t.episodios().stream()).collect(Collectors.toList());//a lista dados episodios é uma lista que possui todos os episodios
        

        // System.out.println("\nTOP 5 MELHORES EPISODIOS\n");

        // dadosEposidios.stream()
        // .filter(e->!e.avaliacao().equalsIgnoreCase("N/A"))
        // .peek(e-> System.out.println("Primeiro Filtro(N/A)" + e))
        // .sorted(Comparator.comparing(DadosEposidio::avaliacao).reversed()).peek(e-> System.out.println("\nOrdenação " + e))
        // .limit(5).peek(e-> System.out.println("Limite " + e))
        // .map(e -> e.Titulo().toLowerCase()).peek(e-> System.out.println("Mapeando " + e))
        // .forEach(System.out::println);
        // System.out.println("\n");


        // List<Episodio> episodios = temporada.stream()
        // .flatMap(t->t.episodios().stream()
        //     .map(d -> new Episodio(t.numero(), d)))
        //     .collect(Collectors.toList());

        // episodios.forEach(System.out::println);

        // // //criando um search por temporada
        // // System.out.println("\nDigite um trecho do episodio que deseja buscar:");
        // // var trechoTitulo = entrada.nextLine().toUpperCase();//deixando tanto o trecho digitado quanto o getNome do episodio buscado em maiusculo para que quando o search for feito não tenha problemas em ter que diferenciar letra maiuscula ou minuscula

        // // Optional<Episodio> episodioBuscado = episodios.stream()
        // // .filter(e -> e.getNome().toUpperCase().contains(trechoTitulo))
        // // .findFirst();//encontra a primeira referencia que está buscando
        
        // // //Optional é um objeto Contêiner que pode ou não conter um valor não nulo
        
        // // if(episodioBuscado.isPresent()){
        // //     System.out.println("Episodio encontrado!\n");
        // //     System.out.println("Temporada: " + episodioBuscado.get());
        // // }else{
        // //     System.out.println("Episodio não encontrado!");
        // // }


        // // //Criando um search por data

        // // System.out.println("\nA partir de que ano você deseja ver os episodios?");

        // // var ano = entrada.nextInt();
        // // entrada.nextLine();

        // // LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        // // DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // // episodios.stream().filter(e ->e.getDataLançamento() != null && e.getDataLançamento().isAfter(dataBusca)).forEach(e -> System.out.println(
        // //     "Temporada: " + e.getTemporada() +
        // //     " / Episodio: " + e.getNome() +
        // //     " / Data lançamento: " + e.getDataLançamento().format(formatador)
        // // ));


        // //criando mapa com dados por temporada
        // Map<Integer, Double> avaliacoesPorTemp = episodios.stream()
        // .filter(e -> e.getAvaliacao() > 0.0)
        // .collect(Collectors.groupingBy(Episodio::getTemporada, Collectors.averagingDouble(Episodio::getAvaliacao)));

        // System.out.println("\n" + avaliacoesPorTemp);


        // //coletando estatistica
        // DoubleSummaryStatistics est = episodios.stream()
        // .filter(e -> e.getAvaliacao() > 0.0)
        // .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
    
        // System.out.println("\nMédia: " + est.getAverage() + 
        // "\nMelhor episodio: " + est.getMax() +
        // "\nPior episodio: " + est.getMin() +
        // "\nQuantidade de episodios: " + est.getCount());
    }
}
