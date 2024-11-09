import java.util.Scanner;

public class BudgetManagement {
    public BudgetManagement(){
        System.out.println("是否需要设置预算？");
        Scanner in=new Scanner(System.in);
        while (true) {
            String reply=in.nextLine();

            if (reply.equals("yes")) {
                for(int i=0;i< budget.length;i++){
                    budget[i] =in.nextInt();
                }

                break;
            } else if(reply.equals("no")){
                break;
            }else {
                System.out.println("回答错误");
            }
        }

    }
    public double[] budget=new double[12];


}
