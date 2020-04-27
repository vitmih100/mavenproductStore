package productStore;

import java.time.LocalDate;

public class productsStore {
  private static int idst=0;
  private int id;
  private String nume_prod;
  private double pret_achez;
  private double pret_vinz;
  private LocalDate data_expir;
  private int cantitate_achez;
  private int cantitate_vinz;
  private String unit_masura;
  private double profit;
  
  public productsStore(String nume_prod,double pret_achez,double pret_vinz,LocalDate data_expir,
          int cantitate_achez,int cantitate_vinz,String unit_masura){
    this.id=idst++;
    this.nume_prod=nume_prod;
    this.pret_achez=pret_achez;
    this.pret_vinz=pret_vinz;
    this.data_expir=data_expir;
    this.cantitate_achez=cantitate_achez;
    this.cantitate_vinz=0;
    this.unit_masura=unit_masura;
    this.profit=0;
  }  
  public double getProfit(){
    return cantitate_vinz*(pret_vinz-pret_achez);
  }
  public int getcantitate_achez(){
    return this.cantitate_achez;
  }
  public int getcantitate_vinz(){
    return this.cantitate_vinz;
  }
  public void setcantitate_vinz(int cantitate_vinz){
    this.cantitate_vinz+=cantitate_vinz;
  }  
  
}
