package dsa.stackqueue.test;

import static dsa.stackqueue.main.ExpressionConverter.*;

public class ExpressionConverterTest {

    public static void main(String[] arg) {
        /*
        Infix: A * B + C ^ D - E / F
        Postfix: A B * C D ^ + E F / -

        Infix: (A + B) * (C - D) ^ E
        Postfix: A B + C D - E ^ *

        Infix: A ^ (B + C)
         Postfix: A B C + ^

         */

        //remove the space
        String infix = "(A+B)*(C-D)^E";
        String postfix = infixToPostfixConversion(infix);
        System.out.println(postfix);

       /*
       Infix: A * B + C ^ D - E / F
       Prefix: - + * A B ^ C D / E F

       Infix: (A + B) * (C - D) ^ E
       Prefix: * + A B ^ - C D E

       Infix: A ^ (B + C)
       Prefix: ^ A + B C
        */

        infix = "(A+B)*(C-D)^E";
        String prefix = infixToPrefixConversion(infix);
        System.out.println(prefix);


        /*
         Postfix: A B * C D ^ + E F / -
         Infix: ((A * B) + (C ^ D) - (E / F))

         Postfix: A B + C D - E ^ *
         Infix: ((A + B) * ((C - D) ^ E))

         Postfix: A B C + ^
         Infix: (A ^ (B + C))
         */
        postfix = "AB+CD-E^*";
        infix = postfixToInfixConversion(postfix);
        System.out.println(infix);

        /*
         Prefix: -+*AB^CD/EF
         Infix: (((A*B)+(C^D))-(E/F))

         Prefix: *+AB^-CDE
         Infix: ((A+B)*((C-D)^E))

        Prefix: ^A+BC
        Infix: (A^(B+C))
        */
        prefix = "*+AB^-CDE";
        infix = prefixToInfixConversion(prefix);
        System.out.println(infix);

        /*
        Postfix: AB*CD^+EF/-
        Prefix: -+*AB^CD/EF

        Postfix: AB+CD-E^*
        Prefix: *+AB^-CDE

        Postfix: ABC+^
        Prefix: ^A+BC
         */
        postfix = "AB+CD-E^*";
        prefix = postfixToPrefixConversion(postfix);
        System.out.println(prefix);

        /*
        Prefix: -+*AB^CD/EF
        Postfix: AB*CD^+EF/-

       Prefix: *+AB^-CDE
       Postfix: AB+CD-E^*

       Prefix: ^A+BC
       Postfix: ABC+^
         */

        prefix = "^A+BC";
        postfix = prefixToPostfixConversion(prefix);
        System.out.println(postfix);
    }
}
