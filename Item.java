public abstract class Item {

    private String name;
    //Implementera Interface Pricable

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
