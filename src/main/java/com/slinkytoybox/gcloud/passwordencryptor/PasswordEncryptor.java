/*
 * The MIT License
 *
 * Copyright 2023 Slinky Software.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.slinkytoybox.gcloud.passwordencryptor;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.iv.RandomIvGenerator;

/**
 *
 * @author Michael Junek (michael@juneks.com.au)
 */
public class PasswordEncryptor {

    private final static PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
    private final static String ENC_ALGORITHM = "PBEWithHMACSHA512AndAES_256";

    public static void main(String[] args) {
        System.out.println("============================");
        System.out.println("= Password Encryption Tool =");
        System.out.println("============================");
        System.out.println("");

        String encryptionKey;
        String output;
        String input;
        if (args.length != 2 && args.length != 3) {
            System.out.println("Usage: PasswordEncryptor.jar <EncryptionKey> <Unencrypted Text>\n");
            System.exit(-1);
        }
        input = args[1];
        encryptionKey = args[0];

        encryptor.setAlgorithm(ENC_ALGORITHM);
        encryptor.setIvGenerator(new RandomIvGenerator());
        encryptor.setPassword(encryptionKey);
        encryptor.setPoolSize(4);
        encryptor.initialize();

        if (args.length == 2) {
            output = encryptor.encrypt(input);
            System.out.println("Encrypted secret:   " + output + "\n");
        }
        else {
            try {
                output = encryptor.decrypt(input);
            }
            catch (EncryptionOperationNotPossibleException ex) {
                output = "## COULD NOT DECRYPT ##";
            }
            System.out.println("Decrypted secret:   " + output + "\n");
        }
        System.exit(0);
    }

}
