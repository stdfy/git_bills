public class Out {

    public String date;
    public double num;
    public String type;
    public String note;
    public Out(){

    }
    public Out(String date, double num, String type,String note){
        if(num<0){
            System.out.println("输入的金额需大于零！");
            return ;
        }
        setDate(date);
        setNum(num);
        setType(type);
        setNote(note);
    }

    public String getNote() {
        return note;
    }

    public String getDate() {
        return date;
    }

    public double getNum() {
        return num;
    }

    public String getType() {
        return type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public void print(){
        System.out.println("日期:"+getDate()+" 支出："+getNum()+" 类型"+getType()+" 备注："+getNote());
    }
}
