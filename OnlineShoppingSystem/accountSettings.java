import java.util.*;
public class accountSettings extends customer {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int op=0;
        while(op!=6){
            System.out.println("\n1)EDIT DETAILS\n2)VIEW PREVIOUS ORDERS\n3)SIGN OUT\n4)DELETE ACCOUNT\n5)BACK\n6)EXIT\n");
            op=s.nextInt();
            switch(op)
            {
                case 1:
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                case 5:
                break;
                case 6:
                break;
                default:
                System.out.println("Wrong input, try again.");
            }
        }

    }
}
