/**
 * @Auther:hsd
 * @Date:2021/3/4-03-04-18:59
 * @Description:
 * @version: 1.0
 */
//宝贝留的问题--------------------------------------
public class Test6 {
    public static void main(String[] args) {
        Digui d = new Test6().new Digui();
        System.out.println(d.dg(5));
    }

    class Digui {
        int sum = 0;
        public int dg(int m){

            if (m == 1){
                return 1;
            }
            else{
                sum = sum+ m +dg(m-1);
                return sum;
            }
        }
    }
}
