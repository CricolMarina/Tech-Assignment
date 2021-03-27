import java.util.Scanner;


public class CandlesTask {

    public static void main(String[] args) throws InterruptedException {

        birthdayCakeCandles();
    }

        public static void birthdayCakeCandles() {

            Scanner scan = new Scanner(System.in);

            System.out.println("Introduce please the number of candles");

            // the number of candles
            int n = scan.nextInt();

            //count the number of candles having the max weight
            int count = 0;

            int max = 0;

            for (int i = 0; i < n; i++) {
                int candles_height = scan.nextInt();

                if (candles_height > max) {

                    max = candles_height;
                    count = 1;
                } else {
                    if (candles_height == max) {
                        count++;
                    }
                }
            }

            scan.close();

            System.out.println("The number of candles with the maximum weight is :" + count);

        }
    }
