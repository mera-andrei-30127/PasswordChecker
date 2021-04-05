public class PasswordLength implements IVerifyCharacters, IError {
    String password;

    public PasswordLength(String password) {
        this.password = password;
    }

    @Override
    public int verifyCharacters() {
        if (password.length() >= 6 && password.length() <= 20) {
            return 1;
        }
        return 0;
    }

    @Override
    public void error() {
        System.out.println("password must be between 6-20 characters");
    }
}
