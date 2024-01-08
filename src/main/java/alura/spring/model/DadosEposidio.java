package alura.spring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEposidio(@JsonAlias("Title")String Titulo, 
@JsonAlias("Episode") Integer numero,
@JsonAlias("imdbRating") String avaliacao,
@JsonAlias("Released") String dataDeLancamento) {
    
}
