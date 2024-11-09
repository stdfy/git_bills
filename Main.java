import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static ArrayList<Income> incomes = new ArrayList<>();
    private static ArrayList<Out> outs = new ArrayList<>();

    public static void addIncome(String date, double num, String type, String note) {
        Income income = new Income(date, num, type,note);
        incomes.add(income);
    }

    public static void addOut(String date, double num, String type, String note) {
        Out out = new Out(date, num, type,note);
        outs.add(out);
    }

    public static void viewAllRecords() {
        System.out.println("\n--- 收入记录 ---");
        for (Income income : incomes) {
            System.out.println(income);
        }
        System.out.println("\n--- 支出记录 ---");
        for (Out out : outs) {
            System.out.println(out);
        }
    }
    public  static void viewRecords(){
        Scanner in=new Scanner(System.in);
        while (true) {
            System.out.println("请输入所要查询账单的日期：");
            String date = in.nextLine();
            boolean found = false;

            for (Income income : incomes) {
                if (date.equals(income.date)) {
                    System.out.println(income);
                    found = true;
                    break;
                }
            }
            for (Out out : outs) {
                if (date.equals(out.date)) {
                    System.out.println(out);
                    found = true;
                    break;
                }
            }

            if (found) {

                break;
            } else {
                System.out.println("查询不到此日期！");
            }
        }
    }

    public static void monthlyStatistics(String month){
        double totalIncome=0;
        double totalOut=0;
        Map<String, Double> typeAmountMap = new HashMap<>();
        for(Income i:incomes){
            if (month.equals(i.date.substring(0,7))){
                totalIncome+=i.num;

            }
        }
        System.out.println("总收入："+totalIncome);
        for(Out i:outs){
            if (month.equals(i.date.substring(0,7))){
                totalOut+=i.num;
                typeAmountMap.put(i.type,
                        typeAmountMap.getOrDefault(i.type, 0.0) + i.num);
            }
        }
        System.out.println("总支出："+totalOut);
        for (Map.Entry<String, Double> entry : typeAmountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n请选择操作: ");
            System.out.println("1. 记录收入");
            System.out.println("2. 记录支出");
            System.out.println("3. 查看所有记录");
            System.out.println("4. 查看账单");
            System.out.println("5. 预算管理");
            System.out.println("6. 月度统计");
            System.out.println("7. 退出系统");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":

                    System.out.print("输入日期 (YYYY-MM-DD): ");
                    String incomeDate = scanner.nextLine();
                    System.out.print("输入收入金额: ");
                    double incomeNum = Double.parseDouble(scanner.nextLine());
                    System.out.print("输入收入类别 (如工资、奖金等): ");
                    String incomeType = scanner.nextLine();
                    System.out.print("输入备注: ");
                    String incomeNote = scanner.nextLine();
                    addIncome(incomeDate, incomeNum, incomeType, incomeNote);
                    System.out.println("收入记录添加成功！");
                    break;

                case "2":
                    System.out.print("输入日期 (YYYY-MM-DD): ");
                    String outDate = scanner.nextLine();
                    System.out.print("输入支出金额: ");
                    double outNum = Double.parseDouble(scanner.nextLine());
                    System.out.print("输入支出类别 (如餐饮、交通、购物等): ");
                    String outType = scanner.nextLine();
                    System.out.print("输入备注: ");
                    String outNote = scanner.nextLine();
                    addOut(outDate,outNum,outType,outNote);
                    System.out.println("支出记录添加成功！");
                    break;

                case "3":
                    viewAllRecords();
                    break;

                case "4":
                    viewRecords();
                    break;

                case "5":
                    BudgetManagement budgetManagement=new BudgetManagement();
                    System.out.println("可用预算：");
                    String[] month={"01","02","03","04","05","06","07","08","09","10","11","12"};
                    for(int i=0;i<budgetManagement.budget.length;i++){
                        for (Out out:outs){
                            if (out.date.substring(5,7).equals(month[i])){
                                budgetManagement.budget[i]-=out.num;
                            }
                        }
                    }int i=1;
                    for(double d: budgetManagement.budget){

                        System.out.println(i+"月："+d);
                        i++;
                    }

                    break;

                case "6":
                    System.out.print("输入月份 (YYYY-MM): ");
                    String mon = scanner.nextLine();
                    monthlyStatistics(mon);
                    break;

                case "7":
                    System.out.println("退出系统");
                    return;

                default:
                    System.out.println("无效的选项，请重新选择");
                    break;
            }
        }
    }
}