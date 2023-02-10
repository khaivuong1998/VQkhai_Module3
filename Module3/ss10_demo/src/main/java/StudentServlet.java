import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private List<Student> studentList = new ArrayList<>();

    public void init() {
        studentList.add(new Student(1, "Thắng", 5.9));
        studentList.add(new Student(2, "Kỳ", 7.8));
        studentList.add(new Student(3, "Duy", 4.6));
        studentList.add(new Student(4, "Huy", 8.8));
        studentList.add(new Student(5, "Huỳnh", 3.0));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
