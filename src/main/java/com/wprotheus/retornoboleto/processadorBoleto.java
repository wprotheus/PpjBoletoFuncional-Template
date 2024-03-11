package com.wprotheus.retornoboleto;

import lombok.Setter;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

@Setter
public class processadorBoleto {
    public static DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private Function<String[], Boleto> criarBoleto;

    public processadorBoleto(Function<String[], Boleto> criarBoleto) {
        this.criarBoleto = criarBoleto;
    }

    public final void processar(URI caminhoArquivo) {
        try {
            var boletos = Files.lines(Paths.get(caminhoArquivo))
                    .map(linha -> linha.split(";"))
                    .map(criarBoleto)
                    .toList();
            boletos.forEach(System.out::println);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}