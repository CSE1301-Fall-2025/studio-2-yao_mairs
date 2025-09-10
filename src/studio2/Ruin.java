public class Ruin {
    public static void main(String[]args){
        double startAmount = 2.0;
        double winChance = 0.3;
        double SuccessMoney = 4.0;
        double RuinMoney = 0.0;
        int totalSimulations = 10;
        int plays = 0;
        int ruins = 0;

        for(int days = 1; days <= totalSimulations; days++){
            while(startAmount>RuinMoney && startAmount <SuccessMoney)
            {
                double probability = Math.random();
                if(probability < winChance){
                startAmount+=2;
                plays++;

                }
                    else
                {
                    startAmount-=2;
                    plays++;
                }
            
            }

            System.out.println(days);
            System.out.println(plays);
            plays = 0;

            if(startAmount >= SuccessMoney){
                System.out.println("Success!");
            }
            else if(startAmount <= RuinMoney){
                System.out.println("Ruin!");
                ruins++;
            }
        startAmount = 2.0;
        }
        System.out.println(ruins);
        double ruinRate = ((double)ruins / totalSimulations)*100;
        System.out.println(ruinRate+"%");

        double a = (1 - winChance)/winChance;
        double aStartAmount = Math.pow(a,startAmount);
        double awinLimit = Math.pow(a,SuccessMoney);
        double expectedRuin = (aStartAmount - awinLimit)/(1 - awinLimit);
        System.out.println("Expected Ruin Rate: " + expectedRuin*100 + "%");
    }
}