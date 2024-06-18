package com.ukma.enums;

public enum SecureRandomAlgorithm {
    SHA1PRNG("SHA1PRNG"),
    NativePRNG("Windows-PRNG"),
    DRBG("DRBG");

    private final String name;

    SecureRandomAlgorithm(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
