public class VerifyGroupOfCharacters implements IVerifyCharacters, IError {
    String password;

    public VerifyGroupOfCharacters(String password) {
        this.password = password;
    }

    @Override
    public int verifyCharacters() {
        int group = 0;
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2))
                group++;
        }
        return group;
    }

    @Override
    public void error() {
        System.out.println("in password are group of 3 or more same characters together");
    }
}


