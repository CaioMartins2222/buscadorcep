package br.com;

import br.com.models.Address;
import br.com.models.FileGenerator;
import br.com.services.AddressServices;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o Cep desejado:");
        String zip = sc.nextLine();

        AddressServices addressServices = new AddressServices();
        Address adress = addressServices.findCep(zip);

        System.out.println(adress);

        FileGenerator fileGenerator = new FileGenerator();
        fileGenerator.saveJson(adress);
    }
}
