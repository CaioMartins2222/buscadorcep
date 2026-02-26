package br.com.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public void saveJson (Address address) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter fw = new FileWriter(address.getZip() + ".json");
        fw.write(gson.toJson(address));
        fw.close();

    }
}
