package com.ukma;

import com.ukma.enums.MessageDigestAlgorithm;
import com.ukma.enums.SecureRandomAlgorithm;
import com.ukma.service.MessageDigestService;
import com.ukma.service.SecureRandomService;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Main {

    private static List<MessageDigestAlgorithm> messageDigestAlgorithms = List.of(
            MessageDigestAlgorithm.MD2,
            MessageDigestAlgorithm.MD5,
            MessageDigestAlgorithm.SHA_256
    );

    private static List<SecureRandomAlgorithm> secureRandomAlgorithms = List.of(
            SecureRandomAlgorithm.DRBG,
            SecureRandomAlgorithm.NativePRNG,
            SecureRandomAlgorithm.SHA1PRNG
    );

    public static void main(String... args) throws NoSuchAlgorithmException {
        System.out.println("Java automation: practice 1\n");
        String testValue = "hello world!";

        System.out.println("----- Task 1 -----\n");
        System.out.println("Message Digest Algorithms\n");
        for (MessageDigestAlgorithm mdAlgorithm : messageDigestAlgorithms) {
            System.out.println("algorithm name: " + mdAlgorithm.getName() + ". Hash results:");
            System.out.print(testValue + " -> ");
            System.out.println(MessageDigestService.toHash(testValue, mdAlgorithm));
        }

        System.out.println();
        System.out.println("----- Task 2 -----\n");
        System.out.println("Secure Random Algorithms\n");
        for (SecureRandomAlgorithm srAlgorithm : secureRandomAlgorithms) {
            System.out.println("algorithm name: " + srAlgorithm.getName() + ". Hash results:");
            System.out.print(testValue + " -> ");
            System.out.println(SecureRandomService.toHash(testValue, srAlgorithm));
        }

    }
}
