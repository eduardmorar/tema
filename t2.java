import org.xml.sax.helpers.AttributeListImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class t2 {

    public static ArrayList<ArrayList<Integer>> reomve_duplicates(ArrayList<ArrayList<Integer>> arry, int index)
    {
        for(int i=0;i<arry.get(index).size()-1;i++)
        {
            if(arry.get(index).get(i)==arry.get(index).get(i+1)) {
                arry.get(index).remove(i+1);
                i--;
            }
        }
        return arry;
    }

    public static ArrayList<String> remove_string(ArrayList<String> words,ArrayList<Integer> index)
    {
        for(int i =0; i<index.size();i++){
            words.remove(index.get(i)-i);
        }
        return words;
    }

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

        rez = reomve_duplicates(rez,0);
        rez = reomve_duplicates(rez,1);

        return rez;

    }


    static ArrayList<Integer> positions(ArrayList<String> a, String b)
    {
        ArrayList<Integer> pos = new ArrayList<>();

        for(int i=0;i<a.size();i++){
            if(a.get(i).toLowerCase(Locale.ROOT).contains(b.toLowerCase(Locale.ROOT)))
                pos.add(i);
        }
        return pos;
    }

    static boolean contains_string(ArrayList<String> a, String b)
    {
        boolean has = false;
        for(int i=0;i<a.size();i++)
            if (a.get(i).toLowerCase(Locale.ROOT).contains(b.toLowerCase(Locale.ROOT))) has= true;


        return has;
    }

    static ArrayList<Integer> positions_exact_value(ArrayList<String> a, String b)
    {
        ArrayList<Integer> pos = new ArrayList<>();

        for(int i=0;i<a.size();i++){
            if(a.get(i).contains(b) && a.get(i).length()==b.length())
                pos.add(i);
        }
        return pos;
    }


    public static void main(String[] args) {


        //ex1 #########################################################


        int[] array1 = new int[]{3,5,7,8,9,12,28};
        int[] array2 = new int[]{11,4,777,81,13449};
        int size1 = array1.length;
        int size2 = array2.length;
        System.out.println("ex1:");

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
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(8,15,2,3));
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
        System.out.println("ex2:");
        System.out.println(al1);
        System.out.println(al2);
        System.out.println(count);

        //ex3 ############################################## de aici deja ii rau dar ii ora 22, si ma si uit la top gear

        ArrayList<String> arrstr1 = new ArrayList<>(Arrays.asList("The dogs are gone","doggo","dog","cat","pest"));
        ArrayList<String> arrstr2 = new ArrayList<>(Arrays.asList("MANY DOgs applesauce","why dog","dog","doggo","fish","pet"));
        ArrayList<Integer> arrind1;
        ArrayList<Integer> arrind2;

        String str3 = "dog";


        arrind1 = positions(arrstr1,str3);
        arrind2 = positions(arrstr2,str3);

        System.out.println("ex3:");
        System.out.println(arrind1);
        System.out.println(arrind2);
       // System.out.println(positions_exact_value(arrstr1,str3));
       // System.out.println(positions_exact_value(arrstr2,str3));

        //######### remove str that has substring #######
        remove_string(arrstr1,arrind1);
        remove_string(arrstr2,arrind2);



        System.out.println(arrstr1);
        System.out.println(arrstr2);

        if(!contains_string(arrstr1,str3) && !contains_string(arrstr2,str3))
        {
            String flettr = "";
            flettr = flettr + str3.charAt(0) + str3.charAt(1);

            if(arrstr1.size()>arrstr2.size())
            {
                arrstr2.add(flettr);
            }
            else arrstr1.add(flettr);
        }
        if(positions_exact_value(arrstr1,str3).size()>0 && positions_exact_value(arrstr2,str3).size()>0)
        {
            remove_string(arrstr1,positions_exact_value(arrstr1,str3));
            remove_string(arrstr2,positions_exact_value(arrstr2,str3));
            arrstr1.add(str3);
            arrstr2.add(1,str3);
        }


        //########### ex4###############

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        ArrayList<Integer> min = al1;
        if(min.size()>al2.size()) min = al2;

        ArrayList<String> longer = arrstr1;
        if(longer.size()<arrstr2.size()) longer = arrstr2;

        ArrayList<String> shorter = arrstr1;
        if(shorter.size()>arrstr2.size()) shorter = arrstr2;

        for(int i:min)
        {
            //System.out.println(i);
            if(i%2==0) map.put(i,shorter);
            if(i>10&&i<30) map.put(i,longer);
        }
        System.out.println("ex4:");
        System.out.println(map);
        
     }
}
