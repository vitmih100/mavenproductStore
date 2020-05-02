package productStore;

import java.util.Scanner;
import enums.EBACK_END;
import enums.EFRONT_END;
import enums.EMenu;
//import java.util.Scanner;

public class meniu{

  private EMenu Menu;
  private EFRONT_END FRONT_END;
  private EBACK_END BACK_END;

  public meniu(){
    this.Menu = EMenu.Main_menu;
    this.FRONT_END = EFRONT_END.MENIUL;
    this.BACK_END = EBACK_END.End_execution;
  }

  public EMenu getMenu(){
    return this.Menu;
  }

  public EFRONT_END getFRONT_END(){
    return this.FRONT_END;
  }

  public EBACK_END getBACK_END(){
    return this.BACK_END;
  }

  public void setMenu(EMenu Menu){
    this.Menu=Menu;
  }

  public void setFRONT_END(EFRONT_END FRONT_END){
    this.FRONT_END=FRONT_END;
  }

  public void setBACK_END(EBACK_END BACK_END){
    this.BACK_END=BACK_END;
  }


  private void main_meniu(){
    setMenu(EMenu.Main_menu);
    System.out.println("\n\n\n\t\t  **** MENIU ****");
    System.out.println("\t  1. Adaugarea produselor in stoc ");
    System.out.println("\t  2. Afisarea intregului stoc ");
    System.out.println("\t  3. Vinzarea produsului ");
    System.out.println("\t  4. Profitul produsului ");
    System.out.println("\t  5. Profitul total ");
    System.out.println("\t  6. Afisarea produsului(sortare)"); 
    System.out.println("\t  q. Exit ");

    Scanner in = new Scanner(System.in);
    switch((int)in.next().charAt(0)){
      case 49:{this.BACK_END=EBACK_END.InsertProductStore; break;}
      case 50:{this.BACK_END=EBACK_END.ShowProductStore; break;}
      case 51:{this.BACK_END=EBACK_END.SellProductStore; break;}
      case 52:{this.BACK_END=EBACK_END.ProfitSellProductStore; break;}
      case 53:{this.BACK_END=EBACK_END.ProfitSellProductStoreTotal; break;}
      case 54:{this.BACK_END=EBACK_END.ShowProductStoreSort; break;}
      case 113:{this.BACK_END=EBACK_END.End_execution; break;}
    }
  }
  
  private void meniulSellProductStore(){
    setMenu(EMenu.Sell_menu_productStore);
    System.out.println("\n\n\n\t***MENIU VINZAREA PRODUSELOR");
    System.out.println("\t 1. Cauterea produsului dupa id");
    System.out.println("\t 2. Cautarea produsului dupa nume");
    System.out.println("\t q. Exit");
    Scanner in = new Scanner(System.in);
    switch((int)in.next().charAt(0)){
      case 49: {this.BACK_END=EBACK_END.SellId;} break;
      case 50: {this.BACK_END=EBACK_END.SellNume;} break;
      case 113: {this.Menu = EMenu.Main_menu;this.BACK_END=EBACK_END.Not_exist;} break;
    } 
  }

  private void meniulSortProductStore(){
    setMenu(EMenu.Sell_menu_productStore);
    System.out.println("\n\n\n\t***MENIU SORTAREA PRODUSELOR");
    System.out.println("\t 1. Sortarea dupa nume");
    System.out.println("\t 2. Sortarea dupa data de expirare");
    System.out.println("\t 3. Sortarea dupa pret vinzare ordinea crescatoare");
    System.out.println("\t 4. Sortarea dupa pret vinzare ordinea descrescatoare");
    System.out.println("\t q. Exit");
    Scanner in = new Scanner(System.in);
    switch((int)in.next().charAt(0)){
      case 49: {this.BACK_END=EBACK_END.ShowProdStSortName;} break;
      case 50: {this.BACK_END=EBACK_END.ShowProdStSortDataExpir;} break;
      case 51: {this.BACK_END=EBACK_END.ShowProdStSortPrice;} break;      
      case 52: {this.BACK_END=EBACK_END.ShowProdStSortPriceDSC;} break; 
      case 113: {this.Menu = EMenu.Main_menu;this.BACK_END=EBACK_END.Not_exist;} break;
    } 
  }
  
  public void meniul(){
    switch(getMenu()){
      case Main_menu: main_meniu(); break;
      case Sell_menu_productStore: meniulSellProductStore();break;
      case Sort_menu_productStore: meniulSortProductStore();break;
    }
  }
}
