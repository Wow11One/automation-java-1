package com.ukma.service;

import com.ukma.enums.SecureRandomAlgorithm;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class SecureRandomService {

    public static String toHash(String value, SecureRandomAlgorithm secureRandomAlgorithm) throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance(secureRandomAlgorithm.getName());
        secureRandom.setSeed(value.getBytes());
        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);

        return  UtilService.bytesToHex(randomBytes);
    }
}
