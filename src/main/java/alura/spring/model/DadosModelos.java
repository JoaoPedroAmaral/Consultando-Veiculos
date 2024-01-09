package alura.spring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;//não precisa de json alias se o nome da variavel é igual ao da variavel
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelos(List<Dados>modelos) {
}
