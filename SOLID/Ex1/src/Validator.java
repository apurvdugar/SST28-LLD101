import java.util.*;
class Validator {

    // returns list of errors
    List<String> validate(StudentInput input) {

        String name = input.name;
        String email = input.email;
        String phone = input.phone;
        String program = input.program;

        List<String> errors = new ArrayList<>();
        if (name.isBlank()) errors.add("name is required");
        if (email.isBlank() || !email.contains("@")) errors.add("email is invalid");
        if (phone.isBlank() || !phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(program.equals("CSE") || program.equals("AI") || program.equals("SWE"))) errors.add("program is invalid");

        return errors;
    }
}