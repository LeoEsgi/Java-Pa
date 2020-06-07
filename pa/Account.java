package pa;

class Account {

    public enum AccountType {
        EMPLOYEE,
        FRANCHISE,
        CUSTOMER
    }

    String firstname;
    String lastname;
    String city;
    String country;
    AccountType type;
    boolean activated;

    public Account() {
    }

    public Account(String firstname, String lastname, String city, String country, AccountType type, boolean activated) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.country = country;
        this.type = type;
        this.activated = activated;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", type=" + type +
                ", activated=" + activated +
                '}';
    }
}
