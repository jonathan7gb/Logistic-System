package org.transportadora.model.domain;

import org.transportadora.exceptions.InvalidCnhException;
import org.transportadora.exceptions.InvalidCpfCnpjException;

public class CnhValidate {

    public static boolean validate(String cnh) throws InvalidCnhException {
        if (cnh == null || cnh.isBlank()) {
            throw new InvalidCnhException("CNH não pode ser nulo ou vazio.");
        }

        // remove pontos, traços e barras
        String apenasDigitos = cnh.replaceAll("\\D", "");

        if (apenasDigitos.length() == 11) {
            return true; // CNH válido só pelo tamanho
        } else {
            throw new InvalidCnhException("Documento deve ter 11 dígitos (CNH).");
        }
    }
}
