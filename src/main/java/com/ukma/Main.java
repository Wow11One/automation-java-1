package com.ukma;

import com.ukma.enums.MessageDigestAlgorithm;
import com.ukma.service.MessageDigestService;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Main {

    private static List<MessageDigestAlgorithm> messageDigestAlgorithms = List.of(
            MessageDigestAlgorithm.MD2,
            MessageDigestAlgorithm.MD5,
            MessageDigestAlgorithm.SHA_256
    );

    public static void main(String... args) throws NoSuchAlgorithmException {
        System.out.println("Java automation: practice 1\n");

        System.out.println("----- Task 1 -----\n");
        String testValue = "hello world!";
        for (MessageDigestAlgorithm mdAlgorithm : messageDigestAlgorithms) {
            System.out.println("algorithm name: " + mdAlgorithm.getName() + ". Hash results:");
            System.out.print(testValue + " -> ");
            System.out.println(MessageDigestService.toHash(testValue, mdAlgorithm));
        }
    }
}
