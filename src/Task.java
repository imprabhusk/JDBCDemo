import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task {
    String url, username, password;

    public Task() {
        url = "jdbc:mysql://localhost:3306/jdbc";
        username = "prabhusk";
        password = "genius";
    }

    public void getTask11(Connection conn, Statement stmt) throws SQLException {
        String sql = "select * from students where last_name like \"kumar%\";";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 11 : Diplay student details where last name = \"kumar\"");

        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\ncourse_id \t= " + rs.getInt(2)
                    + "\nstd_name \t= " + rs.getString(3)
                    + "\nlast_name \t= " + rs.getString(4)
                    + "\nstd_dob \t= " + rs.getString(5)
                    + "\nstd_addr \t= " + rs.getString(6)
                    + "\nstd_doj \t= " + rs.getString(7)
                    + "\nstd_gender \t= " + rs.getString(8));
        }
    }

    public void getTask12(Connection conn, Statement stmt) throws SQLException {
        String sql = "select * from students where last_name like \"s%n\";";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 12 : Display students details whose last_name starts with 's' ends with 'n'");

        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\ncourse_id \t= " + rs.getInt(2)
                    + "\nstd_name \t= " + rs.getString(3)
                    + "\nlast_name \t= " + rs.getString(4)
                    + "\nstd_dob \t= " + rs.getString(5)
                    + "\nstd_addr \t= " + rs.getString(6)
                    + "\nstd_doj \t= " + rs.getString(7)
                    + "\nstd_gender \t= " + rs.getString(8));
        }
    }

    public void getTask13(Connection conn, Statement stmt) throws SQLException {
        String sql = "select * from students where last_name like \"SURESH%\"";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 13 : Display student details in case sensitive and case insensitive type");

        System.out.println("\ncase insensitive comparision");
        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\ncourse_id \t= " + rs.getInt(2)
                    + "\nstd_name \t= " + rs.getString(3)
                    + "\nlast_name \t= " + rs.getString(4)
                    + "\nstd_dob \t= " + rs.getString(5)
                    + "\nstd_addr \t= " + rs.getString(6)
                    + "\nstd_doj \t= " + rs.getString(7)
                    + "\nstd_gender \t= " + rs.getString(8));
        }

        String sql1 = "select * from students where binary last_name like \"SURESH%\"";
        ResultSet rs1 = stmt.executeQuery(sql1);
        System.out.println("\ncase sensitive comparision");
        try {
            while (rs1.next()) {
                System.out.println("\nstd_id \t\t= " + rs1.getInt(1)
                        + "\ncourse_id \t= " + rs1.getInt(2)
                        + "\nlast_name \t= " + rs1.getString(3)
                        + "\nstd_name \t= " + rs1.getString(4)
                        + "\nstd_dob \t= " + rs1.getString(5)
                        + "\nstd_addr \t= " + rs1.getString(6)
                        + "\nstd_doj \t= " + rs1.getString(7)
                        + "\nstd_gender \t= " + rs1.getString(8));
            }
        } catch (Exception e) {
            System.out.println("\nNo Records Found for case sensitive comparision");
        }

    }

    public void getTask14(Connection conn, Statement stmt) throws SQLException {
        String sql = "select students.std_id, students.std_name, count(students.std_id) as no_of_games from students inner join studentActivity on students.std_id=studentActivity.std_id inner join sports on studentActivity.sports_id=sports.sports_id group by std_id;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 14 : Display students id, name and no games they are involved");
        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\nstd_name \t= " + rs.getString(2)
                    + "\nno_of_games \t= " + rs.getInt(3));
        }
    }

    public void getTask15(Connection conn, Statement stmt) throws SQLException {
        String sql = "select students.std_id, students.std_name, sports.sports_name from students inner join studentActivity on students.std_id=studentActivity.std_id inner join sports on studentActivity.sports_id=sports.sports_id;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 15 : Display students id, name and games they are involved");
        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\nstd_name \t= " + rs.getString(2)
                    + "\nsports_name \t= " + rs.getString(3));
        }
    }

    public void getTask16(Connection conn, Statement stmt) throws SQLException {
        String sql = "select students.std_id, students.std_name, sum(studentMark.sub_mark) as total_mark, avg(studentMark.sub_mark) as average_mark from students inner join studentMark on students.std_id=studentMark.std_id group by std_id;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 16 : Display students id, name, total and average of their marks");
        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\nstd_name \t= " + rs.getString(2)
                    + "\ntotal_mark \t= " + rs.getInt(3)
                    + "\naverage_mark \t= " + rs.getInt(4));
        }
    }

    public void getTask17(Connection conn, Statement stmt) throws SQLException {
        String sql = "select students.std_id, students.std_name,  avg(studentMark.sub_mark) as average_mark from students inner join studentMark on students.std_id=studentMark.std_id group by std_id having average_mark>65;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 17 : Display students id, name whose average mark greater than 65");
        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\nstd_name \t= " + rs.getString(2)
                    + "\naverage_mark \t= " + rs.getInt(3));
        }
    }

    public void getTask18(Connection conn, Statement stmt) throws SQLException {
        String sql = "select students.std_id, students.std_name, sum(studentMark.sub_mark) as total_mark,  avg(studentMark.sub_mark) as average_mark from students inner join studentMark on students.std_id=studentMark.std_id group by std_id having average_mark>80 and average_mark<90;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 18 : Display students id, name, total and average mark > 80 and < 90");
        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\nstd_name \t= " + rs.getString(2)
                    + "\ntotal_mark \t= " + rs.getInt(3)
                    + "\naverage_mark \t= " + rs.getInt(4));
        }
    }

    public void getTask19(Connection conn, Statement stmt) throws SQLException {
        String sql = "select students.std_id, students.std_name, sum(studentMark.sub_mark) as total_mark,  avg(studentMark.sub_mark) as average_mark from students inner join studentMark on students.std_id=studentMark.std_id group by std_id order by average_mark desc limit 1;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 19 : Display students id, name, total and average mark which is greater");
        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\nstd_name \t= " + rs.getString(2)
                    + "\ntotal_mark \t= " + rs.getInt(3)
                    + "\naverage_mark \t= " + rs.getInt(4));
        }
    }

    public void getTask20(Connection conn, Statement stmt) throws SQLException {
        String sql = "select students.std_id, students.std_name, sum(studentMark.sub_mark) as total_mark,  avg(studentMark.sub_mark) as average_mark from students inner join studentMark on students.std_id=studentMark.std_id group by std_id order by average_mark desc limit 5;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 20 : Display students id, name, total and average mark of top 5 students");
        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\nstd_name \t= " + rs.getString(2)
                    + "\ntotal_mark \t= " + rs.getInt(3)
                    + "\naverage_mark \t= " + rs.getInt(4));
        }
    }

    public void getTask21(Connection conn, Statement stmt) throws SQLException {
        String sql = "select students.std_id, students.std_name, sum(studentMark.sub_mark) as total_mark,  avg(studentMark.sub_mark) as average_mark from students inner join studentMark on students.std_id=studentMark.std_id group by std_id order by average_mark limit 1;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 21 : Display students id, name, total and average mark of lowest mark");
        while (rs.next()) {
            System.out.println("\nstd_id \t\t= " + rs.getInt(1)
                    + "\nstd_name \t= " + rs.getString(2)
                    + "\ntotal_mark \t= " + rs.getInt(3)
                    + "\naverage_mark \t= " + rs.getInt(4));
        }
    }

    public void getTask22(Connection conn, Statement stmt) throws SQLException {
        String sql = "select subjectTeachers.teacher_id, subjectTeachers.sub_id,subjects.sub_name, teachers.teacher_name from subjectTeachers inner join teachers on subjectTeachers.teacher_id=teachers.teacher_id inner join subjects on subjectTeachers.sub_id=subjects.sub_id;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 22 : Display name of a teacher who is teaching which subject and its name");
        while (rs.next()) {
            System.out.println("\nteacher_id \t= " + rs.getInt(1)
                    + "\nsubject_id \t= " + rs.getInt(2)
                    + "\nsubject_name \t= " + rs.getString(3)
                    + "\nteacher_name \t= " + rs.getString(4));
        }
    }

    public void getTask23(Connection conn, Statement stmt) throws SQLException {
        String sql = "select subjectTeachers.teacher_id, subjectTeachers.course_id, subjects.sub_id, Teachers.teacher_name, subjects.sub_name, courses.course_name from subjectTeachers inner join courses on subjectTeachers.course_id=courses.course_id inner join subjects on subjectTeachers.sub_id=subjects.sub_id inner join teachers on subjectTeachers.teacher_id=teachers.teacher_id;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(
                "\n\nTask - 23 : Display name of a teacher who is teaching which subject, course id and which course");
        while (rs.next()) {
            System.out.println("\nteacher_id \t= " + rs.getInt(1)
                    + "\ncourse_id \t= " + rs.getInt(2)
                    + "\nsubject_id \t= " + rs.getInt(3)
                    + "\nteacher_name \t= " + rs.getString(4)
                    + "\nsubject_name \t= " + rs.getString(5)
                    + "\ncourse_name \t= " + rs.getString(6));
        }
    }

    public void getTask24(Connection conn, Statement stmt) throws SQLException {
        String sql = "select students.std_name, upper(students.std_name) as uppercase_std_name from students;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 24 : Display all students name in uppercase");
        while (rs.next()) {
            System.out.println("\nstd_name \t\t= " + rs.getString(1)
                    + "\nuppercase_std_name \t= " + rs.getString(2));
        }
    }

    public void getTask25(Connection conn, Statement stmt) throws SQLException {
        String sql = "select students.std_name from students inner join studentActivity on students.std_id=studentActivity.std_id inner join sports on  sports.sports_id=studentActivity.sports_id group by std_name;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nTask - 25 : Display all the students who are participating in sports activity");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(task.url, task.username, task.password);
            Statement stmt = conn.createStatement();

            task.getTask11(conn, stmt);
            task.getTask12(conn, stmt);
            task.getTask13(conn, stmt);
            task.getTask14(conn, stmt);
            task.getTask15(conn, stmt);
            task.getTask16(conn, stmt);
            task.getTask17(conn, stmt);
            task.getTask18(conn, stmt);
            task.getTask19(conn, stmt);
            task.getTask20(conn, stmt);
            task.getTask21(conn, stmt);
            task.getTask22(conn, stmt);
            task.getTask23(conn, stmt);
            task.getTask23(conn, stmt);
            task.getTask25(conn, stmt);

        } catch (ClassNotFoundException e) {
            System.out.println(new Exception("Class not found"));
        } catch (SQLException e) {
            System.out.println(new Exception("Sql Exception occured"));
        }
    }
}