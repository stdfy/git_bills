public class Income {
    public int date;
    public double num;
    public String type;

    public Income(){


    }

public void setData(int date){
        this.date=date;
}
public void setNum(double num){
        this.num=num;
}
public void setType(String type){
        this.type=type;
}
public int getDate(){
        return date;
}
public double getNum(){
        return num;
}
public String  getType(){
        return type;
}
public void record(int date,double num,String type){
    if(num<0){
        System.out.println("输入的金额需大于零！");
        return ;
    }
    date+=date;
    num+=num;
    type+=type;
}
public void print(){
    System.out.println("日期:"+getDate()+" 收入："+getNum()+" 类型"+getType());
}
}
