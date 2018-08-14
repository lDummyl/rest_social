package com.example.demo.commercial.PurchasingEquipment;

import com.example.demo.commercial.Price;
import com.example.demo.models.Hibernatable;

import javax.persistence.*;


@Entity
@Table(name = "pumps_imp")
public class IMP_Pump /*extends Pump */ implements Hibernatable, Orderable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "art")
    public String art;

    @Column(name = "refer")
    public String refer;

    @Column(name = "price_eur")
    public int price_eur;

    @Column(name = "dn")
    public int dn;

    @Column(name = "discount")
    public Double discount;

    @Column(name = "speed_3")
    public String speed_3;

    @Column(name = "speed_2")
    public String speed_2;

    public int getId() {return id;}

//    @Override
//    public Price getPrice() {
//        return super.getPrice();
//    }

    public IMP_Pump(Price price) {
//        super(price);
    }
    public IMP_Pump(String ref){
//        super(ref);
        refer =  ref;
    }
    public IMP_Pump(){
        super();
    }
}
