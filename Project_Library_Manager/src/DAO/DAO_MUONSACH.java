/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.POJO_MUONSACH;
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
public class DAO_MUONSACH {
    public static ArrayList<POJO_MUONSACH> getListMuonSach()
    {
            ArrayList<POJO_MUONSACH> list=new ArrayList<POJO_MUONSACH>();
            SQLProvider provide=new SQLProvider();
        try {
            provide.Open();
            String query="Select * from MUONSACH";
            ResultSet rs=provide.executeQuery(query);
            while (rs.next())
                {
                        POJO_MUONSACH msh=new POJO_MUONSACH();
                        msh.setMADG(rs.getString("MADG"));
                        msh.setMASH(rs.getString("MASH"));
                        msh.setNGAYMUON(rs.getString("NGAYMUON"));
                        msh.setSONGAYMUON(rs.getInt("SONGAYMUON"));
                        msh.setSOTIENCOC(rs.getInt("SOTIENCOC"));
                        list.add(msh);
                }
            provide.Close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_MUONSACH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_MUONSACH.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static boolean AddRentBook(POJO_MUONSACH book)
        {
            boolean kq=false ;
            SQLProvider provide=new SQLProvider();  
        try {
              
            String sql=String.format("Insert into MUONSACH Values ('%s','%s',Convert(DATE,'%s',103),%d,%d);",book.getMADG(),book.getMASH(),book.getNGAYMUON(),book.getSONGAYMUON(),book.getSOTIENCOC());
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
    public static boolean delete_1_RentBook(String madg,String mash)
    {
            boolean kq=false ;
            SQLProvider provide=new SQLProvider();
        try {
            provide.Open();  
            String sqlDelete=String.format("Delete from MUONSACH Where MADG='%s' and MASH='%s'",madg,mash);
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
    public static boolean deleteGroupRentBookByMadg(String madg)
    {
            boolean kq=false ;
            SQLProvider provide=new SQLProvider();
        try {
            provide.Open();  
            String sqlDelete=String.format("Delete from MUONSACH Where MADG='%s' ",madg);
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
    public static boolean UpdateDayRent(POJO_MUONSACH book)
    {
            boolean kq=false;
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql=String.format("UPDATE MUONSACH set NGAYMUON=Convert(DATE,'%s',103)"+ "Where MADG='%s' AND MASH='%s'",book.getNGAYMUON(),book.getMADG(),book.getMASH());
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
    public static boolean UpdateNumberDayRent(POJO_MUONSACH book)
    {
            boolean kq=false;
            SQLProvider provide=new SQLProvider();
        try {
            
            String sql=String.format("UPDATE MUONSACH set SONGAYMUON=%d"+ "Where MADG='%s' AND MASH='%s'",book.getSONGAYMUON(),book.getMADG(),book.getMASH());
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
