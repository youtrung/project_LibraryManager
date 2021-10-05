/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.DAO_SACH;
import POJO.POJO_SACH;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author trung
 */
public class TableModelSach extends AbstractTableModel {
    ArrayList <POJO_SACH> listSach;
    DAO_SACH sach=new DAO_SACH();
    public TableModelSach() {
        listSach=sach.getListSach();
    }
    public void reloadTbl(){
     super.fireTableDataChanged();
    }
    public void addElement(POJO_SACH sach){
        listSach.add(sach);
        super.fireTableDataChanged();
    }
    public void removeElement(POJO_SACH sach){
           listSach.remove(sach);
         super.fireTableDataChanged();
    }
    public void removeByIndex(int rowIndex ){
        listSach.remove(rowIndex);
        super.fireTableDataChanged();
    }
    public POJO_SACH getByIndex(int rowIndex){
        return listSach.get(rowIndex);
    }
    protected ListSelectionModel selectionModel;
    public int getSelectedRow() {
        return selectionModel.getMinSelectionIndex();
    }
    @Override
    public int getRowCount() {
       return listSach.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        POJO_SACH sach=listSach.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return sach.getMASH();
            case 1:return sach.getTENSH();
            case 2:return sach.getTACGIA();
            case 3:return sach.getTHELOAI();
            case 4:return sach.getTINHTRANG();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:return "Mã sách";
            case 1:return "Tên sách";
            case 2:return "Tác giả";
            case 3:return "Thể loại";
            case 4:return "Tình trạng";
            default: return null;
        }
    }
    
}
