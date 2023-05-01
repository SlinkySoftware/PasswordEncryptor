Password Encryption CLI
=======================

This tool will encrypt passwords for storage within the Slinky GCloud suite of applications.

After compiling to a JAR file, it is invoked from the command line as such:

```java -jar PasswordEncryptor-0.1-SNAPSHOT-jar-with-dependencies.jar <ENCRYPTION KEY> <PASSWORD>```

* Replace ```<ENCRYPTION KEY>``` with the key used in the application.
* Replace ```<PASSWORD>``` with the password to be encrypted.

The tool will encrypt the password and present a base64 version of the encrypted password 
which can be copied into the appropriate configuration item.

### Example Execution ###
```
D:\PasswordEncryptor>java -jar PasswordEncryptor-0.1-SNAPSHOT-jar-with-dependencies.jar MyEncryptionKeyGoesHere MyVerySecurePasswordHere
============================
= Password Encryption Tool =
============================

Encrypted secret:   0DmljXCza+L3qrKmYjrXck9giCLHzaXIDfeFQagZihKDn9DDBmtk2Za6K2cu1orrQO8X79KisamgMMYqK+taxA==


D:\PasswordEncryptor>

```