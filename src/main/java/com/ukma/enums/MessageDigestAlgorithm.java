package com.ukma.enums;

public enum MessageDigestAlgorithm {
    MD2("MD2"),
    MD5("MD5"),
    SHA_256("SHA-256");

    private String name;

    MessageDigestAlgorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
