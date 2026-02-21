import java.util.*;

interface StudentRepository {
    void save(StudentRecord record);
    int count();
    List<StudentRecord> all();
}