class IdGenerator {

    String generate (StudentRepository repository) {
        return IdUtil.nextStudentId(repository.count());
    }
}