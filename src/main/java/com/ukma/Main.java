package com.ukma;

import com.ukma.entity.BrokenStudent;
import com.ukma.entity.Student;
import com.ukma.enums.MessageDigestAlgorithm;
import com.ukma.enums.SecureRandomAlgorithm;
import com.ukma.service.MessageDigestService;
import com.ukma.service.SecureRandomService;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final List<MessageDigestAlgorithm> messageDigestAlgorithms = List.of(
            MessageDigestAlgorithm.MD2,
            MessageDigestAlgorithm.MD5,
            MessageDigestAlgorithm.SHA_256
    );

    private static final List<SecureRandomAlgorithm> secureRandomAlgorithms = List.of(
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

        System.out.println();
        System.out.println("----- Task 3 -----\n");
        System.out.println("Correct hashCode and equals class\n");

        Student studentFirst = new Student("Vova", 20);
        Student studentSecond = new Student("Vova", 20);
        Student studentThird = new Student("Denis", 22);


        System.out.println(studentFirst + stringResultEquals(studentFirst, studentSecond) + studentSecond);
        System.out.println(studentSecond + stringResultEquals(studentSecond, studentThird) + studentThird);
        System.out.println(studentFirst + stringResultEquals(studentFirst, studentThird) + studentThird);

        System.out.println();
        System.out.println("Hashmap\n");
        System.out.println("Initial state");
        Map<Student, Integer> correctStudentMap = new HashMap<>();
        correctStudentMap.put(studentFirst, 1);
        correctStudentMap.put(studentSecond, 2);
        correctStudentMap.put(studentThird, 3);
        System.out.println(correctStudentMap);
        System.out.println("hashmap contains key " + studentFirst + " = "
                           + correctStudentMap.containsKey(studentFirst) + '\n');

        System.out.println("delete " + studentFirst + " key from hashmap");
        correctStudentMap.remove(studentFirst);
        System.out.println("State after delete");
        System.out.println(correctStudentMap);
        System.out.println("hashmap contains key " + studentFirst + " = "
                           + correctStudentMap.containsKey(studentFirst) + '\n');

        System.out.println("Incorrect hashCode and equals class\n");

        BrokenStudent brokenStudentFirst = new BrokenStudent("Vova", 20);
        BrokenStudent brokenStudentSecond = new BrokenStudent("Vova", 20);
        BrokenStudent brokenStudentThird = new BrokenStudent("Denis", 22);


        System.out.println(brokenStudentFirst + stringResultEquals(brokenStudentFirst, brokenStudentSecond)
                           + brokenStudentSecond);
        System.out.println(brokenStudentSecond + stringResultEquals(brokenStudentSecond, brokenStudentThird)
                           + brokenStudentThird);
        System.out.println(brokenStudentFirst + stringResultEquals(brokenStudentFirst, brokenStudentThird)
                           + brokenStudentThird);

        System.out.println();
        System.out.println("Hashmap\n");
        System.out.println("Initial state");
        Map<BrokenStudent, Integer> incorrectStudentMap = new HashMap<>();
        incorrectStudentMap.put(brokenStudentFirst, 1);
        incorrectStudentMap.put(brokenStudentSecond, 2);
        incorrectStudentMap.put(brokenStudentThird, 3);
        System.out.println(incorrectStudentMap);
        System.out.println("hashmap contains key " + brokenStudentFirst + " = "
                           + incorrectStudentMap.containsKey(brokenStudentFirst) + '\n');

        System.out.println("delete " + brokenStudentFirst + " key from hashmap");
        incorrectStudentMap.remove(brokenStudentFirst);
        System.out.println("State after delete");
        System.out.println(incorrectStudentMap);
        System.out.println("hashmap contains key " + brokenStudentFirst + " = "
                           + incorrectStudentMap.containsKey(brokenStudentFirst));

    }

    private static <T> String stringResultEquals(T first, T second) {
        return first.equals(second)
                ? " equals "
                : " does not equal ";
    }
}
