/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.POJO_SACH;
import SQLServerProvider.SQLProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author trung
 */
public class DAO_SACH {
    public static ArrayList<POJO_SACH> getListSach()
    {
        ArrayList<POJO_SACH> listSach=new ArrayList<POJO_SACH>();
            SQLProvider provide=new SQLProvider();
        try {
            provide.Open();
            String query="Select * from SACH";
            ResultSet rs=provide.executeQuery(query);
            while (rs.next())
            {
                        POJO_SACH sach=new POJO_SACH();
                        sach.setMASH(rs.getString("MASH"));
                        sach.setTENSH(rs.getString("TENSH"));
                        sach.setTACGIA(rs.getString("TACGIA"));
                        sach.setTHELOAI(rs.getString("THELOAI"));
                        sach.setTINHTRANG(rs.getString("TINHTRANG"));
                listSach.add(sach);
                
            }
            provide.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_SACH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_SACH.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSach;
    }
    public static boolean AddBook(POJO_SACH sach)
    {
        boolean kq=false ;
            SQLProvider provide=new SQLProvider();  
        try {
              
            String sql=String.format("Insert into SACH Values ('%s','%s','%s','%s','%s')",sach.getMASH(),sach.getTENSH(),sach.getTACGIA(),sach.getTHELOAI(),sach.getTINHTRANG());
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
    public static boolean CheckConditionById(String mash)
    {
        boolean kq=false ;
            SQLProvider provide=new SQLProvider();
        try {
            provide.Open();
            String sqlKtra=String.format("Select * from MUONSACH Where MASH='%s'",mash);
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
    public static boolean DeleteBookById(String mash)
    {
        boolean kq=false ;
            SQLProvider provide=new SQLProvider();  
        try {
              
           
            provide.Open();        
            String sqlDelete=String.format("Delete from SACH Where MASH='%s'",mash);
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
    public static boolean UpdateNameOfBook(POJO_SACH sach)
    {
            boolean kq=false;
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql=String.format("UPDATE SACH set TENSACH='%s'"+ "Where MASH='%s'",sach.getTENSH(),sach.getMASH());
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
    public static boolean UpdatePublisherOfBook(POJO_SACH sach)
    {
            boolean kq=false;
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql=String.format("UPDATE SACH set TACGIA='%s'"+ "Where MASH='%s'",sach.getTACGIA(),sach.getMASH());
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
    public static boolean UpdateTypeOfBook(POJO_SACH sach)
    {
            boolean kq=false;
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql=String.format("UPDATE SACH set THELOAI='%s'"+ "Where MASH='%s'",sach.getTHELOAI(),sach.getMASH());
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
    public static boolean UpdateStatusOfBook(POJO_SACH sach)
    {
            boolean kq=false;
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql=String.format("UPDATE SACH set TINHTRANG='%s'"+ "Where MASH='%s'",sach.getTINHTRANG(),sach.getMASH());
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
