import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private List<Customer> customerList = new ArrayList<>();
    public void init() {
        customerList.add(new Customer(1,"Mai Văn Hoàn","1983-08-20","Hà Nội","https://hinhgaixinh.com/wp-content/uploads/2022/03/anh-gai-xinh-hoc-sinh-tuyet-dep.jpg"));
        customerList.add(new Customer(2,"Nguyễn Văn Nam","1983-08-21","Bắc Giang","https://zilo.vn/wp-content/uploads/2022/03/hinh-anh-gai-xinh-dep-cute-lam-anh-dai-dien-16.jpg"));
        customerList.add(new Customer(3,"Nguyễn Thái Hòa","1983-08-22","Nam Định","https://file.vfo.vn/hinh/2018/02/top-nhung-hinh-anh-gai-dep-gai-xinh-nhat-hien-nay-1.png"));
        customerList.add(new Customer(4,"Trần Đăng Khoa","1983-08-17","Hà Tây","https://luv.vn/wp-content/uploads/2021/10/hinh-nen-gai-xinh-9-1.jpg"));
        customerList.add(new Customer(5,"Nguyễn Đình Thi","1983-08-29","Hà Nội","https://pdp.edu.vn/wp-content/uploads/2021/06/hinh-anh-gai-xinh-nhat-ban-de-thuong-1.jpg"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
