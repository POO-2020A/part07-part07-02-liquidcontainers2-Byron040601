
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int first = 0;
        int second = 0;        
        Container container = new Container();
        
        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");
            String input = scanner.nextLine();
            System.out.println("");
            
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            
            if (command.equals("add")) {
                container.add(first);
                container.add(amount);
                first = container.contains();
                container.remove(100);
            }
            if (command.equals("move")) {
                if (amount > 0) {
                    if (amount <= first) {
                        second = second + amount;
                        first = first - amount;
                        if (first < 0) {
                            first = 0;
                        }
                        
                        if (second > 100) {
                            second = 100;
                        }
                    } else {
                        second = second + first;
                        first = first - amount;
                        if (first < 0) {
                            first = 0;
                        }
                                                                           
                        if (second > 100) {
                            second = 100;
                        }
                    }
                }
            }
            
            if (command.equals("remove")) {
                container.add(second);
                container.remove(amount);
                second = container.contains();
            }
        }
    }
}
