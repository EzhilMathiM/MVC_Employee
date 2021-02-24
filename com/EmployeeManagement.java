import java.io.IOException;
import com.ideas2it.employee.view.EmployeeView;

/**
 * Class EmployeeManagement is where the EmployeeManagement thread begins
 * EmployeeView class is accessed in order to get input from user.
 * @author Ezhilmathi.M
 * @created 24.02.2021
 */
public class EmployeeManagement {
    public static void main(String[] args) throws IOException {
        EmployeeView employeeView = new EmployeeView();
        employeeView.getChoice();
    }
}