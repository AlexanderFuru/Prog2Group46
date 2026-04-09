public class TestusClassus {
    public static void main(String[] args) {
        Book testBook1 = new Book("Eisenhorn: the Omnibus", "Dan Abnett", 350, false);
        Book testBook2 = new Book("Silmarillion", "J.R.R. Tolkien", 289, true);

        CompactDisc testCD = new CompactDisc("testName", "testArtist", 1971, 9, 170);

        LongPlay testLP = new LongPlay("testNameLP", "testArtistLP", 1989, 8, 540);

        Order order = new Order(testCD, testBook2); 
        Order order2 = new Order(testLP);

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
        System.out.println(order2.getReceipt());
    }
}
