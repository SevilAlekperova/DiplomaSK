package models;

public class User {
    private final String login;
    private final String psw;

    public User(String login, String psw) {
        this.login = login;
        this.psw = psw;
    }

    public String getLogin() {
        return login;
    }

    public String getPsw() {
        return psw;
    }
}
