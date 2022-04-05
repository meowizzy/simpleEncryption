public class SimpleEncryption {
    public static void main(String[] args)  {
        System.out.println(decrypt(encrypt("This kata is very interesting!", 1), 1));
    }

    public static String encrypt(final String text, final int n) {
        if (n <= 0 || text.isEmpty()) return text;

        String result = text;

        for (int i = 0; i < n; i++) {
            result = getEven(result) + getOdd(result);
        }

        return result;
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (n <= 0 || encryptedText.isEmpty()) return encryptedText;

        String res = encryptedText;

        String even = res.substring(0, res.length() / 2);
        String odd = res.substring(res.length() / 2);

        StringBuilder temp = new StringBuilder();

        int counter = 0;

        while (counter < odd.length() && counter < even.length()) {
            temp.append(odd.charAt(counter)).append(even.charAt(counter));
            counter++;
        }

        res = temp.toString();

        return decrypt(encryptedText.length() % 2 == 0 ? res : res + encryptedText.charAt(encryptedText.length() - 1), n - 1);
    }

    public static String getEven(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < text.length(); i += 2) {
            result.append(text.charAt(i));
        }

        return result.toString();
    }

    public static String getOdd(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            result.append(text.charAt(i));
        }

        return result.toString();
    }
}
