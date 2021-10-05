/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.POJO_DOCGIA;
import SQLServerProvider.SQLProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author trung
 */
public class DAO_DOCGIA {
    public static ArrayList<POJO_DOCGIA> getListDocgia()
        {
            ArrayList<POJO_DOCGIA> listDG=new ArrayList<POJO_DOCGIA>();
              SQLProvider provide=new SQLProvider();
        try {
            provide.Open();
            String query="Select * from DOCGIA";
            ResultSet rs=provide.executeQuery(query);
            while (rs.next())
            {
                POJO_DOCGIA DG=new POJO_DOCGIA();
                        DG.setMADG(rs.getString("MADG"));
                        DG.setTENDG(rs.getString("TENDG"));
                        DG.setDIACHI(rs.getString("DIACHI"));
                        DG.setEMAIL(rs.getString("EMAIL"));
                        DG.setNGAYSINH(rs.getString("NGAYSINH"));
                listDG.add(DG);
            }
            provide.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDG;
        }
    public static ArrayList<POJO_DOCGIA> timkiemdocgiatheoTen(String tenDG)
    {
         ArrayList <POJO_DOCGIA> listDG=new ArrayList<POJO_DOCGIA>();
         SQLProvider provide=new SQLProvider();
        try {
           
            String sql="Select * from DOGIA where TENDG like '%" +tenDG +"%'";
            
            ResultSet rs=provide.executeQuery(sql);
            while (rs.next())
            {
                POJO_DOCGIA dg=new POJO_DOCGIA();
                dg.setMADG(rs.getString("MADG"));
                dg.setTENDG(rs.getString("TENDG"));
                dg.setNGAYSINH(rs.getString("NGAYSINH"));
                dg.setEMAIL(rs.getString("EMAIL"));
                listDG.add(dg);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDG;
    }
    
    public static boolean themDocGia(POJO_DOCGIA dg)
        {
            boolean kq=false ;
            SQLProvider provide=new SQLProvider();  
        try {
              
            String sql=String.format("Insert into DOCGIA Values ('%s','%s',Convert(DATE,'%s',103),'%s','%s');",dg.getMADG(),dg.getTENDG(),dg.getNGAYSINH(),dg.getDIACHI(),dg.getEMAIL());
            provide.Open();
            int n=provide.executeUpdate(sql);
            if (n==1)
            {
                kq=true;
            }
            provide.Close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        }
         
          
        return kq;
        }
    public static boolean checkDieuKien(String madg)
    {       
            boolean kq=false ;
            SQLProvider provide=new SQLProvider();
        try {
            provide.Open();
            String sqlKtra=String.format("Select * from MUONSACH Where MADG='%s'",madg);
            ResultSet rs=provide.executeQuery(sqlKtra);
            if(rs.next())
            {
                kq=true;
            }
            provide.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public static boolean xoaDocgia(String madg)
    {
            boolean kq=false ;
            SQLProvider provide=new SQLProvider();
        try {
            provide.Open();  
            String sqlDelete=String.format("Delete from DOCGIA Where MADG='%s'",madg);
            int n=provide.executeUpdate(sqlDelete);
             if (n==1)
            {
                kq=true;
                
            }
            provide.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public static boolean UpdateTenDocGia(POJO_DOCGIA dg)
    {
            boolean kq=false;
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql=String.format("UPDATE DOCGIA set TENDG='%s'"+ "Where MADG='%s'",dg.getTENDG(),dg.getMADG());
            provide.Open();
            int n=provide.executeUpdate(sql);
            if (n==1)
            {
                kq=true;
            }
            provide.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public static boolean UpdateNgaySinhDocGia(POJO_DOCGIA dg)
    {
            boolean kq=false;
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql=String.format("UPDATE DOCGIA set NGAYSINH=Convert(DATE,'%s',103)"+ "Where MADG='%s'",dg.getNGAYSINH(),dg.getMADG());
            provide.Open();
            int n=provide.executeUpdate(sql);
            if (n==1)
            {
                kq=true;
            }
            provide.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public static boolean UpdateDiaChiDocGia(POJO_DOCGIA dg)
    {
            boolean kq=false;
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql=String.format("UPDATE DOCGIA set DIACHI='%s'"+ "Where MADG='%s'",dg.getDIACHI(),dg.getMADG());
            provide.Open();
            int n=provide.executeUpdate(sql);
            if (n==1)
            {
                kq=true;
            }
            provide.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public static boolean UpdateEmailDocGia(POJO_DOCGIA dg)
    {
            boolean kq=false;
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql=String.format("UPDATE DOCGIA set EMAIL='%s'"+ "Where MADG='%s'",dg.getEMAIL(),dg.getMADG());
            provide.Open();
            int n=provide.executeUpdate(sql);
            if (n==1)
            {
                kq=true;
            }
            provide.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DOCGIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
}


