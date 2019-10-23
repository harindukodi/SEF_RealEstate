import Controller.RealState;

/**
 * The Startup class responsible for the S&E Real Estate Company.
 *
 * @author Harindu Kodituwakku
 */


public class RealStateStartUp {

    public static void main(String[] args) {
        try {
            new RealState().Start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("All rights reserved. S&E Controller.RealState Company 2019.");

        }
    }
}