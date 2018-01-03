package bank;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {

    public static void main(String[] args) {
        System.out.println("Есть номиналы 1,2,5,10,20,50,100,200,500 грн.");
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500};
        int[] result =  new int[denominations.length];/*result[i] содержит кол-во купюр номиналом denominations[i]*/
        
        System.out.print("Введите необходумую сумму вывода(грн): ");
        Scanner input = new Scanner(System.in);
        String count_str = input.nextLine();
        
        if(Bank.checkInt(count_str) == false) System.out.println("Данная сумма не может быть выдана...");
        else {
            int count = Integer.parseInt(count_str);
            for(int i = denominations.length - 1; i >= 0; i--){
                if((count % denominations[i]) == 0){/*Сумма нацело делится на данный нoминал*/
                    result[i] = count / denominations[i];
                    break;
                }
                if(count > denominations[i]){/*Сумма больше данного номинала*/
                    result[i] = (int) Math.floor(count / denominations[i]);
                    count -= result[i] * denominations[i];
                }
            }
            
            for(int i = result.length - 1; i >= 0; i--){
                if(result[i] != 0) System.out.println("Купюра " + denominations[i] + " грн. - " + result[i] + " шт.");

            }
        }
    }
    
    /**
     * Проверка указанной суммы на коректность
     * @param str Сумма, указанная пользователем
     * @return Результат проверки (true/false)
     */
    private static boolean checkInt(String str){
        Pattern p = Pattern.compile("^[1-9][0-9]{0,8}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }
    
}
