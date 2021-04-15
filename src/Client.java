import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

    public static void main(String args[]) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Calculator href = CalculatorHelper.narrow(ncRef.resolve_str("CALCULATOR-SERVER"));

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Inserte el primer numero: ");
            float a = Float.parseFloat(br.readLine());

            System.out.println("Inserte el segundo numero: ");
            float b = Float.parseFloat(br.readLine());

            // Calling the remote method using the obtained object
            float plusR = href.plus(a, b);
            float minusR = href.minus(a, b);
            float timesR = href.times(a, b);
            float divideR = href.divide(a, b);
            float moduleR = href.modul(a, b);

            System.out.println(String.format("The result of %.2f + %.2f is: %.2f", a, b, plusR));
            System.out.println(String.format("The result of %.2f - %.2f is: %.2f", a, b, minusR));
            System.out.println(String.format("The result of %.2f * %.2f is: %.2f", a, b, timesR));
            System.out.println(String.format("The result of %.2f / %.2f is: %.2f", a, b, divideR));
            System.out.println(String.format("The result of %.2f %% %.2f is: %.2f", a, b, moduleR));

        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (CannotProceed cannotProceed) {
            cannotProceed.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
