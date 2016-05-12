
package experimentsjava.fibbonachi;

/**
 *вычисляем фиббоначи с помощью цикла
 * 
 * Хотя по сравнению с рекурсией он обладает явным премуществом, но все же при n = 92, производительность падает.
 * @author Lama
 */
public class FLoop {
    /**
     * Функция, которая вычисляет n-e число фибоначчи с помощью цикла.
     * @param n - порядковый номер.
     * @return число по порядковому номеру n
     */
    public static long fNumber(int n){
        if (n < 0) throw new IllegalArgumentException("n < 0");
        long f1 = 1;
        long f2 = 1;
        long result = 1;
        for (int i = 2; i <= n; i++){
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        
        return result;
    }

}
