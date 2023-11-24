public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) throws Exception {
        if ((gender == 'ж' || gender == 'м') && isEmailCorrect(email)) {
            this.name = name;
            this.email = email;
            this.gender = gender;
        }
        else
            throw new Exception("Проверьте корректность введеного email и пола");
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public char getGender()
    {
        return gender;
    }

    public String toString()
    {
        return name + " (" + gender + ") " + email;
    }

    private boolean isEmailCorrect(String email)
    {
        return email.matches("\\S*@\\S*\\.\\S*");
    }
}
