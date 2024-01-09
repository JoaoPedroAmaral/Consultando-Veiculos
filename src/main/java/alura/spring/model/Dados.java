package alura.spring.model;

public record Dados(String codigo, String nome) //mapeamento com o json
{

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }   
    
}
