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
public class POJO_THONGTINSACH {
    String THELOAI,TENTHELOAI;

    public POJO_THONGTINSACH(String THELOAI) {
        this.THELOAI = THELOAI;
    }

    public POJO_THONGTINSACH() {
    }

    public POJO_THONGTINSACH(String THELOAI, String TENTHELOAI) {
        this.THELOAI = THELOAI;
        this.TENTHELOAI = TENTHELOAI;
    }
    

    public String getTHELOAI() {
        return THELOAI;
    }

    public void setTHELOAI(String THELOAI) {
        this.THELOAI = THELOAI;
    }

    public String getTENTHELOAI() {
        return TENTHELOAI;
    }

    public void setTENTHELOAI(String TENTHELOAI) {
        this.TENTHELOAI = TENTHELOAI;
    }

    @Override
    public String toString() {
        return getTHELOAI()+"-"+getTENTHELOAI();
    }
    
    
}
