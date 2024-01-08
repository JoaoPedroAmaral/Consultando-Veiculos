package alura.spring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DadosTipo (String codigo, String nome) //mapeamento com o json
{
    
    
}
