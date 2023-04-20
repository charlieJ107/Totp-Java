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
        while (true) {
            var time = System.currentTimeMillis() / 1000 / 30;
            var totp = TotpGenerator.generateTOTP(decoded, time, 6, "HmacSHA1");
            System.out.println(totp);
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}