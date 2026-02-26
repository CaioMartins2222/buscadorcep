package br.com.models;

public class Address {
    private String city;
    private String street;
    private String state;
    private String complement;
    private String zip;
    private String neighborhood;

    public Address(ViaCepResponse viaCepResponse) {
        this.city = viaCepResponse.localidade();
        this.street = viaCepResponse.logradouro();
        this.state = viaCepResponse.estado();
        this.complement = viaCepResponse.complemento();
        this.zip = viaCepResponse.cep();
        this.neighborhood = viaCepResponse.bairro();
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getComplement() {
        return complement;
    }

    public Address(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    @Override
    public String toString() {
        return "Cep: " + zip +  " , Logradouro: " + street + ", Bairro: " + neighborhood +
                ", Cidade: " + city + ", Estado: " + state + ", Complemento: " + complement ;
    }
}
