
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aishwarya
 */
public class List
{

    ArrayList a;

    public void IntegerList()
    {
        a = new ArrayList<Integer>();
    }

    public void DoubleList()
    {
        a = new ArrayList<Double>();
    }

    public void FloatList()
    {
        a = new ArrayList<Float>();
    }

    public void StringList()
    {
        a = new ArrayList<String>();
    }

    public void BooleanList()
    {
        a = new ArrayList<Boolean>();
    }

    public void add(Object item)
    {
        a.add(item);
    }

    public void remove(Object item)
    {
        a.remove(item);
    }

    public void getVal(int pos)
    {
        a.get(pos);
    }
    
    public void getIndex(Object value)
    {
        a.indexOf(value);
    }

    public void setVal(int pos, Object value)
    {
        a.set(pos, value);
    }
}
