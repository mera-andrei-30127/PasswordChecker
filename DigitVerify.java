public class DigitVerify implements IVerifyCharacters, IError {
    String password;

    public DigitVerify(String password) {
        this.password = password;
    }

    @Override
    public int verifyCharacters() {
        int i = 0;
        while (i < password.length()) {
            if (Character.isDigit(password.charAt(i))) {
                return 1;
            }
            i++;

        }
        return 0;
    }

    @Override
    public void error() {
        System.out.println("password miss a digit");
    }
}
