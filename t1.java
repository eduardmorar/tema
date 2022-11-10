import java.util.Arrays;


public class t1 {
    public static int number_of_5(int a,int b,int c){
        int n=0;
        int[] list5 = make_ordered_list(a,b,c);
        for(int i:list5){
            if(i%5==0) n++;
        }
        return n;

    }
    public static int[] make_ordered_list(int a, int b, int c){
        int[] list = new int[] {a,b,c};
        Arrays.sort(list);
        return list;
    }
    public static int[] make_ordered_list(int a, int b, int c,int d) {
        int[] list = new int[] {a, b, c, d};
        Arrays.sort(list);
        return list;
    }
    public static boolean check_str(String a, char b){
        for (int i =0;i<a.length();i++)
        {
            if(a.charAt(i)==b) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        //ex1 ###########################################
        int a = 5, b = 5 , c = 17 ;

        switch (number_of_5(a,b,c))
        {
            case (0):
                a = a * 3;
                b = b * 3;
                c = c * 3;
                int[] list0 = make_ordered_list(a, b, c);
                System.out.println(list0[0]);
                System.out.println(list0[1] + list0[2]);
                break;

            case (1):
                if (a == 13 || b == 13 || c == 13)
                {
                    int[] list1 = make_ordered_list(a, b, c);
                    System.out.println(list1[0]);
                }
                break;

            case (2):
                int[] list3 = make_ordered_list(a, b, c);
                for (int i : list3)
                {
                    if (i > 7) System.out.println(i);
                }
                break;
        }


        //ex2 #####################################

        int d = 2;

            switch (d)
            {
                case 2:
                    System.out.println("val is 2");
                    break;
                case 13:
                    System.out.println("val is 13");
                    break;
                case 98:
                    System.out.println("val is 98");
                    break;
                case 365:
                    System.out.println("val is 365");


            }


            //ex3 ##########################################

        boolean bool = true;
            if(bool)
            {
                a+=20;
                b+=20;
                c+=20;
                d+=20;
                int[] list3 =make_ordered_list(a,b,c,d);
                for(int i:list3)
                {
                    if(i>30) System.out.println(i);
                }
            }
            else
            {
                a*=10;
                b*=10;
                c*=10;
                d*=10;
                int[] list4 = make_ordered_list(a,b,c,d);
                for(int i:list4)
                {
                    if(i%7==0) System.out.println(i);
                }
            }

            //ex4 ##############################################


            String w1 = "wor";
            String w2 ="oord";
            char c1 = 'w';
            int len = w1.length();
            if(!check_str(w1,c1) && len>3)
            {
                w2 = w2 + c1 + w1.charAt(len-3) + w1.charAt(len-2) + w1.charAt(len-1) + c1;
            }
            if(!check_str(w1,c1)&& len<=3)
            {
                w2 = w2 + c1+ w1;
            }
        System.out.println(w2);
    }
}
