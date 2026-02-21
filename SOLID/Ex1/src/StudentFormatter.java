class StudentFormatter {
    
    void confirmation(StudentRepository repository, StudentRecord rec) {
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + repository.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}