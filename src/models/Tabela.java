/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADM_House
 */
public class Tabela extends AbstractTableModel {
    
    private ArrayList linhas;
    private String[] colunas; 

    public Tabela(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }
    
    /*public Tabela(ArrayList linhas, String[] colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
    }*/

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    public int getColumnCount(){
        return colunas.length;
    }

    public int getRowCount(){
        return  linhas.size();
    }
    
    public String getColumnName(int colum){
            return colunas[colum];
    }
    
    public Object getValueAt(int numLinha, int numColum){
      Object[] linha = (Object[])getLinhas().get(numLinha);  
      return linha[numColum];
    }
}
