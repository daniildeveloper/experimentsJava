package experimentsjava.fibbonachi;

/**
 *Самы простой способ - это рекурсия. Вычислительная мощность явно хромает.
 * @author Lama
 */
public class FwRekursia {
    /**
     * Принимает на вход число, которое >= 0. С посмощью рекурсии вычисляем n-е число.
     * @param n - порядковый номер числа в последовательности Ф.
     * @return возвращает само число.
     */
    public static long fNumber(int n){
        if (n < 0 ){
            throw new IllegalArgumentException("");
        }
        if (n == 0 || n == 1){
            return 1;
        } else {
            return fNumber(n - 1) + fNumber(n - 2);
        }
    }

}
