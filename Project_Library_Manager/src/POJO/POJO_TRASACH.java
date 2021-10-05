/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;

/**
 *
 * @author trung
 */
public class POJO_TRASACH {
    String MADG,MASH;
    Date NGAYTRA;

    public POJO_TRASACH(String MADG) {
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

    public Date getNGAYTRA() {
        return NGAYTRA;
    }

    public void setNGAYTRA(Date NGAYTRA) {
        this.NGAYTRA = NGAYTRA;
    }
}
