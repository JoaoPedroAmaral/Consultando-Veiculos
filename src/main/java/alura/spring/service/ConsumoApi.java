package alura.spring.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public String obterDados(String endereco){
        HttpClient client = HttpClient.newHttpClient(); // cria um client
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();//cria um URI dizendo pra qual endereço vo fazer uma requisição
        HttpResponse<String> response = null; // a resposta da requisição
        
        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        }catch(IOException e){
            throw new RuntimeException(e);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
