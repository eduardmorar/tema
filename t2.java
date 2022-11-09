import org.xml.sax.helpers.AttributeListImpl;

import java.util.ArrayList;
import java.util.Arrays;

public class t2 {


    // pain ;((((, de ce am facut asta?


    public static ArrayList<ArrayList<Integer>> positions(ArrayList a, ArrayList b)
    {
        ArrayList<ArrayList<Integer>> rez = new ArrayList<>(2);
        for(int z=0;z<2;z++){
            rez.add(new ArrayList<>());
        }
        for(int i=0;i < a.size()-1;i++)
        {
            for(int j=0;j<b.size()-1;j++)
            {
                if(a.get(i) == b.get(j))
                {
                        rez.get(0).add(i);
                        rez.get(1).add(j);
                }
            }
        }
        for(int i=0;i<rez.get(0).size()-1;i++)
        {
            if(rez.get(0).get(i)==rez.get(0).get(i+1)) {
                rez.get(0).remove(i+1);
                i--;
            }
        }
        for(int i=0;i<rez.get(1).size()-1;i++)
        {
            if(rez.get(1).get(i)==rez.get(1).get(i+1)) {
                rez.get(1).remove(i+1);
                i--;
            }
        }

        return rez;
    }
    public static void main(String[] args) {


        //ex1 #########################################################


        int[] array1 = new int[]{3,5,7,8,9,12,28};
        int[] array2 = new int[]{11,4,777,81,13449};
        int size1 = array1.length;
        int size2 = array2.length;
        for(int i = 0; i<size1;i++)
        {
            if(array1[i]<size2) {System.out.println(array2[array1[i]]);}
            else if(array1[i]>size2)
            {int c = array1[i];
                while(c>size1-1)
                {
                    c=c/2;
                }
                System.out.println(array1[c]);
            }
        }



        //ex2 jesus cred ca numa mai rau m-am complicat ###################################


        ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(1,2,3,4,2,5,5,5,5));
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(8,12,2,3));
        int a = 5;

        ArrayList<ArrayList<Integer>> list1 = positions(al1,al2);
        //System.out.println(list1);
        int count =0;
        for(int i=0;i< list1.get(0).size();i++)
        {
            int f = list1.get(0).get(i)-i;
            al1.remove(f);

        }
        for(int j=0;j< list1.get(1).size();j++)
        {
            int doubl = al2.get(list1.get(1).get(j))*2;
            al2.set(list1.get(1).get(j),doubl);
        }
        for(int i :al1){
            if(i==a) count++;
        }
        for(int i :al2){
            if(i==a) count++;
        }
        //System.out.println(list1);
        System.out.println(al1);
        System.out.println(al2);
        System.out.println(count);

        //ex3 ########################################################################

        ArrayList<String> arrstr1 = new ArrayList<>(Arrays.asList("The dogs"));
        ArrayList<String> arrstr2 = new ArrayList<>(Arrays.asList("MANY DOgs"));
        String str3 = "dog";


    }
}
