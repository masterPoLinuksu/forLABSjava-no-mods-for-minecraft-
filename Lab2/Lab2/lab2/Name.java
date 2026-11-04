package lab2;
class Name {
    public String surname;
    public String firstName;
    public String patronymic;

    public Name(String surname, String firstName, String patronymic) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String toString() {
        String result = "";
        if (surname != null) {
            result = result + surname + " ";
        }
        if (firstName != null) {
            result = result + firstName + " ";
        }
        if (patronymic != null) {
            result = result + patronymic + " ";
        }
        return result.trim();
    }
}