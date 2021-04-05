import java.util.HashMap;

public class Validation {
    final String password;
    final HashMap<String, Integer> contains;
    Boolean errrorr;
    int errorCount;

    public Validation(String password) {
        this.password = password;
        this.errrorr = true;
        this.errorCount = 0;
        this.contains = new HashMap<>();
    }

    public String result() {
        DigitVerify digitVerify = new DigitVerify(password);
        LowerCaseLetter lowerCaseLetter = new LowerCaseLetter(password);
        PasswordLength passwordLength = new PasswordLength(password);
        UpperCaseLetter upperCaseLetter = new UpperCaseLetter(password);
        VerifyGroupOfCharacters verifyGroupOfCharacters = new VerifyGroupOfCharacters(password);

        contains.put("digitVerify", digitVerify.verifyCharacters());
        contains.put("lowerCaseLetter", lowerCaseLetter.verifyCharacters());
        contains.put("passwordLength", passwordLength.verifyCharacters());
        contains.put("upperCaseLetter", upperCaseLetter.verifyCharacters());
        contains.put("verify group of characters", verifyGroupOfCharacters.verifyCharacters());

        for (String valuable : contains.keySet()) {
            if (valuable.equals("digitVerify") && contains.get(valuable) == 0) {
                {
                    errrorr = false;
                    errorCount++;
                    digitVerify.error();
                }
            } else if (valuable.equals("lowerCaseLetter") && contains.get(valuable) == 0) {
                {
                    errrorr = false;
                    errorCount++;
                    lowerCaseLetter.error();
                }
            } else if (valuable.equals("passwordLength") && contains.get(valuable) == 0) {
                {
                    errrorr = false;
                    errorCount++;
                    passwordLength.error();
                }
            } else if (valuable.equals("upperCaseLetter") && contains.get(valuable) == 0) {
                errrorr = false;
                errorCount++;
                upperCaseLetter.error();
            } else if (valuable.equals("verify group of characters") && contains.get(valuable) != 0) {

                if (errrorr) {
                    /*
                    If all the requirements are checked, we must apply changes only at the characters groups.
                     */
                    errorCount = errorCount + contains.get(valuable);
                    errrorr = false;
                } else {
                    /*
                     If all the requirements aren't checked, we must replace wrong groups with missed characters.(where we can)
                     */
                    errorCount = errorCount + contains.get(valuable) - 1;
                }
                verifyGroupOfCharacters.error();
            }

        }
        if (errrorr) {
            return "password is correct";
        } else {
            System.out.println();
            System.out.println("you need " + errorCount + " more changes");
            return "password incorrect";
        }
    }
}
