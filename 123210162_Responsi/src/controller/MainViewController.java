/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.LombaLagu;
import java.util.List;
import javax.swing.JFrame;
import mainView.MainView;
import model.ModelLomba;
import model.Lomba;

/**
 *
 * @author Lab Informatika
 */
public class MainViewController {
    MainView mv;
    LombaLagu pd;
    List<Lomba> data;
    String key;
    ModelLomba model;

    public MainViewController(MainView mv) {
        this.mv = mv;
        pd = new LombaLagu();
        data = (List<Lomba>) pd.getAll();
    }
    
    public void isiTabel() {
       data = (List<Lomba>) pd.getAll();
       ModelLomba model = new ModelLomba(data);
       mv.getTabel().setModel(model);
    }
    
    public void insert() {
        Lomba p = new Lomba();
        p.setjudul(mv.getLabelJudul().getText());
        p.setalur(mv.getLabelAlur ().getText());
        p.setorisinalitas(mv.getLabelOrisinalitas().getText());
        p.setpemilihankata(mv.getLabelPemilihanKata().getText());
        p.setnilai(mv.getLabelNilai().getText());
        p.setStock(Integer.parseInt(mv.getLabelStock().getText()));
        pd.insert(p);
    }
    
    public void update() {
        Lomba p = new Lomba();
        p.setJudul(mv.getLabelJudul().getText());
        p.setalur(mv.getLabelAlur().getText());
        p.setorisinalitas(mv.getLabelOrisinalitas().getText());
        p.setpemilihankata(mv.getLabelPemilihanKata().getText());
        p.setnilai(mv.getLabelNilai().getText());
        p.setStock(Integer.parseInt(mv.getLabelStock().getText()));
        p.setId(Integer.parseInt(mv.getLabelId().getText()));
        pd.update(p);
    }
    
    public void hapus() {
        int id = Integer.parseInt(mv.getLabelId().getText());
        pd.delete(id);
    }
    
    public void clear() {
        mv.getLabelId().setText("");
        mv.getLabelJudul().setText("");
        mv.getLabelGenre().setText("");
        mv.getLabelPenerbit().setText("");
        mv.getLabelPenulis().setText("");
        mv.getLabelLokasi().setText("");
        mv.getLabelStock().setText("");
    }
    
    public void cariJudul() {
        key = mv.getCari().getText();
        data = (List<Lomba>) pd.getAll(1, key);
        model = new ModelLomba(data);
        mv.getTabel().setModel(model);
    }
    
    public void cariGenre() {
        key = mv.getCari().getText();
        data = (List<Lomba>) pd.getAll(2,key);
        model = new ModelLomba(data);
        mv.getTabel().setModel(model);
    }
    
    public void cariPenulis() {
        key = mv.getCari().getText();
        data = (List<Lomba>) pd.getAll(3, key);
        model = new ModelLomba(data);
        mv.getTabel().setModel(model);
    }
    
    public void cariPenerbit() {
       key = mv.getCari().getText();
       data = (List<Lomba>) pd.getAll(4, key);
       model = new ModelLomba(data);
       mv.getTabel().setModel(model);
    }
}
