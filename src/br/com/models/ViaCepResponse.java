package br.com.models;

public record ViaCepResponse(String cep, String logradouro, String complemento, String bairro, String estado, String localidade) {
}
