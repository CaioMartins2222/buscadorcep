package br.com.services;

import br.com.models.Address;
import br.com.models.ViaCepResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AddressServices {
    public Address findCep (String zip) {
        String cleanZip = zip.replaceAll("\\D", "");

        if (cleanZip.length() != 8) {
            throw new IllegalArgumentException("CEP deve conter 8 dígitos");
        }

        String url = "https://viacep.com.br/ws/" + cleanZip + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        HttpResponse<String> response = null;

        try {
            response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao tentar buscar o CEP: " + e.getMessage());
        }

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na requisição: " + response.statusCode());
        }

        String json = response.body();

        Gson gson = new Gson();

        ViaCepResponse viaCepResponse = gson.fromJson(json, ViaCepResponse.class);

        return new Address(viaCepResponse);

    }
}
