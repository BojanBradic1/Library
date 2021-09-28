/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import db.KonekcijaSaBazom;
import model.Clan;
import model.Kategorija;
import model.Knjiga;
import model.Pisac;

/**
 *
 * @author boki
 */
public class TestKonekcije {
    
    public static void main(String[] args){
        KonekcijaSaBazom db = new KonekcijaSaBazom();
        
        //pisac == pisac iz baze
        //ili pisac == null
        
        Pisac pisac = db.nadjiPiscaPoId(new Long(2));
        
        if(pisac != null)
            System.out.println("Pisac je pronadjen i zove se " + pisac.getIme());
        else
            System.out.println("Pisac nije pronadjen");
    }
    
    
    
}
