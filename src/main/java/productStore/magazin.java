package productStore;

import enums.EMenu;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mihail
 */
public class magazin {

  private static List<productsStore> productSt;
 
  public magazin(){
    productSt = new ArrayList<>();
  }  

  public static LocalDate getDateFromString(String stringDate,DateTimeFormatter format){
    LocalDate date = LocalDate.parse(stringDate,format);
    return date;
  }
  
  public static EMenu insertProductStore(){

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    Scanner in = new Scanner(System.in);
    Scanner inq = new Scanner(System.in);
    do{
      /////////clrscr();
      System.out.println("Introduce-ti numele produsului: ");
      String nume_prod = in.nextLine();
      //in.nextLine();
      
      double pret_achez = 0.0;
      while (pret_achez<=0.0){
        System.out.println("Introduceti pretul de achizitie: ");
        try{
          pret_achez = in.nextDouble();
        }
        catch(InputMismatchException e){
          System.out.println("Nu ati introdus pretul de achizitie corect. Mai incercati odata.");
          in.nextLine();
          continue;
        }
        if(pret_achez<=0.0){
          System.out.println("Nu ati introdus pretul de achizitie corect. Pretul de achizitie trebuie sa fie un numar pozitiv. Mai incercati odata.");
        }
      }
      
      
      int cantitate_achez = 0;
      while (cantitate_achez<=0){
        System.out.println("Introduceti cantitatea de achizitie: ");
        try{
          cantitate_achez = in.nextInt();
        }
        catch(InputMismatchException e){
          System.out.println("Nu ati introdus cantitatea de achizitie corect. Mai incercati odata.");
          in.nextLine();
          continue;
        }
        if(cantitate_achez<=0.0){
          System.out.println("Nu ati introdus cantitatea de achizitie corect. Cantitatea de achizitie trebuie sa fie un numar pozitiv. Mai incercati odata.");
        }
      }
      
      double pret_vinz = 0.0;
      while (pret_vinz<=0.0){
        System.out.println("Introduceti pretul de vinzare: ");
        try{
          pret_vinz = in.nextDouble();
        }
        catch(InputMismatchException e){
          System.out.println("Nu ati introdus pretul de vinzare corect. Mai incercati odata.");
          in.nextLine();
          continue;
        }
        if(pret_vinz<=0.0){
          System.out.println("Nu ati introdus pretul de vinzare corect. pretul de vinzare trebuie sa fie un numar pozitiv. Mai incercati odata.");
        }
      }
      in.nextLine();
      LocalDate data_expir = null;
      while (data_expir==null){
        System.out.println("Introduce-ti data de expirare a produsului in formatul dd.mm.yyyy: ");
        String data_expirStr = in.nextLine();
        //System.out.println("hireDayStr="+hireDayStr);
        try{
          //System.out.println("hireDayStr= " + hireDayStr);
          data_expir = getDateFromString(data_expirStr, formatter);
          //System.out.println("hireDay="+hireDay);
        }
        catch(DateTimeParseException e){
          System.out.println("Nu ati introdus data corect. Mai incerca-ti odata.");
          //System.out.println("Exeption: " + e);
        }
      }
      //in.nextLine();     
      
      System.out.println("Introduce-ti unitate de masura a produsului: ");
      String unit_masura = in.nextLine();
      
      productSt.add(new productsStore(nume_prod,pret_achez,cantitate_achez,pret_vinz,data_expir,
                                      unit_masura));

      System.out.println("Pentru iesirea in meniul principal apasati butonul q. ");
    }while((int)inq.next().charAt(0)!=113);
    //productSt.add(e);
  
    return EMenu.Main_menu;
  }
  
  public static EMenu showProductStore(){
 
    Scanner inq = new Scanner(System.in);
    do{
      System.out.println(String.format("\t %-4.4s %-30.30s %-20.20s %-20.20s %-20.20s %-20.20s %-20.20s",
                                      "id","Numele produsului","Pretul de achizitie","Cantit. de achizitie","Pretul de vinzare",
                                      "Data de expirare","Unit. de masura"));   
      for(productsStore prdct : productSt){
        System.out.println(String.format("\t %-4.4s %-30.30s %-20.20s %-20.20s %-20.20s %-20.20s %-20.20s",
                                      String.valueOf(prdct.getId()),prdct.getNumeProd(),String.valueOf(prdct.getPretAchez()),String.valueOf(prdct.getCantitateAchez()),String.valueOf(prdct.getPretVinz()),
                                      String.valueOf(prdct.getDataExpir()),prdct.getUnitMasura()));   
      }
      System.out.println("Pentru iesirea in meniul principal apasati butonul q. ");
    }while((int)inq.next().charAt(0)!=113);

    //System.out.println("Unitate de masura:");
    return EMenu.Main_menu;
  }
  
  public static EMenu sellIdproductStore(){

    Scanner in = new Scanner(System.in);
    Scanner inq = new Scanner(System.in);
    int id=0;
    do{
        System.out.println("Introduceti idul de achizitie: ");
        try{
          id = in.nextInt();
        }
        catch(InputMismatchException e){
          System.out.println("Nu ati introdus idul de achizitie corect. Mai incercati odata.");
          in.nextLine();
          continue;
        }
        if(id<=0.0){
          System.out.println("Nu ati introdus idul de achizitie corect. Idul de achizitie trebuie sa fie un numar pozitiv. Mai incercati odata.");
        }
      System.out.println("Pentru iesirea in meniul principal apasati butonul q. ");
      System.out.println("Pentru a prelunju cautarea apasati oricare litera. ");
    }while((int)inq.next().charAt(0)!=113);
      
    return EMenu.Sell_menu_productStore;
  }
  
  public static EMenu sellNumeproductStore(int numParametr){
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    List<productsStore> productSell = new ArrayList<>();
    int cantitDispon,pressedKey=0;
 
    Scanner in = new Scanner(System.in);
    Scanner inq = new Scanner(System.in);
    int k=0,id=-1;
    
    do{      
      if (pressedKey==118){ 
        do{
          int idtm=-1;
          if (numParametr==1){
            System.out.println("Introduceti idul produsului care doriti sa-l vindeti: ");
            try{
              idtm = in.nextInt();
            }
            catch(InputMismatchException e){
              System.out.println("Nu ati introdus idul produsului corect. Mai incercati odata.");
              in.nextLine();
              continue;
            }
            if(idtm<0){
              System.out.println("Nu ati introdus idul produsului corect. Idul produsului trebuie sa fie un numar pozitiv. Mai incercati odata.");
            }
          }
          for(productsStore prdct : productSell){
            if (numParametr==1 && prdct.getIdtm() == idtm || numParametr==2 && prdct.getId() == id) {
              k=1;
              int cantitate_vinz = 0;
              while (cantitate_vinz<=0){
                System.out.println("Introduceti numarul produselor cit doriti sa vindeti: ");
                try{
                  cantitate_vinz = in.nextInt();
                }
                catch(InputMismatchException e){
                  System.out.println("Nu ati introdus numarul de produse corect. Mai incercati odata.");
                  in.nextLine();
                  continue;
                }
                if(cantitate_vinz<=0){
                  System.out.println("Nu ati introdus numarul de produse corect. Numarul de produse trebuie sa fie un numar pozitiv. Mai incercati odata.");
                }
                /*System.out.println("prdct.getCantitateAchez()="+prdct.getCantitateAchez());
                System.out.println("prdct.getCantitateVinz()="+prdct.getCantitateVinz());
                System.out.println("cantitate_vinz="+cantitate_vinz);
                System.out.println("prdct.getId()="+prdct.getId());*/
                if ((prdct.getCantitateAchez()-prdct.getCantitateVinz())>=cantitate_vinz){
                  for(productsStore prdcto : productSt){
                    //System.out.println("prdcto.getId()="+prdcto.getId());
                    if (prdcto.getId() == prdct.getId()){
                      if ((prdcto.getCantitateAchez()-prdcto.getCantitateVinz())>=cantitate_vinz){
                        prdcto.setCantitateVinz(cantitate_vinz);
                        prdcto.getProfit();
                        System.out.println("Datele au fost modificate cu succes");
                        //System.out.println("prdcto.getCantitateVinz()"+prdcto.getCantitateVinz());
                      }else{
                        System.out.println("Ati introdus numarul de produse mai mare decit este disponibil in vinzare. Datele este necesar de reafisat.");
                      }                
                    }
                  }
                }else{             
                   System.out.println("Ati introdus numarul de produse mai mare decit este disponibil in vinzare. Mai incercati odata.");
                }
              }
            }
          }
          if(k==0){
            System.out.println("Idiul pe care ati selectat nu este corect. ");
          }
          System.out.println("Pentru iesirea in meniul precedent apasati butonul q. ");
          System.out.println("Pentru a prelunju vinzare apasati oricare litera. ");
        }while((int)inq.next().charAt(0)!=113);
     
      }
      
      productSell.clear();
      int i=0;
      String nume_prod="";
      id=-1;
      if (numParametr==1){
        System.out.println("Introduceti numele produsului: ");
        nume_prod = in.nextLine();
      }else
      if (numParametr==2){
        while(id<0){
          System.out.println("Introduceti idul de achizitie: ");
          try{
            id = in.nextInt();
          }
          catch(InputMismatchException e){
            System.out.println("Nu ati introdus idul de achizitie corect. Mai incercati odata.");
            in.nextLine();
            continue;
          }
          if(id<0){
            System.out.println("Nu ati introdus idul de achizitie corect. Idul de achizitie trebuie sa fie un numar pozitiv. Mai incercati odata.");
          }
        }
      }
      
      for(productsStore prdct : productSt){
        if (numParametr==1 && prdct.getNumeProd().contains(nume_prod) && prdct.getCantitateAchez()>prdct.getCantitateVinz()) {
          productSell.add(new productsStore(prdct.getId(),prdct.getNumeProd(),prdct.getPretAchez(),prdct.getCantitateAchez(),
                          prdct.getPretVinz(),prdct.getCantitateVinz(),prdct.getDataExpir(),prdct.getUnitMasura(),i++));

        } else
        if (numParametr==2 && prdct.getId()==id && prdct.getCantitateAchez()>prdct.getCantitateVinz()) {
          productSell.add(new productsStore(prdct.getId(),prdct.getNumeProd(),prdct.getPretAchez(),prdct.getCantitateAchez(),
                          prdct.getPretVinz(),prdct.getCantitateVinz(),prdct.getDataExpir(),prdct.getUnitMasura(),prdct.getId()));
        }
      }

      System.out.println(String.format("\t %-4.4s %-30.30s %-22.22s %-6.6s","id","Denumirea cartii","Cantitatea disponibila","Pretul"));   
      for(productsStore prdct : productSell){
        cantitDispon=prdct.getCantitateAchez()-prdct.getCantitateVinz();
        System.out.println(String.format("\t %-4.4s %-30.30s %-22.22s %-6.6s",String.valueOf(prdct.getIdtm()),prdct.getNumeProd(),String.valueOf(cantitDispon),String.valueOf(prdct.getPretVinz())));
      }

      System.out.println("Pentru iesirea in meniul principal apasati butonul q. ");
      System.out.println("Pentru vinzare apasati butonul v. ");
      System.out.println("Pentru a prelunju cautarea apasati oricare litera. ");
      pressedKey=(int)inq.next().charAt(0);
    }while(pressedKey!=113);
    return EMenu.Sell_menu_productStore;
  }

  public static EMenu profitSellProductStore(){
  
    Scanner inq = new Scanner(System.in);
    do{
      System.out.println(String.format("\t %-4.4s %-30.30s %-20.20s %-20.20s %-20.20s",
                                      "id","Numele produsului","Pretul de vinzare","Cantit. vindute",
                                      "Profit"));   
      for(productsStore prdct : productSt){
        System.out.println(String.format("\t %-4.4s %-30.30s %-20.20s %-20.20s %-20.20s",
                                      String.valueOf(prdct.getId()),prdct.getNumeProd(),String.valueOf(prdct.getPretVinz()),String.valueOf(prdct.getCantitateVinz()),
                                      String.valueOf(prdct.getProfit())));   
      }
      System.out.println("Pentru iesirea in meniul principal apasati butonul q. ");
    }while((int)inq.next().charAt(0)!=113);

    //System.out.println("Unitate de masura:");
    return EMenu.Main_menu; 
  
  
  }
  
  public static EMenu profitSellProductStoreTotal(){

    Scanner inq = new Scanner(System.in);
    double profitTotal=0;
    do{
      System.out.println(String.format("\t %-4.4s %-20.20s",
                                      "id","Profit"));   
      for(productsStore prdct : productSt){
        profitTotal=profitTotal+prdct.getProfit();
      }
      System.out.println(String.format("\t %-4.4s %-20.20s","0",String.valueOf(profitTotal)));      
      System.out.println("Pentru iesirea in meniul principal apasati butonul q. ");
    }while((int)inq.next().charAt(0)!=113);

    //System.out.println("Unitate de masura:");
    return EMenu.Main_menu; 
  
  
  }
  
  public static EMenu sortNameProductStore(){

    productSt.sort((s1,s2)->s1.getNumeProd().compareTo(s2.getNumeProd()));
    showProductStore();
    
    return EMenu.Sort_menu_productStore;
  }
  
  public static EMenu sortDateExpirProductStore(){
 
    productSt.sort((s1,s2)->s1.getDataExpir().compareTo(s2.getDataExpir()));
    showProductStore();
    
    return EMenu.Sort_menu_productStore;  
  }
  public static EMenu sortPriceProductStore(){

    productSt.sort((s1,s2)->Double.compare(s1.getPretVinz(),s2.getPretVinz()));
    showProductStore();
    
    return EMenu.Sort_menu_productStore;
  }
  
  public static EMenu sortPriceProductStoreDSC(){

    productSt.sort((s1,s2)->Double.compare(s2.getPretVinz(),s1.getPretVinz()));
    showProductStore();
    
    return EMenu.Sort_menu_productStore;
  } 
  
  public static void main(String[] args){

    meniu meniulPrin = new meniu();
    EMenu Menu;
    new magazin();
    while (true){

      switch(meniulPrin.getFRONT_END()){
        case MENIUL: meniulPrin.meniul(); break;
      }

      switch(meniulPrin.getBACK_END()){
        case InsertProductStore: 
               //Menu=iEmployee(staff);
               Menu=insertProductStore();
               meniulPrin.setMenu(Menu);
               break;
           /*try {
             TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
             e.printStackTrace();
           }; break; */
              
        case ShowProductStore: 
               Menu=showProductStore();
               meniulPrin.setMenu(Menu);
               break;

        case SellProductStore: 
               Menu=EMenu.Sell_menu_productStore;
               meniulPrin.setMenu(Menu);
               break;
               
        case SellId: 
               Menu=sellNumeproductStore(2);//sellIdproductStore();
               meniulPrin.setMenu(Menu);
               break;             

        case SellNume: 
               Menu=sellNumeproductStore(1);
               meniulPrin.setMenu(Menu);
               break;
 
        case ProfitSellProductStore:       
               Menu=profitSellProductStore();
               meniulPrin.setMenu(Menu);
               break;   
        case ProfitSellProductStoreTotal:       
               Menu=profitSellProductStoreTotal();
               meniulPrin.setMenu(Menu);
               break;    
               
        case ShowProductStoreSort: 
               Menu=EMenu.Sort_menu_productStore;
               meniulPrin.setMenu(Menu);
               break;

        case ShowProdStSortName: 
               Menu=sortNameProductStore();
               meniulPrin.setMenu(Menu);
               break;               
               
         case ShowProdStSortDataExpir: 
               Menu=sortDateExpirProductStore();
               meniulPrin.setMenu(Menu);
               break;            
        
         case ShowProdStSortPrice:
               Menu=sortPriceProductStore();
               meniulPrin.setMenu(Menu);
               break;        

         case ShowProdStSortPriceDSC:
               Menu=sortPriceProductStoreDSC();
               meniulPrin.setMenu(Menu);
               break;                
               
        case End_execution: System.exit(0); break;
      }
        //*BACK_END=Not_exist;^M
    }

  }
    
}
