/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public interface DAOInterface<TypeObject,TypeData> {
    public ArrayList<TypeObject> getAll();
    public int insertToDB(TypeObject t);
    public int updateToDB(TypeObject t);
    public int delete(TypeData t);
    public TypeObject getByID(TypeData t);
    
}
