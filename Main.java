import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Income> incomes = new ArrayList<>();
    private static ArrayList<Out> outs = new ArrayList<>();

    public static void addIncome(String date, double num, String type, String note) {
        Income income = new Income(date, num, type,note);
        incomes.add(income);
    }

    public static void addExpense(String date, double num, String type, String note) {
        Out out = new Out(date, num, type,note);
        outs.add(out);
    }

    public static void viewRecords() {
        System.out.println("\n--- 收入记录 ---");
        for (Income income : incomes) {
            System.out.println(income);
        }
        System.out.println("\n--- 支出记录 ---");
        for (Out out : outs) {
            System.out.println(out);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n请选择操作: ");
            System.out.println("1. 记录收入");
            System.out.println("2. 记录支出");
            System.out.println("3. 查看所有记录");
            System.out.println("4. 退出");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("输入日期 (YYYY-MM-DD): ");
                    String incomeDate = scanner.nextLine();
                    System.out.print("输入收入金额: ");
                    double incomeAmount = Double.parseDouble(scanner.nextLine());
                    System.out.print("输入收入类别 (如工资、奖金等): ");
                    String incomeCategory = scanner.nextLine();
                    System.out.print("输入备注: ");
                    String incomeRemark = scanner.nextLine();
                    addIncome(incomeDate, incomeAmount, incomeCategory, incomeRemark);
                    System.out.println("收入记录添加成功！");
                    break;

                case "2":
                    System.out.print("输入日期 (YYYY-MM-DD): ");
                    String expenseDate = scanner.nextLine();
                    System.out.print("输入支出金额: ");
                    double expenseAmount = Double.parseDouble(scanner.nextLine());
                    System.out.print("输入支出类别 (如餐饮、交通、购物等): ");
                    String expenseCategory = scanner.nextLine();
                    System.out.print("输入备注: ");
                    String expenseRemark = scanner.nextLine();
                    addExpense(expenseDate, expenseAmount, expenseCategory, expenseRemark);
                    System.out.println("支出记录添加成功！");
                    break;

                case "3":
                    viewRecords();
                    break;

                case "4":
                    System.out.println("退出系统");
                    return;

                default:
                    System.out.println("无效的选项，请重新选择");
                    break;
            }
        }
    }
}