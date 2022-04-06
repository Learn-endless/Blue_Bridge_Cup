package 第十二届试题B卡片;

public class Main2 {
    public static void main(String[] args) {
        int kp[] = new int[10];

        //赋值
        for(int i = 0 ; i <= 9 ; i ++){
            kp[i] = 2021;//每种卡片2021张
        }
        System.out.println(def(kp));
    }


    public static int def(int kp[]){
        int i;
        for(i = 1 ; i < 20210 ; i ++){
            int t = i;
            while(t > 0 ){    

                kp[t%10]--;   
                //只要这玩意断片就给他结束
                if(kp[t%10] <= 0 ){
                    return i;
                }
                t /= 10;
            }
        }
        return 0;
    }
}