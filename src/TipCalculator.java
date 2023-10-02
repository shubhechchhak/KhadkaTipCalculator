import java.util.Scanner;
public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group: ");
        int people = scan.nextInt();
        scan.nextLine();
        System.out.print("What is your tip percentage (0-100): ");
        double percentage = scan.nextInt();
        scan.nextLine();

        double subCost = 0;
        double cost = 0;
        while (cost != -1) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            cost = scan.nextDouble();
            scan.nextLine();

            //adding to the cost
            subCost += cost;
        }
        subCost += 1;

        //calculating total tip
        percentage /= 100.00;
        double totalTip = percentage * subCost;
        double roundedTotalTip = Math.round(totalTip * 100.00) / 100.00; // I learned how to round from https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java

        //calculating total cost with total tip
        double totalCost = subCost + roundedTotalTip;
        double roundedTotalCost = Math.round(totalCost * 100.00) / 100.00;

        //calculating per person costs
        double personCost = subCost / people;
        double roundedPersonCost = Math.round(personCost * 100.00) / 100.00;
        double personTip = totalTip / people;
        double roundedPersonTip = Math.round(personTip * 100.00) / 100.00;
        double personTotal = personCost + personTip;
        double roundedPersonTotal = Math.round(personTotal * 100.00) / 100.00;

        //freestyle: service tax
        double serviceTax = roundedTotalCost * 0.08; //8% service tax imposed
        double roundedServiceTax = Math.round(serviceTax * 100.00) / 100.00;
        double finalCost = roundedServiceTax + roundedTotalCost;
        double roundedFinalCost = Math.round(finalCost * 100.00) / 100.00;

        int wholePercentage = (int) (percentage * 100);

        //summary portion of the bill
        System.out.println("--------------------------------------");
        System.out.println("Total bill before tip: $" + subCost);
        System.out.println("Total percentage: " + wholePercentage + "%");
        System.out.println("Total tip: $" + roundedTotalTip);
        System.out.println("Total bill with tip: $" + roundedTotalCost);
        System.out.println("Per person cost before tip: $" + roundedPersonCost);
        System.out.println("Tip per person: $" + roundedPersonTip);
        System.out.println("Total cost per person: $" + roundedPersonTotal);
        System.out.println("Total cost before service tax: $" + roundedTotalCost);
        System.out.println("Cost of service tax: $" + roundedServiceTax);
        System.out.println("Total bill with service tax: $" + roundedFinalCost);
    }
}
