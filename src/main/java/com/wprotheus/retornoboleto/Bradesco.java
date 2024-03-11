package com.wprotheus.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.wprotheus.retornoboleto.processadorBoleto.FORMATO_DATA;
import static com.wprotheus.retornoboleto.processadorBoleto.FORMATO_DATA_HORA;

public class Bradesco {
    public static Boleto criarBoleto(String[] vetor) {
        final var boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);
        boleto.setAgencia(vetor[2]);
        boleto.setContaBancaria(vetor[3]);
        boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
        boleto.setDataPagamento(LocalDateTime.parse(vetor[5], FORMATO_DATA_HORA));
        boleto.setCpfCliente(vetor[6].replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4"));
        boleto.setValor(Double.parseDouble(vetor[7]));
        boleto.setMulta(Double.parseDouble(vetor[8]));
        boleto.setJuros(Double.parseDouble(vetor[9]));
        return boleto;
    }
}