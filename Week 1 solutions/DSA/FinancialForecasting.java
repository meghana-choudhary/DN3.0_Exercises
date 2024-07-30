public class FinancialForecasting {
    public static double calcFutureValue(double currValue, double growthRate, int periods) {
        if (periods == 0) {
            return currValue;
        }
        return calcFutureValue(currValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double currentValue = 1000; 
        double growthRate = 0.05;    
        int periods = 10;           

        double futureValue = calcFutureValue(currentValue, growthRate, periods);

        System.out.println("Future Value after " + periods + " periods: " + Math.round(futureValue));
    }
}
