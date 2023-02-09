public class Main {

    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator(true,true,  true, 16);
        System.out.println(passwordGenerator.generatePassword());
    }

}
