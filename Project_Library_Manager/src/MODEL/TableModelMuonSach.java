/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.DAO_MUONSACH;
import POJO.POJO_MUONSACH;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author trung
 */
public class TableModelMuonSach extends AbstractTableModel {
    ArrayList <POJO_MUONSACH> list;
    DAO_MUONSACH sach=new DAO_MUONSACH();

    public TableModelMuonSach() {
        list=sach.getListMuonSach();
        
    }
    public void addElement(POJO_MUONSACH book){
        list.add(book);
        super.fireTableDataChanged();
    }
    public void removeElement(POJO_MUONSACH book){
           list.remove(book);
         super.fireTableDataChanged();
    }
    public void removeByIndex(int rowIndex ){
        list.remove(rowIndex);
        super.fireTableDataChanged();
    }
    public POJO_MUONSACH getByIndex(int rowIndex){
        return list.get(rowIndex);
    }
    protected ListSelectionModel selectionModel;
      public int getSelectedRow() {
        return selectionModel.getMinSelectionIndex();
    }
    @Override
    public int getRowCount() {
         return list.size();
    }

    @Override
    public int getColumnCount() {
            return 5;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        POJO_MUONSACH book=list.get(rowIndex);
        switch (columnIndex)
        {
            case 0:return book.getMADG();
            case 1:return book.getMASH();
            case 2:return book.getNGAYMUON();
            case 3:return book.getSONGAYMUON();
            case 4:return book.getSOTIENCOC();
            default: return null;
        }
    }
     @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:return "Mã Đọc Giả";
            case 1:return "Mã Sách";
            case 2:return "Ngày Mượn";
            case 3:return "Số Ngày Mượn ";
            case 4:return "Số Tiền Cọc";
            default: return null;
        }
    }
    
    
    
}
