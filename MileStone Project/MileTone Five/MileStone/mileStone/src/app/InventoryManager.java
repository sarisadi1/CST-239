package app;

import java.util.ArrayList;


public class InventoryManager <T extends SalableProduct> {
    FileServices<T> file = new FileServices<>();

        public  ArrayList<T> inventory = new ArrayList<>();

        // Load inventory data from a JSON file
        public void initializeInventoryFromJSON(String fileName) {
            try {
                ArrayList<T> products =  file.readFromFile(fileName);
                inventory.addAll(products);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // Save inventory data to a JSON file
        public void saveInventoryToJSON(String fileName) {
            file.saveFile(fileName , inventory);
        }
    public ArrayList<T> getInventory() {
        initializeInventoryFromJSON("inventory.json");
        return inventory;
    }

        public ArrayList<T> showInventory() {
//            initializeInventoryFromJSON("inventory.json");
            for (T product : inventory) {
                System.out.println("Name: " + product.getName());
                System.out.println(product.getDescription());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println();
            }
            return inventory;
        }

        public void addProductToInventory(T InventoryProduct) {
            // Existing code for adding products to inventory.
            inventory.add(InventoryProduct);
        }

        public void returnProduct(T InventoryProduct) {
            // Existing code for removing products from inventory.
            inventory.remove(InventoryProduct);
        }
    }



//    //Create a public array list for the inventory
//    public static ArrayList<SalableProduct> inventory = new ArrayList<SalableProduct>();
//
//
//
//    //Initialize store 10/20
//    public static  void StoreInitialize()
//    {
//        Weapon FirstWeapon=new Weapon("First", " Description: Powerful 1 Weapon", 10, 20);
//        //Create second weapon
//        Weapon SecondWeapon=new Weapon("Second Weapon"," Description: Very Powerful 2 Weapon",30,40);
//        //Create First Armor
//        Armor FirstArmor=new Armor("First Armor", " Description: amazing PowerFull 1 Armor", 50, 60);
//        //Create Second Armor
//        Armor SecondArmor=new Armor("Second Armor", " Description: crazy PowerFull 2 Armor", 70, 80);
//        //Create First health option
//        Health FirstHealth=new Health("First Health", " Description: weak Powerful 1 Health", 90, 100);
//        //Create Second health option
//        Health SecondHealth=new Health("Second Health", " Description: super weak Powerful 2 Health", 110, 120);
//        {
//
//            //add object to the array list 10/20
//            inventory.add(FirstWeapon);
//            inventory.add(SecondWeapon);
//            inventory.add(FirstArmor);
//            inventory.add(SecondArmor);
//            inventory.add(FirstHealth);
//            inventory.add(SecondHealth);
//
//
//        }
//    }
//
//
//
//    //////////////////////////////////////////////////////////////
//    //Create a method to show Inventory done 10/20
//    public static ArrayList<SalableProduct> showInventory() {
//
//        for (int i=0; i <inventory.size();i++) {
//            if (inventory.get(i).getQuantity()>1) {
//                System.out.println("Item:"+inventory.get(i).getName());
//                System.out.println(" Description: "+inventory.get(i).getDescription());
//                System.out.println( " Price: "+ inventory.get(i).getPrice());
//                System.out.println("Quantity: "+inventory.get(i).getQuantity());
//                System.out.println(" ");
//
//            }
//
//        }
//        return inventory;
//
//    }
//
//
//    //Method to get inventory
//    public ArrayList<SalableProduct> ShowInventory(){
//
//        return inventory;
//
//    }
//
//    //Create a method to buy a product and pass to cart 10/20
//    //gonna be used later when using IO
//    public static void addProductionInventory(SalableProduct InventoryProduct) {
//
//        inventory.add(InventoryProduct);
//
//    }
//
//    //Create a method to remove a product and pass to cart 10/20
//    //gonna be used later when using IO
//    public static void ReturnProduct (SalableProduct InventorProduct) {
//        inventory.remove(InventoryProduct);
//    }




