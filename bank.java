package bank;
import java.util.Scanner;

public class Bank {

    public static void main(String[] args){
        System.out.println("Есть номиналы 1,2,5,10,20,50,100,200,500 грн.");
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500};
        int[] result =  new int[denominations.length];/*result[i] содержит кол-во купюр номиналом denominations[i]*/
        
        System.out.print("Введите необходумую сумму вывода(грн): ");
        Scanner input = new Scanner(System.in);
        
        try {
            int count = input.nextInt();
            for(int i = denominations.length - 1; i >= 0; i--){
                if((count % denominations[i]) == 0){
                    result[i] = count / denominations[i];
                    break;
                }
                if(count > denominations[i]){
                    result[i] = (int) Math.floor(count / denominations[i]);
                    count -= result[i] * denominations[i];
                }
            }
            for(int i = result.length - 1; i >= 0; i--){
                if(result[i] != 0) System.out.println("Купюра " + denominations[i] + " грн. - " + result[i] + " шт.");

            }
        } catch(Exception e) {
            System.out.println("Данная сумма не может быть выдана...");
        }
    }
    
}
