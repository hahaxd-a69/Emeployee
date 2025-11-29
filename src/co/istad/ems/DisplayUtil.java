package co.istad.ems;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class DisplayUtil {

    public static void print(String text, boolean newLine) {
        if (newLine) System.out.println(text);
        else System.out.print(text);
    }

    public static void printMessage(String text) {
        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
        table.setColumnWidth(0, 50, 80);
        table.addCell(text);
        print(table.render(), true);
    }

    public static void printAppName() {
        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE);
        CellStyle center = new CellStyle(CellStyle.HorizontalAlign.center);
        table.setColumnWidth(0, 50, 80);
        table.addCell("EMPLOYEE MANAGEMENT SYSTEM", center);
        print(table.render(), true);
    }

    public static void printAppMenu() {
        print("=========== MENU ===========", true);
        print("1. List employees", true);
        print("2. Search employees", true);
        print("3. Add employee", true);
        print("4. Update employee", true);
        print("5. Delete employee", true);
        print("6. Sort employees", true);
        print("7. Toggle active/inactive", true);
        print("8. Show ACTIVE employees", true);
        print("9. Show INACTIVE employees", true);
        print("0. Exit", true);
    }

    public static void printEmployeeList(List<Employee> list) {
        if (list == null || list.isEmpty()) {
            print("No employee found!", true);
            return;
        }

        Table table = new Table(7, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("ID");
        table.addCell("NAME");
        table.addCell("GENDER");
        table.addCell("POSITION");
        table.addCell("DEPARTMENT");
        table.addCell("SALARY");
        table.addCell("ACTIVE");

        for (Employee e : list) {
            table.addCell(e.getEmpId());
            table.addCell(e.getName());
            table.addCell(e.getGender());
            table.addCell(e.getPosition());
            table.addCell(e.getDepartment());
            table.addCell(e.getSalary().toString());
            table.addCell(e.getActive().toString());
        }

        print(table.render(), true);
    }
}
