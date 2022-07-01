package dao_.test;

import dao_.dao.StudentDao;
import dao_.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestDao {
    @Test
    public void testStudentDao(){
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.queryMultiply("select * from students where id > ?", Student.class, 1);
        for (Student student : students) {
            System.out.println(student);

        }
        System.out.println("===单行数据===");
        Student student = studentDao.querySingle("select * from students where id = ?", Student.class, 1);
        System.out.println(student);

        System.out.println("===单列单值数据===");
        Object o = studentDao.queryScalar("select name from students where id = ?",  1);
        System.out.println(o);

        int num = studentDao.update("insert into students value (null, ?,?,?,?) ",  80, 11,"张无忌",12343444);
        System.out.println(num);


    }
}
