package org.app;

import java.util.ArrayList;
import java.util.List;

// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
public class HighArray {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //-----------------------------------------------------------
    public HighArray(int max)         // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    public long[] getArray() {
        return a;
    }
    //-----------------------------------------------------------
    public boolean find(long searchKey)
    {                              // find specified value
        int j;
        for(j=0; j<nElems; j++)            // for each element,
            if(a[j] == searchKey)           // found item?
                break;                       // exit loop before end
        if(j == nElems)                    // gone to end?
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }  // end find()
    //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //-----------------------------------------------------------
    // Deletes the first ocurrences, shifts the rest
    public boolean delete(long value)
    {
        int j;
        for(j=0; j<nElems; j++)        // look for it
            if( value == a[j] )
                break;
        if(j==nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for(int k=j; k<nElems - 1; k++) // move higher ones down
                a[k] = a[k+1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()
    //-----------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    public int getSize() {
        return nElems;
    }

    public int getOcurrences(HighArray highArray) {
        HighArray clon = highArray.clon();
        int ocurrences = 0;

        for (long value : a) {
            if (clon.delete(value)) {
                ocurrences++;
            }
        }

        return ocurrences;
    }

    private HighArray clon() {
        HighArray clone = new HighArray(a.length);
        for (long value : a) {
            clone.insert(value);
        }
        return clone;
    }

    public List<Long> getArrayList() {
        List<Long> list = new ArrayList<>();
        for (long value : a) {
            list.add(value);
        }
        return list;
    }
    //-----------------------------------------------------------
}  // end class HighArray
////////////////////////////////////////////////////////////////
