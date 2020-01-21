//This program is an implementation of the binary knapsack and fractional knapsack algorithms
/*
Weights     Cost
24          20
46          35
19          16
67          27
26          10

Max weight : 105
*/

class knapsack {
    public static void main(String[] args) {
        int[] weights = {24,46,19,67,26};
        int[] costs = {20,35,16,27,10};
        int maxWeight = 105;

        binaryKnap(weights, costs, maxWeight);
        fractionalKnap(weights, costs, maxWeight);
    }

    public static void binaryKnap(int[] weights, int[] costs,int maxWeight) {
        int i,flag = 0; //flag will be 1 when there is a choice of another weight
        int maxIndex = 0; //Assuming the first index of costs has the max cost
        int sumWeights = 0, costSum = 0;

        while(true) {
            for(i = 0; i < weights.length; i++) {
                if((sumWeights + weights[i] <= maxWeight) && costs[i] >= costs[maxIndex]) {
                    maxIndex = i;
                    flag = 1;
                }
            }
            if(flag == 0) { //No weight has been selected
                break;
            }
            sumWeights = sumWeights + weights[maxIndex];
            costSum = costSum + costs[maxIndex];
            flag = 0;
            maxIndex = 0;
        }

        System.out.println("Binary max cost : " + costSum);
    }

    public static void fractionalKnap(int[] weights, int[] costs,int maxWeight) {
        int i;
        int weightIndex = 0,sumWeights = 0,chosenWI = 0;
        double costSum = 0.0,costIndex = 0.0,maxCost = 0.0;

        while(sumWeights != maxWeight) {
            for(i = 0; i < weights.length; i++) {
                if(maxWeight - sumWeights >= weights[i]) {
                    weightIndex = weights[i];
                    costIndex = costs[i];
                }
                else {
                    weightIndex = maxWeight - sumWeights;
                    costIndex = ((double)weightIndex / weights[i]) * costs[i];
                }
                if(costIndex > maxCost) {
                    maxCost = costIndex;
                    chosenWI = weightIndex;
                }
            }
            sumWeights = sumWeights + chosenWI;
            costSum = costSum + maxCost;
            maxCost = 0.0;
        }
        System.out.println("Fractional max cost : " + Math.round(costSum));
    }
}