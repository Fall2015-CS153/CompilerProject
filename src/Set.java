
import java.util.HashSet;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aishwarya
 */
public class Set
{
   

    HashSet a;

    public void IntegerList()
    {
        a = new HashSet<Integer>();
    }

    public void DoubleList()
    {
        a = new HashSet<Double>();
    }

    public void FloatList()
    {
        a = new HashSet<Float>();
    }

    public void StringList()
    {
        a = new HashSet<String>();
    }

    public void BooleanList()
    {
        a = new HashSet<Boolean>();
    }

     /*
   
      a.add(4);
      a.remove(4);
      a.getVal(3);
      
    */
    public void add(Object item)
    {
        a.add(item);
    }

    public void remove(Object item)
    {
        a.remove(item);
    }

}
