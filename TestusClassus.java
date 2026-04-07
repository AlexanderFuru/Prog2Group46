public class TestusClassus {
    public static void main(String[] args) {
        Book testBook1 = new Book("Eisenhorn: the Omnibus", "Dan Abnett", 350, false);
        Book testBook2 = new Book("Silmarillion", "J.R.R. Tolkien", 289, true);
        Order order = new Order(testBook1, testBook2); 

        System.out.println(testBook1.toString());
        System.out.println(testBook2.toString());

        //Ta fram namnet på boken, ärver getName från Item
        System.out.println("Name: " + testBook1.getName());

        //Ta fram författare
        System.out.println("Author: " + testBook1.author);

        //Ta fram orginalpris som skrivs in vid instansiering
        System.out.println("Orginalpris: " + testBook1.price);

        //Ta fram om inbunden eller inte
        System.out.println("Bound? " + testBook1.bound);

        //Ta fram pris bound
        if (testBook1.bound == true)
            System.out.println("Price bound: " + testBook1.getPrice());

        //Ta fram moms
        System.out.println("Momssats för bok: " + testBook1.getVAT());

        //Ta fram pris med moms
        System.out.println("Pris inkl. moms: " + testBook1.getPriceWithVAT());

        //Ta fram kvitto
        System.out.println(order.getReceipt());
    }
}
