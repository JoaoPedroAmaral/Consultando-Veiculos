package alura.spring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dadosveiculo(String TipoVeiculo, @JsonAlias("Valor")String valor, @JsonAlias("Marca") String marca, @JsonAlias("Modelo") String modelo, @JsonAlias("AnoModelo") String anoModelo, @JsonAlias("Combustivel") String combustivel, @JsonAlias("CodigoFipe") String codigoFIpe,@JsonAlias("MesReferencial") String mesReferencial, String siglaCombustivel) {

   
    
    public String getTipoVeiculo() {
        return TipoVeiculo;
    }

    public String getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public String getCodigoFIpe() {
        return codigoFIpe;
    }

    public String getMesReferencial() {
        return mesReferencial;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    @Override
    public String toString() {
        return "Tipo do veiculo: " + getTipoVeiculo() + "\n" +
        "Valor: " + getValor() + "\n" + 
        "Marca: " + getMarca() + "\n" +
        "Modelo: " + getModelo() + "\n" + 
        "Ano do modelo: " + getAnoModelo() + "\n" +
        "Combustivel: " + getCombustivel() + "\n" +
        "Codigo FIPE: " + getCodigoFIpe() + "\n" +
        "Mes de referencia: " + getMesReferencial() + "\n" +
        "Sigla do combustivel: " + getCombustivel() + "\n";
    }

    
}
