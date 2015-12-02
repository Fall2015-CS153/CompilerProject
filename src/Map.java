
import java.util.HashMap;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aishwarya
 */
public class Map
{

    HashMap a;

    public void IntegerIntegerList()
    {
        a = new HashMap<Integer,Integer>();
    }
    
    public void IntegerDoubleList()
    {
        a = new HashMap<Integer,Double>();
    }
    
    public void IntegerFloatList()
    {
        a = new HashMap<Integer,Float>();
    }
    
    public void IntegerStringList()
    {
        a = new HashMap<Integer,String>();
    }
    
    public void IntegerBooleanList()
    {
        a = new HashMap<Integer,Boolean>();
    }

      public void DoubleIntegerList()
    {
        a = new HashMap<Double,Integer>();
    }
    
    public void DoubleDoubleList()
    {
        a = new HashMap<Double,Double>();
    }
    
    public void DoubleFloatList()
    {
        a = new HashMap<Double,Float>();
    }
    
    public void DoubleStringList()
    {
        a = new HashMap<Double,String>();
    }
    
    public void DoubleBooleanList()
    {
        a = new HashMap<Double,Boolean>();
    }
    
        public void FloatIntegerList()
    {
        a = new HashMap<Float,Integer>();
    }
    
    public void FloatDoubleList()
    {
        a = new HashMap<Float,Double>();
    }
    
    public void FloatFloatList()
    {
        a = new HashMap<Float,Float>();
    }
    
    public void FloatStringList()
    {
        a = new HashMap<Float,String>();
    }
    
    public void FloatBooleanList()
    {
        a = new HashMap<Float,Boolean>();
    }
    
        public void StringIntegerList()
    {
        a = new HashMap<String,Integer>();
    }
    
    public void StringDoubleList()
    {
        a = new HashMap<String,Double>();
    }
    
    public void StringFloatList()
    {
        a = new HashMap<String,Float>();
    }
    
    public void StringStringList()
    {
        a = new HashMap<String,String>();
    }
    
    public void StringBooleanList()
    {
        a = new HashMap<String,Boolean>();
    }
    
        public void BooleanIntegerList()
    {
        a = new HashMap<Boolean,Integer>();
    }
    
    public void BooleanDoubleList()
    {
        a = new HashMap<Boolean,Double>();
    }
    
    public void BooleanFloatList()
    {
        a = new HashMap<Boolean,Float>();
    }
    
    public void BooleanStringList()
    {
        a = new HashMap<Boolean,String>();
    }
    
    public void BooleanBooleanList()
    {
        a = new HashMap<Boolean,Boolean>();
    }
    /*
    
          map{int,int} a;
     
     
      
      a.setVal{0,3};
    */
    public void add(Object key,Object value)
    {
        a.put(key,value);
    }

    public void remove(Object item)
    {
        a.remove(item);
    }

    public void getVal(Object key)
    {
        a.get(key);
    }
    

    public void setVal(Object key, Object value)
    {
        a.put(key, value);
    }
}
