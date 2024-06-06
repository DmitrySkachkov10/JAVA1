package by.dmitry.messager.core.dto;

import java.time.LocalDate;
import java.util.Objects;


public class UserRegistration {

    private String login;
    private String password;
    private String fio;
    private LocalDate brDate;

    public UserRegistration() {
    }

    public UserRegistration(String login, String password, String fio, LocalDate brDate) {
        this.login = login;
        this.password = password;
        this.fio = fio;
        this.brDate = brDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getBrDate() {
        return brDate;
    }

    public void setBrDate(LocalDate brDate) {
        this.brDate = brDate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRegistration userRegistration)) return false;
        return Objects.equals(login, userRegistration.login) && Objects.equals(password, userRegistration.password) && Objects.equals(fio, userRegistration.fio) && Objects.equals(brDate, userRegistration.brDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, fio, brDate);
    }
}