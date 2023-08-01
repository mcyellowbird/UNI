class Q10{
  public static void main(String[] args){
    Item item1 = new Item("Printer");

    Item item2 = new Item("Scanner");  

    Item item3 = new Item("");

    System.out.println(item1.getItemCode());

    System.out.println(item2.getItemCode());

    System.out.println(item3.getItemCode());
  }
}

class Item{

  private static int totalItems=0;

  private int itemCode;

  private String name;

  public Item(String name) {

    this.name = name;

    itemCode = ++totalItems+100;

  }

    public int getItemCode(){
    return itemCode;

  }

}