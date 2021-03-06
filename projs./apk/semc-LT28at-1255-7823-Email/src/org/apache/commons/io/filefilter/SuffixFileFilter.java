package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.AbstractFileFilter;

public class SuffixFileFilter extends AbstractFileFilter implements Serializable {

   private final IOCase caseSensitivity;
   private final String[] suffixes;


   public SuffixFileFilter(String var1) {
      IOCase var2 = IOCase.SENSITIVE;
      this(var1, var2);
   }

   public SuffixFileFilter(String var1, IOCase var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("The suffix must not be null");
      } else {
         String[] var3 = new String[]{var1};
         this.suffixes = var3;
         IOCase var4;
         if(var2 == null) {
            var4 = IOCase.SENSITIVE;
         } else {
            var4 = var2;
         }

         this.caseSensitivity = var4;
      }
   }

   public SuffixFileFilter(List var1) {
      IOCase var2 = IOCase.SENSITIVE;
      this(var1, var2);
   }

   public SuffixFileFilter(List var1, IOCase var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("The list of suffixes must not be null");
      } else {
         String[] var3 = new String[var1.size()];
         String[] var4 = (String[])((String[])var1.toArray(var3));
         this.suffixes = var4;
         IOCase var5;
         if(var2 == null) {
            var5 = IOCase.SENSITIVE;
         } else {
            var5 = var2;
         }

         this.caseSensitivity = var5;
      }
   }

   public SuffixFileFilter(String[] var1) {
      IOCase var2 = IOCase.SENSITIVE;
      this(var1, var2);
   }

   public SuffixFileFilter(String[] var1, IOCase var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("The array of suffixes must not be null");
      } else {
         this.suffixes = var1;
         IOCase var3;
         if(var2 == null) {
            var3 = IOCase.SENSITIVE;
         } else {
            var3 = var2;
         }

         this.caseSensitivity = var3;
      }
   }

   public boolean accept(File var1) {
      String var2 = var1.getName();
      int var3 = 0;

      boolean var7;
      while(true) {
         int var4 = this.suffixes.length;
         if(var3 >= var4) {
            var7 = false;
            break;
         }

         IOCase var5 = this.caseSensitivity;
         String var6 = this.suffixes[var3];
         if(var5.checkEndsWith(var2, var6)) {
            var7 = true;
            break;
         }

         ++var3;
      }

      return var7;
   }

   public boolean accept(File var1, String var2) {
      int var3 = 0;

      boolean var7;
      while(true) {
         int var4 = this.suffixes.length;
         if(var3 >= var4) {
            var7 = false;
            break;
         }

         IOCase var5 = this.caseSensitivity;
         String var6 = this.suffixes[var3];
         if(var5.checkEndsWith(var2, var6)) {
            var7 = true;
            break;
         }

         ++var3;
      }

      return var7;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      String var2 = super.toString();
      var1.append(var2);
      StringBuffer var4 = var1.append("(");
      if(this.suffixes != null) {
         int var5 = 0;

         while(true) {
            int var6 = this.suffixes.length;
            if(var5 >= var6) {
               break;
            }

            if(var5 > 0) {
               StringBuffer var7 = var1.append(",");
            }

            String var8 = this.suffixes[var5];
            var1.append(var8);
            ++var5;
         }
      }

      StringBuffer var10 = var1.append(")");
      return var1.toString();
   }
}
