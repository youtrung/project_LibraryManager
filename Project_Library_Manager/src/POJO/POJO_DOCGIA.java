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
public class POJO_DOCGIA {
    String MADG,TENDG,DIACHI,EMAIL;
    String NGAYSINH;

    public POJO_DOCGIA() {
    }

    public POJO_DOCGIA(String MADG) {
        this.MADG = MADG;
    }

    
    

    public String getMADG() {
        return MADG;
    }

    public void setMADG(String MADG) {
        this.MADG = MADG;
    }

    public String getTENDG() {
        return TENDG;
    }

    public void setTENDG(String TENDG) {
        this.TENDG = TENDG;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }
    
}
