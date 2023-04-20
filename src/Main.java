import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        byte[] secretBytes = new byte[20];
        new SecureRandom().nextBytes(secretBytes);
        System.out.println(secretBytes);
        Base32 base32 = new Base32();
        var encoded = base32.encodeAsString(secretBytes);
        System.out.println(encoded);
        var decoded = base32.decode(encoded);
        System.out.println(decoded);

    }
}