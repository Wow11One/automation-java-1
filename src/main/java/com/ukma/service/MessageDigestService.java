package com.ukma.service;

import com.ukma.enums.MessageDigestAlgorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestService {
    private MessageDigestService() {}

    public static String toHash(String value, MessageDigestAlgorithm algorithm)
            throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.getName());

        return UtilService.bytesToHex(messageDigest.digest(value.getBytes()));
    }
}
