/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Iryna
 */
public class JavaApplication2Test {
    
    public JavaApplication2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of st method, of class JavaApplication2.
     */
    @Test
    public void testSt() {
        //System.out.println("st");        
        String[] a = new String[5];  // строки на входе
        a[0]="3 s"; a[1]="4 sy"; a[2]="5 sym"; a[3]="6 symb"; a[4]="7 symbo";
        String[] instr = a;
        String[] b = new String[5];  // строки на выходе
        b[0]="3 s"; b[1]="4 sy"; b[2]=null; b[3]=null; b[4]=null;
        String[] expResult = b;
        String[] result = JavaApplication2.st(instr);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class JavaApplication2.
     */
    @Test
    public void testMain() {
        //System.out.println("main");
        String[] args = null;
        JavaApplication2.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}