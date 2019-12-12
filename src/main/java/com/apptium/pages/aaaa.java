package com.apptium.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class aaaa {

    public static void main(String[] args) {
        List<String > deneme = new ArrayList<String>();
        deneme.add("zld 93 12");
        deneme.add("fp kindle book");
        deneme.add("10a echo show");
        deneme.add("17g 12 25 6");
        deneme.add("ab1 kindle book");
        deneme.add("125 echo dot second generation");

        System.out.println(reorderLogFiles(deneme));
    }
    public static List<String> reorderLogFiles(List<String> logs) {

            String[] str = new String[logs.size()];
            for(int i=0;i<logs.size();i++){
                str[i]= logs.get(i);
            }
             Comparator<String> myComp = new Comparator<String>() {
     @Override
           public int compare(String s1, String s2) {
             String[] split1 = s1.split(" ", 2);
             String[] split2 = s2.split(" ", 2);
             List<String> sp1= new ArrayList<>();
         List<String> sp2= new ArrayList<>();
             for (int i =0; i<split1.length;i++){
                 sp1.add(split1[i]);

             }
          for (int i =0; i<split2.length;i++){
             sp2.add(split2[i]);

         }

             boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
             if(!isDigit1 && !isDigit2) {
              int comp = split1[1].compareTo(split2[1]);
             if(comp != 0)
               return comp;
                return split1[0].compareTo(split2[0]);
            }
              return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
           }
        };
      Arrays.sort(str, myComp);
      List<String> words = new ArrayList<>();
      for(int i=0;i<str.length;i++){
          words.add(str[i]);
      }
        return words;
     }
}
