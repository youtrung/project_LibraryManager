/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;



/**
 *
 * @author trung
 */
public class POJO_MUONSACH {
    String MADG,MASH;
    String NGAYMUON;
    int SONGAYMUON,SOTIENCOC;

    public POJO_MUONSACH() {
    }
    
    
    public POJO_MUONSACH(String MADG) {
        this.MADG = MADG;
    }

    public String getMADG() {
        return MADG;
    }

    public void setMADG(String MADG) {
        this.MADG = MADG;
    }

    public String getMASH() {
        return MASH;
    }

    public void setMASH(String MASH) {
        this.MASH = MASH;
    }

    public String getNGAYMUON() {
        return NGAYMUON;
    }

    public void setNGAYMUON(String NGAYMUON) {
        this.NGAYMUON = NGAYMUON;
    }

    public int getSONGAYMUON() {
        return SONGAYMUON;
    }

    public void setSONGAYMUON(int SONGAYMUON) {
        this.SONGAYMUON = SONGAYMUON;
    }

    public int getSOTIENCOC() {
        return SOTIENCOC;
    }

    public void setSOTIENCOC(int SOTIENCOC) {
        this.SOTIENCOC = SOTIENCOC;
    }
    
}
