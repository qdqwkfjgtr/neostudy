import java.util.Scanner;
public class Task {
    public static void main(String[] args) {
        System.out.println("Введите десятичное число");
        Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt();
        String solution=Calc.tenToSixteen(x);
        System.out.println("Шестнадцатиричный вид этого числа " +solution);
        String solution1 =Calc.tenToDouble(x);
        System.out.println("Двоичный вид этого чилса "+solution1);
        System.out.println("Введите двоичное число");
        x=scanner.nextInt();
        int solution2=Calc.doubleToTen(x);
        System.out.println("Десятичный вид этого числа "+solution2);

    }
}

class Calc {
    public static String tenToSixteen(int a) {
        String p = "";
        while (a >= 16) {
            int t = a%16;//промежуточная переменная,записывающая остаток
            a = a/16;
            if (t > 9) {
                switch (t) //преобразование 10-15 в буквы
                {
                    case 10:
                        p += "a";
                        break;
                    case 11:
                        p += "b";
                        break;
                    case 12:
                        p += "c";
                        break;
                    case 13:
                        p += "d";
                        break;
                    case 14:
                        p += "e";
                        break;
                    case 15:
                        p += "f";
                        break;
                }
            } else {
                p += t;

            }
        }
        if (a < 16)//запись последнего элемента встроку
            p += a;


        StringBuffer reversedStr = new StringBuffer(p).reverse();
        p = reversedStr.toString();
        return p;
    }


    public static String tenToDouble(int a){

        String p="";
        while (a !=0){
            int t=a%2;
            p+=t;
            a=a/2;

        }
        StringBuffer reversedStr = new StringBuffer(p).reverse();
        p = reversedStr.toString();
        return p;

    }
    public static int doubleToTen(int a){
        String p="";
        p+=a;
        int b,t;
        int res=0;
        for(int i=0;i<p.length();i++)
        {
            b=p.charAt(p.length()-1-i);//достаем символ с конца строки и узнаем 1 или 0
            if (b=='1'||b=='0'){
                if(b=='1')
                    t=1;
                else t=0;
            }else {
                System.out.println("Некорректный ввод");
                break;
            }
            res+=t*Math.pow(2,i);

        }
        return res;
    }
}
