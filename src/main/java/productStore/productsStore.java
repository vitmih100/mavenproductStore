package productStore;

import java.time.LocalDate;

public class productsStore {
  private static int idst=0;
  private int id;
  private String nume_prod;
  private double pret_achez;
  private int cantitate_achez;
  private double pret_vinz;
  private int cantitate_vinz;
  private LocalDate data_expir;
  private String unit_masura;
  private double profit;
  private int idtm;
  
  public productsStore(String nume_prod,double pret_achez,int cantitate_achez,double pret_vinz,LocalDate data_expir,
          String unit_masura){
    this.id=idst++;
    this.nume_prod=nume_prod;
    this.pret_achez=pret_achez;
    this.cantitate_achez=cantitate_achez;
    this.pret_vinz=pret_vinz;
    this.cantitate_vinz=0;
    this.data_expir=data_expir;
    this.unit_masura=unit_masura;
    this.profit=0;
    this.idtm=0;
  }  
 
   public productsStore(int id,String nume_prod,double pret_achez,int cantitate_achez,double pret_vinz,int cantitate_vinz,LocalDate data_expir,
          String unit_masura,int idtm){
    this.id=id;
    this.nume_prod=nume_prod;
    this.pret_achez=pret_achez;
    this.cantitate_achez=cantitate_achez;
    this.pret_vinz=pret_vinz;
    this.cantitate_vinz=cantitate_vinz;
    this.data_expir=data_expir;
    this.unit_masura=unit_masura;
    this.profit=0;
    this.idtm=idtm;
  }  
  
  public int getId(){
    return this.id;
  } 
  
  public String getNumeProd(){
    return this.nume_prod;
  } 
  
  public double getPretAchez(){
    return this.pret_achez;
  } 
  
  public int getCantitateAchez(){
    return this.cantitate_achez;
  } 
  public double getPretVinz(){
    return this.pret_vinz;
  } 
  public int getCantitateVinz(){
    return this.cantitate_vinz;
  } 
  public LocalDate getDataExpir(){
    return this.data_expir;
  } 
  public String getUnitMasura(){
    return this.unit_masura;
  } 

  public double getProfit(){
    return cantitate_vinz*(pret_vinz-pret_achez);
  }

  public void setCantitateVinz(int cantitate_vinz){
    this.cantitate_vinz+=cantitate_vinz;
  }  
  
  public int getIdtm(){
    return this.idtm;
  } 
  
  public void setIdtm(int idtm){
    this.idtm=idtm;
  } 
  
}
