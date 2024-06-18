package com.ukma.service;

import com.ukma.enums.MessageDigestAlgorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestService {
    private MessageDigestService() {}

    public static String toHash(String value, MessageDigestAlgorithm algorithm)
            throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.getName());

        return bytesToHex(messageDigest.digest(value.getBytes()));
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
