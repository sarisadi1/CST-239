import java.util.ArrayList;
import java.util.List;

public class InventoryManager <T extends SalableProduct> {

    //instance of file class
    FileServices<T> file = new FileServices<>();


    // list for storing available products and then saving it to jason file
        public List<T> inventory = new ArrayList<>();

        // Load inventory data from a JSON file
        public void initializeInventoryFromJSON(String fileName) {
            try {
                List<T> products =  file.readFromFile(fileName);
                inventory.addAll(products);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // Save inventory data to a JSON file
        public void saveInventoryToJSON(String fileName , List<T> inventory) {

            file.saveFile(fileName , inventory);
        }

        // getter
    public List<T> getInventory() {

             return inventory;
    }


    // Displaying the inventory
        public void showInventory() {
            for (T products : getInventory()){
                System.out.println("Name: "+ products.getName());
                System.out.println("Description: "+products.getDescription());
                System.out.println("Price: "+ products.getPrice());
                System.out.println("Quantity: "+ products.getQuantity());
                System.out.println();
            }
        }

        public void addProductToInventory( String InventoryProduct) {
            // increasing the quantity of the product
            try{
                for (T inv : getInventory()){
                    if ( inv.getName().equalsIgnoreCase(InventoryProduct)){
                        inv.setQuantity(inv.getQuantity()+1);
                        saveInventoryToJSON("inventory.json" , getInventory());
                        break;
                    }
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }


        public void removeProduct(String InventoryProduct) {
            // reducing the quantity of the product
            try{
            for (T inv : getInventory()){
                if ( inv.getName().equalsIgnoreCase(InventoryProduct) && inv.getQuantity()>0){
                    inv.setQuantity(inv.getQuantity()-1);

                    // saving the file with reduced quantity
                    saveInventoryToJSON( "inventory.json" , getInventory()  );
                }
            }}
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
