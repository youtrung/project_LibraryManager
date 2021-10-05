/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.POJO_THONGTINSACH;
import SQLServerProvider.SQLProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung
 */
public class DAO_THONGTINSACH {
    public static ArrayList<POJO_THONGTINSACH> getListThongtinsach()
    {   
        ArrayList<POJO_THONGTINSACH> listTT= new ArrayList<POJO_THONGTINSACH>();
        SQLProvider provide=new SQLProvider();
        try {
            provide.Open();
            String query="Select * from THONGTINSACH";
            ResultSet rs=provide.executeQuery(query);
            while (rs.next())
            {
                POJO_THONGTINSACH tts =new POJO_THONGTINSACH();
                tts.setTENTHELOAI(rs.getString("TENTHELOAI"));
                tts.setTHELOAI(rs.getString("THELOAI"));
                listTT.add(tts);
            }
            provide.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_THONGTINSACH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_THONGTINSACH.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTT;
    }
    public static ArrayList<POJO_THONGTINSACH> searchByName(String tenTL){
        ArrayList<POJO_THONGTINSACH> listTT= new ArrayList<POJO_THONGTINSACH>();
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql="Select * from THONGTINSACH where tenTL like '%" +tenTL +"%'";
            ResultSet rs=provide.executeQuery(sql);
            while  (rs.next())
            {
                POJO_THONGTINSACH tt=new POJO_THONGTINSACH();
                tt.setTHELOAI(rs.getString("THELOAI"));
                tt.setTHELOAI(rs.getString("TENTHELOAI"));
                listTT.add(tt);
            }
            return listTT;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_THONGTINSACH.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTT;
    }
    public static ArrayList<String> LoadDataToCombobox()
    {        ArrayList <String> list=new ArrayList<String>();
             SQLProvider provide=new SQLProvider();
            try {
                provide.Open();
                String sql="Select * from THONGTINSACH";
                ResultSet rs=provide.executeQuery(sql);
                while (rs.next())
                    {
                        list.add(rs.getString("THELOAI")+"-"+rs.getString("TENTHELOAI"));
                        
                    }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_THONGTINSACH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_THONGTINSACH.class.getName()).log(Level.SEVERE, null, ex);
        }
            return list;
    }
}
