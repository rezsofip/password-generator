import java.util.*;

public class PasswordGenerator {

    private boolean containsUpper;
    private boolean containsDigits;
    private boolean containsSpec;
    private int length;

    private static final String UPPER_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+,";

    public PasswordGenerator(boolean containsUpper, boolean containsDigits, boolean containsSpec, int length) {
        this.containsUpper = containsUpper;
        this.containsDigits = containsDigits;
        this.containsSpec = containsSpec;
        this.length = length;
    }

    public String generatePassword() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Character> possibleCharacters = new ArrayList<>(UPPER_LETTERS.chars().
                mapToObj(c -> (char) c).map(Character::toLowerCase).toList());
        if(containsUpper) {
            possibleCharacters.addAll(UPPER_LETTERS.chars().mapToObj(c -> (char) c).toList());
        }
        if(containsDigits) {
            possibleCharacters.addAll(DIGITS.chars().mapToObj(c -> (char) c).toList());
        }
        if(containsSpec) {
            possibleCharacters.addAll(SPECIAL_CHARACTERS.chars().mapToObj(c -> (char) c).toList());
        }
        Random random = new Random();
        int count = 0;
        while(count < length) {
            stringBuilder.append(possibleCharacters.get(random.nextInt(possibleCharacters.size())));
            count++;
        }
        return stringBuilder.toString();

    }

}
