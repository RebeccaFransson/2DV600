package rf222cz_assign1;

/**
 * Created by ymafr on 2016-09-07.
 */
public class FractionMain {
    public static void main(String[] args){
        Fraction fraction = new Fraction(4, 12);
        Fraction fraction2 = new Fraction(3, 8);
        Fraction fractionEqual = new Fraction(2, 6);
        Fraction fractionNegative = new Fraction(-4, 12);
        Fraction fractionAdd = new Fraction(1, 4);
        Fraction fractionSub = new Fraction(2, 12);

        //equal
        if(fraction.isEqualTo(fractionEqual))
            System.out.println(fraction.toString()+" is equal to "+fractionEqual.toString());
        //not equal
        if(!fraction.isEqualTo(fraction2))
            System.out.println(fraction.toString()+" is NOT equal to "+fraction2.toString());
        //neg
        if(fractionNegative.isNegative())
            System.out.println(fractionNegative.toString()+" is negative");

        //add
        System.out.println("---- Adding: "+fraction.toString()+" + "+fractionAdd.toString()+" ----");
        Fraction sum = fraction.add(fractionAdd);
        System.out.println("* Answer = "+sum.toString());

        //sub
        System.out.println("---- Subtracting: "+fraction.toString()+" - "+fractionSub.toString()+" ----");
        sum = fraction.subtract(fractionSub);
        System.out.println("* Answer = "+sum.toString());

        //multiply
        System.out.println("---- Multiply: "+fraction.toString()+" * "+fraction2.toString()+" ----");
        sum = fraction.multiply(fraction2);
        System.out.println("* Answer = "+sum.toString());

        //divide
        System.out.println("---- Dividing: "+new Fraction(1, 2).toString()+" / "+new Fraction(1, 6).toString()+" ----");
        sum = new Fraction(1, 2).divide(new Fraction(1, 6));
        System.out.println("* Answer = "+sum.toString());
    }
}
