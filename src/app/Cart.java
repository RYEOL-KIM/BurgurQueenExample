package app;

import app.product.Product;
import app.product.subproduct.Burgerset;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.Scanner;

public class Cart {
    private Product[] items = new Product[0];
    private Scanner scanner = new Scanner(System.in);

    public void printCart() {
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n", );

        System.out.println("이전으로 돌아가려면 엔터를 누르세요.");
        scanner.nextLine();
    }

    private void printCartItemDetails() {
        for (Product product : items) {
            if (product instanceof Burgerset) {
                Burgerset burgerset = (Burgerset) product;
                System.out.printf(
                        "  %s %6d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                        product.getName(),
                        product.getPrice(),
                        burgerset.getSide().getName(),
                        burgerset.getSide().getKetchup(),
                        burgerset.getDrink().getName(),
                        burgerset.getDrink().hasStraw()
                );
            }
            else if (product instanceof Hamburger) {
                System.out.printf(
                        "  %-8s %6d원 (단품)\n",
                        product.getName(),
                        product.getPrice()
                );
            }
            else if (product instanceof Side) {
                System.out.printf(
                        "  %-8s %6d원 (케첩 %d개)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Side) product).getKetchup()
                );
            }
            else if (product instanceof Drink) {
                System.out.printf(
                        "  %-8s %6d원 (빨대 %s)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).hasStraw() ? "있음" : "없음"
                );
            }
        }
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
