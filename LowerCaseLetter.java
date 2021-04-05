public class LowerCaseLetter implements IVerifyCharacters, IError {
    String password;

    public LowerCaseLetter(String password) {
        this.password = password;
    }

    @Override
    public int verifyCharacters() {
        int i = 0;
        while (i < password.length()) {
            if (Character.isLowerCase(password.charAt(i))) {
                return 1;
            }
            i++;

        }
        return 0;
    }

    @Override
    public void error() {
        System.out.println("password miss a lower case character");
    }
}
