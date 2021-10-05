/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.DAO_DOCGIA;
import POJO.POJO_DOCGIA;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author trung
 */
public class TablemodelDOCGIA extends AbstractTableModel  {
    ArrayList <POJO_DOCGIA> listDG;
    DAO_DOCGIA DG=new DAO_DOCGIA();
    
    public TablemodelDOCGIA() {
        listDG=DG.getListDocgia();
    }
    public void reloadTbl(){
     super.fireTableDataChanged();
    }
    public void addElement(POJO_DOCGIA docgia){
        listDG.add(docgia);
        super.fireTableDataChanged();
    }
    public void removeElement(POJO_DOCGIA docgia){
           listDG.remove(docgia);
         super.fireTableDataChanged();
    }
    public void removeByIndex(int rowIndex ){
        listDG.remove(rowIndex);
        super.fireTableDataChanged();
    }
    public POJO_DOCGIA getByIndex(int rowIndex){
        return listDG.get(rowIndex);
    }
    public int getSelectedRow() {
        return selectionModel.getMinSelectionIndex();
    }
   
    @Override
    public int getRowCount() {
        return listDG.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        POJO_DOCGIA dg=listDG.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return dg.getMADG();
            case 1:return dg.getTENDG();
            case 2:return dg.getNGAYSINH();
            case 3:return dg.getDIACHI();
            case 4:return dg.getEMAIL();
            default: return null;
        }
        
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:return "Mã đọc giả";
            case 1:return "Họ Và Tên";
            case 2:return "Ngày Sinh";
            case 3:return "Địa chỉ";
            case 4:return "Email";
            default: return null;
        }
    }
    protected ListSelectionModel selectionModel;
    
}
