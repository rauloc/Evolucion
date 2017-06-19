/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author JUAN CARLOS
 */
public class Lista<T> {
    
    private ArrayList<T>L;

    public Lista() {
        L=new ArrayList<>();
    }
    public boolean agregar(T x)
    {
        return L.add(x);
    }
    public void agregar(T x,int p)
    {
        L.add(p, x);
    }
    public T getT(int p)
    {
        return L.get(p);
    }
    public int buscar(T x)
    {
        return L.indexOf(x);
    }
    public int size()
    {
        return L.size();
    }
    public ArrayList<T> getLista()
    {
        return L;
    }
    
    
}
