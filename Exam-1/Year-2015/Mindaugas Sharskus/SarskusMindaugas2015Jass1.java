
import java.io.*;	// Ignore 1
import java.util.Scanner;

/*
Mindaugas Sharskus
Conaght Weight Management Solutions - Lab exam 2015     // this coment should be before import's
*/

public class SarskusMindaugas2015Jass1
{
    public static void main(String[] args)throws FileNotFoundException // Ignore 2
    {
	// Line below reads file "TestBMI.txt". No need manualy ener values. Makes life easier	 
        Scanner input = new Scanner(new FileReader("TestBMI.txt")); // Ignore 3

        //
        //	Groop variable, few in line. Otherwise loose marks ~5%
        //
        final double
                // Price related constants
                COST_UNDER_WEIGHT = 100.00,
                COST_NORMAL_WEIGHT = 120.00,
                COST_OVER_WEIGHT = 155.00,
                COST_SEVERE_WEIGHT = 200.00,
                COST_TSHIRT = 5.00,
                VAT = .23,              // 23%
                //Discount related constants
                DIS_FRIEND = .02,       // 2%
                DIS_CLIENT = .035,      // 3.5%
                DIS_CORPORATE = .04,    // 4%
                DIS_PREMIUM = .02,      // 2% per 150 spend. max 6%
                DIS_PREM_MAX = .06,     // 6%
                DIS_PREM_SUM_MIN = 150.00,
                DIS_PREM_SUM_MAX = 450.00;
        double
                // Custumer related variables
                cusKilos,
                cusMeters,
                cusPromo,
                bmiNumber,
                // Cost related variables
                costPackage = .0,
                costFull = .0,
                costVAT,
                costFinal,
                disAmount = .0,
                costMaxPack = .0,
                costMinPack = .0,
                // Totals
                totalPack = .0,
                totalDisc = .0,
                totalPromo = .0,
                totalFullCost = .0,
                totalVAT = .0,
                totalFinal = .0;
        int
                month,
                totalClients,
                clientHighest = 0,
                clientLowest = 0;

        char
                disType,
                tshirtNeed,
                bmiType = '_';

        // Line below for manualy enter values. Should be on exam.
        // Scanner input = new Scanner(System.in);

        System.out.println("Enter number of clients: ");
        totalClients = input.nextInt();

        System.out.println(     // it's ok to do like this.
                "Lab exam 1(2015)                     Client   BMI       BMI   Package  Discount   Promo   Full    Vat     Final\n"
              + "Mindaugas Sharskus                   Number   Number    Type  Cost     Amount     Value   Cost    Cost    Cost");


        // Print '='
        int lineLength = 115;
        for(int line = lineLength ; line > 0; line--)  System.out.print("=");	// Loose marks. Do println() insted
        System.out.println();

        for(int i = 1; i <= totalClients; i++){ // declare i outside loop. loose marks.

            System.out.println("Kilos/Meters/Month/TShirt/Disc/Promo/:");
            cusKilos = input.nextDouble();
			cusMeters = input.nextDouble();
			month = input.nextInt();
			tshirtNeed = input.next().charAt(0);
			disType = input.next().charAt(0);
			cusPromo = input.nextDouble();

            bmiNumber = cusKilos / (cusMeters * cusMeters);

            // Finde Package type and cost
            // I think tshirt should be add here but..
            if(bmiNumber < 18.5){
                bmiType = 'U';
                costPackage = COST_UNDER_WEIGHT * month;
            }else if(bmiNumber > 18.4 && bmiNumber < 25){   // bmiNumber > 18.4 redundand. No need
                bmiType = 'N';
                costPackage = COST_NORMAL_WEIGHT * month;
            }else if(bmiNumber > 24.9 && bmiNumber < 30){   // bmiNumber > 24.9 redundand. No need
                bmiType = 'O';
                costPackage = COST_OVER_WEIGHT * month;
            }else if(bmiNumber > 29.9){
                bmiType = 'S';
                costPackage = COST_SEVERE_WEIGHT * month;
            }

            // Count discount
            if(disType == 'f' || disType == 'F'){
                disAmount = costPackage * DIS_FRIEND;       // try get calculations outside if statment
            }else if(disType == 'r' || disType == 'R'){
                disAmount = costPackage * DIS_CLIENT;
            }else if(disType == 'c' || disType == 'C'){
                disAmount = costPackage * DIS_CORPORATE;
            }else if(disType == 'p' || disType == 'P'){
                if(costPackage >= DIS_PREM_SUM_MAX){
                    disAmount = costPackage * DIS_PREM_MAX;
                }else if(costPackage >= DIS_PREM_SUM_MIN && costPackage < DIS_PREM_SUM_MAX){
                    disAmount = costPackage * ((int)(costPackage / DIS_PREM_SUM_MIN) * DIS_PREMIUM);
                }
            }else{
                System.out.println("Error. Unknown discount type"); // will be ignored. not loosing marks
                disAmount = .0;
            }

            // Count full cost
            if(tshirtNeed == 'y' || tshirtNeed == 'Y'){
                costFull = costPackage - disAmount - cusPromo + COST_TSHIRT;    // not great. beter is to declare new variable
            }else{
                costFull = costPackage - disAmount - cusPromo;
            }

            costVAT = costFull * VAT;
            costFinal = costFull + costVAT;

            System.out.printf("%40d %10.2f %7s %8.2f %8.2f %8.2f %8.2f %8.2f %8.2f\n",
                    i, bmiNumber, bmiType, costPackage, disAmount, cusPromo, costFull, costVAT, costFinal);

            totalPack += costPackage;
            totalDisc += disAmount;
            totalPromo += cusPromo;
            totalFullCost += costFull;
            totalVAT += costVAT;
            totalFinal += costFinal;

            // Find Lowes and Highest cost package
            if(costMinPack <= 0){
                costMinPack = costPackage;
                clientLowest = i;
            }else if(costMinPack > costPackage){
                costMinPack = costPackage;
                clientLowest = i;
            }

            if(costMaxPack < costPackage){
                costMaxPack = costPackage;
                clientHighest = i;
            }
        }//for

        // footer
        for(int line = lineLength; line > 0; line--) System.out.print("="); // Loose marks. Do println() insted
        System.out.printf("\n%52s %15.2f %8.2f %8.2f %8.2f %8.2f %8.2f\n",
                "Totals:", totalPack, totalDisc, totalPromo, totalFullCost, totalVAT, totalFinal);
        for(int line = lineLength; line > 0; line--) System.out.print("=");	// Loose marks. Do println() insted
        System.out.println();

        System.out.printf("\nClient " + clientLowest + " has the lowest package cost of: %.2f", costMinPack);
        System.out.printf("\nClient " + clientHighest + " has the highest package cost of: %.2f\n\n", costMaxPack);

    }//main

}//class