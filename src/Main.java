import java.util.Scanner;
import Controller.*;

public class Main {
    public static void main(String[] args) {
        QueryController queryController = new QueryController();
        Scanner scanner = new Scanner(System.in);
        int choice1=0;
        do
        {
            System.out.println("+++MENU INIZIALE+++");
            System.out.println("digita la tua scelta");
            System.out.println("1) QUERY");
            choice1 = scanner.nextInt();
            if(choice1==1)
            {
                do
                {
                    System.out.println("+++QUERY+++");
                    System.out.println("1) NUMERO DI BOX");
                    System.out.println("2) NUMERO DI VILLE CON GIARDINO");
                    System.out.println("3) NUMERO DI SUPERFICIE TOTALE PER PROPRIETARIO");
                    System.out.println("4) PROPRIETARI CHE HANNO UNA VILLA");
                    System.out.println("5) PROPRIETARI CON APPARTAMENTO CON BOX");
                    System.out.println("6) PROPRIETARI CON IMMOBILI DI DOPO DEL 1996");
                    System.out.println("7) PROPRIETARI DI APPARTAMENTI CON VANI DISPONIBILI");
                    System.out.println("8) PROPRIETARI LA CUI SOMMA DI MQ SUPERIORE A 400MQ");
                    System.out.println("9) INDIETRO");
                    int choice2 = scanner.nextInt();
                    if (choice2==1)
                    {
                        queryController.query1();
                    }
                    else if(choice2==2)
                    {
                        queryController.query2();
                    }
                    else if (choice2==3)
                    {
                        queryController.query3();
                    }
                    else if (choice2==4)
                    {
                        queryController.query4();
                    }
                    else if (choice2==5)
                    {
                        queryController.query5();
                    }
                    else if (choice2==6)
                    {
                        queryController.query6();
                    }
                    else if (choice2==7)
                    {
                        queryController.query7();
                    }
                    else if (choice2==8)
                    {
                        queryController.query8();
                    }
                    else if (choice2==9)
                    {
                        choice1=0;
                    }
                }
                while(choice1==1);
            }
        }
        while(choice1 !=9);


    }
}