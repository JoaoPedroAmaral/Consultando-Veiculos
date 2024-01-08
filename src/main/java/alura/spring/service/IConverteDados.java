package alura.spring.service;

import java.util.List;

public interface IConverteDados {
    public <T> T obterDados(String json, Class<T> classe);
    //usa o <T> T caso não saiba ainda o tipo que queremos no obterDados
    public <T> List <T> obterLista(String json, Class<T> classe);
}
