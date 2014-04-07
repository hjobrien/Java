// A Name object represents a name such as "John Q. Public".

public class Name {
    String firstName;
    char middleInitial;
    String lastName;

    // The name in normal order such as "John Q. Public".
    public String getNormalOrder() {
        return firstName + " " + middleInitial +
               ". " + lastName;
    }

    // The name in reverse order such as "Public, John Q.".
    public String getReverseOrder() {
        return lastName + ", " + firstName +
               " " + middleInitial + ".";
    }
}
