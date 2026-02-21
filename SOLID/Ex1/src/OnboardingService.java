import java.util.*;

public class OnboardingService {
    private final StudentRepository repository;

    public OnboardingService(StudentRepository repository) { this.repository = repository; }

    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);
        
        StudentInput input = new Parser().parse(raw);

        List<String> errors = new Validator().validate(input);
        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
        }

        String id = new IdGenerator().generate(repository);
        StudentRecord rec = new StudentRecord(id, input.name, input.email, input.phone, input.program);
        
        repository.save(rec);

        StudentFormatter fmt = new StudentFormatter();
        fmt.confirmation(repository, rec);
    }
}
