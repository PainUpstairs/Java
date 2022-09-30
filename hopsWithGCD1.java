import java.util.*;

public class hopsWithGCD1 {

    static public int gcd(int a, int b){

        int value;
        if( a<b ) {
            value = gcd( b, a);
            return value ;
        }else{ 
            int temp = a%b;
            if ( temp == 0 ){
                if( b == 1) return 1;
                else return b;
            }
            return gcd(b, temp );
        }


    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 22, 66 ));
        // System.out.println(gcd( 134124,42424));

        boolean _flag = true;
        for( int i: arr){
            _flag = true;
            for( int j : arr){
                int temp = gcd( i, j );
                if( temp == 1) {
                    _flag = false;
                    break;
                }
            }
            if(_flag) break;
        }
        System.out.println( _flag);
    }
}
