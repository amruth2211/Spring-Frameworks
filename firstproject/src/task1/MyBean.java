package task1;


class MyBean{
    String firstName,lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static MyBean getInstance(){
        return new MyBean();
    }

    @Override
    public String toString() {
        return "MyBean [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
    
}