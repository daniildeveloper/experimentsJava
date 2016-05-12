
package experimentsjava.fibbonachi;

import java.math.BigInteger;

/**
 *
 * @author Lama
 */
public class FBigInt {
    public static BigInteger fNumber(int n){
        BigInteger f1 = BigInteger.valueOf(1);
        BigInteger f2 = BigInteger.valueOf(1);
        BigInteger result = BigInteger.valueOf(1);
        
        for (int i = 2; i <= n; i++){
            result = f1.add(f2);
            f1 = f2;
            f2 = result;
            
        }
        return result;
        
    }

}
