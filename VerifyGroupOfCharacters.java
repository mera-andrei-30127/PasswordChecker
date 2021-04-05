public class VerifyGroupOfCharacters implements IVerifyCharacters, IError {
    String password;

    public VerifyGroupOfCharacters(String password) {
        this.password = password;
    }

    @Override
    public int verifyCharacters() {
        int group = 0;
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
                group++;
                i = i + 2;
            }

        }
        return group;
    }

    @Override
    public void error() {
        System.out.println("in password exists groups of same characters together, >=3 ");
    }
}


