package rf222cz_assign1;

/**
 * Created by ymafr on 2016-09-07.
 */
public class Fraction {
    public int n;
    public int d;

    public Fraction(int n, int d){
        this.n = n;
        this.d = d;
    }

    public int getNumerator(){
        return n;
    }
    public int getDenominator(){
        return d;
    }


    public boolean isNegative(){
        if(this.n < 0 && this.d < 0 || this.n > 0 && this.d > 0) return false; //negative+negative = positive
        return true;
    }
    public boolean isEqualTo(Fraction f) {
        int gcf;
        //decide witch of the fractions is lower than the other
        Fraction lowerNr = (this.d < f.getDenominator()) ? this : f;
        Fraction greaterNr = (this.d > f.getDenominator()) ? this : f;

        int dupD = lowerNr.getDenominator();
        int dupN = lowerNr.getNumerator();

        gcf = lowerNr.gcf();
        //Get the same denominator
        if(gcf != 1){
            while (dupD < greaterNr.getDenominator()){
                dupD = dupD * gcf;
                dupN = dupN * gcf;
                if(dupD == greaterNr.getDenominator() && dupN == greaterNr.getNumerator()){
                    return true;
                }
            }
        }
        return false;
    }

    int gcf(){
        //Find greatest common factor
        int a = this.getDenominator();
        int b = this.getNumerator();
        while(a!=0 && b!=0) {// until either one of them is 0
            int c = b;
            b = a%b;
            a = c;
        }

        return a+b; // either one is 0, so return the non-zero value
    }

//TODO: bryt ut? de är väldigt lika
    public Fraction add(Fraction f){
        Fraction sum;
        if(this.d != f.getDenominator()){
            //Get common denominator
            int newD = this.d * f.getDenominator();
            int newN = (this.n * f.getDenominator()) + (this.d*f.getNumerator());

            sum = new Fraction(newN, newD);
        }else{
            this.n = this.n + f.getNumerator();
            sum = new Fraction(this.n, this.d);
        }
        //check if simplyfing is possible
        System.out.println("Before simplifying: "+sum.toString());
        return new Fraction(sum.getNumerator()/sum.gcf(), sum.getDenominator()/sum.gcf());
    }
    public Fraction subtract(Fraction f){
        Fraction sum;
        if(this.d != f.getDenominator()){
            //Get common denominator
            int newD = this.d * f.getDenominator();
            int newN = (this.n * f.getDenominator()) - (this.d*f.getNumerator());

            sum = new Fraction(newN, newD);
        }else{
            this.n = this.n - f.getNumerator();
            sum = new Fraction(this.n, this.d);
        }
        //check if simplyfing is possible
        System.out.println("Before simplifying: "+sum.toString());
        return new Fraction(sum.getNumerator()/sum.gcf(), sum.getDenominator()/sum.gcf());
    }
    public Fraction multiply(Fraction f){
        //multiply Numerator(/top) and Denominator(/bottom) = new fraction
        Fraction sum = new Fraction(this.n * f.getNumerator(), this.d * f.getDenominator());

        //try simplifying
        System.out.println("Before simplifying: "+sum.toString());
        int gcf = sum.gcf();
        return new Fraction(sum.getNumerator()/gcf, sum.getDenominator()/gcf);
    }
    public Fraction divide(Fraction f){
        //Turns the second fraction upside down and them multiplying
        return this.multiply(new Fraction(f.getDenominator(), f.getNumerator()));
    }

    public String toString(){
        //check if a whole number
        if(this.d == 1){
            return ""+this.n; //?
        }
        return this.n+"/"+this.d;
    }

}
