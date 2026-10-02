import java.io.*;

public class App {

    public static double calculateDiscount(
            double price, String category) {

        switch (category) {

            case "electronics":
                return price * 0.9;

            case "clothing":
                return price * 0.8;

            default:
                return price;
        }
    }

    public static void createFlatFile() throws IOException {

        try (PrintWriter pw =
                new PrintWriter(new FileWriter("testdata.txt"))) {

            pw.println("500,electronics");
            pw.println("300,clothing");
            pw.println("150,grocery");
        }
    }

    public static void flatFileTest() throws IOException {

        System.out.println(
            "---- Data Driven Test via Flat File ----");

        try (BufferedReader br =
                new BufferedReader(
                    new FileReader("testdata.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                double price =
                    Double.parseDouble(parts[0]);

                String category = parts[1];

                double result =
                    calculateDiscount(price, category);

                System.out.printf(
                    "price=%.1f, category=%s -> discounted=%.2f%n",
                    price, category, result
                );
            }
        }
    }

    public static void main(String[] args)
            throws IOException {

        createFlatFile();

        flatFileTest();
    }
}
