public class Income {
    public String date;
    public double num;
    public String type;
    public String note;

    public Income(){

    }
    public Income(String date, double num, String type,String note){
        if(num<0){
            System.out.println("输入的金额需大于零！");
            return ;
        }
        setDate(date);
        setNum(num);
        setType(type);
        setNote(note);
    }
public void setDate(String date){
        this.date=date;
}
public void setNum(double num){
        this.num=num;
}
public void setType(String type){
        this.type=type;
}

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate(){
        return date;
}
public double getNum(){
        return num;
}
public String  getType(){
        return type;
}

    public String getNote() {
        return note;
    }


    @Override
    public String toString() {
        return "日期: " + date + ", 收入: " + num + ", 类别: " + type + ", 备注: " + note;
    }

    public void print(){
        System.out.println("日期:"+getDate()+" 收入："+getNum()+" 类型"+getType()+" 备注："+getNote());
    }
}



class IncomeDemo{
    public static void main(String[] args){
        Income income=new Income("2024.09.30",100,"利息","");
        income.print();
    }
}