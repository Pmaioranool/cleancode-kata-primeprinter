public class Exercise3 {
    /**
     *
     * @param amount price
     * @param type   Account status (NotRegistered = 1, SimpleCustomer = 2,
     *               ValuableCustomer = 3, MostValuableCustomer = 4)
     * @param years  Time in years that the client is our customer
     * @return THE PRICE
     */
    public double calculate(double amount, int type, int years) {
        double result = 0;
        double disc = (years > 5) ? (double) 5 / 100 : (double) years / 100;
        double numberFour = 0.5;
        double numberTwo = 0.1;
        // NotRegistered
        switch (type) {
            case 1:
                result = amount;
                return result;
            case 2:
                result = calculate(amount, disc, numberTwo);
                break;
            case 3:
                result = (0.7 * amount) - disc * (0.7 * amount);
                return result;
            case 4:
                result = calculate(amount, disc, numberFour);
                break;
            default:
                break;
        }
        return result;
    }

    public static double calculate(double amount, double disc, double magicNumber) {
        return (amount - (magicNumber * amount)) - disc * (amount - (magicNumber * amount));
    }
}