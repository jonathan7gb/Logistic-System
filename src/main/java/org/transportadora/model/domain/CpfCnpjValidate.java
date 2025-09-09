package org.transportadora.model.domain;

import org.transportadora.exceptions.InvalidCpfCnpjException;

public class CpfCnpjValidate {

    public static boolean validate(String cpfCnpj) throws InvalidCpfCnpjException {
        if (cpfCnpj == null || cpfCnpj.isBlank()) {
            throw new InvalidCpfCnpjException("CPF/CNPJ não pode ser nulo ou vazio.");
        }

        // remove pontos, traços e barras
        String apenasDigitos = cpfCnpj.replaceAll("\\D", "");

        if (apenasDigitos.length() == 11) {
            return true; // CPF válido só pelo tamanho
        } else if (apenasDigitos.length() == 14) {
            return true; // CNPJ válido só pelo tamanho
        } else {
            throw new InvalidCpfCnpjException("Documento deve ter 11 dígitos (CPF) ou 14 dígitos (CNPJ).");
        }
    }
}
